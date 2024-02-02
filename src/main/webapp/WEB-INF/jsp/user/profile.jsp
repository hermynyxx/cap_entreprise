<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="${user.nickname}"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/base.jsp"/>


<div class="container mt-5 ">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a class="btn-link" href="${contextPath}/">Accueil</a></li>
            <li class="breadcrumb-item"><a class="btn-link" href="${contextPath}${UrlRoute.URL_GAME}">Les jeux</a></li>
            <li class="breadcrumb-item active" aria-current="page">${user.nickname}</li>
            <li class="breadcrumb-item active"><a class="btn-link" href="#user-reviews">Les commentaires</a></li>
        </ol>
    </nav>

    <img class ="rounded-circle" src="https://img.freepik.com/photos-gratuite/portrait-belle-jeune-femme-coiffure-elegante-lunettes_1142-40217.jpg?w=740&t=st=1706786934~exp=1706787534~hmac=b6fc1dc732b60dbd5d252ae03ec0aa05cc1412f7d95b92d872ebc380ce45b545" alt="logo" id="logo" style="width:90px; height:90px">
    <h1>${user.nickname}</h1>
    <c:if test="${!user.moderator}">
        <p>${dateUtils.getAgeFromDate(user.birthAt)} ans</p>
    </c:if>

    <div id="user-reviews"
         class="my-5"
    >
        <h2> Tes commentaires</h2>
        <c:if test="${pageReviews.content.size() > 0}">
        <div class ="row ">
    <div class="d-flex justify-content-between index-jeu bg-secondary  bg-dark bg-gradient shadow-sm mb-5  rounded pb-3" style ="color:orange;">
                <div class="d-flex">
                    <!-- Label à afficher -->
                    <c:set var="label" scope="request" value="DATE"/>
                    <!-- Sur quelle propriété de l'objet on souhaite trier -->
                    <c:set var="sortable" value="createdAt"/>
                    <%@ include file="../component/sortable.jsp" %>

                    <c:set var="label" scope="request" value="NOTES"/>
                    <c:set var="sortable" value="rating"/>
                    <%@ include file="../component/sortable.jsp" %>

                    <c:set var="label" scope="request" value="JOUEUR"/>
                    <c:set var="sortable" value="gamer.nickname"/>
                    <%@ include file="../component/sortable.jsp" %>

                    <%@ include file="../component/filter-reset.jsp" %>
                </div>

                <c:set var="page" scope="request" value="${pageReviews}"/>
                <%@ include file="../component/pagination-number.jsp" %>
            </div>
            <div class="row">
                <c:forEach items="${pageReviews.content}" var="review">
                    <%@ include file="../component/entity/review-card.jsp" %>
                </c:forEach>
            </div>
            <%@ include file="../component/pagination.jsp" %>
        </div>
    </c:if>
</div>
</div>

<%@ include file="../footer.jsp" %>