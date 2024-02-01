<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="Avis"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/base.jsp"/>


<div class="background-container background-image-page d-none d-sm-block d-lg-block ">
    <img src="${contextPath}/css/asset/pikachu.png" class:"img-fluid img-cover"alt="pikachu" id="pikachu" style="width:500px; height 500px">
</div>

<div class = "container container-game"
    <h1 class="py-5 fw-bolder fst-italic text-start my-5">
        Les jeux
            <security:authorize access="hasRole('MODERATOR')">
            <a href="${UrlRoute.URL_GAME_NEW}" class="ms-2">
                <i class="fa fa-circle-plus link-green"></i>
            </a>
            </security:authorize>
    </h1>

    <div class="d-flex justify-content-between index-jeu">
        <div class="d-flex">
            <!-- Label à afficher -->
            <c:set var="label" scope="request" value="Date"/>
            <!-- Sur quelle propriété de l'objet on souhaite trier -->
            <c:set var="sortable" value="publishedAt"/>
            <%@ include file="../component/sortable.jsp" %>

            <c:set var="label" scope="request" value="Name"/>
            <c:set var="sortable" value="name"/>
            <%@ include file="../component/sortable.jsp" %>

            <c:set var="label" scope="request" value="Genre"/>
            <c:set var="sortable" value="genre.name"/>
            <%@ include file="../component/sortable.jsp" %>

            <c:set var="label" scope="request" value="Editeur"/>
            <c:set var="sortable" value="publisher.name"/>
            <%@ include file="../component/sortable.jsp" %>

            <%@ include file="../component/filter-reset.jsp" %>
        </div>

        <c:set var="page" scope="request" value="${pageGames}"/>
        <%@ include file="../component/pagination-number.jsp" %>
    </div>
    <div class="row row-cols-1 row-cols-md-3 g-4  help">
        <c:forEach items="${pageGames.content}" var="game">
            <%@ include file="../component/entity/game-card.jsp" %>
        </c:forEach>
        </div>
    </div>
    <%@ include file="../component/pagination.jsp" %>


<%@ include file="../footer.jsp" %>