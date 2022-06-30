package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.*;

import model.IModel;
import model.Model;
import shape.IShape;


/**
 * The type Frame.
 */
public class Frame extends JFrame implements ActionListener, IView {

  /**
   * The Button pre.
   */
//make JButton global
  JButton buttonPre;
  /**
   * The Button select.
   */
  JButton buttonSelect;
  /**
   * The Button next.
   */
  JButton buttonNext;
  /**
   * The Button quit.
   */
  JButton buttonQuit;
  /**
   * The My panel.
   */
  Panel myPanel;
  /**
   * The Timebox.
   */
  JLabel timebox;
  private List<IShape> shape;
  private List<Timestamp> timelist;
  private HashMap<Timestamp, List<IShape>> snapshots;
  int i = 0;

  /**
   * Instantiates a new Frame.
   */
  public Frame(){};

  /**
   * View.
   *
   * @param timelist  the timelist
   * @param snapshots the snapshots
   */
  @Override
  public void view(List<Timestamp> timelist, HashMap<Timestamp, List<IShape>> snapshots) {
    this.timelist = timelist;
    this.snapshots = snapshots;
    shape = snapshots.get(timelist.get(0));

    //create button
    //create buttonPre
    JButton buttonPre = new JButton();
    buttonPre.addActionListener(this);
    buttonPre.setText("<< Pre <<");
    buttonPre.setFocusable(false);
    buttonPre.setHorizontalTextPosition(JButton.CENTER);
    buttonPre.setVerticalTextPosition(JButton.BOTTOM);
    buttonPre.setBackground(Color.black);
    buttonPre.setBackground(Color.lightGray);
    buttonPre.setBorder(BorderFactory.createEtchedBorder());

    //create buttonSelect
    JButton buttonSelect = new JButton();
    buttonSelect.addActionListener(this);
    buttonSelect.setText("^^ Select ^^");
    buttonSelect.setFocusable(false);
    buttonSelect.setHorizontalTextPosition(JButton.CENTER);
    buttonSelect.setVerticalTextPosition(JButton.BOTTOM);
    buttonSelect.setBackground(Color.black);
    buttonSelect.setBackground(Color.lightGray);
    buttonSelect.setBorder(BorderFactory.createEtchedBorder());

    //create buttonNext
    JButton buttonNext = new JButton();
    buttonNext.addActionListener(this);
    buttonNext.setText(">> Next >>");
    buttonNext.setFocusable(false);
    buttonNext.setHorizontalTextPosition(JButton.CENTER);
    buttonNext.setVerticalTextPosition(JButton.BOTTOM);
    buttonNext.setBackground(Color.black);
    buttonNext.setBackground(Color.lightGray);
    buttonNext.setBorder(BorderFactory.createEtchedBorder());

    //create buttonQuit
    JButton buttonQuit = new JButton();
    buttonQuit.addActionListener(this);
    buttonQuit.setText("xx Quit xx");
    buttonQuit.setFocusable(false);
    buttonQuit.setHorizontalTextPosition(JButton.CENTER);
    buttonQuit.setVerticalTextPosition(JButton.BOTTOM);
    buttonQuit.setBackground(Color.black);
    buttonQuit.setBackground(Color.lightGray);
    buttonQuit.setBorder(BorderFactory.createEtchedBorder());

    //set up frame
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    this.setLocationRelativeTo(null);
    this.setTitle("cs5004 Shapes Photo Album Viewer");
    this.setSize(800,800);
    this.setVisible(true);

    //create myPanel for painting shapes
    //add myPanel on frame
    myPanel = new Panel();
    myPanel.showSnapShots(shape);
    this.add(myPanel);
    this.setVisible(true);

    //set jPanel to put buttons on
    JPanel jPanel = new JPanel();
    jPanel.add(buttonPre);
    jPanel.add(buttonSelect);
    jPanel.add(buttonNext);
    jPanel.add(buttonQuit);
    jPanel.setBackground(Color.PINK);
    this.add(jPanel, BorderLayout.SOUTH);
    this.setVisible(true);

    //create panel2 for showing timestamp
    //add panel2 on the top of frame
    JPanel panel2 = new JPanel();
    if (timelist.size()!=0) {
      timebox = new JLabel(timelist.get(0).toString());
      panel2.add(timebox);
    }
    this.add(panel2, BorderLayout.NORTH);
    this.setVisible(true);
  }

  /**
   * Menu.
   * create window of timestamp menu to choose from
   */
  public void Menu(){
    Object[] items = timelist.toArray();

    Object selectionObject = JOptionPane.showInputDialog(null,
            "Choose", "Menu", JOptionPane.QUESTION_MESSAGE, null, items, items[0]);
    String selectionString = selectionObject.toString();
    for (Timestamp t : timelist) {
      if (selectionString.equals(t.toString())) {
        shape = snapshots.get(t);
        i = timelist.indexOf(t);

        myPanel.showSnapShots(shape);
        timebox.setText(t.toString());
      }
    }
    }

  /**
   * actionPerformed.
   * When the action event occurs, that object's actionPerformed method is invoked
   */
    @Override
  public void actionPerformed(ActionEvent e) {

      if (e.getActionCommand().equals("<< Pre <<")) {
        i--;
        if (i < 0) {
          JOptionPane.showConfirmDialog(null, "no snapshots to show prior this", "Message", -1);
          i = 0;
        }
        shape = snapshots.get(timelist.get(i));
        myPanel.showSnapShots(shape);
        timebox.setText(timelist.get(i).toString());
      }

      if (e.getActionCommand().equals("^^ Select ^^"))  {
        Menu();
      }

      if (e.getActionCommand().equals(">> Next >>"))  {
        i++;
        if (i >= timelist.size()) {
          JOptionPane.showConfirmDialog(null, "End of the photo album", "Message", -1);
          i = timelist.size() - 1;
        }
        shape = snapshots.get(timelist.get(i));
        myPanel.showSnapShots(shape);
        timebox.setText(timelist.get(i).toString());
      }

      if (e.getActionCommand().equals("xx Quit xx"))  {
        System.exit(0);
      }
    }
}
