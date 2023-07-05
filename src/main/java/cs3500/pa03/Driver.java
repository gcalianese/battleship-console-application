package cs3500.pa03;

import cs3500.pa03.controller.Controller;
import java.util.Scanner;

/**
 * This is the main driver of this project.
 */
public class Driver {
  /**
   * Project entry point
   *
   * @param args - no command line args required
   */
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Controller c = new Controller(s);
    c.getSetupInfo(s);
    c.play();
  }
}
