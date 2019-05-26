//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    userInfo: {},
    hasUserInfo: true,
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },
  //事件处理函数
  // bindViewTap: function() {
  //   wx.navigateTo({
  //     url: '../logs/logs'
  //   })
  // },
  onLoad: function () {
    // if (app.globalData.userInfo) {
    //   console.log(app.globalData.userInfo)
    //   this.setData({
    //     userInfo: app.globalData.userInfo,
    //     hasUserInfo: true
    //   })
    // } else if (this.data.canIUse){
    //   // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
    //   // 所以此处加入 callback 以防止这种情况
    //   app.userInfoReadyCallback = res => {
    //     console.log(res.userInfo)
    //     this.setData({
    //       userInfo: res.userInfo,
    //       hasUserInfo: true
    //     })
    //   }
    console.log("==========================================================")
    console.log(app.globalData.userInfo)
    console.log(app.globalData.openId)
    //if (app.globalData.userInfo||app.globalData.openId!=null) {
    if (app.globalData.openId) {
      console.log("====================setData================================")
      this.setData({
        userInfo: app.globalData.userInfo,
        openId: app.globalData.openId,
        hasUserInfo: true
      })
    } else if (this.data.canIUse){
      // console.log("====================this.data.canIUse================================")
      // // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // // 所以此处加入 callback 以防止这种情况
      // //app.userInfoReadyCallback = res => {
      // app.userInfoReadyCallback = openId => {
      //   console.log("================app.globalData.userInfo========================+++++++++++++++++++++++++++++++++++++++")
      //   console.log(app.globalData.userInfo)
      //   console.log(app.globalData.openId)
      //   // this.setData({
      //   //   userInfo: res.userInfo,
      //   //   hasUserInfo: true
      //   // })
      //   this.setData({
      //     userInfo:app.globalData.userInfo,
      //     openId:app.globalData.openId,
      //     //hasUserInfo:true
      //   })
      // }
    } else {
      // console.log("====================在没有 open-type=getUserInfo 版本的兼容处理================================")
      // // 在没有 open-type=getUserInfo 版本的兼容处理
      // wx.getUserInfo({
      //   success: res => {
      //     app.globalData.userInfo = res.userInfo
      //     this.setData({
      //       userInfo: res.userInfo,
      //       hasUserInfo: true
      //     })
      //   }
      // })
    }
  },
  // getUserInfo: function(e) {
  //   console.log(e)
  //   app.globalData.userInfo = e.detail.userInfo
  //   this.setData({
  //     userInfo: e.detail.userInfo,
  //     hasUserInfo: true
  //   })
  // }
})
