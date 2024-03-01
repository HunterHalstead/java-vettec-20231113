// Goal: Fetch the customer's order's list of items and add them to the list of items
/*
<li class="list-group-item d-flex justify-content-between lh-sm">
    <div>
        <h6 class="my-0">Bananas</h6>
    </div>
    <span class="text-body-secondary">x10</span> // ????? Where does the quantity get set?
</li>
*/

function createListItem(item) {
    const li = document.createElement("li");
    li.classList = "list-group-item d-flex justify-content-between lh-sm";

    const span = document.createElement("span");
    span.classList = "text-body-secondary";
    span.innerText = `x${item.quantity}`;

    const div = document.createElement("div");

    const h6 = document.createElement("h6");
    h6.innerText = item.description;

    // h6 is the child of div
    div.appendChild(h6);
    // div is a child of li
    li.appendChild(div);

    // span is a child of li
    li.appendChild(span);

    // li is child of ul with id items-list
    const ul = document.getElementById("items-list");
    ul.appendChild(li);

}

// On page load fetch the items from the grocery grabber api GET /items/1 endpoint
async function fetchItems() {
    try {
        const response = await fetch("http://localhost:8080/orders/1");
        console.log(response)
        const order = await response.json();
        const items = order.groceryItems;
        console.log(items)
        const item1 = items[0];
        console.log("description: " + item1.description)
        console.log("quantity: " + item1.quantity)
        createListItem(item1);
    } catch (error) {
        console.log(error)
    }
}

fetchItems();

///////////////////////////////////////////////////////////////////
// Goal: Submit the form to /items/1 assuming we have the order id
let form = document.getElementById("item-form")

form.addEventListener("submit", listener)
// Step 0: Prevent form submit from refreshing the page

// Step 1: Grab the inputs from the form
function listener(event) {
    event.preventDefault();

    let formData = form.formData;
    let item = {};
    // Loop over the 
    for (let field in formData) {
        // add the properties nad valuse to an object
        item[field] = formData[field];
    }

    // stringify the object info JSON
    let json = JSON.stringify(item);

    fetch("http://localhost:8080/items/1", {
        method: "POST",
        body: json
    })
}


