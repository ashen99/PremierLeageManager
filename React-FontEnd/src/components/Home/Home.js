import React from "react";
import classes from "./home.module.scss";
import background from "../../img/stadium.jpg";

const Home = () => {
  return (
    <div className={classes.Container}>
      <img
        className={classes.Background}
        src={background}
        alt="background"
      ></img>
      <div className={classes.TextContainer}>
        <h1 className={classes.h1}>Welcome to Premier League Manager</h1>
      </div>
      {/* <button className={classes.btn}>KICK IN</button> */}
      <div className={classes.card}>
        <div className={classes.header}>
          <p>Points Table</p>
        </div>
        <div className={classes.container}>
          <p>
            In Premier League Manager you can see statistics of every club that
            is in premier league and you can sort the clubs acording to Points ,
            Goals and number of Wins.
          </p>
        </div>
      </div>
      <div className={classes.card2}>
        <div className={classes.header}>
          <p>Add Match</p>
        </div>
        <div className={classes.container}>
          <p>
            By using Premier League Manager u can add a match between two
            randomly selected teams. the match infomation will also be updated
            randomly.
          </p>
        </div>
      </div>
      <div className={classes.card3}>
        <div className={classes.header}>
          <p>View Matches</p>
        </div>
        <div className={classes.container}>
          <p>
            You can view all the matches played in the league and they are
            sorted by the date.
          </p>
        </div>
      </div>
      <div className={classes.card4}>
        <div className={classes.header}>
          <p>View Clubs</p>
        </div>
        <div className={classes.container}>
          <p>You can view all the clubs that currenty in the premier league.</p>
        </div>
      </div>
    </div>
  );
};

export default Home;
