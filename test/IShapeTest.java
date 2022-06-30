import org.junit.Test;

import shape.MyColor;
import shape.IShape;
import shape.Oval;
import shape.Position;
import shape.Rectangle;
import shape.Size;
import shape.TypeofShape;

import static org.junit.Assert.assertEquals;

/**
 * The type Shape test.
 */
public class IShapeTest {
  IShape rectangle = new Rectangle("RECTANGLE", TypeofShape.RECTANGLE,
          new Position(100,100), new Size(10,10), new MyColor(1,0,0));

  IShape oval = new Oval("OVAL", TypeofShape.OVAL, new Position(50,50),
          new Size(5,5), new MyColor(1,1,0));

  /**
   * Gets name.
   *
   * @return the name
   */
  @Test
  public void getNameTest1() {

    assertEquals("RECTANGLE", rectangle.getName());
  }
  public void getNameTest2() {
    assertEquals("OVAL", oval.getName());
  }

  /**
   * Gets the type.
   *
   * @return the type
   */
  @Test
  public void getTypeTest1() {
    assertEquals(TypeofShape.RECTANGLE, rectangle.getType());
  }
  public void getTypeTest2() {
    assertEquals(TypeofShape.OVAL, oval.getType());
  }

  /**
   * Gets position.
   *
   * @return the position
   */
  @Test
  public void getPositionTest1() {
    assertEquals("(100.0,100.0)", rectangle.getPosition().toString());
  }
  public void getPositionTest2() {
    assertEquals("(50.0,50.0)", oval.getPosition().toString());
  }


  /**
   * Sets the position.
   *
   * @return the position
   */
  @Test
  public void setPositionTest1() {
    assertEquals("(100.0,100.0)", rectangle.getPosition().toString());
    rectangle.setPosition(new Position(200, 200));
    assertEquals("(200.0,200.0)", rectangle.getPosition().toString());
  }
    public void setPositionTest2() {
    assertEquals("(50.0,50.0)", oval.getPosition().toString());
    oval.setPosition(new Position(57,57));
    assertEquals("(57.0,57.0)",oval.getPosition().toString());
  }

  /**
   * Gets size.
   *
   * @return the x and y of the size
   */
  @Test
  public void getSizeTest1() {
    assertEquals(10,rectangle.getSize().getX(),0.001);
    assertEquals(10,rectangle.getSize().getY(),0.001);
  }
  public void getSizeTest2() {
    assertEquals(5,oval.getSize().getX(),0.001);
    assertEquals(5,oval.getSize().getY(),0.001);
  }

  /**
   * Sets size.
   *
   * @return the x and y of the size
   */
  @Test
  public void setSizeTest1() {
    assertEquals(10,rectangle.getSize().getX(),0.001);
    assertEquals(10,rectangle.getSize().getY(),0.001);
    rectangle.setSize(new Size(20,20));
    assertEquals(20,rectangle.getSize().getX(),0.001);
    assertEquals(20,rectangle.getSize().getY(),0.001);
  }
  public void setSizeTest2() {
    assertEquals(5,oval.getSize().getX(),0.001);
    assertEquals(5,oval.getSize().getY(),0.001);
    rectangle.setSize(new Size(7,7));
    assertEquals(7,oval.getSize().getX(),0.001);
    assertEquals(7,oval.getSize().getY(),0.001);
  }

  /**
   * Gets the color.
   *
   * @return the R,G,B of color
   */
  @Test
  public void getColorTest1() {
    assertEquals(1,rectangle.getColor().getR(),0.001);
    assertEquals(0,rectangle.getColor().getG(),0.001);
    assertEquals(0,rectangle.getColor().getB(),0.001);
  }
  public void getColorTest2() {
    assertEquals(1,oval.getColor().getR(),0.001);
    assertEquals(1,oval.getColor().getG(),0.001);
    assertEquals(0,oval.getColor().getB(),0.001);
  }

  /**
   * Sets the color.
   *
   * @return the R,G,B of color
   */
  @Test
  public void setColorTest1() {
    assertEquals(1,rectangle.getColor().getR(),0.001);
    assertEquals(0,rectangle.getColor().getG(),0.001);
    assertEquals(0,rectangle.getColor().getB(),0.001);
    rectangle.setColor(new MyColor(2,2,2));
    assertEquals(2,rectangle.getColor().getR(),0.001);
    assertEquals(2,rectangle.getColor().getG(),0.001);
    assertEquals(2,rectangle.getColor().getG(),0.001);
  }
  public void setColorTest2() {
    assertEquals(1,oval.getColor().getR(),0.001);
    assertEquals(1,oval.getColor().getG(),0.001);
    assertEquals(0,oval.getColor().getB(),0.001);
    oval.setColor(new MyColor(0,1,20));
    assertEquals(0,oval.getColor().getR(),0.001);
    assertEquals(1,oval.getColor().getG(),0.001);
    assertEquals(20,oval.getColor().getG(),0.001);
  }
}