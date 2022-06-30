package svg;

import java.sql.Timestamp;
import java.util.List;

import shape.IShape;
import shape.TypeofShape;

/**
 * The type Svg.
 */
public class SVG {
  public SVG() {
  }

  /**
   * To svg string.
   *
   * @param shapeList the shape list
   * @param t         the t
   * @return the string
   */
  public static String toSvg(List<IShape> shapeList, Timestamp t){
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("<div>\n    <h2>").append(t.toString()).append("</h2>\n");
    stringBuilder.append("    <svg width=\"").append(800);
    stringBuilder.append("\" height=\"").append(800).append("\">\n");
    for (IShape shape:shapeList) {
      TypeofShape type = shape.getType();
      if (type == TypeofShape.RECTANGLE) {
        stringBuilder.append("        <rect id=\"").append(shape.getName());
        stringBuilder.append("\" x=\"").append(shape.getPosition().getX()).append("\" y=\"");
        stringBuilder.append(shape.getPosition().getY());
        stringBuilder.append("\" width=\"").append(shape.getSize().getX());
        stringBuilder.append("\" height=\"").append(shape.getSize().getY());
        stringBuilder.append("\" fill=\"rgb(");
        stringBuilder.append((int) shape.getColor().getR()).append(", ").append((int) shape.getColor().getG()).append(", ").append((int) shape.getColor().getB());
        stringBuilder.append(")\">\n        </rect>\n");
      } else if (type == TypeofShape.OVAL) {
        stringBuilder.append("        <ellipse id=\"").append(shape.getName());
        stringBuilder.append("\" cx=\"").append(shape.getPosition().getX()).append("\" cy=\"");
        stringBuilder.append(shape.getPosition().getY());
        stringBuilder.append("\" rx=\"").append(shape.getSize().getX());
        stringBuilder.append("\" ry=\"").append(shape.getSize().getY());
        stringBuilder.append("\" fill=\"rgb(");
        stringBuilder.append((int) shape.getColor().getR()).append(", ").append((int) shape.getColor().getG()).append(", ").append((int) shape.getColor().getB());
        stringBuilder.append(")\">\n        </ellipse>\n");
      }
    }
    stringBuilder.append("    </svg>\n").append("</div>\n");
    return stringBuilder.toString();
  }

}
