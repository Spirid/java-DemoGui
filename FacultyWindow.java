import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class FacultyWindow extends JFrame implements ActionListener {
    JLabel name;
    JTextField nameIn;
    JLabel degree;
    JTextField degreeIn;
    JButton accept;
    JButton clear;
    JButton close;
    MyPanel buttonPanel;
    FlowLayout flow;
    University added;
    String text;
    MenuWindow menuWindow;

    FacultyWindow(University personIn, MenuWindow mainWin) {
        setTitle("Faculty form");
        setSize(350, 120);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        text = "";
        buttonPanel = new MyPanel();
        flow= new FlowLayout();
        buttonPanel.setLayout(flow);
        name = new JLabel("Name:");
        nameIn = new JTextField("", 15);
        degree = new JLabel("Degree:");
        degreeIn = new JTextField("", 5);
        accept = new JButton("Accept");
        clear = new JButton("Clear");
        close = new JButton("Close");

        buttonPanel.add(name);
        buttonPanel.add(nameIn);
        buttonPanel.add(degree);
        buttonPanel.add(degreeIn);
        buttonPanel.add(accept);
        buttonPanel.add(clear);
        buttonPanel.add(close);
        add(buttonPanel);

        accept.addActionListener(this);
        clear.addActionListener(this);
        close.addActionListener(this);

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

				@Override
				public void windowOpened(WindowEvent e) 
				{
					super.windowOpened(e);
					setEnabled(true);
				}
			}
		);

        setVisible(true);
        added = personIn;
        menuWindow = mainWin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object sourse = e.getSource();

        if(sourse == accept) {
            added.addPerson("FECULTY", nameIn.getText(), degreeIn.getText());
            text = "ACCEPTED" + added.quantity;
            nameIn.setText("");
            degreeIn.setText("");
            repaint();
        }
        if (sourse == clear) {
            nameIn.setText("");
            degreeIn.setText("");
            text = "";
            repaint();
        }
        if (sourse == close) {
            dispose();
            menuWindow.setTitle("DS&A Assignment " + (added.quantity + 1));
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
