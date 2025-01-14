package views;

import models.Person;
import wwsservices.DataAccessObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SpesenView extends JPanel {

    JComboBox<String> personAuswahl;

    public SpesenView() {
        setLayout(new BorderLayout());
        Box spesenBox = Box.createVerticalBox();
        add(spesenBox, BorderLayout.CENTER);
        DataAccessObject dao = new DataAccessObject();
        List<Person> listPersonen = dao.findAll();
        String[] personen = new String[listPersonen.size()];
        for (int i = 0; i < listPersonen.size(); i++) {
            Person bufPerson = listPersonen.get(i);
            personen[i] = String.format("%s: %s, %s", bufPerson.getId(), bufPerson.getNachname(), bufPerson.getVorname());
        }
        personAuswahl = new JComboBox<>(personen);
        spesenBox.add(personAuswahl);

        /*
        personAuswahl.addActionListener(e -> {JOptionPane.showMessageDialog(getParent(), "Hallo");});
        */

        /*
        personAuswahl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(getParent(), "Hallo");
            }
        });
         */

        personAuswahl.addActionListener(new JBoxEventHandler());

        JButton btnTest = new JButton("Test");
        btnTest.addActionListener(new ButtonEventHandler());
        spesenBox.add(btnTest);

    }

    private class JBoxEventHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(getParent(), "Hallo");
        }
    }

    private class ButtonEventHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(getParent(), personAuswahl.getSelectedItem());
        }
    }
}