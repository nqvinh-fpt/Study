let season = "winter";
let response;

if (season.includes("summer")) {
    response = "It's probably nice and warm where you are; enjoy the sun!";
} else if (season.includes("winter")) {
    response = "It's probably nice and cool where you are; enjoy the snow!";
} else {
    response = "We don't know what season it is.";
}
const section = document.querySelector('section');
let para1 = document.createElement('p');
para1.innerHTML = response;
section.appendChild(para1);