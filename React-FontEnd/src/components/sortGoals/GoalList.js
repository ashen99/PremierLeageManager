import React, { useState, useEffect } from "react";
import axios from "axios";
import classes from "./goallist.module.scss";

const GoalList = () => {
  const [stateClub, setClubState] = useState([]);

  useEffect(() => {
    getClub();
  }, []);

  const getClub = () => {
    axios
      .get("http://localhost:8080/goalsTable")
      .then((data) => {
        console.log(data);
        setClubState(data.data);
      })
      .catch((err) => alert(err));
  };

  return (
    <div className={classes.Container}>
      <div className={classes.PointList}>
        <table className={classes.table}>
          <thead>
            <tr>
              <th>CLUB NAME</th>
              <th>LOCATION</th>
              <th>OWNER</th>
              <th>POINTS</th>
              <th>WINS</th>
              <th>DEFEATS</th>
              <th>DRAWS</th>
              <th>NUM OF MATCHES</th>
              <th>GOALS SCORED</th>
              <th>GOALS RECIVED</th>
            </tr>
          </thead>
          <tbody>
            {stateClub.map((d) => (
              <tr key={d.clubName}>
                <td>{d.clubName}</td>
                <td>{d.clubLocation}</td>
                <td>{d.nameOfOwner}</td>
                <td>{d.points}</td>
                <td>{d.wins}</td>
                <td>{d.defeats}</td>
                <td>{d.draws}</td>
                <td>{d.numberOfMatches}</td>
                <td>{d.numOfGoalsScored}</td>
                <td>{d.numOfGoalsRecived}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default GoalList;
