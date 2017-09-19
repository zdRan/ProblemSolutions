# Html 里加载 markdown 文本
## 环境
+ Ajax
+ markdown
+ Html
+ Strapdown.js、Showdown.js or Marked.js

## 解决方案
###  0x01 Strapdown.js
引入 Strapdown.js [Github 地址](https://github.com/arturadib/strapdown)

使用方式非常简单粗暴
```
<!DOCTYPE html>
<html>
<title>Hello Strapdown</title>

<xmp theme="united" style="display:none;">
# Markdown 内容
这是一段 markdown文本。
</xmp>

<script src="http://strapdownjs.com/v/0.2/strapdown.js"></script>
</html>
```
需要注意的是，要把导入js的script放到文本之后。

缺点：破坏了html 的格式(没有body标签，并且不支持其他标签)。
### 0x02 Showdown.js
引入 Showdown.js [Github地址](https://github.com/showdownjs/showdown) 
```
 $.ajax({
	   url: "/markdown.md",//文件位置
	   type: "GET",//请求方式为get
	   dataType: "text", //返回数据格式
	   success: function(data) {//请求成功完成后要执行的方法 
			var converter = new showdown.Converter();
			var html = converter.makeHtml(data);
			$("#content").html(html);
	   }
	})
```
### 0x03 Marked.js
引入 Marked.js [Github地址](https://github.com/chjj/marked) 

通过Ajax请求md文档
```
  $.ajax({
	   url: "/markdown.md",//文件位置
	   type: "GET",//请求方式为get
	   dataType: "text", 
	   success: function(data) {//请求成功完成后要执行的方法
		   $("#content").html(marked(data));
	   }
	})
```