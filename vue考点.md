## #v-bind和v-model的区别

1.v-bind用来绑定数据和属性以及表达式，缩写为'：'
2.v-model使用在表单中，实现双向数据绑定的，在表单元素外使用不起作用

```
<input type="radio" value="one" v-model="radioVal" />
<input type="radio" value="two" v-model="radioVal" />
<label for v-bind="radioval" />
```

radioval的值随着选择单选框的值，会变成one 或者 two



## #插值表达式和v-text以及v-html的区别

### ##插值表达式

当页面刷新比较频繁或者网上较慢的时候，我们使用插值表达式页面会先出现‘{{message}}’，再用真实数据替换‘{{message}}’

解决上述问题的办法v-cloak,这个指令可以隐藏未编译的标签直到实例准备完毕

![img](https://img-blog.csdnimg.cn/20190203212944571.png)

![img](https://img-blog.csdnimg.cn/20190203213053719.png)

### ##v-text

![1575132589180](C:\Users\Administrator.Q92LDCJZDC7LONE\AppData\Roaming\Typora\typora-user-images\1575132589180.png)

结论：插值表达式相当于一个占位符，只会替换掉其中的占位置的内容，v-text只能显示Vue对象传递过来的数据，会替换掉节点里已有的内容。

### ##v-html

如果Vue对象传递过来的数据含有HTML标签,能够将html标签解析出来

插值表达式和v-text不能够解析html标签，v-html能够解析html标签