<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<c:set var="title" scope="request" value="Home"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/base.jsp"/>

<%@ include file="navbar.jsp" %>

<section>
<div class="background-container">
    <video class="w-100" id="background-video1" autoplay loop muted>
        <source src="https://www.leagueoflegends.com/static/hero-3e934348790824f4b800524f96a93020.mp4" type="video/mp4">
    </video>
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
</section>

<%@ include file="footer.jsp" %>