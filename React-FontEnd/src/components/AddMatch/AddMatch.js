import classes from "./addmatch.module.scss";
import bgimg from "../../img/vss.jpg";
import React, { useState } from "react";
import axios from "axios";

const AddMatch = () => {
  const [match, setMatch] = useState([]);

  const getMatch = () => {
    axios
      .get("http://localhost:8080/randomMatch")
      .then((data) => {
        setMatch(data.data);
        console.log(match);
      })
      .catch((err) => alert(err));
  };
  return (
    <div className={classes.Container}>
      <button className={classes.btn} onClick={getMatch}>
        PLAY MATCH
      </button>

      <img className={classes.img} src={bgimg} alt="verses pic"></img>

      {match.length > 0 && (
        <div className={classes.card}>
          <div className={classes.header}>
            <p>{match[0].team1name}</p>
          </div>
          <div className={classes.container}>
            <p>GOALS :{match[0].team1GoalsScored}</p>
          </div>
        </div>
      )}
      {match.length > 0 && (
        <div className={classes.card2}>
          <div className={classes.header}>
            <p>{match[0].team2name}</p>
          </div>
          <div className={classes.container}>
            <p>GOALS : {match[0].team2GoalsScored}</p>
          </div>
        </div>
      )}
    </div>
  );
};

export default AddMatch;
