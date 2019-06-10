import javax.swing.*;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {


    private JMenuBar menubar;
    private JMenu menu;
    private JMenuItem option;
    private JFrame frame;
    private JTextArea textbox;
    private JScrollPane scroll;

    public Main() {


        Panel panel = new Panel();


        menubar = new JMenuBar();
        menu = new JMenu("Options");
        option = new JMenuItem("Port Range");

        menubar.add(menu);
        menu.add(option);

        frame = new JFrame("Port Scanner");

        frame.setJMenuBar(menubar);

        frame.setResizable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);
        frame.setSize(300, 410);

        option.addActionListener(new MenuListener());

        frame.setVisible(true);


    }


    /**
     * Basically runs the program
     */
    public static void main(String[] args) {

        Main main = new Main();


    }


    /**
     * Menu listener that allows the user to specify the range of ports to scan
     */
    private class MenuListener implements ActionListener {


        public void actionPerformed(ActionEvent event) {



            Scan scan = new Scan();
            scan.setRange();




        }



        }

    }







