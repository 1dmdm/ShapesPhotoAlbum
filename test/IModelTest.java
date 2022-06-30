import org.junit.Before;

import model.IModel;
import model.Model;
import shape.MyColor;
import shape.IShape;
import shape.Position;
import shape.Rectangle;
import shape.Size;
import shape.TypeofShape;

import static org.junit.Assert.*;

/**
 * The type Model test.
 */
public class IModelTest {

  IModel model;

  /**
   * Set up model.
   *
   */
  @Before
  public void setUp() throws Exception {
    model = new Model();
  }

  /**
   * Create shape.
   *
   */
  @org.junit.Test
  public void createShape() {
    try {
      IShape Rectangle = new Rectangle(null, TypeofShape.RECTANGLE,
              new Position(100,100), new Size(10,10), new MyColor(1,0,0));
    } catch (IllegalArgumentException e) {
  }
    try {
      IShape Rectangle = new Rectangle("R", null,
              new Position(100,100), new Size(10,10), new MyColor(1,0,0));
    } catch (IllegalArgumentException e) {
    }
    try {
      IShape Rectangle = new Rectangle("R", TypeofShape.RECTANGLE, null,
              new Size(10,10), new MyColor(1,0,0));
    } catch (IllegalArgumentException e) {
    }
    try {
      IShape Rectangle = new Rectangle("R", TypeofShape.RECTANGLE,
              new Position(100,100), null, new MyColor(1,0,0));
    } catch (IllegalArgumentException e) {
    }
    try {
      IShape Rectangle = new Rectangle("R", TypeofShape.RECTANGLE,
              new Position(100,100), new Size(10,10), new MyColor(290,0,0));
    } catch (IllegalArgumentException e) {
    }
    try {
      IShape Rectangle = new Rectangle("R", TypeofShape.RECTANGLE,
              new Position(100,100), new Size(10,10), new MyColor(1,290,0));
    } catch (IllegalArgumentException e) {
    }
    try {
      IShape Rectangle = new Rectangle("R", TypeofShape.RECTANGLE,
              new Position(100,100), new Size(10,10), new MyColor(1,0,290));
    } catch (IllegalArgumentException e) {
    }
    }

  /**
   * Gets shape.
   *
   * @return the shape
   */
  @org.junit.Test
  public void getShape() {
    model.createShape("RECTANGLE", TypeofShape.RECTANGLE, new Position(100,100),
            new Size(10,10), new MyColor(1,0,0));
    assertEquals("RECTANGLE", model.getShape().get("RECTANGLE").getName());
    assertEquals(TypeofShape.RECTANGLE, model.getShape().get("RECTANGLE").getType());
    assertEquals("(100.0,100.0)",
            model.getShape().get("RECTANGLE").getPosition().toString());
    assertEquals(10, model.getShape().get("RECTANGLE").getSize().getX(),0.001);
    assertEquals(10, model.getShape().get("RECTANGLE").getSize().getY(),0.001);
    assertEquals(1, model.getShape().get("RECTANGLE").getColor().getR(),0.001);
    assertEquals(0, model.getShape().get("RECTANGLE").getColor().getG(),0.001);
    assertEquals(0, model.getShape().get("RECTANGLE").getColor().getB(),0.001);
    assertEquals(1, model.getShape().size());

    model.createShape("OVAL", TypeofShape.OVAL, new Position(20,20),
            new Size(5,5), new MyColor(1,1,0));
    assertEquals("OVAL", model.getShape().get("OVAL").getName());
    assertEquals("(20.0,20.0)", model.getShape().get("OVAL").getPosition().toString());
    assertEquals(5, model.getShape().get("OVAL").getSize().getX(),0.001);
    assertEquals(5,model.getShape().get("OVAL").getSize().getY(),0.001);
    assertEquals(1,model.getShape().get("OVAL").getColor().getR(),0.001);
    assertEquals(1,model.getShape().get("OVAL").getColor().getG(),0.001);
    assertEquals(0,model.getShape().get("OVAL").getColor().getB(),0.001);
    assertEquals(2, model.getShape().size());
  }

  /**
   * Changes the color.
   *
   * @return the color
   */
  @org.junit.Test
  public void changeColor() {
    model.createShape("RECTANGLE", TypeofShape.RECTANGLE,
            new Position(100,100), new Size(10,10), new MyColor(1,0,0));
    model.changeColor("RECTANGLE", new MyColor(2,0,0));
    assertEquals(2, model.getShape().get("RECTANGLE").getColor().getR(),0.001);
    assertEquals(0, model.getShape().get("RECTANGLE").getColor().getG(),0.001);
    assertEquals(0, model.getShape().get("RECTANGLE").getColor().getB(),0.001);
  }

  /**
   * Change the position.
   *
   * @return the position
   */
  @org.junit.Test
  public void movePosition() {
    model.createShape("RECTANGLE", TypeofShape.RECTANGLE,
            new Position(100,100), new Size(10,10), new MyColor(1,0,0));
    model.movePosition("RECTANGLE", new Position(200,100));
    assertEquals("(200.0,100.0)",
            model.getShape().get("RECTANGLE").getPosition().toString());
  }

  /**
   * Gets the snapshots.
   *
   * @return the snapshots
   */
  @org.junit.Test
  public void getSnapShots() throws InterruptedException {
    model.snapShot();
    model.createShape("RECTANGLE", TypeofShape.RECTANGLE,
            new Position(100,100), new Size(10,10), new MyColor(1,0,0));
    model.snapShot();
    assertEquals( "Printing Snapshots" + "\n[]" + "[\n"
            + "Name: RECTANGLE\n" +
            "Type: rectangle\n" +
            "Min corner: (100.0,100.0), Width: 10.0, Color: (1.0,0.0,0.0)\n" +
            "]",model.toString());

   model.createShape("OVAL", TypeofShape.OVAL,
           new Position(50,50), new Size(5,5), new MyColor(1,1,0));
   model.snapShot();
   assertEquals("{"+model.getTimeList().get(0)+"=[], " + model.getTimeList().get(1)+ "=[\n" +
           "Name: RECTANGLE\n" +
           "Type: rectangle\n" +
           "Min corner: (100.0,100.0), Width: 10.0, Color: (1.0,0.0,0.0)\n" +
           "], " +  model.getTimeList().get(2) + "=[\n" +
           "Name: RECTANGLE\n" +
           "Type: rectangle\n" +
           "Min corner: (100.0,100.0), Width: 10.0, Color: (1.0,0.0,0.0)\n" +
           ", \n" +
           "Name: OVAL\n" +
           "Type: oval\n" +
           "Center: (50.0,50.0), X radius: 5.0, Y radius: 5.0, (1.0,1.0,0.0)\n" +
           "]}",model.getSnapShots().toString());
  }
}