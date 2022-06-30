package shape;

/**
 * The type Rectangle.
 */
public class Rectangle extends AbstractShape {
  /**
   * Instantiates a new Rectangle.
   *
   * @param name     the name
   * @param type     the type
   * @param position the position
   * @param size     the size
   * @param color    the color
   */
  public Rectangle(String name, TypeofShape type, Position position, Size size, MyColor color) {
    super(name, type, position, size, color);
  }

  /**
   * print out string.
   *
   * @return Name:
   *         Type:
   *         Min corner:
   *         Width:
   *         Color:
   */
  public String toString() {
    return "\nName: " + name + "\n"
            + "Type: " + type.toString() + "\n"
            + "Min corner: " + position.toString() + ", "
            + "Width: " + size.getX() + ", "
            + "Color: " + color.toString() + "\n";
  }
}
