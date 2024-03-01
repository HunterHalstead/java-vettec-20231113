// DOM stands for Document Object Model
// It is an in memory representation of th HTML tree
// We can interact with DOM using the document object
document.addEventListener("DOMContentLoaded", () => {
    // console.log("script loaded") // reality check
    console.log("dom content loaded");

    let myDiv = document.getElementById("my-div");
    // console.log(myDiv); // reality check

    let content = myDiv.innerText; // innerHTML prints <span>1</span>
    console.log(content);
});