import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import javax.swing.text.DefaultCaret;
import java.util.regex.*;

/**
 * This class will provide space for the application in which we can attach any
 * other component, including other panels
 */
public class Panel extends JPanel {

    private JTextField addressbox;
    private JButton scanbutton;
    private JScrollPane scroller;
    private JTextArea textbox;
    private PrintStream standardOut;
    private final String ipAddrPattern;

    public Panel() {

        setLayout(null);

        ipAddrPattern = ("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

        textbox = new JTextArea();
        textbox.setEditable(false);
        PrintStream printStream = new PrintStream(new OutputStreamInfo(textbox));
        textbox.setBounds(1, 22, 283, 340);

        standardOut = System.out; //keeps reference of standard output stream

        // this is to re-assign the standard and error output stream
        System.setOut(printStream);
        System.setErr(printStream);

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

    /**
     * Scan button listener event when pressed, scans host for open ports then displays it to the textarea
     */
    private class ScanButton implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            Scan sobj = new Scan();

            String hostname = addressbox.getText().trim();

            Pattern pattern = Pattern.compile(ipAddrPattern);

            Matcher matcher = pattern.matcher(hostname);

            boolean matches = matcher.matches();

            if (matches == false) {

                System.out.println(hostname + " is not a valid address");

            } else

                try {

                    textbox.selectAll();
                    textbox.replaceSelection("");

                    //This is to force the scrollbar to go to the top
                    DefaultCaret caret = (DefaultCaret) textbox.getCaret();
                    caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);

                    if (sobj.isRangeSet() == true) {

                        System.out.println("Finished scanning " + hostname + "!");

                    }
                    sobj.startScan(hostname);

                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        }

        {


        }


    }

























































