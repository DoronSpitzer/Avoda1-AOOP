package Graphics;
import Vehicle.*;
import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
import java.net.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainWindow extends JFrame implements ActionListener {
    private static final String BACKGROUND_PATH="C:\\Users\\ASUS\\IdeaProjects\\Avoda1-AOOP\\Avoda1 + 2- Agency\\img";
    private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
    private ArrayList<Image> imgList = new ArrayList<Image>();

    private JLabel titleLabel,selectLabel;
    private JComboBox<String> vehicleComboBox,comboBox;
    private JButton nxtButton,vehicleListArea,okButton;
    private JPanel mainPanel,detailsPanel;

    //imagewindow
    private JFrame frame;
    private JTextField textfield;
    private JButton btn1,btn2,btn3,btn4,btn5;
    private JButton[] functionbuttons = new JButton[5];
    private JPanel panel;
    private JLabel label;
    private final Image ship = new ImageIcon(getClass().getResource("Cruise11.jpg")).getImage();
    private final Image jeep = new ImageIcon(getClass().getResource("option1.jpg")).getImage();
    private final Image fregata = new ImageIcon(getClass().getResource("fregata.jpg")).getImage();
    private final Image toyDrone = new ImageIcon(getClass().getResource("toy-drone.jpg")).getImage();
    private final Image amphibious = new ImageIcon(getClass().getResource("Amphibious.jpg")).getImage();
    private final Image bike = new ImageIcon(getClass().getResource("Bike.jpg")).getImage();

    private final JLabel imageLabelJeep = new JLabel(new ImageIcon(jeep));
    private final JLabel imageLabelShip = new JLabel(new ImageIcon(ship));
    private final JLabel imageLabelFregata = new JLabel(new ImageIcon(fregata));
    private final JLabel imageLabelToyDrone = new JLabel(new ImageIcon(toyDrone));
    private final JLabel imageLabelAmphibious = new JLabel(new ImageIcon(amphibious));
    private final JLabel imageLabelBike = new JLabel(new ImageIcon(bike));


    private IconDemoApp dialogChooseImage;
    private JButton imagesButton;
    /*private JMenu background;
    private JMenuItem image1;
    private JMenuItem image2;
    private JMenuItem image3;
    private JMenuItem upload;
*/

    public MainWindow(ImageIcon imageIcon, String imageDescription) {

        // Add action listener to the display vehicle list button
        setTitle("Doron and Maya's car agency");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize GUI components
        JButton displayVehicleListButton = new JButton("Display Vehicle List");
        titleLabel = new JLabel("Welcome to Doron and Maya's car agency");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 18));
        selectLabel = new JLabel("Please choose a vehicle:");
        String[] vehicles = {"Jeep", "Fregata", "Toy drone", "Army drone", "Amphibious", "Bike", "Ship Cruise","next","EXIT"};
        vehicleComboBox = new JComboBox<>(vehicles);
        okButton = new JButton("OK");
        nxtButton = new JButton("next");
        vehicleListArea = new JButton("See list");
        vehicleListArea.addActionListener(this);
        okButton.addActionListener(this);
        nxtButton.addActionListener(this);
        //JMenu background=new JMenu("Background");
        imagesButton = new JButton("images");
        imagesButton.addActionListener(this);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(9, 2));
        mainPanel.add(titleLabel);
        mainPanel.add(selectLabel);
        mainPanel.add(vehicleComboBox);
        mainPanel.add(okButton);
        mainPanel.add(nxtButton);
        mainPanel.add(imagesButton);
        //mainPanel.add(background);

        //mainPanel.add(dialogChooseImage);
/*
        image1=new JMenuItem("Image1");
        background.add(image1);
        image1.addActionListener(this);
        image2=new JMenuItem("image2");
        background.add(image2);
        image2.addActionListener(this);
        image3=new JMenuItem("image3");
        background.add(image3);
        image3.addActionListener(this);
        upload=new JMenuItem("upload");
        background.add(upload);
        upload.addActionListener(this);
*/


        frame =new JFrame("frame");
        JPanel panel1 =new JPanel();

        JComboBox comboBox;

        // Add main panel to frame and display
        add(mainPanel);
        setVisible(true);
        // Display the frame
        pack();

        frame = new JFrame("Next page");
        frame.setEnabled(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 800);
        frame.setLayout(null);

        label = new JLabel(imageIcon);
        label.setToolTipText(imageDescription);
        frame.getContentPane().add(label, BorderLayout.CENTER);

        textfield = new JTextField();

        textfield.setEditable(true);
    }


/*
    public void MyFrame(String s) {
        if(s.equals("Jeep"))
        {
            String details = "";

            setSize(1000, 800);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Add the image label to the frame
            imageLabelJeep.setSize(150,100);
            imageLabelJeep.setBounds(150,100,300,300);
            imageLabelBike.setSize(600,100);
            imageLabelBike.setBounds(500,100,300,300);
            imageLabelAmphibious.setSize(50,100);
            imageLabelAmphibious.setBounds(20,100,300,300);
            add(imageLabelJeep);
            add(imageLabelBike);
            add(imageLabelAmphibious);
            btn1.addActionListener(this);

            mainPanel.add(btn1);
        }



            // Display the JFrame
            setVisible(true);
        }

*/
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton) {
            String vehicle = (String) vehicleComboBox.getSelectedItem();
            String details = "";
            switch (Objects.requireNonNull(vehicle)) {
                case "Jeep":
                    details = getJeepDetails();
                    break;
                case "Fregata":
                    details = getFREGATADetails();
                    break;
                case "Toy drone":
                    details = getToyDroneDetails();
                    break;
                case "Army drone":
                    details = getArmyDroneDetails();
                    break;
                case "Amphibious":
                    details = getAmphibiousDetails();
                    break;
                case "Bike":
                    details = getBikeDetails();
                    break;
                case "Ship Cruise":
                    details = getShipCruiseDetails();
                    break;
                case "EXIT":
                    JOptionPane.showMessageDialog(this, "Thank you for choosing to join :)");
                    System.exit(0);
                    break;
            }
            if (details != null && !details.isEmpty()) {
                // Do something with the vehicle and details
                JOptionPane.showMessageDialog(this, "Vehicle " + vehicle + " added with details:\n" + details);
            }
            if (e.getSource() == nxtButton) {
                {
                    JDialog d = new JDialog(frame, "dialog Box");
                    d.add(panel);
                    d.add(textfield);
                    d.setVisible(true);
                    if (e.getSource() == btn1) {
                        JOptionPane.showMessageDialog(this, "Congratz! The purchase was made successfully!");
                    }
                }
            }
        }
        if (e.getSource() == imagesButton)
            dialogChooseImage = new IconDemoApp();

    }



    // Helper method to get vehicle details based on the selected type
    private String getVehicleDetails(String vehicleType) {
        switch (vehicleType) {
            case "Jeep":
                return getJeepDetails();
            case "Fregata":
                return getFREGATADetails();
            case "Toy drone":
                return getToyDroneDetails();
            case "Army drone":
                return getArmyDroneDetails();
            case "Amphibious":
                return getAmphibiousDetails();
            case "Bike":
                return getBikeDetails();
            case "Ship Cruise":
                return getShipCruiseDetails();
            default:
                return null;
        }
    }

    private String getJeepDetails() {
        Vehicle tmp;

        JTextField modelNameField = new JTextField();
        JTextField maxSpeedField = new JTextField();
        JTextField engineLifetimeField = new JTextField();
        JTextField fuelUsageField = new JTextField();
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Model name:"));
        panel.add(modelNameField);
        panel.add(new JLabel("Max speed:"));
        panel.add(maxSpeedField);
        panel.add(new JLabel("Engine lifetime:"));
        panel.add(engineLifetimeField);
        panel.add(new JLabel("Fuel usage:"));
        panel.add(fuelUsageField);
        int result = JOptionPane.showConfirmDialog(this, panel, "Enter Jeep details", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String modelName = modelNameField.getText();
            String maxSpeed = maxSpeedField.getText();
            String engineLifetime = engineLifetimeField.getText();
            String fuelUsage = fuelUsageField.getText();
            tmp = new Jeep(modelName,Integer.parseInt(maxSpeed),Integer.parseInt(engineLifetime),Integer.parseInt(fuelUsage));
            vehicleList.add(tmp);
            imgList.add(jeep);
            //JOptionPane.showMessageDialog(null, null, "jeep", JOptionPane.INFORMATION_MESSAGE, imgList.get(0));
            return "Model name: " + modelName + "\nMax speed: " + maxSpeed + "\nEngine lifetime: " + engineLifetime + "\nFuel usage: " + fuelUsage;
        }
        return null;
    }

    private String getFREGATADetails() {
        Vehicle tmp;
        Vehicle[] vehicleArray = vehicleList.toArray(new Vehicle[0]);
        JTextField modelNameField = new JTextField();
        JTextField windDirectionField = new JTextField();
        JTextField maxPassField = new JTextField();
        JTextField maxSpeedField = new JTextField();
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Model name:"));
        panel.add(modelNameField);
        panel.add(new JLabel("Wind direction:"));
        panel.add(windDirectionField);
        panel.add(new JLabel("Max passengers:"));
        panel.add(maxPassField);
        panel.add(new JLabel("Max speed:"));
        panel.add(maxSpeedField);
        int result = JOptionPane.showConfirmDialog(this, panel, "Enter Fregata details", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String modelName = modelNameField.getText();
            String windDirection = windDirectionField.getText();
            String maxPass = maxPassField.getText();
            String maxSpeed = maxSpeedField.getText();
            tmp = new Fregata(modelName,Integer.parseInt(windDirection),Integer.parseInt(maxPass),Integer.parseInt(maxSpeed));
            vehicleList.add(tmp);
            imgList.add(fregata);
            //JOptionPane.showMessageDialog(null, null, "Fregata", JOptionPane.INFORMATION_MESSAGE, imgList.get(1));
            return "Model name: " + modelName + "\nWind direction: " + windDirection + "\nMax passengers: " + maxPass + "\nMax speed: " + maxSpeed;
        }
        return null;
    }



        private String getToyDroneDetails() {
        Vehicle tmp;
        JTextField modelNameField = new JTextField();
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(new JLabel("Model name:"));
        panel.add(modelNameField);
        int result = JOptionPane.showConfirmDialog(this, panel, "Enter Toy drone details", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String modelName = modelNameField.getText();
            tmp = new drone_toy(modelName);
            vehicleList.add(tmp);
            imgList.add(toyDrone);
            //JOptionPane.showMessageDialog(null, null, "toyDrone", JOptionPane.INFORMATION_MESSAGE, imgList.get(2));
            return "Model name: " + modelName;
        }
        return null;
    }

    private String getArmyDroneDetails() {
        String[] tools = {"Jeep", "Fregata", "Toy drone"};
        JComboBox<String> toolComboBox = new JComboBox<>(tools);
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(new JLabel("Choose tool:"));
        panel.add(toolComboBox);
        int result = JOptionPane.showConfirmDialog(this, panel, "Enter Army drone details", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String tool = (String) toolComboBox.getSelectedItem();
            switch(tool) {
                case "Jeep":
                    return getJeepDetails();
                case "Fregata":
                    return getFREGATADetails();
                case "Toy drone":
                    return getToyDroneDetails();
                default:
                    return null;
            }
        }
        return null;
    }


    private String getAmphibiousDetails() {
        Vehicle tmp;
        JTextField modelNameField = new JTextField();
        JTextField maxSpeedField = new JTextField();
        JTextField maxPassField = new JTextField();
        JTextField lifetimeField = new JTextField();
        JTextField wheelsField = new JTextField();
        JTextField flagField = new JTextField();
        JTextField windDirField = new JTextField();
        JTextField fuelField = new JTextField();
        JTextField lifeField = new JTextField();
        JPanel panel = new JPanel(new GridLayout(9, 2));
        panel.add(new JLabel("Model name:"));
        panel.add(modelNameField);
        panel.add(new JLabel("Max speed:"));
        panel.add(maxSpeedField);
        panel.add(new JLabel("Max passengers:"));
        panel.add(maxPassField);
        panel.add(new JLabel("Lifetime:"));
        panel.add(lifetimeField);
        panel.add(new JLabel("Number of wheels:"));
        panel.add(wheelsField);
        panel.add(new JLabel("Flag:"));
        panel.add(flagField);
        panel.add(new JLabel("Wind direction:"));
        panel.add(windDirField);
        panel.add(new JLabel("Fuel:"));
        panel.add(fuelField);
        panel.add(new JLabel("Life:"));
        panel.add(lifeField);
        int result = JOptionPane.showConfirmDialog(this, panel, "Enter Amphibious details", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String modelName = modelNameField.getText();
            String maxSpeed = maxSpeedField.getText();
            String maxPass = maxPassField.getText();
            String lifetime = lifetimeField.getText();
            String wheels = wheelsField.getText();
            String flag = flagField.getText();
            String windDir = windDirField.getText();
            String fuel = fuelField.getText();
            String life = lifeField.getText();
            tmp = new Amph(modelName,Integer.parseInt(maxSpeed),Integer.parseInt(maxPass),Integer.parseInt(lifetime),Integer.parseInt(wheels),flag,Integer.parseInt(windDir),Integer.parseInt(fuel),Integer.parseInt(life));
            vehicleList.add(tmp);
            imgList.add(amphibious);
            //JOptionPane.showMessageDialog(null, null, "amphibious", JOptionPane.INFORMATION_MESSAGE, imgList.get(3));
            return "Model name: " + modelName + "\nMax speed: " + maxSpeed + "\nMax passengers: " + maxPass + "\nLifetime: " + lifetime + "\nNumber of wheels: " + wheels + "\nFlag: " + flag + "\nWind direction: " + windDir + "\nFuel: " + fuel + "\nLife: " + life;
        }
        return null;
    }

    private String getBikeDetails() {
        Vehicle tmp;
        JTextField modelNameField = new JTextField();
        JTextField maxSpeedField = new JTextField();
        JTextField lifetimeField = new JTextField();
        JTextField roadField = new JTextField();
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Model name:"));
        panel.add(modelNameField);
        panel.add(new JLabel("Max speed:"));
        panel.add(maxSpeedField);
        panel.add(new JLabel("Lifetime:"));
        panel.add(lifetimeField);
        panel.add(new JLabel("Road:"));
        panel.add(roadField);
        int result = JOptionPane.showConfirmDialog(this, panel, "Enter Bike details", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String modelName = modelNameField.getText();
            String maxSpeed = maxSpeedField.getText();
            String lifetime = lifetimeField.getText();
            String road = roadField.getText();
            tmp = new Bike(modelName,Integer.parseInt(maxSpeed),Integer.parseInt(lifetime),road);
            vehicleList.add(tmp);
            imgList.add(bike);
            //JOptionPane.showMessageDialog(null, null, "bike", JOptionPane.INFORMATION_MESSAGE, imgList.get(3));
            return "Model name: " + modelName + "\nMax speed: " + maxSpeed + "\nLifetime: " + lifetime + "\nRoad: " + road;
        }
        return null;
    }
    private String getShipCruiseDetails() {
        Vehicle tmp;
        JTextField modelField = new JTextField(10);
        JTextField maxPassField = new JTextField(10);
        JTextField maxSpeedField = new JTextField(10);
        JTextField flagField = new JTextField(10);
        JTextField fuelField = new JTextField(10);
        JTextField lifetimeField = new JTextField(10);
        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.add(new JLabel("Model name:"));
        panel.add(modelField);
        panel.add(new JLabel("Maximum passengers:"));
        panel.add(maxPassField);
        panel.add(new JLabel("Maximum speed:"));
        panel.add(maxSpeedField);
        panel.add(new JLabel("Flag:"));
        panel.add(flagField);
        panel.add(new JLabel("Fuel usage:"));
        panel.add(fuelField);
        panel.add(new JLabel("Engine lifetime:"));
        panel.add(lifetimeField);

        int result = JOptionPane.showConfirmDialog(this, panel,
                "Please enter the details for the Ship Cruise", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String model = modelField.getText();
            int maxPass = Integer.parseInt(maxPassField.getText());
            int maxSpeed = Integer.parseInt(maxSpeedField.getText());
            String flag = flagField.getText();
            int fuel = Integer.parseInt(fuelField.getText());
            int lifetime = Integer.parseInt(lifetimeField.getText());
            tmp = new Ship(model,maxPass,maxSpeed,flag,fuel,lifetime);
            vehicleList.add(tmp);




            imgList.add(ship);
            //JOptionPane.showMessageDialog(null, null, "Ship Cruise", JOptionPane.INFORMATION_MESSAGE, imgList.get(3));

            return "Model: " + model + "\nMaximum passengers: " + maxPass +
                    "\nMaximum speed: " + maxSpeed + "\nFlag: " + flag +
                    "\nFuel usage: " + fuel + "\nEngine lifetime: " + lifetime;
        }
        return null;
    }


    /*private String getImgByStr(String nameV) {
        ImageIcon tmp = imgList.get(0);
    }*/

        public static void main(String[] args) {
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\ASUS\\IdeaProjects\\Avoda1-AOOP\\Avoda1 + 2- Agency\\img\\option1.jpg");
        String imageDescription = "This is an image.";
        MainWindow gui = new MainWindow(imageIcon, imageDescription);
    }
}
