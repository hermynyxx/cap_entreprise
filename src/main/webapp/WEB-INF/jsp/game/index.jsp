<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="Avis"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/base.jsp"/>


<!--<div class=" container background-container background-image-page d-none d-sm-block d-lg-block ">
    <div class="row">
        <div class ="col">
            <img src="${contextPath}/css/asset/pikachu.png" class:"img-fluid img-cover"alt="pikachu" id="pikachu" style="width:300px; height 300px">
        </div>
    </div>
</div>-->

<div class = "container container-game">
        <h1 class="text-center fw-bolder fst-italic text-start my-5">

            NOS JEUX A LA UNE
                <security:authorize access="hasRole('MODERATOR')">
                <a href="${UrlRoute.URL_GAME_NEW}" class="ms-2">
                    <i class="fa fa-circle-plus link-green text-warning"></i>
                </a>
                </security:authorize>
    </h1>
    <hr>
    <div class="background-container background-image-page d-none d-sm-block d-lg-block ">



<div class ="container section-carousel">
<div class="row">
<div id="carouselExampleFade" class="carousel slide carousel-fade" data-bs-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="${contextPath}/css/asset/perso2.png"  class="d-block w-75"  alt="...">
    </div>
    <div class="carousel-item">
      <img src="${contextPath}/css/asset/perso3.png" class="d-block w-75" alt="...">
    </div>
    <div class="carousel-item">
      <img src="${contextPath}/css/asset/perso4.png" class="d-block w-75" alt="...">
    </div>
    <div class="carousel-item">
      <img src="${contextPath}/css/asset/perso5.png" class="d-block w-75" alt="...">
    </div>
    <div class="carousel-item">
      <img src="${contextPath}/css/asset/perso6.png" class="d-block w-75" alt="...">
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
</div>
</div>

<div class = "container  mb-5">
    <div class ="row container-games">
        <div class="d-flex justify-content-between index-jeu bg-secondary  bg-dark bg-gradient shadow-sm mb-5  rounded pb-3" style ="color:orange;">
            <div class="d-flex">
                <!-- Label à afficher -->
                <c:set var="label" scope="request" value="DATE"/>
                <!-- Sur quelle propriété de l'objet on souhaite trier -->
                <c:set var="sortable" value="publishedAt"/>
                <%@ include file="../component/sortable.jsp" %>

                <c:set var="label" scope="request" value="NOM"/>
                <c:set var="sortable" value="name"/>
                <%@ include file="../component/sortable.jsp" %>

                <c:set var="label" scope="request" value="GENRE"/>
                <c:set var="sortable" value="genre.name"/>
                <%@ include file="../component/sortable.jsp" %>

                <c:set var="label" scope="request" value="EDITEUR"/>
                <c:set var="sortable" value="publisher.name"/>
                <%@ include file="../component/sortable.jsp" %>

                <%@ include file="../component/filter-reset.jsp" %>
            </div>

            <c:set var="page" scope="request" value="${pageGames}"/>
            <%@ include file="../component/pagination-number.jsp" %>
        </div>
    </div>
</div>
<div class="container ">
    <div class="row row-cols-sm-1 row-cols-md-4 gy-5 help">
        <c:forEach items="${pageGames.content}" var="game">
            <%@ include file="../component/entity/game-card.jsp" %>
        </c:forEach>
        </div>
    </div>
</div>
    <%@ include file="../component/pagination.jsp" %>


<%@ include file="../footer.jsp" %>