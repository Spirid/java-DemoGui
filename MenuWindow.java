import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuWindow extends JFrame implements ActionListener {
    University personal;
    JPanel menuPanel;
    JMenuBar menuBar;
    JMenuItem student;
    JMenuItem faculty;
    JMenuItem print;


    MenuWindow() {
        personal = new University();
        setTitle("DS&A Assignment "+(personal.quantity+1));
        setSize(350, 120);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        student = new JMenuItem("Student Data");
        faculty = new JMenuItem("Faculty Data");
        print = new JMenuItem("Print the list");
        menuBar =new JMenuBar();
        menuBar.add(student);
        menuBar.add(faculty);
        menuBar.add(print);
        menuPanel = new JPanel();
        menuPanel.add(menuBar);
        add(menuPanel);

        setVisible(true);

        student.addActionListener(this);
        faculty.addActionListener(this);
        print.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (student.isArmed()) {
            setVisible(false);
            StudentWindow studentWindow = new StudentWindow(personal, this);
        }
        else if (faculty.isArmed()) {
            setVisible(false);
            FacultyWindow facultyWindow = new FacultyWindow(personal, this);
        }
        else if (print.isArmed()) {
            personal.printAll();
        }
    }
}
