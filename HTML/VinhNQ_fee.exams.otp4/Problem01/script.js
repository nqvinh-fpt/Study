const mess = document.getElementById("mess");
const randomNumber = Math.floor(Math.random() * 101);
function checkGuess() {
    let content="";
    while (true) {
        const userInput = parseInt(document.getElementById("guess").value);
        if (isNaN(userInput) || userInput < 0 || userInput > 100) {
            content = `<h2 style="color: red;">Invalid input. Please enter a number between 0 and 100.</h2>`;
        mess.innerHTML = content;
            break;
        }
        const userNumber = parseInt(userInput);
        if (userNumber < randomNumber) {
            content = `<h2 style="color: red;">OOPS SORRY!! TRY A SMALLER NUMBER</h2>`;
        mess.innerHTML = content;
        break;
        } else if (userNumber > randomNumber) {
            content = `<h2 style="color: red;">OOPS SORRY!! TRY A GREATER NUMBER</h2>`;
        mess.innerHTML = content;
        break;
        } else {
            content = `<h2 style="color: red;">CONGRATULATIONS!!!YOU GUESSED IT RIGHT IN 6 GUESS</h2>`;
        mess.innerHTML = content;
            break;
        }        
    }
    
}
