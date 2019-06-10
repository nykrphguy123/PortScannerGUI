import javax.swing.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.*;

public class Scan {

    private static int first, second;
    private List<Future<ScanResult>> futures = new ArrayList<>();

    public Scan() {

    }

    /**
    Sets the range of the port scanner
     */
    public void setRange() {

        String port1 = JOptionPane.showInputDialog(null, "Enter the first port range");

        if (port1 != null) {

            Integer num1 = Integer.parseInt(port1);

            String port2 = JOptionPane.showInputDialog(null, "Enter the second port range");

            if (port2 != null) {

                Integer num2 = Integer.parseInt(port2);

                first = num1;
                second = num2;

            } else

                System.out.println("***WARNING*** 2nd Port Range not set!");
        }
    }

        public void printResults () throws Exception {

           for (final Future<ScanResult> f : futures) {
               if (f.get().getOpen()) {


                  System.out.println("Port " + f.get().getPort() + " is open!");
                   }

               }


           }


    public void startScan(String host) throws Exception {

        final ExecutorService es = Executors.newFixedThreadPool(100);


        for (int i = first; i <= second; i++) {
            futures.add(portScan(es, host, i));
        }

        es.shutdown();

        printResults();

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










