import javax.swing.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.*;

public class Scan {

    private static Integer first, second;
    private List<Future<ScanResult>> futures = new ArrayList<>();

    public Scan() {

    }

    /**
     * Sets the range of the port scanner
     */
    public void setRange(String port1, String port2) {

        try {

            Integer num1 = Integer.parseInt(port1);
            Integer num2 = Integer.parseInt(port2);

            second = num2;
            first = num1;

        } catch (NumberFormatException e) {

            System.out.println("Please specify a port range!");

        }

        }

        public boolean isRangeSet() {

            boolean which;

            if (first == null) {
                which = false;
            } else
                which = true;

            return which;
        }

    public void startScan(String host) throws Exception  {

        final ExecutorService es = Executors.newFixedThreadPool(100);

        if (isRangeSet() == false) {

            System.out.println("You did not set a port range!");

        } else

        for (int i = first; i <= second; i++) {
            futures.add(portScan(es, host, i));
        }

        es.shutdown();

        for (final Future<ScanResult> f : futures) {
            if (f.get().getOpen()) {

                System.out.println("Port " + f.get().getPort() + " is open!");
            }
        }

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










