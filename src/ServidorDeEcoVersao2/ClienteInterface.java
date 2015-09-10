/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorDeEcoVersao2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author lennonalves
 */
public class ClienteInterface extends javax.swing.JFrame {

    /**
     * Creates new form ClienteInterface
     */
    public ClienteInterface() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPorta = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        txtIP = new javax.swing.JTextField();
        MensagemResposta = new javax.swing.JScrollPane();
        txtResposta = new javax.swing.JTextArea();
        MensagemEnviar = new javax.swing.JScrollPane();
        txtMensagem = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 400));
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("PakType Naqsh", 0, 24)); // NOI18N
        jLabel3.setText("Conexão do Cliente");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(90, 10, 210, 30);

        jLabel2.setText("Porta:");
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 110, 110, 16);
        getContentPane().add(txtPorta);
        txtPorta.setBounds(120, 100, 260, 28);

        lblStatus.setText("Status: Desconectado");
        lblStatus.setToolTipText("");
        getContentPane().add(lblStatus);
        lblStatus.setBounds(220, 140, 160, 16);

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnviar);
        btnEnviar.setBounds(320, 170, 60, 80);

        jLabel4.setText("IP de Conexão:");
        jLabel4.setToolTipText("");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 70, 110, 16);
        getContentPane().add(txtIP);
        txtIP.setBounds(120, 60, 260, 28);

        txtResposta.setColumns(20);
        txtResposta.setRows(5);
        txtResposta.setEnabled(false);
        MensagemResposta.setViewportView(txtResposta);

        getContentPane().add(MensagemResposta);
        MensagemResposta.setBounds(10, 260, 370, 82);

        txtMensagem.setColumns(20);
        txtMensagem.setRows(5);
        MensagemEnviar.setViewportView(txtMensagem);

        getContentPane().add(MensagemEnviar);
        MensagemEnviar.setBounds(10, 170, 300, 82);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        // TODO add your handling code here:
        try 
        {  
        Socket conexao = new Socket(txtIP.getText(), Integer.parseInt(txtPorta.getText()));
        
        BufferedReader entrada = new BufferedReader(new InputStreamReader(conexao.getInputStream()));  
        PrintStream saida = new PrintStream(conexao.getOutputStream());  
        String mensagem;
        
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));  
        
        lblStatus.setText("Status: Conectado");
        
        //System.out.println("Conectado");
        
        if (true) 
        {
            mensagem = txtMensagem.getText();
            
            saida.println(mensagem);
            mensagem = entrada.readLine();
            
            txtResposta.setText(mensagem);
            //System.out.println(mensagem);
        }
        } catch (IOException e)
        {  
            System.out.println("IOException: " + e);
            lblStatus.setText("Status: Desconectado");
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClienteInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane MensagemEnviar;
    private javax.swing.JScrollPane MensagemResposta;
    private javax.swing.JToggleButton btnEnviar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTextField txtIP;
    private javax.swing.JTextArea txtMensagem;
    private javax.swing.JTextField txtPorta;
    private javax.swing.JTextArea txtResposta;
    // End of variables declaration//GEN-END:variables
}