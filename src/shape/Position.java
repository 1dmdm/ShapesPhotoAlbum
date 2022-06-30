package shape;

/**
 * The type Position.
 */
public class Position {
  private double x, y;

  /**
   * Instantiates a new Position.
   *
   * @param x the x
   * @param y the y
   */
  public Position(double x, double y) {
      this.x = x;
      this.y = y;
  }

  /**
   * Gets y.
   *
   * @return the y
   */
  public double getY() { return y; }

  /**
   * Gets x.
   *
   * @return the x
   */
  public double getX() { return x; }

  /**
   * Sets x.
   *
   * @param x the x
   */
  public void setX(double x) {
    this.x = x;
  }

  /**
   * Sets y.
   *
   * @param y the y
   */
  public void setY(double y) {
    this.y = y;
  }

  /**
   * print out string.
   *
   * @return (x,y)
   */
  public String toString() {
    return "(" + x +
            "," + y +
            ")";
  }
}
