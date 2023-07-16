// script.js
let httpRequest;
document.querySelector("#ajaxCall").addEventListener('click', () => {
    const inputName = document.querySelector("#inputName").value;
    httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = () => {
        if (httpRequest.readyState === XMLHttpRequest.DONE) {
            if (httpRequest.status === 200) {
                let result = httpRequest.response;
                document.getElementById("name").innerText = result.name;
                document.getElementById("age").innerText = result.age;
            }
            else {
                alert('Request Error!');
            }
        }
    };
    console.log(inputName);
    httpRequest.open('GET', '/getAgeByName?inputName=' + inputName);
    console.log(inputName);

    httpRequest.responseType = 'json';
    httpRequest.send();

});