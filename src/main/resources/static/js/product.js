const baseUrl = "http://localhost:8080/";
const xhr = new XMLHttpRequest();

function getProductById(id) {
    const url = baseUrl + "product/" + id;

    xhr.open("GET", url);
    xhr.onreadystatechange = function () {logResponse(xhr)};
    xhr.send();
}

function addProduct(name, desc) {
    const url = baseUrl + "product/insert";

    xhr.open("PUT", url);
    xhr.onreadystatechange = function () {logResponse(xhr)};

    const data = '{"name":"' + name + '","description":"' + desc + '"}';
    xhr.send(data);
}

function logResponse(xhr) {
    if (xhr.readyState === 4) {
        console.log(xhr.status);
        console.log(xhr.responseText);
    }
}