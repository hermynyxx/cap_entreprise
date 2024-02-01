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
        <script type="text/javascript" src="${contextPath}/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript" src="${contextPath}/js/hide-show.js"></script>
        <script type="text/javascript" src="${contextPath}/js/sortable.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg  navbar-dark bg-dark mask-custom shadow-none" id="navbar">
            <div class="container-fluid">
                <a class="navbar-brand me-2" href="${contextPath}/">
                    <img src="${contextPath}/css/asset/logo.png" alt="logo" id="logo" style="width:44px; height:44px">
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon pe-3"></span>
                </button>
                <security:authorize access="isAuthenticated()">
                <div class="collapse navbar-collapse justify-content-center" id="navbarTogglerDemo02">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item px-3" id="item-navbar">
                            <a class="nav-link custom-link fw-bolder" aria-current="page" href="${UrlRoute.URL_GAME}">JEUX</a>
                        </li>
                        <li class="nav-item px-3" id="item-navbar">
                            <a class="nav-link custom-link fw-bolder" aria-current="page" href="${UrlRoute.URL_REVIEW}">AVIS</a>
                        </li>
                </security:authorize>
                    <security:authorize access="isAuthenticated()">

                        <li class="nav-item dropdown px-3">

                            <a class="nav-link dropdown-toggle " href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                               <i class="fa-regular fa-user"></i>
                            </a>

                             <ul class="dropdown-menu dropdown-menu-dark dropdown-end">
                                <li>
                                    <a class="dropdown-item" href="${UrlRoute.URL_USER}/${userLogged.nickname}">Profil</a>
                                </li>
                                <li>
                                   <form method="POST" action="${UrlRoute.URL_LOGOUT}" autocomplete="off">
                                       <button type="submit" class="dropdown-item" title="Se déconnecter">
                                           Se déconnecter
                                       </button>
                                       <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                   </form>
                                </li>
                             </ul>
                        </li>
                    </ul>
                </security:authorize>

                <security:authorize access="!isAuthenticated()">
                    <a class="d-flex py-2 px-2" href="${UrlRoute.URL_LOGIN}">
                        <button class="btn btn-outline-success bolder btn-sm rounded-pill" type="submit" id="btn-navbar">
                            CONNEXION
                        </button>
                    </a>
                </security:authorize>

                </div>
            </div>
        </nav>










