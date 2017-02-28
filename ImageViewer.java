/**
 * Created by VladsilavShilov on 27.02.17.
 */

package com.jcg;

import com.jcg.View.View;

import javax.swing.SwingUtilities;

public class ImageViewer {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    createAndShowGUI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void createAndShowGUI() throws Exception {
        new View();
    }
}