//app.js
const urlConfig = require('./utils/config.js');

App({
  onLaunch: function () {
    var that = this;

    //登录
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
        that.getUserInfo(res,that)
      }
    })
    // 获取用户信息
    wx.getSetting({
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.getUserInfo({
            success: res => {
              // 可以将 res 发送给后台解码出 unionId
              this.globalData.userInfo = res.userInfo

              // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
              // 所以此处加入 callback 以防止这种情况
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res)
              }
            }
          })
        } else {
          console.log("+++")
          wx.navigateTo({
            url: '/pages/login/login'
          })
        }
      }
    })
  },
  getUserInfo: function (res,that) {
    console.log("=========================== app.js res=============================")
    console.log(res)
    if (res.code) {
      // wx.getUserInfo({
      //   success: function (res) {
      //     var user = {};
      //     user.avatarUrl = res.userInfo.avatarUrl;
      //     user.nickName = res.userInfo.nickName;
      //     //console.log(objz);
      //     //将用户的头像和nickname放入全局变量和缓存中
      //     that.globalData.userInfo = user;
      //     wx.setStorageSync('userInfo', user);//存储userInfo
      //   }
      // });
      var d = that.globalData;//这里存储了appid、secret、token串  

      // var l = 'https://api.weixin.qq.com/sns/jscode2session?appid=' + d.appid + '&secret=' + d.secret + '&js_code=' + res.code + '&grant_type=authorization_code';

      // var l = "http://localhost:8080/login/" + d.appid + "/" + d.secret + "/" + res.code
      var l = "https://www.wenshengtech.cn/forum/login/" + d.appid + "/" + d.secret + "/" + res.code
      console.log("==========================app.js url=============================")
      console.log(l)
      wx.request({
        url: l,
        data: {},
        method: 'GET', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT  
        // header: {}, // 设置请求的 header  
        success: function (res) {
          console.log("========================== app.js res2=============================")
          console.log(res)
          that.globalData.openId = res.data.openid;
          console.log(that.globalData.openId)
          console.log("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
          //console.log(that.openIdCallback)
          if (that.openIdCallback) {
            console.log("=================================openIdCallback=========================================")
            that.openIdCallback(res.data.openid);
          }

          //var obj = {};
          //obj.openid = res.data.openid;
          //obj.expires_in = Date.now() + res.data.expires_in;
          //console.log(obj);
          //wx.setStorageSync('user', obj);//存储openid  
        }
      });
    } else {
      console.log('获取用户登录态失败！' + res.errMsg)
    }
  },
  globalData: {
    userInfo: null,
    openId: null,
    appid: "wxed586a22500273e6",
    secret: "4355ee77bb335d8af2a891974e0cc98a",
    // appid: "wxc421d0a0e5ea69f3",
    // secret: "4a3e05da84bbaccd6766ee81a43b7cd4",
    urlList: urlConfig.urlList,
    baseUrl: "https://www.wenshengtech.cn/forum"
  }
})
//发布
// appid: "wxed586a22500273e6",
// secret: "4355ee77bb335d8af2a891974e0cc98a",

//测试
// appid: "wxc421d0a0e5ea69f3",
    // secret: "4a3e05da84bbaccd6766ee81a43b7cd4",