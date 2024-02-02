<%@ page contentType="text/html;charset=UTF-8" %>


<a class=" mt-3 main-game-card" href="${UrlRoute.URL_GAME}/${game.slug}">




    <div class="col">
        <div class="card  card1">
            <img img-fluid src="${game.image}" class="card-img-top" alt="${game.name}">
            <div class="card-body bg-light bg-gradient">
                <h6 class="card-title b">${game.name}</h6>
                <p class="card-text b">${game.publisher.name}</p>
                <p class="card-text b">${game.genre.name}</p>
                <small class="text-muted">Sorti le ${dateUtils.getDateFormat(game.publishedAt, "dd/MM/yyyy")}</small></p></small>
            </div>
        </div>
    </div>
</a>
