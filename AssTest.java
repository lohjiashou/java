package ass.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AssTest extends JFrame {
    private ArrayList<String> events;

    private JButton addEventButton;
    private JButton showEventsButton;
    private JTextArea eventTextArea;
    private JScrollPane scrollPane;

    public AssTest() {
        events = new ArrayList<>();
        initializeComponents();
        createLayout();
        addEventListeners();
    }

    private void initializeComponents() {
        addEventButton = new JButton("Add Event");
        showEventsButton = new JButton("Show Events");
        eventTextArea = new JTextArea(10, 30);
        eventTextArea.setEditable(false);
        scrollPane = new JScrollPane(eventTextArea);
    }

    private void createLayout() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(addEventButton);
        panel.add(showEventsButton);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setTitle("Event Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // Center the window on the screen
    }

    private void addEventListeners() {
        addEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEvent();
            }
        });

        showEventsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showEvents();
            }
        });
    }

    private void addEvent() {
        String eventName = JOptionPane.showInputDialog(this, "Enter the event name:");
        if (eventName != null && !eventName.isEmpty()) {
            events.add(eventName);
            eventTextArea.append(eventName + "\n");
        }
    }

    private void showEvents() {
        if (events.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No events added yet.");
            return;
        }

        StringBuilder eventList = new StringBuilder();
        for (String event : events) {
            eventList.append(event).append("\n");
        }
        JOptionPane.showMessageDialog(this, eventList.toString(), "Event List", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AssTest().setVisible(true);
            }
        });
    }
}
