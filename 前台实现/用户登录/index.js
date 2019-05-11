//index.js
//获取应用实例
const app = getApp()






Page({
  data: {
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  /*
  onLoad: function () {
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse){
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
  },
  */
  globalData: {
    appid: 'wxd9921564024416e0',//appid需自己提供，此处的appid我随机编写
    secret: '12b9636f38c536a60f07ad2c5c6e6fd2',//secret需自己提供，此处的secret我随机编写
    code: ''

  },
  getUserInfo: function (e) {
    console.log("===========================getUserInfo=============================")
    var that = this
    var user = wx.getStorageSync('user') || {};
    console.log("===========================user=============================")
    console.log(user)
    console.log("===========================e=============================")
    console.log(e)
    var userInfo = wx.getStorageSync('userInfo') || {};
    /*if ((!user.openid || (user.expires_in || Date.now()) < (Date.now() + 600)) && (!userInfo.nickName)) {*/
    if (true) {
      wx.login({
        
        success: function (res) {
          console.log("===========================res=============================")
          console.log(res)
          if (res.code) {
            wx.getUserInfo({
              success: function (res) {
                var objz = {};
                objz.avatarUrl = res.userInfo.avatarUrl;
                objz.nickName = res.userInfo.nickName;
                //console.log(objz);
                wx.setStorageSync('userInfo', objz);//存储userInfo
              }
            });
            var d = that.globalData;//这里存储了appid、secret、token串  
            /*
            var l = 'https://api.weixin.qq.com/sns/jscode2session?appid=' + d.appid + '&secret=' + d.secret + '&js_code=' + res.code + '&grant_type=authorization_code';
            */
            var l = "http://localhost:8080/login/" + d.appid + "/" + d.secret + "/" + res.code
            console.log("==========================url=============================")
            console.log(l)
            wx.request({
              url: l,
              data: {},
              method: 'GET', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT  
              // header: {}, // 设置请求的 header  
              success: function (res) {
                console.log("==========================res=============================")
                console.log(res)
                var obj = {};
                obj.openid = res.data.openid;
                obj.expires_in = Date.now() + res.data.expires_in;
                //console.log(obj);
                wx.setStorageSync('user', obj);//存储openid  
              }
            });
          } else {
            console.log('获取用户登录态失败！' + res.errMsg)
          }
        }
      });
    }
  }

 
  
})
