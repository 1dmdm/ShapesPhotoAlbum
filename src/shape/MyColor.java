package shape;

/**
 * The type Color.
 */
public class MyColor extends java.awt.Color {
  private double r;
  private double g;
  private double b;

  /**
   * Instantiates a new Color.
   *
   * @param r the r
   * @param g the g
   * @param b the b
   */
  public MyColor(double r, double g, double b) {
    super(0,0,0);
    if (r > 255 || r < 0 || g > 255 ||g < 0 || b > 255 || b < 0) {
      throw  new IllegalArgumentException("must be within 0 and 255");
    }
    this.r = r;
    this.g = g;
    this.b = b;
  }

  /**
   * Sets r.
   *
   * @param r the r
   */
  public void setR(double r) {
    this.r = r;
  }

  /**
   * Gets r.
   *
   * @return the r
   */
  public double getR() {
    return r;
  }

  /**
   * Sets g.
   *
   * @param g the g
   */
  public void setG(double g) {
    this.g = g;
  }

  /**
   * Gets g.
   *
   * @return the g
   */
  public double getG() {
    return g;
  }

  /**
   * Sets b.
   *
   * @param b the b
   */
  public void setB(double b) {
    this.b = b;
  }

  /**
   * Gets b.
   *
   * @return the b
   */
  public double getB() {
    return b;
  }

  /**
   * establish string.
   *
   * @return the (r,g,b)
   */
  public String toString() {
    return "(" + r +
            "," + g +
            "," + b +
            ")";

  }
}
