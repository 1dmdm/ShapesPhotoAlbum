package shape;

/**
 * The type Oval.
 */
public class Oval extends AbstractShape{

  /**
   * Instantiates a new Oval.
   *
   * @param name     the name
   * @param type     the type
   * @param position the position
   * @param size     the size
   * @param color    the color
   */
  public Oval(String name, TypeofShape type, Position position, Size size, MyColor color) {
    super(name, type, position, size, color);
  }

  /**
   * establish string.
   *
   * @return the Name:
   *             Type:
   *             Center:
   *             X radius:
   *             Y radius:
   *             Color:
   */
  public String toString() {
    return "\nName: " + name + "\n"
            + "Type: " + type.toString() + "\n"
            + "Center: " + position.toString() + ", "
            + "X radius: " + size.getX() + ", "
            + "Y radius: " + size.getX() + ", " + color.toString() + "\n";
  }
}
