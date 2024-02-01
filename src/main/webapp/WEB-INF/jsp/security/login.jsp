<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<%
    Object title = request.getAttribute("title");
    if (title == null) {
        title = "Cap-Entreprise";
    }
    request.setAttribute("title", title);
%>
<c:set var="title" scope="request" value="Connexion"/>
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


    <section class="background-radial-gradient overflow-hidden" id = "section-connexion">

        <div class="container px-4 py-5 px-md-5 text-center text-lg-start my-5">
            <div class="row gx-lg-5 align-items-center mb-5">
                <div class="col-lg-6 mb-5 mb-lg-0" style="z-index: 10">
                    <h1 class="my-5 display-5 opacity-20 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)">
                        Connectez-vous <br />
                        <span style="color: orange">pour accéder à tous nos jeux</span>
                    </h1>
                    <p class="mb-4 opacity-100 fs-4 fw-semibold" style="color: white">
                        Rejoignez une communauté passionnée de joueurs, faites des parties exceptionnelles
                        et partagez vos exploits. Préparez-vous à vivre des moments inoubliables !
                    </p>
                </div>
                <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
                    <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
                    <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>
                    <div class="card bg-glass">
                        <div class="card-body px-4 py-5 px-md-5">
                            <form method="POST" action="${UrlRoute.URL_LOGIN}" class="form-signin">
                                <!--<div class="row">-->
                                    <div class="form-group ${error != null ? 'has-error' : ''}">
                                        <span>${message}</span>
                                            <div class="form-outline mb-4">
                                                <input autocomplete="off" name="username" type="text" class="form-control mb-3" placeholder="Nom d'utilisateur"/>
                                            </div>
                                            <div class="form-outline mb-4">
                                                <input autocomplete="off" name="password" type="password" class="form-control" placeholder="Mot de passe"/>
                                            </div>
                                            <p class="invalid-feedback">${error}</p>
                                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    </div>
                                    <div class ="d-flex justify-content-center">
                                        <button type="submit" class="btn btn-primary mx-auto btn-block mb-4">
                                            Se connecter
                                        </button>
                                    </div>
                                    <h4 class="text-center">
                                        <p class ="fs-6"> Pas de compte ?</br> Créer un compte
                                        <a href="${contextPath}/s-inscrire" class="btn-link link-custom">ici.</a>
                                        </p>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div>
        </div>
    </section>




