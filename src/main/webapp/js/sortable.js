
function initSortable() {
    const sortableItems = document.querySelectorAll('[data-my-sortable]');
    for (const sortableItem of sortableItems) {
        if (window
            .location
            .search
            .includes(sortableItem.getAttribute('data-my-sortable'))
        ) {
            sortableItem.classList.toggle('invisible');
        }
    }
}

function initSortableSelect() {
    const btn = document.querySelector("[btn-selector]");
        if(btn){
            var url = new URL(location.href);
            const parameter = url.searchParams.get("sort");
            console.log(parameter);
            if(parameter){
                if(parameter==="moderator,asc"){
                    btn.innerHTML = "Non modérés";
                }
                if(parameter==="moderator,desc"){
                    btn.innerHTML = "Modérés";
                }
            }
        }
}

window.addEventListener('load', () => {
   initSortable();
   initSortableSelect();
});