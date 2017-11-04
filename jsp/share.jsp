<%--
  Created by IntelliJ IDEA.
  User: ouyangyi
  Date: 17/10/17
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>很对，作为一个测试页，不知道塞什么内容，点击下面的分享邀请即可</p>
<br/>
<p>很对，作为一个测试页，不知道塞什么内容，点击下面的分享邀请即可</p>
<br/>
<p>以下才是重点</p>
<div class="foot_TL">
    <ul>
        <li onclick="share()"><a href="javascript:">分享邀请</a></li>
    </ul>
</div>
</body>

<script>
    var title = "我是标题";
    var content = "我是内容";
    var url = "落地页的链接";
    function share() {
        dsBridge.call("share",	{title:	title,content:content,
            imageUrl: "图片链接哟",url:url}, function(flag){alert(flag);})
    }
</script>
</html>
