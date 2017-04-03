package lan.messenger;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LANMessenger
{
  public static String hostIP = null;
  public static InetAddress myIP;
  
  public LANMessenger() {}
  
  public static void main(String[] args)
  {
    try {
      myIP = InetAddress.getLocalHost();
    } catch (UnknownHostException ex) {
      Logger.getLogger(LANMessenger.class.getName()).log(Level.SEVERE, null, ex);
    }
    new Selection().setVisible(true);
  }
}