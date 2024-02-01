<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<c:set var="title" scope="request" value="Avis"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/base.jsp"/>

<div class="background-container background-image-page d-none d-sm-block d-lg-block ">
    <img src="${contextPath}/css/asset/pikachu.png" class:"img-fluid img-cover"alt="pikachu" id="pikachu" style="width:500px; height 500px">
</div>

<div class="container mt-5 first-container-review" style="background-image:url('')">
<div class="container mt-5 p-5 ">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item active" aria-current="page">Accueil</li>
            <li class="breadcrumb-item"><a class="btn-link" href="${contextPath}${UrlRoute.URL_GAME}">Les jeux</a></li>
        </ol>
    </nav>

    <div class="d-flex justify-content-between">
        <div class="d-flex">
            <!-- Label à afficher -->
            <c:set var="label" scope="request" value="Date"/>
            <!-- Sur quelle propriété de l'objet on souhaite trier -->
            <c:set var="sortable" value="createdAt"/>
            <%@ include file="component/sortable.jsp" %>

            <c:set var="label" scope="request" value="Note"/>
            <c:set var="sortable" value="rating"/>
            <%@ include file="component/sortable.jsp" %>

            <c:set var="label" scope="request" value="Jeu"/>
            <c:set var="sortable" value="game.name"/>
            <%@ include file="component/sortable.jsp" %>

            <c:set var="label" scope="request" value="Joueur"/>
            <c:set var="sortable" value="gamer.nickname"/>
            <%@ include file="component/sortable.jsp" %>

            <security:authorize access="hasRole('MODERATOR')">
                <div class="sort-filter mt-4 me-3">
                <select class="form-select sortable-select">
                    <option value="all" data-filter-url="${currentUrl}">
                        Tous les commentaires
                    </option>
                    <option value="sort=moderator,desc"
                            data-filter-url="${jspUtils.generateUrlFrom(currentUrl, currentQuery, "sort=moderator,desc")}"
                    >
                        Modérés
                    </option>
                    <option value="sort=moderator,asc"
                            data-filter-url="${jspUtils.generateUrlFrom(currentUrl, currentQuery, "sort=moderator,asc")}"
                    >
                        À modérer
                    </option>
                </select>
            </div>
            </security:authorize>

            <%@ include file="component/filter-reset.jsp" %>
        </div>

        <c:set var="page" scope="request" value="${reviewsList}"/>
        <%@ include file="component/pagination-number.jsp" %>
    </div>

    <div class="container container-card-review">
        <c:forEach items="${reviewsList.content}" var="review">
            <div class="col s-6 col-review">
                <%@ include file="component/entity/review-card.jsp" %>
            </div>
        </c:forEach>
    </div>
    <security:authorize access="hasRole('MODERATOR')">
        <div>
            <a href="${UrlRoute.URL_EXPORT}" class="btn btn-link">
                <i class="fa-solid fa-file-excel me-1"></i>
                Télécharger export Excel
            </a>
        </div>
    </security:authorize>
    <%@ include file="component/pagination.jsp" %>
</div>
</div>

<%@ include file="footer.jsp" %>