function saveData() {
    const title = document.getElementById('title').value;
    const brief = document.getElementById('brief').value;
    const today = new Date();
    const formattedDate = today.toLocaleDateString();

    const newData = {
        title: title,
        brief: brief,
        createDate: formattedDate
    };

    let currentData = JSON.parse(localStorage.getItem('myData')) || [];
    currentData.push(newData);
    localStorage.setItem('myData', JSON.stringify(currentData));

    alert('Data has been saved successfully!');
    window.location.href = 'viewContent.html';
}
