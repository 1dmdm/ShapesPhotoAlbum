package controller;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import shape.MyColor;
import shape.Position;
import shape.Size;
import shape.TypeofShape;
import svg.SVG;
import view.Frame;

import model.Model;

/**
 * The type Controller.
 */
public class Controller {
  /**
   * The Txt.
   */
  String txt;
  /**
   * The Type.
   */
  String type;
  /**
   * The Html.
   */
  String html;
  /**
   * The Width.
   */
  String width;
  /**
   * The Height.
   */
  String height;

  /**
   * Instantiates a new Controller.
   *
   * @param txt    the txt
   * @param type   the type
   * @param html   the html
   * @param width  the width
   * @param height the height
   */
  public Controller(String txt, String type, String html, String width, String height) {
    this.txt = txt;
    this.type = type;
    this.html = html;
    this.width = width;
    this.height = height;
  }

  /**
   * Read file model.
   *
   * @param model the model
   * @return the model
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException  the interrupted exception
   */
  public Model readFile(Model model) throws FileNotFoundException, InterruptedException {
    //read .txt file line by line
    File s = new File(txt);
    Scanner scanner = new Scanner(s);
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      //translate cmd to models
      String[] res = line.split("\n");
      for (String result : res) {
        String[] components = result.split(" ");
        List<String> cmdLine = Arrays.stream(components).filter(c -> !c.isEmpty()).collect(Collectors.toList());
        if (cmdLine.size() != 0) {
          String cmd = cmdLine.get(0);
          //getting the type of shape from the first parameter
          if ("SHAPE".equalsIgnoreCase(cmd)) {
            if (cmdLine.get(2).equals("rectangle")) {
              model.createShape(cmdLine.get(1), TypeofShape.RECTANGLE,
                      new Position(Double.parseDouble(cmdLine.get(3)), Double.parseDouble(cmdLine.get(4))),
                      new Size(Double.parseDouble(cmdLine.get(5)), Double.parseDouble(cmdLine.get(6))),
                      (MyColor) new MyColor(Double.parseDouble(cmdLine.get(7)), Double.parseDouble(cmdLine.get(8)), Double.parseDouble(cmdLine.get(9)))
              );
            }
            if (cmdLine.get(2).equals("oval")) {
              model.createShape(cmdLine.get(1), TypeofShape.OVAL,
                      new Position(Double.parseDouble(cmdLine.get(3)), Double.parseDouble(cmdLine.get(4))),
                      new Size(Double.parseDouble(cmdLine.get(5)), Double.parseDouble(cmdLine.get(6))),
                      (MyColor) new MyColor(Double.parseDouble(cmdLine.get(7)), Double.parseDouble(cmdLine.get(8)), Double.parseDouble(cmdLine.get(9))));
            }
            //set snapshot cmd
          } else if ("SNAPSHOT".equalsIgnoreCase(cmd)) {
            model.snapShot();
            //set move cmd
          } else if ("MOVE".equalsIgnoreCase(cmd)) {
            model.movePosition(cmdLine.get(1), new Position(Double.parseDouble(cmdLine.get(2)), Double.parseDouble(cmdLine.get(3))));
            //set resize cmd
          } else if ("RESIZE".equalsIgnoreCase(cmd)) {
            model.changeSize(cmdLine.get(1), new Size(Double.parseDouble(cmdLine.get(2)), Double.parseDouble(cmdLine.get(3))));
            //set color cmd
          } else if ("COLOR".equalsIgnoreCase(cmd)) {
            model.changeColor(cmdLine.get(1), (MyColor) new MyColor(Double.parseDouble(cmdLine.get(2)), Double.parseDouble(cmdLine.get(3)), Double.parseDouble(cmdLine.get(4))));
            //set remove cmd
          } else if ("REMOVE".equalsIgnoreCase(cmd)) {
            model.deleteShape(cmdLine.get(1));
          }
        }
      }
    }
    return model;
  }

  /**
   * Output file.
   *
   * @param m the m
   * @throws IOException the io exception
   */
  public void outputFile(Model m) throws IOException {
    try {
      //output type is graphical
      if (type.equals("graphical")) {
        Frame f = new Frame();
        f.view(m.getTimeList(), m.getSnapShots());
      }
      //output type is web
      if (type.equals("web")) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>\n" + "<html>\n" + "<body>\n" + "<h1>final project</h1>\n");
        for (Timestamp t : m.getTimeList()) {
          stringBuilder.append(SVG.toSvg(m.getSnapShots().get(t), t));
        }
        stringBuilder.append("</body>\n" +
                "</html>");
        FileWriter fileWriter = new FileWriter(html, false);
        fileWriter.write(stringBuilder.toString());
        fileWriter.close();
      }
  } catch (IOException e) {
    System.out.println("No .txt file");
  }
}
}
