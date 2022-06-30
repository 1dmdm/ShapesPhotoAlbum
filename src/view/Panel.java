package view;

import java.awt.*;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import javax.swing.*;

import shape.IShape;


/**
 * The type Panel.
 */
public class Panel extends JPanel {

  private java.util.List<Timestamp> timelist;
  private java.util.List<IShape> shapes;
  private HashMap<Timestamp, List<IShape>> snapshots;

  /**
   * Instantiates a new Panel.
   */
  public Panel() {
  }

  /**
   * Sets snapshots.
   *
   * @param snapshots the snapshots
   */
  public void setSnapshots(HashMap<Timestamp, List<IShape>> snapshots) {
    this.snapshots = snapshots;
  }

  /**
   * Sets timelist.
   *
   * @param timelist the timelist
   */
  public void setTimelist(List<Timestamp> timelist) {
    this.timelist = timelist;
  }

  /**
   * Show snap shots.
   *
   * @param newShape the new shape
   */
  public void showSnapShots(List<IShape> newShape) {
    shapes = newShape;
    repaint();
  }

  /**
   * Paint.
   *
   * @param g the new shape
   */
  public void paint(Graphics g) {
    Graphics2D gShape2D = (Graphics2D) g;
    if (shapes != null) {
      shapes.forEach(s -> s.paintShape(g));
    }
  }
}


