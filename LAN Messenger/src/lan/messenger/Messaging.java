package lan.messenger;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.SequentialGroup;

public class Messaging extends javax.swing.JFrame
{
  Client c;
  private javax.swing.JLabel apptitle;
  private javax.swing.JTextArea chatarea;
  private javax.swing.JLabel credits;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextField messagefield;
  private javax.swing.JButton sendbutton;  
  public void serverchat(String message)
  {
    chatarea.setText(chatarea.getText() + message);
  }
  public Messaging()
  {
    c = new Client();
    initComponents();
  }
  private void initComponents()
  {
    jScrollPane1 = new javax.swing.JScrollPane();
    chatarea = new javax.swing.JTextArea();
    apptitle = new javax.swing.JLabel();
    credits = new javax.swing.JLabel();
    messagefield = new javax.swing.JTextField();
    sendbutton = new javax.swing.JButton();   
    setDefaultCloseOperation(3);   
    chatarea.setEditable(false);
    chatarea.setColumns(20);
    chatarea.setRows(5);
    jScrollPane1.setViewportView(chatarea);   
    apptitle.setText("LAN Messenger");    
    credits.setText("BML Munjal University");    
    messagefield.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(java.awt.event.FocusEvent evt) {
        Messaging.this.messagefieldFocusGained(evt);
      }     
    });
    sendbutton.setText("SEND");
    sendbutton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        Messaging.this.sendbuttonActionPerformed(evt);
      }      
    });
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(apptitle, -2, 123, -2).addGap(132, 132, 132)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(credits).addContainerGap()))).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane1).addGroup(layout.createSequentialGroup().addComponent(messagefield, -2, 300, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(sendbutton, -1, 82, 32767))).addContainerGap()))));
    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(7, 7, 7).addComponent(apptitle).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jScrollPane1, -2, 187, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(messagefield, -1, 44, 32767).addComponent(sendbutton)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(credits).addContainerGap()));
    pack();
  }  
  private void sendbuttonActionPerformed(java.awt.event.ActionEvent evt)
  {
    String message = messagefield.getText();
    String chat = LANMessenger.myIP + ": " + message + "\n";
    c.startClient(LANMessenger.hostIP);
    c.sendMessage(chat);
    chatarea.setText(chatarea.getText() + chat);
    messagefield.setText(null);
  }  
  private void messagefieldFocusGained(java.awt.event.FocusEvent evt)
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
      java.util.logging.Logger.getLogger(Messaging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Messaging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Messaging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Messaging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    java.awt.EventQueue.invokeLater(new Runnable()
    {
      public void run() {}
    });
  }
}