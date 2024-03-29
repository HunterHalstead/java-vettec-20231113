// AJAX stands for Asynchronous JavaScript and XML
// even though these days we use JSON for sending/receving data

// Asynchronous allows us make http requests without
// - block the page
// - without reloading the page

/////////////////////////////////////////
// Using XMLHttpRequest

document.getElementById("btnFact").addEventListener("click", requestFact);

function requestFact() {
    // step 1 make xhr obj
    const xhr = new XMLHttpRequest();

    // step 2 tell it what to do with response
    // Note, we need to check what the readystate 
    // 0 - UNSENT
    // 1 - OPENED
    // 2 - HEADERS RECEIVED
    // 3 - LOADING
    // 4 - DONE
    xhr.onreadystatechange = () => {
        if (xhr.readyState == 4 && xhr.status == 200) {
            console.log(xhr.responseText);
            let factObj = JSON.parse(xhr.responseText);
            let factText = factObj.fact;
            // Grab the div from the dom using:
            let factDiv = document.getElementById("fact");
            factDiv.innerText = factText;
        }
    }

    // step 3 tell it where to go
    xhr.open('GET', 'https://catfact.ninja/fact');

    // step 4 press send
    xhr.send();
}






//////////////////////////////////////////
// Using the fetch API
// Returns a promise
// Promises have 3 states
// 1. Pending
// 2. Fulfilled
// 3. Rejected
fetch("https://catfact.ninja/fact")
.then((response) => {
//    console.log(response)
   return response.json();
}) // returns a promise so we can chain another .then()
.then((data) => {
    console.log(data.fact)
})
.catch((error) => { 
    console.log(error)
})

fetch("http://localhost:8080/customers")
.then((response) => {
//    console.log(response)
   return response.json();
}) // returns a promise so we can chain another .then()
.then((data) => {
    console.log(data)
})
.catch((error) => { 
    console.log(error)
})