package view;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import shape.IShape;

/**
 * The interface View.
 */
public interface IView {

  /**
   * View.
   *
   * @param timelist  the timelist
   * @param snapshots the snapshots
   */
  void view(List<Timestamp> timelist, HashMap<Timestamp, List<IShape>> snapshots);
}
