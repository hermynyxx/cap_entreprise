<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<%
    Object title = request.getAttribute("title");
    if (title == null) {
        title = "Cap-Entreprise";
    }
    request.setAttribute("title", title);
%>

<html>
    <head>
        <title>${title}</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" rel="stylesheet"/>
        <link  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet"/>

        <link href="${contextPath}/css/main.css" rel="stylesheet">


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
        <script type="text/javascript" src="${contextPath}/js/main.js"></script>
    </head>
    <body>








