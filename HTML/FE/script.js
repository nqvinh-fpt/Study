// const person  = {
//     name: 'John',
//     age: 30
// }

// console.log(person.name);
// console.log(person.age);

// person.age=23;

// const input1=prompt('Please enter');

// console.log(input1);
// const input2=prompt('Please enter');

// console.log(input2);

// const check ='nv '
// if(check){
//     console.log('true');
// }


// const students=[
//     {
//     name: 'John',
//     age: 30,
// },
// {
//     name: 'Mary',
//     age: 23,
// },

// {
//     name: 'Peter',
//     age: 23,
// }];
// students.push({
//     name: 'Mary',
//     age: 23,
// })

const listStudents=[];
while (true)  {
    console.log(listStudents);
    let searchName="";
    const input=prompt(`1.Tao danh sach 
    2.doc danh sach
    3.Sua danh sach
    4.Xoa danh sach`);
    const index=null;
    switch(parseInt(input)){
        case 1:
            const name= prompt('enter name');
            const age= prompt('enter age');
            listStudents.push({name,age});
            console.log(listStudents);
                break;
        case 2:
            searchName= prompt('enter search name');
            index= listStudents.findIndex((item)=>item.name==searchName);
            alert(JSON.stringify(listStudents[index]));
            break;
        case 3:
            searchName= prompt('enter update name');
            const field = prompt("Nhap truong muon update");
            const value = prompt("Nhap gia tri muon update");
            index= listStudents.findIndex((item)=>item.name==searchName);
            listStudents[index][field]=value;
            console.log(listStudents);
            break;
            
        case 4:
            searchName= prompt('enter delete name');
            index= listStudents.findIndex((item)=>item.name==searchName);
            listStudents.splice(index,1);
            break;
        default:
        
    }
    
}


