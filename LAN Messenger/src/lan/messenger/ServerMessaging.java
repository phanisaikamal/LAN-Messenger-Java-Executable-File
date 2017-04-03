package lan.messenger;

import java.awt.event.FocusEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerMessaging extends javax.swing.JFrame
{
  java.io.BufferedWriter bw;
  private JLabel apptitle;
  private JTextArea chatarea;
  private JLabel credits;
  private javax.swing.JScrollPane jScrollPane1;
  private JTextField messagefield;
  private javax.swing.JButton sendbutton;
  public void serverchat(String message)
  {
    chatarea.setText(chatarea.getText() + "\n" + message);
  }
  public ServerMessaging()
  {
    initComponents();
  }
  private void initComponents()
  {
    jScrollPane1 = new javax.swing.JScrollPane();
    chatarea = new JTextArea();
    apptitle = new JLabel();
    credits = new JLabel();
    messagefield = new JTextField();
    sendbutton = new javax.swing.JButton();   
    setDefaultCloseOperation(3);    
    chatarea.setEditable(false);
    chatarea.setColumns(20);
    chatarea.setRows(5);
    jScrollPane1.setViewportView(chatarea);    
    apptitle.setText("LAN Messenger");    
    credits.setText("BML Munjal University");    
    messagefield.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent evt) {
        ServerMessaging.this.messagefieldFocusGained(evt);
      }      
    });
    sendbutton.setText("SEND");
    sendbutton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ServerMessaging.this.sendbuttonActionPerformed(evt);
      }   
    });
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(apptitle, -2, 123, -2).addGap(132, 132, 132)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(credits).addContainerGap()))).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jScrollPane1).addGroup(layout.createSequentialGroup().addComponent(messagefield, -2, 300, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(sendbutton, -1, 82, 32767))).addContainerGap()))));
    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(7, 7, 7).addComponent(apptitle).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jScrollPane1, -2, 187, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(messagefield, -1, 44, 32767).addComponent(sendbutton)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(credits).addContainerGap()));
    pack();
  }
  private void sendbuttonActionPerformed(java.awt.event.ActionEvent evt)
  {
    java.io.OutputStream os = null;
    try {
      os = Server.socket.getOutputStream();
    } catch (IOException ex) {
      Logger.getLogger(ServerMessaging.class.getName()).log(Level.SEVERE, null, ex);
    }
    java.io.OutputStreamWriter osw = new java.io.OutputStreamWriter(os);
    bw = new java.io.BufferedWriter(osw);
    String message = messagefield.getText();
    String chat = null;
    try {
      chat = java.net.InetAddress.getLocalHost().toString() + ": " + message;
    } catch (java.net.UnknownHostException ex) {
      Logger.getLogger(ServerMessaging.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
      bw.write(chat + "\n");
      bw.flush();
      System.out.println(chat);
    } catch (IOException ex) {
      Logger.getLogger(ServerMessaging.class.getName()).log(Level.SEVERE, null, ex);
    }
    chatarea.setText(chatarea.getText() + "\n" + chat);
    messagefield.setText(null);
  }
  private void messagefieldFocusGained(FocusEvent evt)
  {
    javax.swing.JRootPane rootPane = javax.swing.SwingUtilities.getRootPane(sendbutton);
    rootPane.setDefaultButton(sendbutton);
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
      Logger.getLogger(ServerMessaging.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      Logger.getLogger(ServerMessaging.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(ServerMessaging.class.getName()).log(Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      Logger.getLogger(ServerMessaging.class.getName()).log(Level.SEVERE, null, ex);
    }
    java.awt.EventQueue.invokeLater(new Runnable()
    {
      public void run() {}
    });
  }
}