<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
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
<c:set var="title" scope="request" value="Connexion"/>




<section class="background-radial-gradient overflow-hidden" id="section-connexion">
    <div class="container px-4 py-5 px-md-5 text-center text-lg-start my-5">
        <div class="row gx-lg-5 align-items-center mb-5">
            <div class="col-lg-6 mb-5 mb-lg-0" style="z-index: 10">
                <h1 class="my-5 display-5 opacity-20 fw-bold ls-tight" style="color:orange">
                    Créer <br />
                    <span style= "color: hsl(218, 81%, 95%)">votre compte</span>
                </h1>
            </div>
            <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
                <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
                <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>
                <div class="card bg-glass">
                    <div class="card-body px-3 py-4 px-md-5">
                    <div class = "container d-flex justify-content-center">
                    <img class = "img-form pb-4" src = "${contextPath}/css/asset/user-orange-modif.png">
                    </div>
                      <f:form method="POST" modelAttribute="userForm" class="form-signin">
                          <div class="form-group ${status.error ? 'has-error' : ''}">
                            <div class="form-outline mb-4">
                            <f:input type="text" path="username" class="form-control" placeholder="Nom d'utilisateur"
                                        autofocus="true"/>
                            </div>
                            <f:errors path="username" cssClass="invalid-feedback"/>
                          </div>
                          <div class="form-group ${status.error ? 'has-error' : ''}">
                          <div class="form-outline mb-4">
                            <f:input type="email" path="email" class="form-control" placeholder="Email"
                                        autofocus="true"/>

                          </div>
                            <f:errors path="email" cssClass="invalid-feedback"/>
                          </div>
                          <div class="form-group ${status.error ? 'has-error' : ''}">
                          <div class="form-outline mb-4">
                          <f:input type="date" path="birthAt" class="form-control" placeholder="Entrez votre date de naissance"
                                      autofocus="true"/>
                          </div>
                          <f:errors path="birthAt" cssClass="invalid-feedback"/>
                        </div>
                          <div class="form-group ${status.error ? 'has-error' : ''}">
                          <div class="form-outline mb-4">
                            <f:input type="password" path="password" class="form-control" placeholder="Mot de passe"/>
                            </div>
                            <f:errors path="password" cssClass="invalid-feedback"/>
                          </div>
                          <div class = "container d-flex justify-content-center">
                          <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
                      </div>
                      </f:form>
                    </div>



                    </div>
                </div>
            </div>
        </div>
    </div>
</section>



<%@ include file="../footer.jsp" %>