const baseUrl = "http://localhost:8010/product/";
const xhr = new XMLHttpRequest();

function getProductById(id) {
    const url = baseUrl + id;

    xhr.open("GET", url);
    xhr.onreadystatechange = function () {logResponse(xhr)};
    xhr.send();
}

function getProductByName(name) {
    const url = baseUrl + `byName/${name}`;

    xhr.open("GET", url);
    xhr.onreadystatechange = function () {logResponse(xhr)};
    xhr.send();
}

function addProduct(name, desc) {
    const url = baseUrl + `insert?name=${name}&description=${desc}`;

    xhr.open("PUT", url);
    xhr.onreadystatechange = function () {logResponse(xhr)};

    xhr.send();
}

function logResponse(xhr) {
    if (xhr.readyState === 4) {
        console.log(xhr.status);
        console.log(xhr.responseText);
    }
}