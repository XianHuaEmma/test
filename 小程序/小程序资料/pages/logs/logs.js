//logs.js
var util = require('../../utils/util.js')
Page({
  data: {
    logs: []
  },
  navigateBack:function (){
    wx.navigateBack({
      delta:2
    });
  },
  onLoad: function (arg) {
    console.log(arg);
    this.setData({
      logs: (wx.getStorageSync('logs') || []).map(function (log) {
        return util.formatTime(new Date(log))
      })
    })
  }
})
