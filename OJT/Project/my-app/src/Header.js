import React from 'react';
import { Link } from 'react-router-dom';


class Header extends React.Component {
  render() {
    return (
      <nav class="navbar navbar-expand-lg bg-body-tertiary bg-light py-3 shadow-sm">
        <div class="container">
          <a class="navbar-brand fw-bold fs-4" href="#">F88SHOP</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mx-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Account</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">About us</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Top-up</a>
              </li>


            </ul>

            <div className='buttons'>
              <a href="/login" className="btn btn-outline-dark">
                <i class="fa fa-sign-in me-1 "></i> Login
              </a>
              <a href="" className="btn btn-outline-dark ms-2">
                <i class="fa-solid fa-right-to-bracket ms-2 "></i> Register
              </a>
              <a href="" className="btn btn-outline-dark ms-2">
                <i class="fa-solid fa-cart-shopping"></i> Cart
              </a>

            </div>
          </div>
        </div>
      </nav>
    )

  }

}

export default Header;