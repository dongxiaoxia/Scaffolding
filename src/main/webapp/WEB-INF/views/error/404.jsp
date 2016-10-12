<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=${ctxStatic}edge">
    <meta charset="UTF-8">
    <title>手脚架</title>
    <style>
        html,body {
            overflow-x: hidden;
            width: 100%;
            height: 100%;
            margin: 0;
            padding: 0;
        }
        .content {
            width: 337px;
            height: 224px;
            margin: 0 auto; /*水平居中*/
            position: relative; /*脱离文档流*/
            top: 50%; /*偏移*/
            transform: translateY(-50%);
        }
    </style>
</head>
<body>
<div class="content">
    <img  src="${ctxStatic}/images/404.png">
</div>
</body>
</html>

