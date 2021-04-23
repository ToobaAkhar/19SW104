
package dsaproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.LinkedList;

public class StudentEmailGUI extends JFrame
{
   // Constants:
private Container c;
private JTextArea studentTextArea;
private Font f1;
private JTextField cityTextField,idTextField,nameTextField,numberTextField,cnicTextField;
private JLabel cityLabel,idLabel,nameLabel,numberLabel,cnicLabel;
private JButton addButton,deleteButton,displayAllButton,exitButton;
   // Class Instance Data:
   private LinkedList<StudentEmail> studentLinkedList = new LinkedList<StudentEmail> ();

   public StudentEmailGUI ()
   {
   studentTextArea   = new JTextArea ();
   f1=new Font("serif",Font.PLAIN,15);

   idLabel         = new JLabel     ("ID: ");
   idLabel.setFont(f1);
    idLabel.setForeground(Color.BLACK);
   idTextField       = new JTextField (10);
   idTextField.setFont(f1);

   nameLabel         = new JLabel     ("Name: ");
   nameLabel.setFont(f1);
    nameLabel.setForeground(Color.BLACK);
   nameTextField     = new JTextField (10);
   nameTextField.setFont(f1);
   numberLabel         = new JLabel     ("Number: ");
   numberLabel.setFont(f1);
    numberLabel.setForeground(Color.BLACK);
   numberTextField     = new JTextField (10);
   numberTextField.setFont(f1);
   cnicLabel         = new JLabel     ("Cnic: ");
   cnicLabel.setFont(f1);
   cnicLabel.setForeground(Color.BLACK);
   cnicTextField     = new JTextField (10);
   cnicTextField.setFont(f1);
   cityLabel         = new JLabel     ("City: ");
   cityLabel.setFont(f1);
   cityLabel.setForeground(Color.BLACK);
   cityTextField     = new JTextField (10);
   cityTextField.setFont(f1);
     
    

   addButton         = new JButton ("Add");
   deleteButton      = new JButton ("Delete");
   displayAllButton  = new JButton ("Display All");
   exitButton        = new JButton ("Exit");
      /*JPanel flow1Panel = new JPanel (new FlowLayout (FlowLayout.LEFT));
      JPanel flow2Panel = new JPanel (new FlowLayout (FlowLayout.LEFT));
      JPanel flow3Panel = new JPanel (new FlowLayout (FlowLayout.LEFT));
      JPanel flow4Panel = new JPanel (new FlowLayout (FlowLayout.LEFT));
        
      JPanel flow5Panel = new JPanel (new FlowLayout (FlowLayout.LEFT));
      JPanel flow6Panel = new JPanel (new FlowLayout (FlowLayout.CENTER));
      
         
      JPanel gridPanel  = new JPanel (new GridLayout (6, 1));

      studentTextArea.setEditable (false);

      flow1Panel.add (idLabel);
      flow1Panel.add (idTextField);
      flow2Panel.add (nameLabel);
      flow2Panel.add (nameTextField);



      flow3Panel.add (numberLabel);
      flow3Panel.add (numberTextField);
      flow4Panel.add (cnicLabel);
      flow4Panel.add (cnicTextField);
      flow5Panel.add (cityLabel);
      flow5Panel.add (cityTextField);
       
      flow6Panel.add (addButton);
      flow6Panel.add (deleteButton);
      flow6Panel.add (displayAllButton);
      flow6Panel.add (exitButton);

      gridPanel.add (flow1Panel);
      gridPanel.add (flow2Panel); 
      gridPanel.add (flow4Panel);
      gridPanel.add (flow5Panel);
      gridPanel.add (flow6Panel);
*/c = this.getContentPane();
  c.setBackground(Color.BLUE);
      JPanel bot = new JPanel();
      bot.setLayout(new FlowLayout(FlowLayout.CENTER));
      JPanel midPane = new JPanel();
      midPane.setBackground(Color.PINK);
      midPane.setLayout(new GridLayout(5,5,5,5));
      midPane.add(idLabel);
      midPane.add(idTextField);
      midPane.add(nameLabel);
      midPane.add(nameTextField);
      midPane.add(numberLabel);
      midPane.add(numberTextField);
      midPane.add(cnicLabel);
      midPane.add(cnicTextField);
      midPane.add(cityLabel);
      midPane.add(cityTextField);
      bot.add(addButton);
      bot.add(deleteButton);
      bot.add(displayAllButton);
      bot.add(exitButton);
    //  add (studentTextArea, BorderLayout.CENTER);
      //add (gridPanel,       BorderLayout.SOUTH);
      c.add(midPane,BorderLayout.CENTER);
      c.add(bot,BorderLayout.PAGE_END);
      addButton.addActionListener        (event -> addStudent ());
      displayAllButton.addActionListener (event -> displayAll ());
      exitButton.addActionListener       (event -> exitApplication ());
      deleteButton.addActionListener     (event -> deleteStudent ());
   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   this.pack();
   }

   private boolean isStudentIdInLinkedList (String idStr)
   {
      boolean inList = false;

      for (StudentEmail stud : studentLinkedList)
      {
         if (stud.getId ().compareToIgnoreCase (idStr) == 0)
         {
            inList = true;
         }
      }

      return inList;
   }

   private void addStudent ()
   {
      if (isStudentIdInLinkedList (idTextField.getText()) == true)
      {
         JOptionPane.showMessageDialog (null, "Error: student ID is already in the database.");
      }
      else
      {
         try
         {
            StudentEmail stud = new StudentEmail (nameTextField.getText(),
                                                  idTextField.getText(),
                                                  numberTextField.getText(),
                                                  cnicTextField.getText(),
                                                  cityTextField.getText());

            studentLinkedList.add (stud);

            displayAll ();

            nameTextField.setText("");
            idTextField.setText("");
             numberTextField.setText("");
              cnicTextField.setText("");
              cityTextField.setText("");
         }
         catch (StudentEmailException error)
         {
            JOptionPane.showMessageDialog (null, error.toString ());
            // myLabel.setText (error.toString ());


         }
      }
   }

   private void deleteStudent ()
   {
      if (studentLinkedList.size() == 0)
      {
         JOptionPane.showMessageDialog (null, "Error: Database is empty.");
      }
      else if (isStudentIdInLinkedList (idTextField.getText()) == false)
      {
         JOptionPane.showMessageDialog (null, "Error: student ID is not in the database.");
      }
      else
      {
         for (int s = 0; s < studentLinkedList.size(); s++)
         {
            String currId = studentLinkedList.get (s).getId ();

            if (currId.compareToIgnoreCase (idTextField.getText()) == 0)
            {
               studentLinkedList.remove (s);
            }
         }

         displayAll ();

         nameTextField.setText("");
         idTextField.setText("");
         numberTextField.setText("");
         cnicTextField.setText("");
         cityTextField.setText("");
      }
   }

   private void displayAll ()
   {   JFrame f = new JFrame("Data");
   Container cont = f.getContentPane();
   f.setSize(500,600);
   f.setVisible(true);
   //f.pack();
   cont.add(studentTextArea);

      studentTextArea.setText ("");

      for (StudentEmail stud : studentLinkedList)
      {
         studentTextArea.append (stud + "\n");
      }
   }

   private void exitApplication ()
   {
      System.exit (0); // All is OK.
   }

   public static void main (String[] args)
   {
      StudentEmailGUI app = new StudentEmailGUI ();

      app.setVisible  (true);
      app.setSize     (500, 310);
      app.setLocation (200, 100);
      

      Font f=new Font("Arial",Font.BOLD,20);
      app.setFont(f);
      Container c=app.getContentPane();
      c.setBackground(Color.BLUE);

   }
} // public class StudentEmailGUI