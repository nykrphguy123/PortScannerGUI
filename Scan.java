import javax.swing.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.concurrent.Executor.*;
import java.util.concurrent.ExecutorService.*;
import java.util.concurrent.Future.*;

public class Scan {

    private static int first, second;
    private List<Future<ScanResult>> futures = new ArrayList<>();

    public Scan() {


    }

    public void setRange() {

        String port1 = JOptionPane.showInputDialog(null, "Enter the first port range");
        Integer num1 = Integer.parseInt(port1);

        String port2 = JOptionPane.showInputDialog(null, "Enter the second port range");
        Integer num2 = Integer.parseInt(port2);

        first = num1;
        second = num2;


        public List<ScanResult> printInfo () throws Exception {

            for (final Future<ScanResult> f : futures) {
                if (f.get().getOpen()) {
                    System.out.println("Port " + f.get().getPort() + " is open!");

                }

            }

            return futures;
        }
    }

    public void startScan(String host) throws Exception {

        final ExecutorService es = Executors.newFixedThreadPool(100);


        for (int i = first; i <= second; i++) {
            futures.add(portScan(es, host, i));
        }

        es.shutdown();

            }


    public static Future<ScanResult> portScan(final ExecutorService es, String host, int port) {

        return es.submit(new Callable<ScanResult>() {

                             @Override
                             public ScanResult call() {

                                 ScanResult result = new ScanResult(port, false);

                                 try {

                                     Socket socket = new Socket();

                                     socket.connect(new InetSocketAddress(host, port), 200);
                                     socket.close();

                                     result = new ScanResult(port, true);

                                     return result;

                                 } catch (Exception e) {


                                 }
                                 return result;
                             }

                         }
        );
    }
}










