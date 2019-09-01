var order = ["a","b","c"];
var index = 0;
var progressNum = 0;

var rectX = 0;

//用于返回豆瓣前250名的电影
var api = "https://api.douban.com/v2/movie/top250";

Page({
	data:{
		toView:"a",
		imgUrls:[
			'http://img02.tooopen.com/images/20150928/tooopen_sy_143912755726.jpg',
      		'http://img06.tooopen.com/images/20160818/tooopen_sy_175866434296.jpg',
      		'http://img06.tooopen.com/images/20160818/tooopen_sy_175833047715.jpg'
		],
		inter:2000,
		autopaly:true,
		iconType:[
		'success', 'info', 'warn', 'waiting', 'safe_success', 'safe_warn',
      'success_circle', 'success_no_circle', 'waiting_circle', 'circle', 'download',
      'info_circle', 'cancel', 'search', 'clear'
		],
		progress:0,
		disabledBol:false,
		country: [
      {name: 'USA', value: '美国'},
      {name: 'CHN', value: '中国', checked: 'true'},
      {name: 'BRA', value: '巴西'},
      {name: 'JPN', value: '日本'},
      {name: 'ENG', value: '英国'},
      {name: 'TUR', value: '法国'},
    ],
    	citys:["北京","上海","广州","深圳"],
    	index:0,
    	time:"09:01",
    	date:"2016",
    	poster: 'http://y.gtimg.cn/music/photo_new/T002R300x300M000003rsKF44GyaSk.jpg?max_age=2592000',
	    name: '此时此刻',
	    author: '许巍',
	    src: 'http://ws.stream.qqmusic.qq.com/M500001VfvsJ21xFqb.mp3?guid=ffffffff82def4af4b12b3cd9337d5e7&uin=346897220&vkey=6292F51E1E384E06DCBDC9AB7C49FD713D632D313AC4858BACB8DDD29067D3C601481D36E62053BF8DFEAF74C0A5CCFADD6471160CAF3E6A&fromtag=46',
	  	imageSrc:"../../images/cat.jpg",
	  	imageArray:[{
      mode: 'scaleToFill',
      text: 'scaleToFill：不保持纵横比缩放图片，使图片完全适应'
    }, { 
      mode: 'aspectFit',
      text: 'aspectFit：保持纵横比缩放图片，使图片的长边能完全显示出来'
    }, { 
      mode: 'aspectFill',
      text: 'aspectFill：保持纵横比缩放图片，只保证图片的短边能完全显示出来'
    }, { 
      mode: 'top',
      text: 'top：不缩放图片，只显示图片的顶部区域' 
    }, {      
      mode: 'bottom',
      text: 'bottom：不缩放图片，只显示图片的底部区域'
    }, { 
      mode: 'center',
      text: 'center：不缩放图片，只显示图片的中间区域'
    }, { 
      mode: 'left',
      text: 'left：不缩放图片，只显示图片的左边区域'
    }, { 
      mode: 'right',
      text: 'right：不缩放图片，只显示图片的右边边区域'
    }, { 
      mode: 'top left',
      text: 'top left：不缩放图片，只显示图片的左上边区域' 
    }, { 
      mode: 'top right',
      text: 'top right：不缩放图片，只显示图片的右上边区域'
    }, { 
      mode: 'bottom left',
      text: 'bottom left：不缩放图片，只显示图片的左下边区域'
    }, { 
      mode: 'bottom right',
      text: 'bottom right：不缩放图片，只显示图片的右下边区域'
    }],
    	danmuList:[
      {
        text: '第 1s 出现的弹幕',
        color: '#ff0000',
        time: 1
      },
      {
        text: '第 3s 出现的弹幕',
        color: '#ff00ff',
        time: 3
      }
    ],
    markers: [{
      latitude: 23.175200,
      longitude: 113.346410,
      name: '蓝鸥科技',
      desc: '我现在的位置'
    }],
    rectX:0
	},
	getPos:function (){
		wx.getLocation({
		  type: 'gcj02',
		  success: function(res) {
		  	// console.log(res);
		    var latitude = res.latitude
		    var longitude = res.longitude

		    wx.openLocation({
		      latitude: latitude,
		      longitude: longitude,
		      scale: 28
		    })
		  }
		})
	},
	touchstartFn:function (e){
		console.log(e);
	},
	touchmoveFn:function (e){
		console.log(e);
	},
	touchendFn:function (){
		console.log("松开了");
	},
	onReady:function (){
		// this.audioCtx = wx.createAudioContext('myAudio');
		//使用wx.createContext获取绘图的上下文
		var context = wx.createContext("firstCanvas");

		var frameNum = 0;

		/*context.setStrokeStyle("#00ff00");
		context.rect(0,20,50,50);
		context.stroke();
		context.fill();

		wx.drawCanvas({
			canvasId:"firstCanvas",
			actions: context.getActions() // 获取绘图动作数组
		});*/

		function draw(){

			context.setStrokeStyle("#00ff00");
			context.rect(rectX,20,50,50);
			context.stroke();
			context.fill();

			wx.drawCanvas({
				canvasId:"firstCanvas",
				actions: context.getActions() // 获取绘图动作数组
			});
		}

		function animation(){
			frameNum++;
			if (frameNum%4==0){
				rectX++;
				if (rectX > 200){
					return;
				}
				draw();
			}

			if (frameNum>=10000){
				frameNum = 0;
			}
			
			requestAnimationFrame(animation);
		}
		animation();
	},
	audioPlay:function (){
		this.audioCtx.play();
	},
	audioPause:function (){
		this.audioCtx.pause();
	},
	audio50:function (){
		this.audioCtx.seek(50);
	},
	navigateTo:function (){
		wx.navigateTo({
		  url: '../logs/logs?id=54321&user=tangcaiye'
		})
		/*wx.redirectTo({
		  url: '../logs/logs?id=54321&user=tangcaiye'
		})*/
	},
	showToast:function (){

		wx.showToast({
			title:"删除成功",
			icon:"loading",
			duration:10000,
			success:function (){

				console.log("显示消息框成功");
			}
		});
		wx.request({
		  url: api, 
		  data: {},
		  header: {
		      'Content-Type': 'application/json'
		  },
		  success: function(res) {
		    console.log(res.data);
		    wx.hideToast();
		  }
		})
	},
	showModal:function (){

		wx.showModal({
			title:"提示",
			content:"我是一个模态弹窗",
			showCancel:false,
			cancelText:"点我点我",
			confirmText:"我是缺点",
			success:function (res){

				console.log(res);
			}
		});
	},
	showAction:function (){

		wx.showActionSheet({
		  itemList: ['A', 'B', 'C'],
		  itemColor:"red",
		  success: function(res) {
		    if (!res.cancel) {
		      console.log(res.tapIndex)
		    }
		  }
		})
	},
	bindLineChange:function (e){
		console.log(e.detail);
	},
	bindSwitchChange:function (e){
		console.log(e.detail.value);
	},
	bindSliderChange:function (e){
		console.log(e.detail.value);
	},
	bindRadioChange:function (e){
		console.log(e.detail.value);
	},
	bindDateChange:function (e){

		// console.log(e.detail.value);
		this.setData({
			date:e.detail.value
		});
	},
	bindTimeChange:function (e){

		// console.log(e.detail.value);
		this.setData({
			time:e.detail.value
		});
	},
	bindPickerChange:function (e){
		// console.log(e.detail.value);
		this.setData({
			index: e.detail.value
		});
	},
	blurFn:function (){
		console.log("光标失焦了");
	},
	focusFn:function (e){
		console.log("聚焦了");
	},
	inputFn:function (e){
		var val = "数:"+e.detail.value;
		// console.log(e.detail.value);
		return val;
	},
	checkChange:function (e){
		console.log(e.detail.value);
	},
	resetFn:function (){
		console.log("点击重置了");
	},
	subFn:function (e){
		console.log("提交表单:",e.detail.value);
	},
	changeDisabled:function (){
		this.setData({
			disabledBol:false
		});
	},
	scrolltoupper:function (e){

		console.log(e);
	},
	scrolltolower:function (e){
		console.log(e);
	},
	scroll:function (e){
		console.log(e);
	},
	tapChange:function (){
		index++;
		if (index > order.length-1){
			index = 0;
		}
		this.setData({
			toView:order[index]
		});
	},
	swiperChange:function (e){
		// console.log(e);
	},
	intervalChange:function (e){

		// console.log(e);
		var sliderValue = e.detail.value;

		this.setData({
			inter:sliderValue
		});
	},
	changeAntoplay:function (){

		this.setData({
			autopaly:!this.data.autopaly
		});
	},
	onLoad :function (){

		var that = this;
		var timer = setInterval(function (){

			progressNum++;
			if (progressNum >= 100){
				clearInterval(timer);
			}
			that.setData({
				progress:progressNum
			});
		},30);
	}
});









