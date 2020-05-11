<%--
  Created by IntelliJ IDEA.
  User: rubeen
  Date: 03.11.17
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Informationen</title>
</head>
<body>
bufferSize: ${pageContext.out.bufferSize}<br>
remaining: ${pageContext.out.remaining}<br>
characterEncoding: ${pageContext.response.characterEncoding}<br>
contentType: ${pageContext.response.contentType}<br>
locale: ${pageContext.response.locale}<br>
contextPath: ${pageContext.request.contextPath}<br>
localAddr: ${pageContext.request.localAddr}<br>
localName: ${pageContext.request.localName}<br>
localPort: ${pageContext.request.localPort}<br>
method: ${pageContext.request.method}<br>
protocol: ${pageContext.request.protocol}<br>
remoteAddr: ${pageContext.request.remoteAddr}<br>
remoteHost: ${pageContext.request.remoteHost}<br>
remotePort: ${pageContext.request.remotePort}<br>
requestedSessionId: ${pageContext.request.requestedSessionId}<br>
requestURI: ${pageContext.request.requestURI}<br>
scheme: ${pageContext.request.scheme}<br>
serverName: ${pageContext.request.serverName}<br>
serverPort: ${pageContext.request.serverPort}<br>
servletPath: ${pageContext.request.servletPath}<br>
dispatcherType: ${pageContext.request.dispatcherType}<br>
country: ${pageContext.request.locale.country}<br>
language: ${pageContext.request.locale.language}<br>
requestURL: ${pageContext.request.requestURL}<br>
creationTime: ${pageContext.session.creationTime}<br>
id: ${pageContext.session.id}<br>
lastAccessedTime: ${pageContext.session.lastAccessedTime}<br>
maxInactiveInterval: ${pageContext.session.maxInactiveInterval}<br>


request parameters: ${pageContext.request.parameterNames}<br>
request headers: ${pageContext.request.headerNames}<br>
request attributes: ${pageContext.request.attributeNames}<br>
session attributes: ${pageContext.session.attributeNames}<br>
init-parameters of configuration: ${pageContext.servletConfig.initParameterNames}<br>
init-parameters of servlet: ${pageContext.servletContext.initParameterNames}<br>
cookies: ${pageContext.request.cookies}<br>
</body>
</html>
