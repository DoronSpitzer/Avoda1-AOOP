package Graphics;
import Vehicle.*;
import java.awt.image.*;
import java.net.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
// Java program to illustrate the BorderLayout
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Button;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Objects;

// class extends JFrame
public class ImageWindow extends JFrame  {



    private ArrayList<Vehicle> vehicleList1 = new ArrayList<Vehicle>();

    private ArrayList<ImageIcon> imgList1 = new ArrayList<ImageIcon>();



    private JFrame frame;
    private JTextField textfield;
    private JButton btn1,btn2,btn3,btn4,btn5;
    private JButton[] functionbuttons = new JButton[5];
    private JPanel panel;
    private JLabel label;


    // Constructor of BorderDemo class.
    public ImageWindow(ImageIcon imageIcon, String imageDescription)
    {

        Vehicle b = new Bike("sub",  120,  8, null);
        Vehicle j = new Jeep("toyoya", 80,  2, 8);
        Vehicle a = new Amph("J", 120,8,2,4,"is",100,90,2);

        vehicleList1.add(b);
        vehicleList1.add(j);
        vehicleList1.add(a);

        final ImageIcon jeep = new ImageIcon("C:\\Users\\ASUS\\IdeaProjects\\Avoda1-AOOP\\Avoda1 + 2- Agency\\img\\option1.jpg","Jeep");
        final ImageIcon amphibious = new ImageIcon("C:\\Users\\ASUS\\IdeaProjects\\Avoda1-AOOP\\Avoda1 + 2- Agency\\img\\Amphibious.jpg");
        final ImageIcon bike = new ImageIcon("C:\\Users\\ASUS\\IdeaProjects\\Avoda1-AOOP\\Avoda1 + 2- Agency\\img\\Bike.jpg");
        imgList1.add(bike);
        imgList1.add(jeep);
        imgList1.add(amphibious);


        // set the layout

        frame = new JFrame("Next page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 800);
        frame.setLayout(null);

        label = new JLabel(imageIcon);
        label.setToolTipText(imageDescription);
        frame.getContentPane().add(label, BorderLayout.CENTER);

        textfield = new JTextField();

        textfield.setEditable(false);

        // creates Buttons
         btn1 = new JButton("Purchasing");
         btn2 = new JButton("Test");
         btn3 = new JButton("Distance reset");
         btn4 = new JButton("Change flag");
         btn5 = new JButton("EXIT");

        functionbuttons[0] = btn1;
        functionbuttons[1] = btn2;
        functionbuttons[2] = btn3;
        functionbuttons[3] = btn4;
        functionbuttons[4] = btn5;

        panel = new JPanel();
        panel.setBounds(260, 700, 800 , 20);
        panel.setLayout(new GridLayout(0, 5, 10 ,10));

        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
        panel.add(btn5);

        frame.add(panel);
        frame.add(textfield);
        frame.setVisible(true);
        // function to set the title
        setTitle("lets continue...");

    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn1)
        {
            JOptionPane.showMessageDialog(this, "Congratz! The purchase was made successfully!");
        }
    }


    // Main Method
    public static void main(String args[])
    {
        // calling the constructor
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\ASUS\\IdeaProjects\\Avoda1-AOOP\\Avoda1 + 2- Agency\\img\\option1.jpg");
        String imageDescription = "This is an image.";
        ImageWindow window = new ImageWindow(imageIcon, imageDescription);
    }
}

