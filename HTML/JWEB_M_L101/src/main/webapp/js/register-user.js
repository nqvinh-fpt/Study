// Function to set border color and update the local storage
function setBorderColor(element) {
    var borderColor = element.value === "" ? "red" : "green";
    element.style.borderColor = borderColor;
    localStorage.setItem(element.id, borderColor);
}

// Function to apply border colors on page load
function applyBorderColors() {
    var elements = document.querySelectorAll('input[id]');
    elements.forEach(function (element) {
        var storedBorderColor = localStorage.getItem(element.id);
        if (storedBorderColor) {
            element.style.borderColor = storedBorderColor;
        }
    });
}

// Call applyBorderColors on page load
document.addEventListener("DOMContentLoaded", applyBorderColors);

// Function to validate the registration form
function validateRegister() {
    var firstNameElement = document.getElementById("firstName");
    var lastNameElement = document.getElementById("lastName");
    var emailElement = document.getElementById("email");
    var userNameElement = document.getElementById("userName");
    var passwordElement = document.getElementById("password");
    var confirmPasswordElement = document.getElementById("confirmPassword");

    var status = false;
    var message = "Please fill all mandatory fields";

    setBorderColor(firstNameElement);
    setBorderColor(lastNameElement);
    setBorderColor(emailElement);
    setBorderColor(userNameElement);
    setBorderColor(passwordElement);
    setBorderColor(confirmPasswordElement);

    var email = emailElement.value;

    if (email !== "" && !validateEmail(email)) {
        message = "Email is in an incorrect format";
        emailElement.style.borderColor = "red";
    } else if (passwordElement.value !== confirmPasswordElement.value) {
        message = "Confirm password does not match with password";
        confirmPasswordElement.style.borderColor = "red";
    }

    var numberOfInput = document.getElementsByTagName("input").length;
    var countNumberValidInput = 0;

    for (var j = 0; j < numberOfInput; j++) {
        if (document.getElementsByTagName("input")[j].style.borderColor === "green") {
            countNumberValidInput++;
        }
    }

    if (countNumberValidInput === numberOfInput) {
        message = "";
        status = true;
    }

    document.getElementById("error").innerHTML = message;

    if (status) {
        showUserRegistered();
    }

    return status;
}

// Function to display registered users in the table
function showUserRegistered() {
    var table = document.getElementById("tbl-result").getElementsByTagName("tbody")[0];
    var index = table.rows.length;

    if (table.rows.length === 0) {
        var thead = document.getElementById("tbl-result").getElementsByTagName("thead")[0];
        var row = thead.insertRow(0);
        row.insertCell(0).outerHTML = "<th>No</th>";
        row.insertCell(1).outerHTML = "<th>First Name</th>";
        row.insertCell(2).outerHTML = "<th>Last Name</th>";
        row.insertCell(3).outerHTML = "<th>Email</th>";
        row.insertCell(4).outerHTML = "<th>Username</th>";
    }

    var row = table.insertRow(table.rows.length);
    row.insertCell(0).innerHTML = ++index;
    row.insertCell(1).innerHTML = document.getElementById("firstName").value;
    row.insertCell(2).innerHTML = document.getElementById("lastName").value;
    row.insertCell(3).innerHTML = document.getElementById("email").value;
    row.insertCell(4).innerHTML = document.getElementById("userName").value;

    // Clear form and reset border colors after successful registration
    clearForm();
}

// Function to check valid email
function validateEmail(email) {
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}

// Function to clear the form and reset border colors
function clearForm() {
    var elements = document.querySelectorAll('input[id]');
    elements.forEach(function (element) {
        element.value = "";
        element.style.borderColor = "";
        localStorage.removeItem(element.id);
    });
    document.getElementById("error").innerHTML = "";
}