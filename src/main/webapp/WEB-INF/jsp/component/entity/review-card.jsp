<%@ page contentType="text/html;charset=UTF-8" %>

<div class="card text text-start p-3 m-3 card-review">
    <div class="row">
        <div class="col-lg-2 col-md-3 col-sm-4">
            <img class ="rounded-circle" src="https://img.freepik.com/photos-gratuite/portrait-belle-jeune-femme-coiffure-elegante-lunettes_1142-40217.jpg?w=740&t=st=1706786934~exp=1706787534~hmac=b6fc1dc732b60dbd5d252ae03ec0aa05cc1412f7d95b92d872ebc380ce45b545" alt="logo" id="logo" style="width:90px; height:90px">
            <h6 class="card-title"><a class="btn-link text-secondary text-decoration-none" href="${UrlRoute.URL_USER}/${review.gamer.uuid}">${review.gamer.nickname}</a></h5>
             <p class="card-text text-dark">Déposé le ${dateUtils.getDateFormat(review.createdAt, "dd/MM/yyyy")}</p>
        </div>
        <div class="col-lg-10 col-md-9 col-sm-8">
            <div class="card-body text-dark ">
                <p class="review-description">
                    <c:out value="${jspUtils.excerpt(review.description, 1000000)}" escapeXml="false"/>
                </p>
            </div>
        </div>
    </div>
    <div class="card-footer text-muted">
        <div class="d-flex inline-flex">
           <p class="${jspUtils.getCssClas(review.rating)} me-3">
               ${jspUtils.getStringRating(review.rating)} / 20
           </p>
            <c:if test="${empty review.moderator}">
                  <cite title="Source Title">En attente de moderation ⌛</cite>
                   <c:if test="${userLogged.moderator}">
                        <a class="btn btn-link rating-20" href="${UrlRoute.URL_REVIEW}/${review.id}/1" title="Accepter">
                              <i class="fa-regular fa-thumbs-up text-success"></i>
                        </a>
                        /
                        <a class="btn btn-link rating-5"
                           href="${UrlRoute.URL_REVIEW}/${review.id}/0"
                           title="Refuser"
                        >
                            <i class="fa-solid fa-ban text-danger"></i>
                        </a>
                   </c:if>
            </c:if>
            <c:if test="${not empty review.moderator}">
                Modéré par <cite title="Source Title"> ${review.moderator.nickname}</cite> - le ${dateUtils.getDateFormat(review.moderationDate, "dd/MM/yyyy")}
            </c:if>
            <div class="ms-auto">
               <a class="btn-link text-secondary text-decoration-none" href="${UrlRoute.URL_GAME}/${review.game.slug}">
                   ${review.game.name}
               </a>
            </div>
        </div>
    </div>
</div>


