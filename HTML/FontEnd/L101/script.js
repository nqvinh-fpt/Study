const inputGroup = document.getElementById("inputGroup");
function submitForm() {
    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const age = document.getElementById("age").value;
    const role = document.getElementById("role").value;
    const favorite = document.getElementById("favorite").value;
    if (name === "" || email === "" || role === "" || age === ""|| favorite === "") {
        alert("Please fill all the fields");
    } else {
        alert("Thank you for contacting us. We will get back to you soon.");
    }
}
function addButton() {
        var newInput = document.createElement('input');
        newInput.type = 'text';
        newInput.name = 'email';
        newInput.placeholder = 'Enter your email';
        var currentInput = document.querySelector('.input-group input');
        var rowDiv = document.querySelector('.input-group');
        rowDiv.insertBefore(newInput, currentInput.nextSibling);

}