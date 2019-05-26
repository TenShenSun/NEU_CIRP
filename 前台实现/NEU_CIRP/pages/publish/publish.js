const app = getApp();
const util = require('../../utils/util.js');
const baseUrl = app.globalData.baseUrl;
// const userId = app.globalData.openId;
// // const userId = 'tianshengdagoudan111';
const qiniuUploader = require("../../utils/qiniuUploader");

// 初始化七牛相关参数
function initQiniu() {
  console.log("==========================initQiniu======================")
  var options = {
    region: 'NCN', // 华北区
    //uptokenURL: 'https://[yourserver.com]/api/uptoken',
    uptokenURL: baseUrl+'/token/qiniu/2XXLF4PH0-kNCK2mxF2rRMO-ezuyc6l8DqWBffzn/lyGx8sJBsuw0_-t9EmdrqYeNwI71WNe21zIMrrbR/neu_cirp/',
    //uptoken: 'xxxx=',
    // uptoken: '2XXLF4PH0-kNCK2mxF2rRMO-ezuyc6l8DqWBffzn:wOhHCFNGTZ3PTtWcuMQOXqHS6iw=:eyJzY29wZSI6Im5ldV9jaXJwIiwiZGVhZGxpbmUiOjE1NTg4NTIzMjF9',
    domain: 'http://cdn.wenshengtech.cn',
    shouldUseQiniuFileName: false
  };
  qiniuUploader.init(options);
}

Page({
  /**
   * 页面的初始数据
   */
  data: {
    userId:"",
    showTopTips: false,
    datailLength: 0,
    labelList: ["官方公告", "招聘宣讲", "社团活动", "失物招领", "二手交易", "表白墙", "新鲜事"],
    // labelIndex: 0,
    files: [],  //上传图片的本地路径，用于本地显示
    urlList:[], //上传图片后返回的图片url，提交用
    uploadCount: 3, //上传图片数量限制
    info: {
      labelIndex: 6,
      title: null,
      content: null,
      anonymity: true,
      linkman: null,
      phoneNumber: null,
      activityPlace: null,
      activityTime: null
    }
  },
  formReset: function () {
    console.log('form发生了reset事件')
  },
  formSubmit: function (e) {
    console.log(app.globalData.openId)
    console.log('form发生了submit事件，携带数据为：', e.detail.value)
    wx.request({
      url: baseUrl + '/information',
      data: {
        userId: this.data.userId,
        topic: e.detail.value.title,
        content: e.detail.value.content,
        typeId: parseInt(e.detail.value.labelIndex) + 1,
        location: e.detail.value.activityPlace,
        activityTime: e.detail.value.activityTime,
        contactId: e.detail.value.linkman,
        phoneNum: e.detail.value.phoneNumber,
        picUrl: this.data.urlList.join(','),
        isAnony: e.detail.value.anonymity
      },
      method: "POST",
      dataType: "json",
      success: (res) => {
        if (res.statusCode == 200) {
          this.openSuccess();
        } else {
          this.openFail();
        }
      },
      fail: () => {
        this.openFail();
      }
    })
  },
  //发布成功，跳转至成功页面
  openSuccess: function () {
    wx.navigateTo({
      url: 'msg_success'
    })
  },
  //发布失败，跳转至失败页面
  openFail: function () {
    wx.navigateTo({
      url: 'msg_fail'
    })
  },
  //获取textarea内容长度
  userInput: function (e) {
    // console.log("输入的内容---" + e.detail.value)
    // console.log("输入的长度---" + e.detail.value.length)
    this.setData({
      datailLength: e.detail.value.length
    })
  },
  //选择公告类型
  bindLabelChange: function (e) {
    console.log('picker label 发生选择改变，携带值为', e.detail.value);
    this.setData({
      labelIndex: e.detail.value
    })
  },
  //选择上传图片
  chooseImage: function (e) {
    initQiniu();
    var that = this;
    wx.chooseImage({
      count: this.data.uploadCount,
      sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success: function (res) {
        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        // that.setData({
        //   files: that.data.files.concat(res.tempFilePaths)
        // });
        for (let tempFilePath of res.tempFilePaths) {
          qiniuUploader.upload(tempFilePath, (res) => {
              console.log('file url is: ' + res.fileUrl)
              console.log(tempFilePath)
              that.setData({
                files: that.data.files.concat([tempFilePath]),
                urlList: that.data.urlList.concat([res.fileUrl])
              });
              console.log(that.data.files)
              console.log(that.data.urlList)
            }, (error) => {
              console.error('error: ' + JSON.stringify(error));
            },
            // , {
            //     region: 'NCN', // 华北区
            //     uptokenURL: 'https://[yourserver.com]/api/uptoken',
            //     domain: 'http://[yourBucketId].bkt.clouddn.com',
            //     shouldUseQiniuFileName: false
            //     key: 'testKeyNameLSAKDKASJDHKAS'
            //     uptokenURL: 'myServer.com/api/uptoken'
            // }
            null, // 可以使用上述参数，或者使用 null 作为参数占位符
            (progress) => {
              console.log('上传进度', progress.progress)
              console.log('已经上传的数据长度', progress.totalBytesSent)
              console.log('预期需要上传的数据总长度', progress.totalBytesExpectedToSend)
            }, cancelTask => that.setData({
              cancelTask
            })
          );
        }
        // wx.uploadFile({
        //   url: 'https://example.weixin.qq.com/upload', // 仅为示例，非真实的接口地址
        //   filePath: tempFilePaths[0],
        //   name: 'file',
        //   formData: {
        //     user: 'test'
        //   },
        //   success(res) {
        //     const data = res.data
        //     // do something
        //   }
        // })
      }
    })
  },
  //查看图片
  previewImage: function (e) {
    wx.previewImage({
      current: e.currentTarget.id, // 当前显示图片的http链接
      urls: this.data.files // 需要预览的图片http链接列表
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    // this.setData({
    //   userId: app.globalData.openId,
    //   info: {
    //     labelIndex: 6,
    //     title: null,
    //     content: null,
    //     anonymity: true,
    //     linkman: null,
    //     phoneNumber: null,
    //     activityPlace: null,
    //     activityTime: null
    //   }
    // })
    // qiniuUploader.getQiniuToken()
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    this.setData({
      userId: app.globalData.openId,
      info: {
        labelIndex: 6,
        title: null,
        content: null,
        anonymity: true,
        linkman: null,
        phoneNumber: null,
        activityPlace: null,
        activityTime: null
      }
    })
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})