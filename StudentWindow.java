import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class StudentWindow extends JFrame implements ActionListener {
    JLabel name;
    JTextField nameIn;
    JLabel age;
    JTextField ageIn;
    JButton accept;
    JButton clear;
    JButton close;
    MyPanel buttonPanel;
    FlowLayout flow;
    University added;
    String text;
    MenuWindow menuWindow;

    StudentWindow(University personIn, MenuWindow mainWin) {
        setTitle("Student form");
        setSize(350, 120);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        flow= new FlowLayout();
        text = "";

        name = new JLabel("Name:");
        nameIn = new JTextField("", 15);
        age = new JLabel("Age:");
        ageIn = new JTextField("", 6);

        accept = new JButton("Accept");
        clear = new JButton("Clear");
        close = new JButton("Close");

        buttonPanel = new MyPanel();
        buttonPanel.setLayout(flow);
        buttonPanel.add(name);
        buttonPanel.add(nameIn);
        buttonPanel.add(age);
        buttonPanel.add(ageIn);
        buttonPanel.add(accept);
        buttonPanel.add(clear);
        buttonPanel.add(close);
        add(buttonPanel);

        addWindowListener
		(
		new WindowAdapter() 
			{
				@Override
				public void windowClosing(WindowEvent e) 
				{
					dispose();
					menuWindow.setTitle("DS&A Assignment " + (added.quantity + 1));
					menuWindow.setVisible(true);
				}

				public void windowOpened(WindowEvent e) 
				{
                super.windowOpened(e);
                setEnabled(true);
				}
			}
		);

        accept.addActionListener(this);
        clear.addActionListener(this);
        close.addActionListener(this);
        setVisible(true);
        added = personIn;
        menuWindow = mainWin;
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == accept) {
            try {

                added.addPerson("STUDENT", nameIn.getText(), Integer.parseInt(ageIn.getText()));
                nameIn.setText("");
                ageIn.setText("");
                text = "ACCEPTED"+(added.quantity);
            } catch (NumberFormatException ex) {
                text = "Age is only numbers";
            }
            buttonPanel.repaint();
        }
        else if (source == clear) {
            nameIn.setText("");
            ageIn.setText("");
            text = "";
            repaint();
        }
        else if (source == close) {
            dispose();
            menuWindow.setTitle("DS&A Assignment "+(added.quantity+1));
            menuWindow.setVisible(true);
        }
    }

    class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString(text, 50,70);
        }
    }
}
