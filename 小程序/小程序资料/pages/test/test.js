//1.获取应用的实例
var app = getApp();
var common = require("../../common/common.js");

Page({
  data:{
    // text:"这是一个页面"
    name:"tangcaiye",
    pass:null,
    id:8,
    bol: true,
    arr:[1,2,3,4,5],
    obj1:{
      a:3,
      b:4
    }
  },
  show:function (){
    // var bol = this.data.bol;
    this.setData({
      bol: !this.data.bol
    });
  },
  say:function (){
    common.sayHello(this.data.name);
  },
  toIndex:function (){
    wx.navigateTo({
      url:"../navii/navi",
      success:function (){
        console.log("跳转到navi成功");
      }
    });
  },
  outterTap:function (event){
    console.log(event);
    console.log("触发了outter的tap事件");
  },
  middleTap:function (event){
    console.log(event);
    console.log("触发了middle的tap事件");
  },
  innerTap:function (event){
    console.log(event);
    console.log("触发了inner的tap事件");
  },
  onLoad:function(options){
    // 页面初始化 options为页面跳转所带来的参数
    this.setData({
      pass:app.globalData.pass
    });
  },
  onReady:function(){
    // 页面渲染完成
  },
  onShow:function(){
    // 页面显示
    console.log("这个测试页里的onShow方法");
  },
  onHide:function(){
    // 页面隐藏
  },
  onUnload:function(){
    // 页面关闭
  }
})