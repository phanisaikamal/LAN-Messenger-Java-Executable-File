package lan.messenger;

import java.awt.event.ActionEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.UIManager.LookAndFeelInfo;
import static lan.messenger.LANMessenger.myIP;

public class Selection extends javax.swing.JFrame
{
  public static Messaging m = new Messaging();
  private JTextArea detailsarea;
  private javax.swing.JScrollPane jScrollPane1;
  public Selection()
  {
    initComponents();
  }
  private JButton receivebutton;
  private JButton sendbutton;
  private javax.swing.JLabel welcomelabel;
  public static InetAddress myIP;
  private void initComponents()
  {
    try {
      myIP = InetAddress.getLocalHost();
    } catch (UnknownHostException ex) {
      Logger.getLogger(LANMessenger.class.getName()).log(Level.SEVERE, null, ex);
    }
    welcomelabel = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    detailsarea = new JTextArea();
    sendbutton = new JButton();
    receivebutton = new JButton();
    setDefaultCloseOperation(3);
    welcomelabel.setText("Welcome to LAN Messenger ( " + myIP + ")");
    detailsarea.setEditable(false);
    detailsarea.setColumns(20);
    detailsarea.setRows(10);
    detailsarea.setText("\tLAN Messenger helps you connect to your friends\n on a same network and chat with them.\n\n\t\t Team Members: \n\t\t Phani Sai Kamal Lingam \n\t\t Maddimsetty Pavan Kumar\n\t\t Karna Sai Manish Reddy");
    detailsarea.setFocusable(false);
    jScrollPane1.setViewportView(detailsarea);
    sendbutton.setText("Send Message");
    sendbutton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Selection.this.sendbuttonActionPerformed(evt);
      }  
    });
    receivebutton.setText("Recieve Message");
    receivebutton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Selection.this.receivebuttonActionPerformed(evt);
      } 
    });
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jScrollPane1).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 104, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(welcomelabel).addGap(105, 105, 105)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(receivebutton, -2, 170, -2).addComponent(sendbutton, -2, 170, -2)).addGap(113, 113, 113)))))));
    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(welcomelabel).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane1, -2, -1, -2).addGap(18, 18, 18).addComponent(sendbutton).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(receivebutton).addContainerGap(120, 32767)));
    pack();
  }
  private void sendbuttonActionPerformed(ActionEvent evt)
  {
    LANMessenger.hostIP = javax.swing.JOptionPane.showInputDialog("Enter the destination computer's local IP address(generally in the form of 10.x.x.x or 192.168.x.x)");
    
    if ((LANMessenger.hostIP != null) && (!"".equals(LANMessenger.hostIP))) {
      m.setVisible(true);
      dispose();
    }
    else {
      System.exit(1);
    }
  }
  private void receivebuttonActionPerformed(ActionEvent evt)
  {
    new Server();
  }
  public static void main(String[] args)
  {
    try
    {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(Selection.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      Logger.getLogger(Selection.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(Selection.class.getName()).log(Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      Logger.getLogger(Selection.class.getName()).log(Level.SEVERE, null, ex);
    }
    java.awt.EventQueue.invokeLater(new Runnable()
    {
      public void run() {}
    });
  }
}