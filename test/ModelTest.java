import org.junit.Test;

import java.io.FileNotFoundException;

import controller.Controller;
import model.Model;

import static org.junit.Assert.assertEquals;

public class ModelTest {
  @Test
  public void createModel() throws FileNotFoundException, InterruptedException {
    Controller c = new Controller("demo_input.txt", "web",
            "test1", "800", "800");
    Model m = c.readFile(new Model());
    assertEquals("Printing Snapshots\n" +
            "[\n" +
            "Name: myrect\n" +
            "Type: rectangle\n" +
            "Min corner: (200.0,200.0), Width: 50.0, Color: (255.0,0.0,0.0)\n" +
            ", \n" +
            "Name: myoval\n" +
            "Type: oval\n" +
            "Center: (500.0,100.0), X radius: 60.0, Y radius: 60.0, (0.0,255.0,1.0)\n" +
            "][\n" +
            "Name: myrect\n" +
            "Type: rectangle\n" +
            "Min corner: (100.0,300.0), Width: 25.0, Color: (255.0,0.0,0.0)\n" +
            ", \n" +
            "Name: myoval\n" +
            "Type: oval\n" +
            "Center: (500.0,100.0), X radius: 60.0, Y radius: 60.0, (0.0,255.0,1.0)\n" +
            "][\n" +
            "Name: myrect\n" +
            "Type: rectangle\n" +
            "Min corner: (100.0,300.0), Width: 25.0, Color: (0.0,0.0,255.0)\n" +
            ", \n" +
            "Name: myoval\n" +
            "Type: oval\n" +
            "Center: (500.0,400.0), X radius: 60.0, Y radius: 60.0, (0.0,255.0,1.0)\n" +
            "][\n" +
            "Name: myoval\n" +
            "Type: oval\n" +
            "Center: (500.0,400.0), X radius: 60.0, Y radius: 60.0, (0.0,255.0,1.0)\n" +
            "]", m.toString());
  }
}