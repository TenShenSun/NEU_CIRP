const app = getApp();
const util = require('../../utils/util.js');
const baseUrl = app.globalData.baseUrl;
const urlList = app.globalData.urlList;

Page({
  data: {
    userInfo: {},
    hasUserInfo: app.globalData.userInfo,
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },
  // onLoad: function () {
  //   // if (app.globalData.userInfo) {
  //   //   console.log(app.globalData.userInfo)
  //   //   this.setData({
  //   //     userInfo: app.globalData.userInfo,
  //   //     hasUserInfo: true
  //   //   })
  //   // } else if (this.data.canIUse){
  //   //   // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
  //   //   // 所以此处加入 callback 以防止这种情况
  //   //   app.userInfoReadyCallback = res => {
  //   //     console.log(res.userInfo)
  //   //     this.setData({
  //   //       userInfo: res.userInfo,
  //   //       hasUserInfo: true
  //   //     })
  //   //   }
  //   console.log("==========================================================")
  //   console.log(app.globalData.userInfo)
  //   //console.log(app.globalData.userInfo.openId)
  //   //if (app.globalData.userInfo||app.globalData.openId!=null) {
  //   if (app.globalData.openId) {
  //     console.log("====================setData================================")
  //     this.setData({
  //       userInfo: app.globalData.userInfo,
  //       openId: app.globalData.openId,
  //       hasUserInfo: true
  //     })
  //   } else if (this.data.canIUse){
  //     console.log("====================this.data.canIUse================================")
  //     // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
  //     // 所以此处加入 callback 以防止这种情况
  //     //app.userInfoReadyCallback = res => {
  //     app.userInfoReadyCallback = openId => {
  //       console.log("================app.globalData.userInfo========================+++++++++++++++++++++++++++++++++++++++")
  //       console.log(app.globalData.userInfo)
  //       console.log(app.globalData.openId)
  //       // this.setData({
  //       //   userInfo: res.userInfo,
  //       //   hasUserInfo: true
  //       // })
  //       this.setData({
  //         userInfo:app.globalData.userInfo,
  //         openId:app.globalData.openId,
  //         //hasUserInfo:true
  //       })
  //     }
  //   } else {
  //     console.log("====================在没有 open-type=getUserInfo 版本的兼容处理================================")
  //     // 在没有 open-type=getUserInfo 版本的兼容处理
  //     wx.getUserInfo({
  //       success: res => {
  //         app.globalData.userInfo = res.userInfo
  //         this.setData({
  //           userInfo: res.userInfo,
  //           hasUserInfo: true
  //         })
  //       }
  //     })
  //   }
  // },
  getUserInfo: function(e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
    wx.request({
      url: urlList.setUser,
      method: "POST",
      dataType: "json",
      data: {
        id: app.globalData.openId,
        username: e.detail.userInfo.nickName,
        avatarUrl: e.detail.userInfo.avatarUrl
      },
      success: (res) => {
        if (res.statusCode == 200) {
          console.log(res)
        }
      },
      fail: (err) => {
      }
    })
    wx.switchTab({
      url: '../main/main'
    })
    // wx.setStorageSync('userInfo', e.detail.userInfo);//存储openid  
  }
})
