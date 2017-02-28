/**
 * Created by VladsilavShilov on 27.02.17.
 */

package com.jcg.View;

import com.jcg.Controller.Controller;
import com.jcg.Controller.SliderController;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;

public class View {

    public  View(){
        JFrame frame = new JFrame("test layouts");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JPanel panel = new JPanel(new GridLayout(3,1));
        panel.setBounds(0,0,300,100);
        JLabel pathLabel = new JLabel("Путь к файлу");
        JButton openButton = new JButton("Open");
        openButton.setSize(100,50);
        JButton closeButton = new JButton("Close");
        closeButton.setSize(100,50);

        JLabel doesntWork = new JLabel("Не знаю как сделать поворот :(");
        doesntWork.setBounds(135,200,210,30);
        frame.add(doesntWork);

        JPanel imagePanel = new JPanel(null);
        imagePanel.setBorder(new LineBorder(Color.black , 4));
        imagePanel.setBounds(350,100,400,400);
        JLabel imageLabel = new JLabel("Image will be here");
        imageLabel.setBounds(4,4, imagePanel.getWidth()-7, imagePanel.getHeight()-7);
        imagePanel.add(imageLabel);


        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 100);
        slider.setBounds(0,300,300,100);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);

        JButton changeButtonMin = new JButton("-");
        changeButtonMin.setBounds(70,250,50,50);
        frame.add(changeButtonMin);

        JButton changeButtonPlus = new JButton("+");
        changeButtonPlus.setBounds(20,250,50,50);
        frame.add(changeButtonPlus);

        JButton rotateRight = new JButton("Left");
        rotateRight.setBounds(200,250,50,50);
        frame.add(rotateRight);

        JButton rotateLeft = new JButton("Right");
        rotateLeft.setBounds(250,250,50,50);
        frame.add(rotateLeft);

        Controller controller = new Controller(pathLabel, imageLabel, imagePanel, slider);
        openButton.addActionListener(controller);
        closeButton.addActionListener(controller);
        changeButtonMin.addActionListener(controller);
        changeButtonPlus.addActionListener(controller);
        slider.addChangeListener(controller);

        panel.add(pathLabel, BorderLayout.NORTH);
        panel.add(openButton, BorderLayout.EAST);
        panel.add(closeButton, BorderLayout.WEST);

        frame.add(panel);
        frame.add(imagePanel);
        frame.add(slider);
        frame.setVisible(true);

    }


}
