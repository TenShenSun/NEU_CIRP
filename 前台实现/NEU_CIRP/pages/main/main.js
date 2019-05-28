const app = getApp();
const util = require('../../utils/util.js');
const baseUrl = app.globalData.baseUrl;
const urlList = app.globalData.urlList;
const userId = app.globalData.openId;
// const userId = 'tianshengdagoudan111';

Page({
  data: {
    // background: ['demo-text-1', 'demo-text-2', 'demo-text-3'],
    headLineNews: {},
    swiperImage: ["http://cdn.wenshengtech.cn/tmp/wxc421d0a0e5ea69f3.o6zAJs4A4MgHA_x5Mc6_NDhFal1s.rnfzbcduo5eD5c7e47f0c5e6b4c9772612513464d24d.jpg","http://cdn.wenshengtech.cn/tmp/wxc421d0a0e5ea69f3.o6zAJs4A4MgHA_x5Mc6_NDhFal1s.TNveRllPvqa70a6fa2c7650be121ae1b648eb19d9a03.jpg", "http://cdn.wenshengtech.cn/tmp/wxc421d0a0e5ea69f3.o6zAJs4A4MgHA_x5Mc6_NDhFal1s.uIQCtQN6ONwu3640da6793b6c90a46ee058170896209.jpg", "http://cdn.wenshengtech.cn/tmp/wxc421d0a0e5ea69f3.o6zAJs4A4MgHA_x5Mc6_NDhFal1s.2ziI7DzGyt5xe6048d16bc0b7ee81da4c80ddd0986db.jpg"
    ],
    newsList: [],
    infoTypes: [{
        id: 1,
        label: "官方公告",
        iconName: "comment"
      },
      {
        id: 2,
        label: "招聘宣讲",
        iconName: "friends"
      },
      {
        id: 3,
        label: "社团活动",
        iconName: "fire"
      },
      {
        id: 4,
        label: "失物招领",
        iconName: "send-gift"
      },
      {
        id: 5,
        label: "二手交易",
        iconName: "gold-coin"
      },
      {
        id: 6,
        label: "表白墙",
        iconName: "like"
      },
      {
        id: 7,
        label: "新鲜事",
        iconName: "chat"
      },
      {
        id: 8,
        label: "每周话题",
        iconName: "column"
      }
    ]
  },
  clickType: function (event) {
    wx.navigateTo({
      url: '/pages/newsList/newsList?label=' + event.currentTarget.dataset.label + '&typeId=' + event.currentTarget.dataset.id
    })
  },
  bindViewTap: function (event) {
    wx.navigateTo({
      url: '/pages/newsDetail/newsDetail?id=' + event.currentTarget.dataset.id
    })
  },
  onLoad: function (options) {
    wx.showLoading({
      title: '加载中',
      mask: true
    });
    wx.request({
      url: urlList.hotNews,
      method: "GET",
      dataType: "json",
      success: (res) => {
        if (res.statusCode == 200) {
          let info = res.data[0];
          info.createdate = util.formatTime(new Date(info.createdate));
          this.setData({
            headLineNews: info
          })
          console.log(info)
        }
      },
      fail: (err) => {
        wx.showModal({
          content: '服务异常，数据请求失败,请检查网络',
          showCancel: false
        })
      },
      complete: () => {
        wx.hideLoading()
      }
    })
  },
  onShow: function () {
    console.log("-----返回刷新数据---")
    wx.showLoading({
      title: '加载中',
      mask: true
    });
    console.log("加载中")
    console.log(urlList.newInfoList)
    wx.request({
      url: urlList.newInfoList,
      method: "GET",
      dataType: "json",
      success: (res) => {
        if (res.statusCode == 200) {
          res.data.forEach(info => {
            info.createdate = util.formatTime(new Date(info.createdate));
            info.picUrl = info.picUrl?info.picUrl.split(','):null;
            info.readCount = info.readCount?info.readCount:0;
            info.favCount = info.favCount?info.favCount:0;
            if(info.isAnony) {
              info.user.avatarUrl = "http://cdn.wenshengtech.cn/tmp/wxed586a22500273e6.o6zAJs4A4MgHA_x5Mc6_NDhFal1s.0Ghsdo9Yi9nVd9b2bbfba97b8d116ef79da1485964b1.jpg";
              info.user.username = "匿名用户"
            }
          });
          this.setData({
            newsList: res.data
          })
        }
      },
      fail: (err) => {
        wx.showModal({
          content: '服务异常，数据请求失败,请检查网络',
          showCancel: false
        })
      },
      complete: () => {
        wx.hideLoading()
      }
    })
  },
})