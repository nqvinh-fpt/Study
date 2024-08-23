const btnAdd = document.getElementById("btn-add");
const inputTxt = document.getElementById("input-text");
const list = document.getElementById("list");
const loading = document.getElementById("loading");
let data = [];
let id = 0;
let isUpdated = {
  id: 0,
  status: false,
};

const deleteAll = () => {
  data.splice(0, data.length);
  renderUI();
};

const addItemAction = () => {
  id++;
  const valueInput = inputTxt.value;
  inputTxt.value = "";
  data.push({
    id,
    content: valueInput,
  });
  renderUI();
};

const updateItemAction = () => {
  const idx = data.findIndex((item) => item.id == isUpdated.id);
  data[idx].content = inputTxt.value;
  inputTxt.value = "";
  isUpdated = {
    id: 0,
    status: false,
  };
  btnAdd.innerText = "Add";
  renderUI();
};

const handleButtonClick = () => {
  if (isUpdated.status) {
    updateItemAction();
  } else {
    addItemAction();
  }
};
btnAdd.addEventListener("click", handleButtonClick);
inputTxt.addEventListener("keypress", function (event) {
  if (event.key === "Enter") {
    event.preventDefault();
    handleButtonClick();
  }
});

const deleteFunc = (id) => {
  const idx = data.findIndex((item) => item.id == id);
  data.splice(idx, 1);
  renderUI();
};

const update = (id) => {
  const idx = data.findIndex((item) => item.id == id);
  inputTxt.value = data[idx].content;

  isUpdated = {
    id: id,
    status: true,
  };
  btnAdd.innerText = "Update";
};

const renderUI = () => {
  let content = "";
  data.forEach((item) => {
    content += `<li id="${item.id}">
    <a href="https://jsonplaceholder.typicode.com/comments?postId=${item.id}" id="text${item.id}">${item.title}</a>
    <button onclick="deleteFunc(${item.id})">Delete </button>
    <button onclick="update(${item.id})">
    Update
    </button></li>`;
  });
  list.innerHTML = content;
};

const loadingData = () => {
  loading.style.display = "block";
  fetch("https://jsonplaceholder.typicode.com/posts")
    .then((response) => response.json())
    .then((json) => {
      console.log("2", json);
      data = json;
      loading.style.display = "none";
      renderUI();
    });
};
//AJAX
const post = () => {
  fetch("https://jsonplaceholder.typicode.com/posts", {
    method: "POST",
    body: JSON.stringify({
      title: "foo",
      body: "bar",
      userId: 1,
    }),
    headers: {
      "Content-type": "application/json; charset=UTF-8",
    },
  })
    .then((response) => response.json())
    .then((json) => console.log(json));
};