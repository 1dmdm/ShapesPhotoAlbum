package shape;

import java.awt.*;

/**
 * The type Abstract shape.
 */
public class AbstractShape implements IShape{

  /**
   * The Name.
   */
  protected String name;

  /**
   * The Type.
   */
  protected TypeofShape type;

  /**
   * The Position.
   */
  protected Position position;

  /**
   * The Size.
   */
  protected Size size;

  /**
   * The Color.
   */
  protected MyColor color;

  /**
   * Instantiates a new Abstract shape.
   *
   * @param name    the name
   * @param shape   the shape
   * @param position the postion
   * @param size    the size
   * @param color   the color
   */
  public AbstractShape(String name, TypeofShape shape, Position position, Size size, MyColor color) {
    this.name = name;
    this.type = shape;
    this.position = position;
    this.size = size;
    this.color = color;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  @Override
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets type.
   *
   * @return the type
   */
  @Override
  public TypeofShape getType() {
    return type;
  }

  /**
   * Sets type.
   *
   * @param type the type
   */
  @Override
  public void setType(TypeofShape type) {
    this.type = type;
  }

  /**
   * Gets position.
   *
   * @return the position
   */
  @Override
  public Position getPosition() {
    return position;
  }

  /**
   * Sets position.
   *
   * @param position the position
   */
  @Override
  public void setPosition(Position position) {
    this.position = position;
  }

  /**
   * Gets size.
   *
   * @return the size
   */
  @Override
  public Size getSize() {
    return size;
  }

  /**
   * Sets size.
   *
   * @param size the size
   */
  @Override
  public void setSize(Size size) {
    this.size = size;
  }

  /**
   * Gets color.
   *
   * @return the color
   */
  @Override
  public MyColor getColor() {
    return color;
  }

  /**
   * Sets color.
   *
   * @param color the color
   */
  @Override
  public void setColor(MyColor color) {
    this.color = color;
  }

  /**
   * Paint shapes.
   *
   * @param g the g
   */
  public void paintShape(Graphics g) {
    g.setColor(new Color((int) color.getR(), (int) color.getG(), (int) color.getB()));
    if (this.type == TypeofShape.RECTANGLE) {
      g.fillRect((int) position.getX(), (int) position.getY(), (int) size.getX(), (int) size.getY());
    }
    if (this.type == TypeofShape.OVAL) {
      g.fillOval((int) position.getX(), (int) position.getY(), (int) size.getX(), (int) size.getY());
    }
  }

  @Override
  public String toString() {
    if(type == TypeofShape.RECTANGLE) {
      return new Rectangle(this.getName(), this.getType(), this.getPosition(), this.getSize(), this.getColor()).toString();
    }
    else {
      return new Oval(this.getName(), this.getType(), this.getPosition(), this.getSize(), this.getColor()).toString();
    }
  }
}
