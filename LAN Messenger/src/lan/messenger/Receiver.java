package lan.messenger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

class Receiver
  implements Runnable
{
  InputStream is;  
  public Receiver(InputStream is)
  {
    this.is = is;
  }
  public void run()
  {
    for (;;) {
      System.out.println("Inside client receiver thread");
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);
      String message = null;
      try {
        System.out.println("Inside client receiver thread before readline");
        message = br.readLine();
        System.out.println("Recieved message is :- " + message);
      } catch (IOException ex) {
        Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
      }
      System.out.println("Message received from the server : " + message);
      if (message != null) {
        Selection.m.serverchat(message + "\n");
      }
    }
  }
}