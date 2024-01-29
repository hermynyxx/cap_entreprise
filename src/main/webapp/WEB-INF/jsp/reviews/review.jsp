<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<jsp:include flush="true" page="../base.jsp"/>

 <div class="container m">
        <div class="row">

        <h1>Messages</h1>
        <c:forEach items="${reviewsList}" var="review">
            <div class="container">


                          <p>"${review.id}"</p>


                          <p>message créé le "${review.createdAt}" </p>



                      <p>"${review.description}" </p>




           </c:forEach>
             <c:set var="page" scope="request" value="${pageReviews}"/>
               <%@ include file="component/pagination.jsp" %>
           </div>
           </div>

           <section>
               <div class = "position-relative mt-5 main-video "
                   <div class=" container d-sm-none d-md-block container-background">
                        <div class = "container-fluid vh-100 bg-danger section-video">
                             <div class =" container ratio ratio-16x9 container-background">
                                  <video class="w-100" autoplay loop muted>
                                    <source src="https://www.leagueoflegends.com/static/hero-3e934348790824f4b800524f96a93020.mp4" allowfullscreen type="video/mp4">
                                  </video>
                             </div>
           </div>
           <div class="container" id = "container-video">
               <div class="row d-none d-sm-block d-lg-block">
                   <video class="w-100" id="background-video" autoplay loop muted>
                       <source id="background-video2" src="https://www.leagueoflegends.com/static/hero-3e934348790824f4b800524f96a93020.mp4" type="video/mp4">
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
           </div>
           </section>