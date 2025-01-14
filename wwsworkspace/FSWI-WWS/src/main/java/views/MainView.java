package views;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    public MainView(String title) throws HeadlessException {
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Gehaltsabrechnung", new GehaltView());
        tabbedPane.addTab("Spesenabrechnung", new SpesenView());

        getContentPane().add(tabbedPane, BorderLayout.CENTER);

        setVisible(true);
    }

}
