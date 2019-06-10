import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;

/**
 * This class extends from OutputStream to redirect output to JTextArea
 */

public class OutputStreamInfo extends OutputStream {

    private JTextArea textarea;

    public OutputStreamInfo(JTextArea textarea) {

        this.textarea = textarea;

    }


    public void write(int a) throws IOException {

        textarea.append(String.valueOf((char)a));


    }
}
