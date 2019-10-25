<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Donation make the world better</title>

    <link href="${pageContext.request.contextPath}/css/slider.css"
          rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/common.css"
          rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/index.css"
          rel="stylesheet" type="text/css"/>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/js/Notify.js"></script>
            
    <script type="text/javascript">
 
    function initialize()
    {
     var b = new xWin("1",600,200,300,200,"Donate make the world better","We should doante our goods");
    }
    window.onload = initialize;
 
</script>

</head>
<body>
<div class="container header">
    <div class="span5">

    </div>
    <div class="span9">
        <div class="headerAd">

        </div>
    </div>

    <!-- 包含进去首页头部的文件 -->
    <%@ include file="menu.jsp" %>

</div>

<div class="container index">

    <!-- 热门商品 -->
    <div class="span24">
        <div id="hotProduct" class="hotProduct clearfix">

            <div class="title">
                <strong>Almost Achieve</strong>
            </div>

            <ul class="tab">
                <li class="current"><a href="#" target="_blank"></a></li>
                <li><a target="_blank"></a></li>
                <li><a target="_blank"></a></li>
            </ul>

            <ul class="tabContent" style="display: block;">
                <c:forEach var="p" items="${hList}">
                    <li>
                        <a href="${pageContext.request.contextPath }/findByPid/<c:out value="${p.pid}"/>"
                            target="_blank"> <img
                            src="${pageContext.request.contextPath }/<c:out value="${p.image }"/>"
                            style="display: block;"/></a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>

    <!-- 最新商品 -->
    <div class="span24">
        <div id="newProduct" class="newProduct clearfix">
            <div class="title">
                <strong>New Donation Information</strong> <a target="_blank"></a>
            </div>
            <ul class="tab">
                <li class="current"><a href="#" target="_blank"></a></li>
                <li><a target="_blank"></a></li>
                <li><a target="_blank"></a></li>
            </ul>

            <ul class="tabContent" style="display: block;">
                <c:forEach items="${nList }" var="p">
                    <li><a
                            href="${pageContext.request.contextPath }/findByPid/<c:out value="${p.pid}"/>"
                            target="_blank"><img
                            src="${pageContext.request.contextPath}/<c:out value="${p.image}"/>"
                            style="display: block;"/></a></li>
                </c:forEach>
            </ul>
        </div>
    </div>

    <div class="span24">

    </div>
</div>

<div class="container footer">
    <%--<div class="span24">
        <div class="copyright">Copyright © 2016-2016  版权所有</div>
    </div>--%>
</div>
</body>
</html>