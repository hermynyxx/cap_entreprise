<%@ page contentType="text/html;charset=UTF-8" %>


    <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="navbar">
        <div class="container-fluid">
            <a class="navbar-brand me-2" href="">
                <img src="${contextPath}/css/asset/logo.png" alt="logo" id="logo" style="width:60px; height:60px">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon pe-3"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item px-3" id = "item-navbar">
                        <a class="nav-link custom-link fw-bolder" aria-current="page" id="id_container1" href="">PLATE-FORMES</a>
                    </li>
                    <li class="nav-item px-3" id = "item-navbar">
                        <a class="nav-link  custom-link fw-bolder" aria-current="page" href="">JEUX</a>
                    </li>
                    <li class="nav-item px-3" id = "item-navbar">
                        <a class="nav-link  custom-link fw-bolder" aria-current="page" href="">EDITEURS</a>
                    </li>
                    <li class="nav-item px-3" id = "item-navbar">
                        <a class="nav-link  custom-link fw-bolder" aria-current="page" href="">ABONNEMENTS</a>
                    </li>
                </ul>
                        <c:if test="${userLogged != null }">
                            <div>
                            <i class="fa-solid fa-user"></i>
                            </div>
                            <div>
                            <p class="navbar-text fs-6 fw-lighter text-light my-1">${userLogged.nickname}</p>
                            <div>
                        </c:if>
                        <c:if test="${userLogged==null}">
                        <a class="d-flex py-2 px-2" href="${UrlRoute.URL_LOGIN}"> <button class="btn btn-outline-success bolder btn-sm rounded-pill" type="submit" id:"btn-navbar">CONNEXION</button></a>
                        </c:if>
            </div>
        </div>
    </nav>

