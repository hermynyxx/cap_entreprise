<%@ page contentType="text/html;charset=UTF-8" %>


<a class="col-md-4 mt-3 main-game-card" href="${UrlRoute.URL_GAME}/${game.slug}">

  <div class="col">
    <div class="card h-100">
  <img img-fluid src="${game.image}" class="card-img-top" alt="${game.name}">
      <div class="card-body text-bg-light">
        <h5 class="card-title">${game.name}</h5>
        <p class="card-text">${game.publisher.name}</p>
        <p class="card-text">${game.genre.name}</p>
      </div>
      <div class="card-footer">
        <small class="text-muted">Sorti le ${dateUtils.getDateFormat(game.publishedAt, "dd/MM/yyyy")}</small></p></small>
      </div>
    </div>
  </div>

</a>
