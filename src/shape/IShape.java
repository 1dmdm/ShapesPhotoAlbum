package shape;

import java.awt.*;

/**
 * The interface Shape.
 */
public interface IShape {

  /**
   * Gets name.
   *
   * @return the name
   */
  String getName();

  /**
   * Sets name.
   *
   * @param name the name
   */
  void setName(String name);

  /**
   * Gets type.
   *
   * @return the type
   */
  TypeofShape getType();

  /**
   * Sets type.
   *
   * @param type the type
   */
  void setType(TypeofShape type);

  /**
   * Gets position.
   *
   * @return the position
   */
  Position getPosition();

  /**
   * Sets position.
   *
   * @param position the position
   */
  void setPosition(Position position);

  /**
   * Gets size.
   *
   * @return the size
   */
  Size getSize();

  /**
   * Sets size.
   *
   * @param size the size
   */
  void setSize(Size size);

  /**
   * Gets color.
   *
   * @return the color
   */
  MyColor getColor();

  /**
   * Sets color.
   *
   * @param color the color
   */
  void setColor(MyColor color);

  /**
   * Paint shape.
   *
   * @param g the g
   */
  void paintShape(Graphics g);
}
