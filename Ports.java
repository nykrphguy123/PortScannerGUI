import java.util.ArrayList;
import java.util.List;

public class Ports {

    private int port1;
    private int port2;
    private List<Integer> list;

    public Ports(int port1, int port2) {

        this.port1 = port1;
        this.port2 = port2;

        list = new ArrayList<Integer>();
        list.add(port1);
        list.add(port2);



    }

    public List<Integer> getPorts() {

        return list;
    }
}
