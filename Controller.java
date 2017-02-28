package com.jcg.Controller;

import com.sun.tools.javah.Util;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by VladsilavShilov on 27.02.17.
 */
public class Controller implements ActionListener, ChangeListener {
    private JLabel pathLabel = new JLabel();
    private JLabel imageLabel = new JLabel();
    private JPanel imagePanel = new JPanel();
    private JSlider slider = new JSlider();
    final Image[] image = {null};

    public Controller(JLabel pathLabel,JLabel imageLabel,JPanel imagePanel,JSlider slider) {
        super();
        this.pathLabel = pathLabel;
        this.imageLabel = imageLabel;
        this.imagePanel = imagePanel;
        this.slider = slider;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Open")) {
            /*pathLabel.setText("DA POSHEL TY NAHYI");
            JOptionPane.showMessageDialog(null,
                    "Idi ty nahyi", "Error",
                    JOptionPane.ERROR_MESSAGE);*/
            JFileChooser fileopen = new JFileChooser();
            fileopen.addChoosableFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png", "tif"));
            fileopen.setAcceptAllFileFilterUsed(false);

            int ret = fileopen.showDialog(null, "Открыть файл");
            if (ret == JFileChooser.APPROVE_OPTION) {
                File file = fileopen.getSelectedFile();
                String st = file.getPath();
                pathLabel.setText(st);
                //updateImage();

                //Image image = null;

                try {
                    image[0] = ImageIO.read(new File(String.valueOf(st)));
                    Image resizedImage = image[0].getScaledInstance(imagePanel.getWidth(), imagePanel.getHeight(), 0);
                    //ImageIcon icon = new ImageIcon(resizedImage);
                    imageLabel.setIcon(new ImageIcon(resizedImage));
                    imageLabel.setText("");

                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
        else if (e.getActionCommand().equals("Close")){
            if(JOptionPane.showConfirmDialog(null, "Хотите выйти?") == JOptionPane.YES_OPTION) System.exit(0);;
        }
        else if (e.getActionCommand().equals("+")){
            imagePanel.setSize(imagePanel.getWidth()+100,imagePanel.getHeight()+100);
            imageLabel.setBounds(4,4, imagePanel.getWidth()-7, imagePanel.getHeight()-7);
            Image resizedImage = image[0].getScaledInstance(imagePanel.getWidth(), imagePanel.getHeight(), 0);
            //ImageIcon icon = new ImageIcon(resizedImage);
            imageLabel.setIcon(new ImageIcon(resizedImage));
        }
        else if (e.getActionCommand().equals("-")){
            imagePanel.setSize(imagePanel.getWidth()-100,imagePanel.getHeight()-100);
            imageLabel.setBounds(4,4, imagePanel.getWidth()-7, imagePanel.getHeight()-7);
            Image resizedImage = image[0].getScaledInstance(imagePanel.getWidth(), imagePanel.getHeight(), 0);
            //ImageIcon icon = new ImageIcon(resizedImage);
            imageLabel.setIcon(new ImageIcon(resizedImage));
        }
    }


    @Override
    public void stateChanged(ChangeEvent e) {
        int value = slider.getValue();
        imagePanel.setSize(4 * value, 4 * value);
        imageLabel.setBounds(4, 4, imagePanel.getWidth() - 7, imagePanel.getHeight() - 7);
        Image resizedImage = image[0].getScaledInstance(imagePanel.getWidth(), imagePanel.getHeight(), 1);
        imageLabel.setIcon(new ImageIcon(resizedImage));
        //imageLabel.setText("W: " + imagePanel.getWidth() + "H: " + imagePanel.getHeight());
    }
}
