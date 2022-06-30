In this project:
I have package: controller, view, model, photoAlbum, shape and svg.
In my controller package, I have class Controller
In my view package, I have class Frame, class Panel and interface IView
In my svg package, I have class SVG.
In my photoAlbum package, I have class PhotoAlbumMain
In my model package, already explained in last homework
In my shape package, already explained in last homework

Something changed in my shape package(was built up in last hw):
In my IShape, I added method called void paintShape(Graphics g);
In my AbstractShape class, I add a method called public void paintShape(Graphics g), this is used to paint shapes.

Here is how my MVC architecture works:
The concept of my MVC (Model-View-Controller) is : My controller is the interface between View and Model. Controller interacts with the Model to send and receive data. Controller then interacts with the View to render the data. That is to say, Controller read instructions from outside file(.txt), and let Model create shapes and create snapshots. And let View present the information of shapes and timestamp and paint shapes on the panel. 

In my controller class, I have method called public Model readFile(Model model). In this method, my controller read .txt file and let model create shapes, do snapshots, move position, change size, change color and delete shapes. In the end, this method, return a model. Then I created a method called public void outputFile(Model m). In this method, I recognized whether it is about "graphical" or about "web". Then according to their type, this method will let model draw the shapes and gets snapshots.

Under my view package, I have three classes: IView, Frame and Panel.
The first class makes a JFrame (called Frame), and adds a JPanel (called myPanel) on it and draws shapes on the myPanel. The second class makes a JPanel (called Panel) that the first class uses.
Also, my view includes all the UI components that the user interacts with. 

Under my svg, I have class SVG. This class is aimed at translating my shapeList into .html format.

Under my photoAlbum package, I have class PhotoAlbumMain. It is a starter class, and it accepts command line and pass all those parameters to controller. And let controller read file and create a new model and output the file.

In my Frame class, I created a frame class which implements an ActionListener interface, and I put all my panels(three panels) on the frame. I create four buttons on the frame: buttonPre, buttonSelect, buttonNext, buttonQuit
Those four buttons are components upon which an instance of event handler class Frame is registered. 
Then, when users press buttons, they could check snapshots previously and continuously and select snapshots from a window and quit the system.

In my Panel class, I have method called showSnapShots(List<IShape> newShape), I put shapes in the list, and use repaint() method to draw shapes. 

Controller class
public Controller(String txt, String type, String html, String width, String height)
public Model readFile(Model model) 
public void outputFile(Model m) 

IModel Interface
void createShape(String name, TypeofShape shape, Position position, Size size, MyColor color);
HashMap<String, IShape> getShape();
void changeColor(String name, MyColor newcolor);
void changeSize(String name, Size newSize);
void deleteShape(String name);
void movePosition(String name, Position newposition);
void snapShot() throws InterruptedException;
HashMap<Timestamp, List<IShape>> getSnapShots();
List<Timestamp> getTimeList();

Model class
public void createShape(String name, TypeofShape type, Position position, Size size, MyColor myColor)
public HashMap<String, IShape> getShape() 
public void changeColor(String name, MyColor newcolor)
public void movePosition(String name, Position newposition)
public void snapShot()
public HashMap<Timestamp, List<IShape>> getSnapShots() 
public List<Timestamp> getTimeList()
public void changeSize(String name, Size newSize) 
public void deleteShape(String name)
public String toString()

PhotoAlbumMain
public static void main(String[] args) 

shape package
already explained before

added:
IShape
void paintShape(Graphics g);

AbstractShape
public void paintShape(Graphics g)

SVG
public SVG()
public static String toSvg(List<IShape> shapeList, Timestamp t)

IView
void view(List<Timestamp> timelist, HashMap<Timestamp, List<IShape>> snapshots);

Frame class
public Frame()
public void view(List<Timestamp> timelist, HashMap<Timestamp, List<IShape>> snapshots)
public void Menu()
public void actionPerformed(ActionEvent e)

Panel class
public Panel() 
public void setSnapshots(HashMap<Timestamp, List<IShape>> snapshots)
public void setTimelist(List<Timestamp> timelist)
public void showSnapShots(List<IShape> newShape)
public void paint(Graphics g)

