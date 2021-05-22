import "./App.scss";
import Navbar from "./components/Navbar/Navbar";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import PointList from "./components/sortPoints/PontList";
import Home from "./components/Home/Home";
import Matches from "./components/Matches/Matches";
import GoalList from "./components/sortGoals/GoalList";
import WinList from "./components/sortWins/WinList";
import AddMatch from "./components/AddMatch/AddMatch";

function App() {
  return (
    <Router>
      <div className="App">
        <Navbar />
        <Switch>
          <Route exact path="/">
            <Home />
          </Route>
          <Route path="/matches">
            <Matches />
          </Route>
          <Route path="/pointlist">
            <PointList />
          </Route>
          <Route path="/goallist">
            <GoalList />
          </Route>
          <Route path="/winlist">
            <WinList />
          </Route>
          <Route path="/addmatch">
            <AddMatch />
          </Route>
        </Switch>
      </div>
    </Router>
  );
}

export default App;
