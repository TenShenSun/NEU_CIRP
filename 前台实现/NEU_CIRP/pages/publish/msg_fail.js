Page({
  backToMain: function() {
    wx.switchTab({
      url: '/pages/main/main'
    })
  },
  continuePublish: function() {
    wx.switchTab({
      url: '/pages/publish/publish'
    })
  }
});