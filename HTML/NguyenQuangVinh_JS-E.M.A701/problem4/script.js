let machineActive = true; 
let pwd = "cheese";
let machineResult, pwdResult;

machineResult = machineActive ? "Machine is active. Trying login" : "Machine is off";
pwdResult = machineActive ? (pwd === "cheese" ? "Login successful" : "Login unsuccessful.") : "Machine is off";
const section = document.querySelector('section');
let para1 = document.createElement('p');
para1.innerHTML = machineResult;

let para2 = document.createElement('p');
para2.innerHTML = pwdResult;
section.appendChild(para1);
section.appendChild(para2);