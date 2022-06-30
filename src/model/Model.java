package model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import shape.AbstractShape;
import shape.MyColor;
import shape.IShape;
import shape.Oval;
import shape.Position;
import shape.Rectangle;
import shape.Size;
import shape.TypeofShape;

import static java.lang.Thread.sleep;

/**
 * The type Model.
 */
public class Model implements IModel{
  private HashMap<Timestamp, List<IShape>> snapshots;
  private List<Timestamp> timelist;
  private HashMap<String, IShape> shapes;
  private List<IShape> shapeList;

  /**
   * Instantiates a new Model.
   */
  public Model() {
    this.shapes = new LinkedHashMap<>();
    this.snapshots = new LinkedHashMap<>();
    this.timelist = new ArrayList<>();
    this.shapeList = new ArrayList<>();
  }

  /**
   * Create shape.
   *
   * @param name    the name
   * @param type   the shape
   * @param position the postion
   * @param size    the size
   * @param myColor   the color
   */
  @Override
  public void createShape(String name, TypeofShape type, Position position, Size size, MyColor myColor)
          throws IllegalArgumentException{
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("name can not be null or empty");
    }
    if (position == null) {
      throw new IllegalArgumentException("position can not be null");
    }
    if (size == null) {
      throw new IllegalArgumentException("size can not be null");
    }
    if (myColor == null) {
      throw new IllegalArgumentException("color can not be null");
    }
    if (type == null) {
      throw new IllegalArgumentException("type can not be null");
    }
    if (type == TypeofShape.RECTANGLE ) {
      shapes.put(name, new Rectangle(name, type, position, size, myColor));
      shapeList = shapes.values().stream().toList();
    }
    if (type == TypeofShape.OVAL ) {
      shapes.put(name, new Oval(name, type, position, size, myColor));
      shapeList = shapes.values().stream().toList();
    }
    }

  /**
   * Gets shape.
   *
   * @return the shape
   */
  @Override
  public HashMap<String, IShape> getShape() {
    return this.shapes;
  }

  /**
   * Change color.
   *
   * @param name     the name
   * @param newcolor the newcolor
   */
  @Override
  public void changeColor(String name, MyColor newcolor) throws IllegalArgumentException {
    if (!getShape().containsKey(name)) {
      throw new IllegalArgumentException("No this shape");
    }
    shapes.get(name).setColor(newcolor);
    shapeList = shapes.values().stream().toList();
  }

  /**
   * Move position.
   *
   * @param name        the name
   * @param newposition the newposition
   */
  @Override
  public void movePosition(String name, Position newposition) throws IllegalArgumentException {
    if (!getShape().containsKey(name)) {
      throw new IllegalArgumentException("No this shape");
    }
    shapes.get(name).setPosition(newposition);
  }

  /**
   * Snap shot.
   */
  @Override
  public void snapShot() throws InterruptedException {
    //to make every snapshot separately and differently
    sleep(10);
    Long dateTime = System.currentTimeMillis();
    Timestamp timestamp = new Timestamp(dateTime);
    timelist.add(timestamp);
    List<IShape> copy = new ArrayList<>();
    for (IShape each:shapeList) {
      copy.add(new AbstractShape(each.getName(), each.getType(), each.getPosition(), each.getSize(), each.getColor()));
    }
    snapshots.put(timestamp, copy);
  }
 // }

  /**
   * Gets snap shots.
   *
   * @return the snap shots
   */
  public HashMap<Timestamp, List<IShape>> getSnapShots() {
    return snapshots;
  }

  /**
   * Gets time lists.
   *
   * @return the timelist
   */
  public List<Timestamp> getTimeList() {
  return timelist;
}

  /**
   * Change size.
   *
   * @param name     the name
   * @param newSize the newSize
   */
  @Override
  public void changeSize(String name, Size newSize) throws IllegalArgumentException {
    if (!getShape().containsKey(name)) {
      throw new IllegalArgumentException("This shape is not existed");
    }
    if (newSize == null) {
      throw new IllegalArgumentException("new size can't be null");
    }
    shapes.get(name).setSize(newSize);
    shapeList = shapes.values().stream().toList();
  }

  /**
   * delete Shape.
   *
   * @param name the name
   */
  @Override
  public void deleteShape(String name) throws IllegalArgumentException {
    if (!getShape().containsKey(name)) {
      throw new IllegalArgumentException("There is no such shape");
    }
    shapes.remove(name);
    shapeList = shapes.values().stream().toList();
  }

  public String toString() {
  StringBuilder s = new StringBuilder("Printing Snapshots\n");
  for (int i = 0; i < snapshots.size(); i++) {
    s.append(snapshots.get(timelist.get(i)).toString());
  }
  return s.toString();
  }



}