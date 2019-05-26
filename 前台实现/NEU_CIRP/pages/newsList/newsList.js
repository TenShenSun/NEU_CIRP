const app = getApp();
const util = require('../../utils/util.js');
const baseUrl = app.globalData.baseUrl;
const urlList = app.globalData.urlList;
Page({
  data: {
    label: "官方公告",
    defaultAvatar: "/images/默认头像.png",
    newsList: [],
    userId:"",
    newsEmpty: true
  },
  avatarError(e) {
    if (e.type == "error") {
      var errorAvatarIndex = e.target.dataset.index //获取错误图片循环的下标
      var newsList = this.data.newsList    　　　　　　　//将图片列表数据绑定到变量
      newsList[errorAvatarIndex].userInfo.avatar = this.data.defaultAvatar //错误图片替换为默认图片
      this.setData({
        newsList: newsList
      })
    }
  },
  bindViewTap: function(event) {
    wx.navigateTo({
      url: '/pages/newsDetail/newsDetail?id='+event.currentTarget.dataset.id
    })
  },
  onLoad: function (options) {
    wx.showLoading({
      title: '加载中',
      mask: true
    });
    let label = this.options.label;
    let url = '';
    wx.setNavigationBarTitle({
      title: label//页面标题为路由参数
    });
    this.setData({
      label: label,
      userId: app.globalData.openId
    })
    if(label == "发布记录") {
      url = urlList.publishHistory(this.data.userId);
    } else if(label == "浏览历史") {
      url = urlList.viewHistory(this.data.userId);
    } else if(label == "我的收藏") {
      url = urlList.myfavor(this.data.userId);
    } else {
      url = urlList.viewByType(this.options.typeId);
    }
    wx.request({
      url: url,
      method: "GET",
      dataType: "json",
      success:  (res) => {
        if (res.statusCode == 200) {
          if(res.data.length != 0){
            res.data.forEach(info => {
              info.createdate = util.formatTime(new Date(info.createdate)),
              info.picUrl = info.picUrl?info.picUrl.split(','):null
            });
            this.setData({
              newsList: res.data,
              newsEmpty: false
            })
          } else {
            this.setData({
              newsEmpty: true
            })
          }
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
  }
})