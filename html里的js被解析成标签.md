# html里的js被解析成标签
## 环境
+ spring boot项目
+ html页面，内部含有的js代码

## 页面部分代码

```
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head lang="en">
<meta charset="utf-8"></meta>
<meta http-equiv="X-UA-Compatible" content="IE=edge"></meta>
<meta name="viewport" content="width=device-width, initial-scale=1"></meta>

<body>
	//...
</body>

<script th:inline="javascript">
	//...
	function toVaild(){
		var success = true;
		var arr = new Array();
		//...
		for(var i = 0;i < arr.length; i++){
			//...
		}
		return success;
	}
	//...	
</script>
</html>
```

## 报错信息
```
org.xml.sax.SAXParseException: 元素类型 "arr.length" 必须后跟属性规范 ">" 或 "/>"。
	at com.sun.org.apache.xerces.internal.util.ErrorHandlerWrapper.createSAXParseException(ErrorHandlerWrapper.java:203) ~[?:1.8.0_131]
	at com.sun.org.apache.xerces.internal.util.ErrorHandlerWrapper.fatalError(ErrorHandlerWrapper.java:177) ~[?:1.8.0_131]
	at com.sun.org.apache.xerces.internal.impl.XMLErrorReporter.reportError(XMLErrorReporter.java:400) ~[?:1.8.0_131]
	at com.sun.org.apache.xerces.internal.impl.XMLErrorReporter.reportError(XMLErrorReporter.java:327) ~[?:1.8.0_131]
	at com.sun.org.apache.xerces.internal.impl.XMLScanner.reportFatalError(XMLScanner.java:1472) ~[?:1.8.0_131]
	at com.sun.org.apache.xerces.internal.impl.XMLDocumentFragmentScannerImpl.seekCloseOfStartTag(XMLDocumentFragmentScannerImpl.java:1394) ~[?:1.8.0_131]
	at com.sun.org.apache.xerces.internal.impl.XMLDocumentFragmentScannerImpl.scanStartElement(XMLDocumentFragmentScannerImpl.java:1309) ~[?:1.8.0_131]
	at com.sun.org.apache.xerces.internal.impl.XMLDocumentFragmentScannerImpl$FragmentContentDriver.next(XMLDocumentFragmentScannerImpl.java:2784) ~[?:1.8.0_131]
	at com.sun.org.apache.xerces.internal.impl.XMLDocumentScannerImpl.next(XMLDocumentScannerImpl.java:602) ~[?:1.8.0_131]
	at com.sun.org.apache.xerces.internal.impl.XMLDocumentFragmentScannerImpl.scanDocument(XMLDocumentFragmentScannerImpl.java:505) ~[?:1.8.0_131]
	at com.sun.org.apache.xerces.internal.parsers.XML11Configuration.parse(XML11Configuration.java:841) ~[?:1.8.0_131]
	at com.sun.org.apache.xerces.internal.parsers.XML11Configuration.parse(XML11Configuration.java:770) ~[?:1.8.0_131]
	at com.sun.org.apache.xerces.internal.parsers.XMLParser.parse(XMLParser.java:141) ~[?:1.8.0_131]
	at com.sun.org.apache.xerces.internal.parsers.AbstractSAXParser.parse(AbstractSAXParser.java:1213) ~[?:1.8.0_131]
	at com.sun.org.apache.xerces.internal.jaxp.SAXParserImpl$JAXPSAXParser.parse(SAXParserImpl.java:643) ~[?:1.8.0_131]
	at com.sun.org.apache.xerces.internal.jaxp.SAXParserImpl.parse(SAXParserImpl.java:327) ~[?:1.8.0_131]
	at org.thymeleaf.templateparser.xmlsax.AbstractNonValidatingSAXTemplateParser.doParse(AbstractNonValidatingSAXTemplateParser.java:209) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
	at org.thymeleaf.templateparser.xmlsax.AbstractNonValidatingSAXTemplateParser.parseTemplateUsingPool(AbstractNonValidatingSAXTemplateParser.java:134) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
	at org.thymeleaf.templateparser.xmlsax.AbstractNonValidatingSAXTemplateParser.parseTemplate(AbstractNonValidatingSAXTemplateParser.java:116) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
	at org.thymeleaf.TemplateRepository.getTemplate(TemplateRepository.java:278) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
	at org.thymeleaf.TemplateEngine.process(TemplateEngine.java:1104) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
	at org.thymeleaf.TemplateEngine.process(TemplateEngine.java:1060) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
	at org.thymeleaf.TemplateEngine.process(TemplateEngine.java:1011) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
	at org.thymeleaf.spring4.view.ThymeleafView.renderFragment(ThymeleafView.java:335) ~[thymeleaf-spring4-2.1.5.RELEASE.jar:2.1.5.RELEASE]
	at org.thymeleaf.spring4.view.ThymeleafView.render(ThymeleafView.java:190) ~[thymeleaf-spring4-2.1.5.RELEASE.jar:2.1.5.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.render(DispatcherServlet.java:1286) ~[spring-webmvc-4.3.9.RELEASE.jar:4.3.9.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.processDispatchResult(DispatcherServlet.java:1041) ~[spring-webmvc-4.3.9.RELEASE.jar:4.3.9.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:984) ~[spring-webmvc-4.3.9.RELEASE.jar:4.3.9.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:901) ~[spring-webmvc-4.3.9.RELEASE.jar:4.3.9.RELEASE]
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:970) ~[spring-webmvc-4.3.9.RELEASE.jar:4.3.9.RELEASE]
	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:861) ~[spring-webmvc-4.3.9.RELEASE.jar:4.3.9.RELEASE]
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:635) ~[tomcat-embed-core-8.5.15.jar:8.5.15]
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:846) ~[spring-webmvc-4.3.9.RELEASE.jar:4.3.9.RELEASE]
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:742) ~[tomcat-embed-core-8.5.15.jar:8.5.15]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231) ~[tomcat-embed-core-8.5.15.jar:8.5.15]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-8.5.15.jar:8.5.15]
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52) ~[tomcat-embed-websocket-8.5.15.jar:8.5.15]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-8.5.15.jar:8.5.15]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-8.5.15.jar:8.5.15]
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:99) ~[spring-web-4.3.9.RELEASE.jar:4.3.9.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) ~[spring-web-4.3.9.RELEASE.jar:4.3.9.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-8.5.15.jar:8.5.15]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-8.5.15.jar:8.5.15]
	at org.springframework.web.filter.HttpPutFormContentFilter.doFilterInternal(HttpPutFormContentFilter.java:105) ~[spring-web-4.3.9.RELEASE.jar:4.3.9.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) ~[spring-web-4.3.9.RELEASE.jar:4.3.9.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-8.5.15.jar:8.5.15]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-8.5.15.jar:8.5.15]
	at org.springframework.web.filter.HiddenHttpMethodFilter.doFilterInternal(HiddenHttpMethodFilter.java:81) ~[spring-web-4.3.9.RELEASE.jar:4.3.9.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) ~[spring-web-4.3.9.RELEASE.jar:4.3.9.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-8.5.15.jar:8.5.15]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-8.5.15.jar:8.5.15]
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:197) ~[spring-web-4.3.9.RELEASE.jar:4.3.9.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) ~[spring-web-4.3.9.RELEASE.jar:4.3.9.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-8.5.15.jar:8.5.15]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-8.5.15.jar:8.5.15]
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:198) [tomcat-embed-core-8.5.15.jar:8.5.15]
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:96) [tomcat-embed-core-8.5.15.jar:8.5.15]
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:478) [tomcat-embed-core-8.5.15.jar:8.5.15]
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:140) [tomcat-embed-core-8.5.15.jar:8.5.15]
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:80) [tomcat-embed-core-8.5.15.jar:8.5.15]
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:87) [tomcat-embed-core-8.5.15.jar:8.5.15]
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:342) [tomcat-embed-core-8.5.15.jar:8.5.15]
	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:799) [tomcat-embed-core-8.5.15.jar:8.5.15]
	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:66) [tomcat-embed-core-8.5.15.jar:8.5.15]
	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:861) [tomcat-embed-core-8.5.15.jar:8.5.15]
	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1455) [tomcat-embed-core-8.5.15.jar:8.5.15]
	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49) [tomcat-embed-core-8.5.15.jar:8.5.15]
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142) [?:1.8.0_131]
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617) [?:1.8.0_131]
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) [tomcat-embed-core-8.5.15.jar:8.5.15]
	at java.lang.Thread.run(Thread.java:748) [?:1.8.0_131]

```
## 解决方案

```
<script th:inline="javascript">
/*<![CDATA[*/

	...
	...

/*]]>*/	
</script>
```

## 原因分析
js里的```<```被误解析成html的标签了。
有两种解释，一种是在XHTML里的<script>标签里的内容一样会被当成html对待，所以出现上面的问题。
但问题是我的不是XHTML，而是html。不知道是什么原因。

还有一种是，```org.thymeleaf.templateparser```,这个里边内置了一些标签，冲突导致的问题。