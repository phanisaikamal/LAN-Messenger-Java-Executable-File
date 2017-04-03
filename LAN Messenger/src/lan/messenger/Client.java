package lan.messenger;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Client
{
  public static Socket socket;
  InputStream is;  
  public Client() {} 
  public void startClient(String host)
  {
    try
    {
      int port = 5321;
      InetAddress address = InetAddress.getByName(host);
      socket = new Socket(address, port);
      is = socket.getInputStream();
      new Thread(new Receiver(is)).start();
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
      JFrame frame = new JFrame();
      JOptionPane.showMessageDialog(frame, "Could not establish a connection to " + host);
      System.exit(0);
    }
  } 
  public void sendMessage(String message) {
    OutputStream os = null;
    try {
      os = socket.getOutputStream();
      OutputStreamWriter osw = new OutputStreamWriter(os);
      BufferedWriter buffer = new BufferedWriter(osw);
      buffer.write(message);
      buffer.flush();
    } catch (IOException ex) {
      Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}