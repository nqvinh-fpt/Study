import React from "react";



const Home = () => {
  return (
    <div>
      <div id="carouselExampleIndicators" class="carousel slide">
        <div class="carousel-indicators">
          <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
          <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
          <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="https://scontent.fhan2-4.fna.fbcdn.net/v/t39.30808-6/301885319_498396008956746_3974689540426338371_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=783fdb&_nc_ohc=pA4ajLhpbV8AX9-C791&_nc_ht=scontent.fhan2-4.fna&oh=00_AfDo742qBwrPWyfN5I5HAfa7qrm8q30xjPodXW6og0csOA&oe=656D6576" class="d-block w-100" alt="..." style={{ height: '400px' }} />
          </div>
          <div class="carousel-item">
            <img src="https://scontent.fhan2-3.fna.fbcdn.net/v/t39.30808-6/326333756_639408171286379_1536659892935654017_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=783fdb&_nc_ohc=qFU0t2I9y5wAX9gCBPw&_nc_ht=scontent.fhan2-3.fna&oh=00_AfBcPHJZrJIvOcZJYvvOQyjJplzpDZLLbT_GzuG8UCHwKA&oe=656C8767" class="d-block w-100" alt="" style={{ height: '400px' }} />
          </div>
          <div class="carousel-item">
            <img src="https://scr.vn/wp-content/uploads/2022/07/acc-lien-quan-50k.jpg" class="d-block w-100" alt="..." style={{ height: '400px' }} />
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>


    </div>
  )
}

export default Home;