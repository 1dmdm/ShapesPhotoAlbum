package photoAlbum;

import java.io.IOException;

import controller.Controller;
import model.Model;

/**
 * The type Photo album main.
 */
public class PhotoAlbumMain {
  /**
   * The entry point of application.
   *
   * @param args the input arguments
   * @throws IOException the io exception
   */
  public static void main(String[] args) throws IOException, InterruptedException {
    int i = 0;
    String txt = "";
    String type = "";
    String html = "";
    String width = "1000";
    String height = "1000";

    while (i + 1 < args.length) {
      if ("-in".equals(args[i])) {
        txt = args[i + 1];
      } else if ("-view".equals(args[i]) || "-v".equals(args[i])) {
        type = args[i + 1];
      } else if ("-out".equals(args[i])) {
        html = args[i + 1];
      } else if ("graphical".equals(args[i])) {
        if (i + 2 < args.length) {
          width = args[i + 1];
          height = args[i + 2];
        }
      }
      i += 1;
    }
    Controller c = new Controller(txt, type, html, width, height);
    Model m = c.readFile(new Model());
    c.outputFile(m);

  }

}


