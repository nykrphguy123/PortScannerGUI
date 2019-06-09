import javax.swing.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class will provide space for the application in which we can attach any
 * other component, including other panels
 *
 * @author (Kristian Hernandez)
 * @version (1.0)
 */
public class Panel extends JPanel {


    private JTextField addressbox;
    private JButton scanbutton;
    private JScrollPane scroller;
    private JTextArea textbox;


    public Panel() {

        setLayout(null);

        textbox = new JTextArea();
        textbox.setEditable(false);
        textbox.setBounds(1, 22, 283, 340);

        scroller = new JScrollPane(textbox);
        scroller.setBounds(1, 22, 283, 340);
        scroller.setVerticalScrollBarPolicy((JScrollPane.VERTICAL_SCROLLBAR_ALWAYS));

        scanbutton = new JButton("Scan");
        scanbutton.setBounds(215, 1, 72, 20);

        addressbox = new JTextField();
        addressbox.setBounds(1, 1, 215, 22);

        add(addressbox);
        add(scanbutton);
        add(scroller);

        scanbutton.addActionListener(new ScanButton());

    }

    private class ScanButton implements ActionListener {

            public void actionPerformed(ActionEvent event) {

                Scan sobj = new Scan();

                String hostname = addressbox.getText();


                try {
                   sobj.startScan(hostname);
                   sobj.printInfo();

                } catch (Exception e) {
                    e.printStackTrace();
                }



            }


    }
}






















































