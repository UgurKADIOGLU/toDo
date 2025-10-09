import { Link } from 'react-router-dom'
import logo from '../../assets/hoaxify.png'

function NavBar() {
  return (
   <nav className="navbar navbar-expand shadow-sm bg-body-tertiary">
        <div className="container-fluid">
          <Link className="nav-link" to="*">
            <img src={logo} alt="Hoaxify" width="60" />
            Hoaxify
          </Link>
          <ul className="navbar-nav">
            <li className="nav-item">
              <Link className="nav-link" to="/singup">
                Sing Up
              </Link>
            </li>
          </ul>
        </div>
      </nav>
  )
}

export default NavBar