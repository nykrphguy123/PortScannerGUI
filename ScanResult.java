public class ScanResult {

    private int port;
    private boolean isOpen;

    public ScanResult(int p, boolean o) {

        this.port = p;
        this.isOpen = o;


    }

  public boolean getOpen() {

        return isOpen;

  }

  public int getPort() {

        return port;
  }
}
