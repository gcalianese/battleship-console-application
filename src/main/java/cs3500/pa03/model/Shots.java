package cs3500.pa03.model;

import cs3500.pa03.model.player.Player;
import java.util.ArrayList;
import java.util.List;

/**
 * A class for representing sets of Shots
 */
public class Shots {
  private List<Coord> shotsFired;
  private List<Coord> shotsReceived;
  private List<Coord> nextRound;
  private List<Coord> shotsHitOpponent;
  private Player player;

  /**
   * Instantiates a Shots object
   *
   * @param p the Player this Board belongs to
   */
  public Shots(Player p) {
    player = p;
    shotsFired = new ArrayList<>();
    shotsReceived = new ArrayList<>();
    nextRound = new ArrayList<>();
    shotsHitOpponent = new ArrayList<>();
  }

  /**
   * getter for the shotsFired field
   *
   * @return the shotsFired field
   */
  public List<Coord> getShotsFired() {
    return shotsFired;
  }

  /**
   * getter for the shotsReceived field
   *
   * @return the shotsReceived field
   */
  public List<Coord> getShotsReceived() {
    return shotsReceived;
  }

  /**
   * getter for the nextRound field
   *
   * @return the nextRound field
   */
  public List<Coord> getNextRound() {
    return nextRound;
  }

  /**
   * getter for the shotsHitOpponent method
   *
   * @return the shotsHitOpponent method
   */
  public List<Coord> getShotsHitOpponent() {
    return shotsHitOpponent;
  }

  /**
   * handles and returns a shot volley
   *
   * @param shots a Shots object of the Player
   *
   * @param fleet the Fleet of the Player
   *
   * @return an empty List if the fleet's size is 0,
   *        otherwise returns the next round of shots
   */
  public List<Coord> takeShots(Shots shots, Fleet fleet) {
    if (fleet.getFleet().size() == 0) {
      return new ArrayList<>();
    } else {
      return shots.getNextRound();
    }
  }

  /**
   * returns a List of Coord that damaged ships on the given Board
   *
   * @param opponentShotsOnBoard shots fired by the opponent
   *
   * @param board the Board being checked
   *
   * @return a List of the Coord on the given Board that were damaged
   */
  public List<Coord> reportDamage(List<Coord> opponentShotsOnBoard, Board board) {
    List<Coord> hits = new ArrayList<>();
    for (Coord c : opponentShotsOnBoard) {
      int x = c.getX();
      int y = c.getY();
      if (board.getCoveredSpaces().contains(c)) {
        hits.add(c);
        board.getBoard()[y][x].setHit(true);
      } else {
        board.getBoard()[y][x].setMissed(true);
      }
    }
    return hits;
  }
}
