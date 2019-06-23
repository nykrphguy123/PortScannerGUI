import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostResolve {

    private final String hostaddress;

    public HostResolve(final String hostaddress) {

        this.hostaddress = hostaddress;

    }

    public void addressResolve(String name) {

        try {

            InetAddress address = InetAddress.getByName(hostaddress);

            System.out.println("Resolved address is: " + address.getHostAddress());

        } catch (UnknownHostException ex) {

            System.out.println("Unable to pull address");

        }
    }
}

