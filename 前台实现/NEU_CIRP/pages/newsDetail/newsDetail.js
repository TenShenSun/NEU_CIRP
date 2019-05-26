const app = getApp();
const util = require('../../utils/util.js');
const baseUrl = app.globalData.baseUrl;
const urlList = app.globalData.urlList;
Page({
  data: {
    news: {
      id: "111", //公告id
      title: "", //公告标题
      content: "", //公告内容
      createTime: "2019-01-01 10:10:10", //发布时间
      viewCount: 123, //浏览量
      favoriteCount: 20, //收藏量
      imgList: [], //用户上传的图片url列表 
      userInfo: { //用户信息
        name: "xxx", //用户昵称
        avatar: "/images/默认头像.png" //用户头像
      },
      favorite: true
    }
  },
  previewImage: function (e) {
    console.log(e.currentTarget)
    wx.previewImage({
      current: e.currentTarget.dataset.url, // 当前显示图片的http链接
      urls: e.currentTarget.dataset.urls // 需要预览的图片http链接列表
    })
  },
  favoriteOn: function () {
    this.setData({
      'news.favorite': true
    })
    wx.request({
      url: baseUrl + '/infofavread/',
      data: {
        userId: this.data.userId,
        infoId: this.options.id,
        isFav: 1
      },
      dataType: "json",
      method: "PUT",
      success: (res) => {
        if (res.statusCode == 200) {
          wx.showToast({
            title: '收藏成功',
            icon: 'success',
            duration: 1000
          })
        }
      },
      fail: () => {
        // wx.showModal({
        //   title: "错误",
        //   content: "数据发送失败",
        // })
      }
    })
  },
  favoriteOff: function () {
    this.setData({
      'news.favorite': false
    })
    wx.request({
      url: baseUrl + '/infofavread/',
      data: {
        userId: this.data.userId,
        infoId: this.options.id,
        isFav: 0
      },
      dataType: "json",
      method: "PUT",
      success: (res) => {
        if (res.statusCode == 200) {
          wx.showToast({
            title: '取消收藏',
            icon: 'success',
            duration: 1000
          })
        }
      },
      fail: () => {
        // wx.showModal({
        //   title: "错误",
        //   content: "数据发送失败",
        // })
      }
    })
  },
  onLoad: function (options) {
    wx.showLoading({
      title: '加载中',
      mask: true
    });
    this.setData({
      userId: app.globalData.openId
    })
    wx.request({
      url: urlList.getInfo(this.options.id),
      data: '',
      method: "GET",
      dataType: "json",
      success: (res) => {
        console.log(res)
        if (res.statusCode == 200) {
          res.data.createdate = util.formatTime(new Date(res.data.createdate));
          res.data.picUrl = res.data.picUrl?res.data.picUrl.split(','):null;
          res.data.count = res.data.count? res.data.count : 20;
          res.data.contactId = res.data.contactId? res.data.contactId : "无";
          res.data.location = res.data.location? res.data.location : "无";
          res.data.phoneNum = res.data.phoneNum? res.data.phoneNum : "无";
          res.data.activityTime = res.data.activityTime? res.data.activityTime : "无";
          console.log("++++")
          console.log(res.data)
          this.setData({
            news: res.data
          })
          // that.setData({
          //   'news.title': res.data.topic,
          //   'news.content': res.data.content,
          //   'news.createTime': util.formatTime(new Date(res.data.createdate)),
          // })
        } else {
          wx.showModal({
            title: "错误",
            content: "数据请求失败",
          })
        }
      },
      fail: () => {
        wx.showModal({
          content: '服务异常，数据请求失败,请检查网络',
          showCancel: false
        })
      },
      complete: () => {
        wx.hideLoading()
      }
    })
    wx.request({
      url: baseUrl + '/infofavread/',
      data: {
        userId: this.data.userId,
        infoId: this.options.id,
        isRead: 1
      },
      dataType: "json",
      method: "POST",
      success: (res) => {
        if (res.statusCode == 200) {
          console.log(res)
        }
      },
      fail: () => {
      }
    })
  }
})