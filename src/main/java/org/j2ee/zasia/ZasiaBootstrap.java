package org.j2ee.zasia;

import org.j2ee.zasia.ui.ZasiaFrame;

import javax.swing.*;

public class ZasiaBootstrap extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ZasiaFrame::new);
    }

}
