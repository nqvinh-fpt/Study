let machineActive = false;
let score = 75;
let response;
function check() {
    if (!machineActive) {
        response = "The machine is turned off. Turn it on to process your score.";
    } else {
        switch (true) {
            case score < 0 || score > 100:
                response = "This is not possible, an error has occurred.";
                break;
            case score >= 0 && score <= 19:
                response = "That was a terrible score — total fail!";
                break;
            case score >= 20 && score <= 39:
                response = "You know some things, but it's a pretty bad score. Needs improvement.";
                break;
            case score >= 40 && score <= 69:
                response = "You did a passable job, not bad!";
                break;
            case score >= 70 && score <= 89:
                response = "That's a great score, you really know your stuff.";
                break;
            case score >= 90 && score <= 100:
                response = "What an amazing score! Did you cheat? Are you for real?";
                break;
            default:
                response = "No matching score found.";
                break;
        }
    }
}
const section = document.querySelector('section');
machineActive = false;
check();
let para1 = document.createElement('p');
para1.innerHTML = "You score is " + score + "<br>" + response;
machineActive = true;
check();
let para2 = document.createElement('p');
para2.innerHTML = "You score is " + score + "<br>" + response;
section.appendChild(para1);
section.appendChild(para2);