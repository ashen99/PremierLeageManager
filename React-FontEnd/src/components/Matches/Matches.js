import React, { useState, useEffect } from "react";
import axios from "axios";
import classes from "./matchlist.module.scss";

const Matches = () => {
  const [stateMatch, setMatchState] = useState([]);

  useEffect(() => {
    getMatches();
  }, []);

  const getMatches = () => {
    axios
      .get("http://localhost:8080/matches")
      .then((data) => {
        setMatchState(data.data);
      })
      .catch((err) => alert(err));
  };

  return (
    <div className={classes.Container}>
      <div className={classes.PointList}>
        <table className={classes.table}>
          <thead>
            <tr>
              <th>DATE</th>
              <th>TEAM ONE</th>
              <th>GOALS BY TEAM ONE</th>
              <th>TEAM TWO</th>
              <th>GOALS BY TEAM TWO</th>
            </tr>
          </thead>
          <tbody>
            {stateMatch.map((d) => (
              <tr key={d.clubName}>
                <td>
                  {d.year}/{d.month}/{d.day}
                </td>
                <td>{d.team1name}</td>
                <td>{d.team1GoalsScored}</td>
                <td>{d.team2name}</td>
                <td>{d.team2GoalsScored}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default Matches;
