import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

    private JMenuBar menubar;
    private JMenu menu;
    private JMenuItem option, option2;
    private JFrame frame;
    private JTextArea textbox;
    private JScrollPane scroll;

    public Main() {

        Panel panel = new Panel();

        menubar = new JMenuBar();
        menu = new JMenu("Options");
        option = new JMenuItem("Port Range");
        option2 = new JMenuItem("Host Resolve");

        menubar.add(menu);
        menu.add(option);
        menu.add(option2);

        frame = new JFrame("Orbit Scanner v1.0");

        frame.setJMenuBar(menubar);

        frame.setResizable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);
        frame.setSize(300, 424);

        option.addActionListener(new MenuListener());
        option2.addActionListener(new MenuListener2());

        frame.setVisible(true);

    }

    /**
     * Basically runs the program
     */
    public static void main(String[] args) {

        Main main = new Main();

    }

    private class MenuListener2 implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String hostname = JOptionPane.showInputDialog(null, "Enter a hostname");
            HostResolve hr = new HostResolve(hostname.trim());

            hr.addressResolve(hostname);

            }

        }

        /**
         * Menu listener that allows the user to specify the range of ports to scan
         */
        private class MenuListener implements ActionListener {

            public void actionPerformed(ActionEvent event) {

                Scan scan = new Scan();

                String port1 = JOptionPane.showInputDialog(null, "Enter the first port range");
                String port2 = JOptionPane.showInputDialog(null, "Enter the second port range");

                scan.setRange(port1, port2);

            }

        }

    }









