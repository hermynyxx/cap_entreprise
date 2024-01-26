<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<jsp:include flush="true" page="../base.jsp"/>


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
                                    <p class ="fs-6"> Pas de connexion?</br> Créer un compte
                                    <a href="${contextPath}/showForm" class="btn-link link-custom">ici.</a>
                                    </p>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>



<%@ include file="../footer.jsp" %>