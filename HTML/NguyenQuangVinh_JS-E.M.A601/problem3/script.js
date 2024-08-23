let cat = {
    name: 'Bertie',
    breed: 'Cymric',
    color: 'white',
    greeting: function () {
        console.log(`Hello, said ${this.name} the ${this.breed}.`);
    },
};
let cat2 = {
    name: 'Elfie',
    breed: 'Aphrodite Giant',
    color: 'white',
    greeting: function () {
        console.log(`Hello, said ${this.name} the ${this.breed}.`);
    },
};
cat.greeting();  
cat2.greeting(); 