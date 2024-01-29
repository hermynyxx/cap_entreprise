<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<c:set var="title" scope="request" value="Home"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/base.jsp"/>

<%@ include file="navbar.jsp" %>

<section class ="mb-5">
<div class="background-container d-none d-sm-block d-lg-block ">
    <video class="w-100" autoplay loop muted>
        <source src="https://www.leagueoflegends.com/static/hero-3e934348790824f4b800524f96a93020.mp4" type="video/mp4">
    </video>
</div>
<div class="container container-video">
    <div class="row mx-auto test1">
        <video class=" test" autoplay loop muted>
            <source src="https://www.leagueoflegends.com/static/hero-3e934348790824f4b800524f96a93020.mp4" type="video/mp4">
        </video>
        </div>
        <div class="position-relative">
            <div class="position-absolute bottom-0 start-0 w-50 content">
                <h1 class="display-3">
                    <span class="fw-bold" style="color: orange;">H</span><span class="fw-bolder" style="color: #fff;">GAMES</span>
                </h1>
                <form class="d-flex py-2 px-2" role="search">
                    <button class="btn btn-outline-success bolder btn-sm " type="submit" id ="btn-navbar">CONNEXION</button>
                </form>
            </div>
        </div>
    </div>
</div>
</section>

<section class = "section-carousel">
     <div class="container px-4 py-5 px-md-5 text-center text-lg-start my-5">
            <div class="row gx-lg-5 align-items-center mb-5">
                <div class="col-lg-6 mb-5 mb-lg-0" style="z-index: 10">
                    <h1 class="my-5 display-5 opacity-20 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)">
                        Choisisssez <br />
                        <span style="color: orange">vos héros préférés.</span>
                    </h1>

                </div>
    <div class="col-lg-6 mb-5 mb-lg-0 rounded-circle position-relative container-carousel">
         <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
        <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>
        <div class="card bg-glass">
            <div class="card-body px-4 py-5 px-md-5">
        <div id="carouselExampleFade" class="carousel slide carousel-fade" data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="${contextPath}/css/asset/perso1.png" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="${contextPath}/css/asset/perso2.png" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="${contextPath}/css/asset/perso3.png" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="${contextPath}/css/asset/perso4.png" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="${contextPath}/css/asset/perso5.png" class="d-block w-100" alt="...">
                </div>
            </div>
            <button class="carousel-control-prev d-none" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next d-none" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </div>
</section>
<section>
     <div class="container title">
               <h1 class="my-5 fw-bolder fst-italic text-start my-5">NOS DERNIERES SORTIES</h1></br>
           </div>
       <section class="container d-flex justify-content center-align">

    <div class="container mx-auto mt-4">

        <div class="row row-cols-1 row-cols-md-2 g-4">
            <c:forEach items="${gamesReleased}" var="game">
            <div class="col-md-4 col-sm-12">
                <div class="card bg-dark card-index";>
                    <img src="${game.image}" class="img-fluid card-img-top"  id= "img-index" alt="${game.name}">

                    <div class="card-footer custom-card">
                    <a  href="${s:mvcUrl('AppGame#show').arg(0, game.slug).build()}">
                                        <p class="card-title text-end">${game.name}</p>
                                        </a>

                    </div>
                </div>
            </div>

            </c:forEach>
        </div>
    </div>
     </div>
        </div>
</section>


<%@ include file="footer.jsp" %>