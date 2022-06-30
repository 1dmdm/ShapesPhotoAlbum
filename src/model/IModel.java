package model;


import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import shape.MyColor;
import shape.IShape;
import shape.Position;
import shape.Size;
import shape.TypeofShape;

/**
 * The interface Model.
 */
public interface IModel {

  /**
   * Create shape.
   *
   * @param name    the name
   * @param shape   the shape
   * @param position the postion
   * @param size    the size
   * @param color   the color
   */
  void createShape(String name, TypeofShape shape, Position position, Size size, MyColor color);

  /**
   * Gets shape.
   *
   * @return the shape
   */
  HashMap<String, IShape> getShape();

  /**
   * Change color.
   *
   * @param name     the name
   * @param newcolor the newcolor
   */
  void changeColor(String name, MyColor newcolor);

  /**
   * Change size.
   *
   * @param name     the name
   * @param newSize the newSize
   */
  void changeSize(String name, Size newSize);

  /**
   * delete Shape.
   *
   * @param name     the name
   */
  void deleteShape(String name);

  /**
   * Move position.
   *
   * @param name        the name
   * @param newposition the newposition
   */
  void movePosition(String name, Position newposition);

  /**
   * Snap shot.
   * @return
   */
  //HashMap<Timestamp, List<IShape>>
  //
  void snapShot() throws InterruptedException;

  /**
   * Gets snap shots.
   *
   * @return the snapshots
   */
  HashMap<Timestamp, List<IShape>> getSnapShots();

  /**
   * Gets Timestamp.
   *
   * @return the timestamp
   */
  List<Timestamp> getTimeList();
}


