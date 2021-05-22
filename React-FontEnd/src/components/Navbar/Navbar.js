import classes from "./navbar.module.scss";
import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <div className={classes.NavBar}>
      <div className={classes.logo}>
        PREMIER<strong>LEAGUE</strong>
      </div>
      <nav>
        <ul>
          <li>
            <Link to="/">Home</Link>
          </li>
          <li className={classes.down}>
            <Link to="/pointlist">Point Table</Link>
            <div className={classes.dropdown}>
              <Link to="/goallist">Sort with goals</Link>
              <Link to="/winlist">Sort with wins</Link>
            </div>
          </li>
          <li>
            <Link to="/matches">Played Matches</Link>
          </li>
          <li>
            <Link to="/addmatch">Add Match</Link>
          </li>
        </ul>
      </nav>
    </div>
  );
};

export default Navbar;
