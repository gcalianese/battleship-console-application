package cs3500.pa03.model.player;

import cs3500.pa03.model.Coord;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A class for an AiPlayer
 */
public class AiPlayer extends AbstractPlayer {

  /**
   * Instantiates an AiPlayer
   */
  public AiPlayer() {
    super("AI Player");
  }

  /**
   * Returns this player's shots on the opponent's board. The number of shots returned should
   * equal the number of ships on this player's board that have not sunk.
   *
   * @return the locations of shots on the opponent's board
   */
  public List<Coord> takeShots() {
    if (fleet.getFleet().size() == 0) {
      return new ArrayList<>();
    } else {
      ArrayList<Coord> nextRound = new ArrayList<>();
      Random rand = new Random();
      int h = board.getHeight();
      int w = board.getWidth();
      for (int i = 0; i < fleet.determineNumShots(shots, board); i++) {
        int x = rand.nextInt(w);
        int y = rand.nextInt(h);
        nextRound.add(new Coord(x, y));
      }
      return nextRound;
    }
  }
}