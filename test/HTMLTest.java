import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import controller.Controller;
import model.Model;

import static org.junit.Assert.assertEquals;

public class HTMLTest {

  @Test
  public void test() throws IOException, InterruptedException {
    Controller c = new Controller("demo_input.txt", "web",
            "htmlWeb.html", "800", "800");
    Model m = c.readFile(new Model());
    c.outputFile(m);
    StringBuilder str = new StringBuilder();
    File s = new File("htmlWeb.html");
    Scanner scanner = new Scanner(s);
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      str.append(line+"\n");
    }

    assertEquals("<!DOCTYPE html>\n" +
            "<html>\n" +
            "<body>\n" +
            "<h1>final project</h1>\n" +
            "<div>\n" +
            "    <h2>" + m.getTimeList().get(0) + "</h2>\n" +
            "    <svg width=\"800\" height=\"800\">\n" +
            "        <rect id=\"myrect\" x=\"200.0\" y=\"200.0\" width=\"50.0\" height=\"100.0\" fill=\"rgb(255, 0, 0)\">\n" +
            "        </rect>\n" +
            "        <ellipse id=\"myoval\" cx=\"500.0\" cy=\"100.0\" rx=\"60.0\" ry=\"30.0\" fill=\"rgb(0, 255, 1)\">\n" +
            "        </ellipse>\n" +
            "    </svg>\n" +
            "</div>\n" +
            "<div>\n" +
            "    <h2>" + m.getTimeList().get(1)+ "</h2>\n" +
            "    <svg width=\"800\" height=\"800\">\n" +
            "        <rect id=\"myrect\" x=\"100.0\" y=\"300.0\" width=\"25.0\" height=\"100.0\" fill=\"rgb(255, 0, 0)\">\n" +
            "        </rect>\n" +
            "        <ellipse id=\"myoval\" cx=\"500.0\" cy=\"100.0\" rx=\"60.0\" ry=\"30.0\" fill=\"rgb(0, 255, 1)\">\n" +
            "        </ellipse>\n" +
            "    </svg>\n" +
            "</div>\n" +
            "<div>\n" +
            "    <h2>" + m.getTimeList().get(2) + "</h2>\n" +
            "    <svg width=\"800\" height=\"800\">\n" +
            "        <rect id=\"myrect\" x=\"100.0\" y=\"300.0\" width=\"25.0\" height=\"100.0\" fill=\"rgb(0, 0, 255)\">\n" +
            "        </rect>\n" +
            "        <ellipse id=\"myoval\" cx=\"500.0\" cy=\"400.0\" rx=\"60.0\" ry=\"30.0\" fill=\"rgb(0, 255, 1)\">\n" +
            "        </ellipse>\n" +
            "    </svg>\n" +
            "</div>\n" +
            "<div>\n" +
            "    <h2>" + m.getTimeList().get(3) + "</h2>\n" +
            "    <svg width=\"800\" height=\"800\">\n" +
            "        <ellipse id=\"myoval\" cx=\"500.0\" cy=\"400.0\" rx=\"60.0\" ry=\"30.0\" fill=\"rgb(0, 255, 1)\">\n" +
            "        </ellipse>\n" +
            "    </svg>\n" +
            "</div>\n" + "</body>\n" +
            "</html>\n", str.toString());
  }
}
