package Graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
public class IconDemoApp extends JFrame {
    private static final String BACKGROUND_PATH="C:\\Users\\ASUS\\IdeaProjects\\Avoda1-AOOP\\Avoda1 + 2- Agency\\img";

    private JLabel photographLabel = new JLabel();
    private JToolBar buttonBar = new JToolBar();

    private String imagedir = "C:\\Users\\ASUS\\IdeaProjects\\Avoda1-AOOP\\Avoda1 + 2- Agency\\src\\";

    private MissingIcon placeholderIcon = new MissingIcon();

    /**
     * List of all the descriptions of the image files. These correspond one to
     * one with the image file names
     */
    private String[] imageCaptions = { "Amphibious", "Bike",
            "Ship Cruise", "Fregata", "Jeep","Toy Drone"};

    /**
     * List of all the image files to load.
     */
    private String[] imageFileNames = {"Graphics\\image_1.jpg", "Graphics\\image_2.jpg",
            "Graphics\\image_3.jpg", "Graphics\\image_4.jpg",
            "Graphics\\image_5.jpg","Graphics\\image_6.jpg"};

    private File[] imageFiles = {new File("image_1.jpg"), new File("image_2.jpg"), new File("image_3.jpg"), new File("image_4.jpg"),new File("image_5.jpg"),new File("image_6.jpg")};

    /**
     * Main entry point to the demo. Loads the Swing elements on the "Event
     * Dispatch Thread".
     *
     * @param args
     */

    private void showDialog(String message) {
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(this, message);
        });
    }

    public static void main(String[] args) {
        IconDemoApp app = new IconDemoApp();
        app.setVisible(true);
    }

    /**
     * Default constructor for the demo.
     */
    public IconDemoApp() {
        // start the image loading SwingWorker in a background thread
        loadimages.execute();
        ImageIcon[] images = new ImageIcon[imageFiles.length];

        for (int i = 0; i < imageFiles.length; i++) {
            images[i] = new ImageIcon(imageFiles[i].getPath());
        }

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2));
        for (int i = 0; i < imageFileNames.length; i++) {
            Image img = images[i].getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            images[i] = new ImageIcon(img);
            JButton button = new JButton("Image " + (i+1));
            buttonPanel.setPreferredSize(new Dimension(900, 800));
            ImageIcon icon = new ImageIcon(getClass().getResource("image_" + Integer.valueOf(i+1) + ".jpg"));

            button.setIcon(icon);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JDialog dialog = (JDialog) button.getTopLevelAncestor();
                    dialog.dispose();
                }
            });
            buttonPanel.add(button);
        }

        // Display the images in a dialog and let the user choose one
        JDialog dialog = new JDialog();
        dialog.setTitle("Image Chooser");
        dialog.add(new JLabel("Choose an image:"));
        dialog.add(buttonPanel);
        dialog.pack();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }


    /**
     * SwingWorker class that loads the images a background thread and calls publish
     * when a new one is ready to be displayed.
     *
     * We use Void as the first SwingWroker param as we do not need to return
     * anything from doInBackground().
     */

    private SwingWorker<Void, ThumbnailAction> loadimages = new SwingWorker<Void, ThumbnailAction>() {

        /**
         * Creates full size and thumbnail versions of the target image files.
         */

        @Override
        protected Void doInBackground() throws Exception {
            for (int i = 0; i < imageCaptions.length; i++) {
                ImageIcon icon = new ImageIcon((getClass().getResource("image_" + Integer.valueOf(i+1) + ".jpg")).getPath());

                ThumbnailAction thumbAction;
                if(icon != null){

                    ImageIcon thumbnailIcon = new ImageIcon(getScaledImage(icon.getImage(), 32, 32));

                    thumbAction = new ThumbnailAction(icon, thumbnailIcon, imageCaptions[i]);

                }else{
                    // the image failed to load for some reason
                    // so load a placeholder instead
                    thumbAction = new ThumbnailAction(placeholderIcon, placeholderIcon, imageCaptions[i]);
                }
                if (icon == null) {
                    // the image failed to load for some reason
                    // so load a placeholder instead
                    thumbAction = new ThumbnailAction(placeholderIcon, placeholderIcon, imageCaptions[i]);
                    showDialog("Failed to load image " + imageFileNames[i]);
                } else
                    publish(thumbAction);
            }
            // unfortunately we must return something, and only null is valid to
            // return when the return type is void.
            return null;
        }

        /**
         * Process all loaded images.
         */

        @Override
        protected void process(List<ThumbnailAction> chunks) {
            for (ThumbnailAction thumbAction : chunks) {
                JButton thumbButton = new JButton(thumbAction);
                // add the new button BEFORE the last glue
                // this centers the buttons in the toolbar
                buttonBar.add(thumbButton, buttonBar.getComponentCount() - 1);
            }
        }
    };

    /**
     * Creates an ImageIcon if the path is valid.
     * @param String - resource path
     * @param String - description of the file
     */
    protected ImageIcon createImageIcon(String path,
                                        String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /**
     * Resizes an image using a Graphics2D object backed by a BufferedImage.
     * @param srcImg - source image to scale
     * @param w - desired width
     * @param h - desired height
     * @return - the new resized image
     */
    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }

    /**
     * Action class that shows the image specified in it's constructor.
     */
    private class ThumbnailAction extends AbstractAction{

        /**
         *The icon if the full image we want to display.
         */
        private Icon displayPhoto;

        /**
         * @param Icon - The full size photo to show in the button.
         * @param Icon - The thumbnail to show in the button.
         * @param String - The descriptioon of the icon.
         */
        public ThumbnailAction(Icon photo, Icon thumb, String desc){
            displayPhoto = photo;

            // The short description becomes the tooltip of a button.
            putValue(SHORT_DESCRIPTION, desc);

            // The LARGE_ICON_KEY is the key for setting the
            // icon when an Action is applied to a button.
            putValue(LARGE_ICON_KEY, thumb);
        }

        /**
         * Shows the full image in the main area and sets the application title.
         */
        public void actionPerformed(ActionEvent e) {
            photographLabel.setIcon(displayPhoto);
            setTitle("Icon Demo: " + getValue(SHORT_DESCRIPTION).toString());
        }

    }
}
