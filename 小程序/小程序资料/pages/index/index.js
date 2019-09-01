//index.js
//获取应用实例
var app = getApp()
//相对路径
var common = require("../../common/common");
Page({
  data: {
    motto: 'tangcaiye',
    userInfo: {}
  },
  //事件处理函数
  bindViewTap: function() {
    console.log(this.data.motto);
    //页面跳转
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  changeMotto:function (){

    this.setData({
      motto:"你好 世界!"
    });
  },
  //当页面加载好之后执行的
  onLoad: function () {
    common.sayHello("zhagnsan");
    console.log('onLoad')
    var that = this
    //调用应用实例的方法获取全局数据
    app.getUserInfo(function(userInfo){
      //更新数据
      console.log(userInfo);
      that.setData({
        userInfo:userInfo
      })
    })
  }
})
