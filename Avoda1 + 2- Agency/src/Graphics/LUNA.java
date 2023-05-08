package Graphics;

import javax.swing.Action;
import javax.swing.ActionMap;

import javax.swing.JButton;

// java Program to create a simple JDialog
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
class LUNA extends JFrame implements ActionListener {

    // frame
    static JFrame f;

    // main class
    public static void main(String[] args)
    {
        // create a new frame
        f = new JFrame("frame");//frame

        // create a object
        LUNA s = new LUNA();

        // create a panel
        JPanel p = new JPanel();//main panel

        JButton b = new JButton("click");//nxt

        // add actionlistener to button
        b.addActionListener(s);//nxt - mainwindow

        // add button to panel
        p.add(b);

        f.add(p);

        // set the size of frame
        f.setSize(400, 400);

        f.show();
    }
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("click")) {
            // create a dialog Box
            JDialog d = new JDialog(f, "dialog Box");
            // create a label
            JLabel l = new JLabel("this is a dialog box");
            d.add(l);
            // setsize of dialog
            d.setSize(100, 100);
            // set visibility of dialog
            d.setVisible(true);
        }
    }
}
