function getDatas() {
    try {
        return localStorage.itemStores ? JSON.parse(localStorage.itemStores) : [];
    } catch (e) { alert(e);}
}

function store(data) {
    const itemStores = getDatas();

    itemStores.push(data);

    localStorage.setItem("itemStores", JSON.stringify(itemStores));

}
