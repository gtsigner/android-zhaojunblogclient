# zhaojunblog-android
学习了android基础，看到了google的,material design，感觉很厉害，尝试了一下


#Android期末作品说明

-	作者：zhaojunlike
-	GitHub：[https://github.com/zhaojunlike](https://github.com/zhaojunlike)
-	只是一个小案例，并没有完善，下学期继续完善尽量能上线
-	博客地址：[http://www.codedreamers.cn](http://www.codedreamers.cn)
-	开发工具：Android Studio

##客户端
-	Google I/O大会，google的最新设计思想,material design设计,自己想试一试在android当中的应用，现在很多APP已经遵循了material design的规范。

-	程序使用material design，只是一个小案例

-	中文文档：[http://wiki.jikexueyuan.com/project/material-design/](http://wiki.jikexueyuan.com/project/material-design/)

-	v7库中已经包含了支持android的新控件

-	获取服务端数据，Gson第三方框架解析json数据



##服务端

-	博客端，Onethink 二次开发博客
-	前端：bootstrap+layer
-	服务端使用 php+mysql+redis开发，服务端所有返回数据都以json格式



###接口说明
-	APP更新接口
	-	地址：
	-	参数：

-	获取访问量最高文章	
	-	地址：[http://121.42.146.105/blog/api.php/Article/getHotArticle](http://121.42.146.105/blog/api.php/Article/getHotArticle)
	-	参数：p（int） c（int），页，limitPage数量

-	获取全部文章
	-	地址：[http://121.42.146.105/blog/api.php/Article/getDocuments](http://121.42.146.105/blog/api.php/Article/getDocuments)
	-	参数:cate(obj)分类，p（int） c（int），页，limitPage数量

-	获取分类
	-	地址：[http://121.42.146.105/blog/api.php/Category/getCategory](http://121.42.146.105/blog/api.php/Category/getCategory)
	-	参数：pid（父类ID）
