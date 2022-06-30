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

Last hw's README is shown as below:
I have interface IModel, and class Model in model package. And I have interface IShape, abstract class AbstractShape, and two concrete classes: Rectangle and Oval, and Enum class: TypeofShape, and class Position, class Size, and class Color in shape package.

In my shape package, basically I just instantiate all my shape objects. Those shape objects could follow the instructions of IShape and AbstractShape class to instantiated themselves. Basically, either Rectangle or Oval has the name as String(“RECTANGLE” or “OVAL”); has the type(either Rectangle or Oval); has the coordinates(x and y); has the size(either width and length); has the color(r,g,b). So I just use those five attributes to instantiate shape objects.

In my model package. My model corresponds all the data-related logic that the user will work with. It can retrieve every shape’s information, eg: shape’s name, thape’s type, shape’s position, shape’s size and shape’s color. And also the model could manipulate it and update data back to the data base or use it to render data. 

In my model, I have a HashMap called snapshots. Just according to the hw requirements, but the string and timestamp into the HashMap.

In my model, I have a HashMap called shapes. I save all the IShape into it as the value, and the name of the shape as the key. Therefore, the model could store, retrieve and update all the data and details of IShape. 

In my mode, I have a list called timelist. I save all the Timstamp into it.


In IModel:
void createShape(String name, TypeofShape shape, Position position, Size size, Color color);
HashMap<String, IShape> getShape();
void changeColor(String name, Color newcolor);
void movePosition(String name, Position newposition);
void snapShot();
HashMap<Timestamp, String> getSnapShots();
List<Timestamp> getTimeList();

In Model:
public void createShape(String name, TypeofShape type, Position position, Size size, Color color): instantiate the shape objects
public HashMap<String, IShape> getShape() : get the HashMap of the Ishape;
public void changeColor(String name, Color newcolor): change the shape’s color
public void movePosition(String name, Position newposition) : change the shape’s position
public void snapShot() :get each time’s timestamp, and put it into the timelist. And just according to the hw’s requirements, I have my StringBuilder. Then I put StringBuilder as value into the HashMap called snapshots. And I put timestamp as key into the HashMap called snapshots. So every time, the model could store and retrieve the details and information of the state of the shapes.

public HashMap<Timestamp, String> getSnapShots():to return the snapshots HashMap

public List<Timestamp> getTimeList(): to get and print out the timestamp


In IShape:
String getName();
void setName(String name);
TypeofShape getType();
void setType(TypeofShape type);
Position getPosition();
void setPosition(Position position);
Size getSize();
void setSize(Size size);
Color getColor();
void setColor(Color color);

In AbstractShape:
protected String name;
protected TypeofShape type;
protected Position position;
protected Size size;
protected Color color;
public AbstractShape(String name, TypeofShape shape, Position position, Size size, Color color)
public String getName()
public void setName(String name)
public TypeofShape getType()
public void setType(TypeofShape type)
public Position getPosition()
public void setPosition(Position position)
public String getName()
public void setName(String name)
public TypeofShape getType()
public void setType(TypeofShape type)
public Position getPosition()
public void setPosition(Position position)
public Size getSize()
public void setSize(Size size)
public Color getColor()
public void setColor(Color color)

In Rectangle:
public Rectangle(String name, TypeofShape type, Position position, Size size, Color color): instantiate the Rectangle object
public String toString() : according to the hw’s requirement, set up the string when it print out

In Oval: 
public Oval(String name, TypeofShape type, Position position, Size size, Color color) : instantiate the Oval object
public String toString() : according to the hw’s requirement, set up the string when it print out

In TypeofShape: 
Enum: RECTANGLE and OVAL

In Position:
public Position(double x, double y): instantiate the Position object
public double getY(): getY
public double getX(): getX
public void setX(double x) :  setX
public void setY(double y) : setY
public String toString(): according to the hw’s requirement, print out as (x,y)
In Size: 
public Size(double x, double y): instantiate the Size object
public double getY(): getY
public double getX():getX
public void setX(double x): setX
public void sety(double y): setY
In Color
public Color(double r, double g, double b): instantiate the Color object
public void setR(double r): setR
public double getR(): getR
public void setG(double g): setG
public double getG(): getG
public void setB(double b): setB
public double getB():getB
public String toString(): according to the hw’s requirement, print out as (r,g,b)



