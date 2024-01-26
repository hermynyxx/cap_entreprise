<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<jsp:include flush="true" page="base.jsp"/>


    <section>
            <div class="container" id = "container-video">
                <div class="row d-none d-sm-block d-lg-block">
                    <video class="w-100" id="background-video" autoplay loop muted>
                        <source id = "background-video2" src="https://www.leagueoflegends.com/static/hero-3e934348790824f4b800524f96a93020.mp4" type="video/mp4">
                    </video>
                    <div class="position-relative">
                        <div class="position-absolute bottom-0 start-0"  id ="content">
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

   <%-- *********************************************** --%>
<div class="container my-5">
    <h2 class="my-5 fw-bolder fst-italic">NOS DERNIERES SORTIES</h2>
    <div class="row row-cols-1 row-cols-sm-1 row-cols-md-3 row-cols-lg-4 g-4">
        <c:forEach items="${gamesReleased}" var="game">
        <div class="col">
            <div class="card h-100 bg-dark card-index" style="width: 15rem";>
                <img src="${game.thumbnailCover}" class="img-fluid card-img-top"  id= "img-index" alt="${game.name}">

                <div class="card-footer custom-card">
                <a  href="${s:mvcUrl('AppGame#show').arg(0, game.slug).build()}">
                                    <p class="card-title text-end">${game.name}</p>
                                    </a>
                    <p class="card-text text-end">${game.price}€</p>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
</div>

<div class="container my-5">
    <h2 class="my-5 fw-bolder text-end fst-italic">RECHERCHE PAR CATEGORIE</h2>

<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="true">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="..." class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="..." class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="..." class="d-block w-100" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
</div>


<%@ include file="footer.jsp" %>
