package br.unicamp.ic.mc536.prontosocorro.exame;

import java.sql.Date;
import java.sql.Time;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
public class InsereExame extends javax.swing.JFrame {

    /**
     * Creates new form CadastroClienteFisica
     */
    
    boolean flagUpdate;
    Exame exame;
    
    public InsereExame() {
        initComponents();
        flagUpdate = false;
    }
    
    public InsereExame(Exame e) {
        initComponents();
        exame = e;
        flagUpdate = true;
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        edPaciente = new javax.swing.JTextField();
        btConfirma = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        lbErro = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        edMedico = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        edLaboratorio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        edHora = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        edInformacoes = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        edData = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        edLaudo = new javax.swing.JTextField();
        edTipo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Medicamentos");
        setName("janela"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cadastro de Exame");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 20, 550, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("* CPF - Paciente:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 70, 120, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("* Informações:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 290, 120, 20);

        edPaciente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(edPaciente);
        edPaciente.setBounds(140, 70, 260, 23);

        btConfirma.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btConfirma.setText("CONFIRMA");
        btConfirma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btConfirmaMouseClicked(evt);
            }
        });
        btConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmaActionPerformed(evt);
            }
        });
        jPanel1.add(btConfirma);
        btConfirma.setBounds(140, 380, 120, 40);

        btVoltar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btVoltar.setText("VOLTAR");
        btVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btVoltarMouseClicked(evt);
            }
        });
        jPanel1.add(btVoltar);
        btVoltar.setBounds(350, 380, 120, 40);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("* Campo Obrigatório");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(400, 180, 150, 17);

        lbErro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbErro.setForeground(new java.awt.Color(255, 0, 51));
        lbErro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbErro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lbErro);
        lbErro.setBounds(10, 360, 360, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("* CRM - Médico:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 100, 100, 20);

        edMedico.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(edMedico);
        edMedico.setBounds(140, 100, 260, 23);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("* Tipo:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 130, 120, 20);

        edLaboratorio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(edLaboratorio);
        edLaboratorio.setBounds(140, 250, 260, 23);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("* Data:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(20, 160, 120, 20);

        edHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        jPanel1.add(edHora);
        edHora.setBounds(140, 190, 140, 20);

        edInformacoes.setColumns(20);
        edInformacoes.setRows(5);
        jScrollPane1.setViewportView(edInformacoes);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(140, 290, 260, 70);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("* Laboratório:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(20, 250, 120, 20);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("* Hora:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 190, 120, 20);

        edData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(edData);
        edData.setBounds(140, 160, 140, 23);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("* Laudo:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(20, 220, 120, 20);

        edLaudo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(edLaudo);
        edLaudo.setBounds(140, 220, 260, 23);

        edTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(edTipo);
        edTipo.setBounds(140, 130, 260, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, -2, 650, 440);

        setSize(new java.awt.Dimension(639, 470));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btConfirmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btConfirmaMouseClicked
            int CRM,laboratorio;
        try {
            String txt_CRM = edMedico.getText().trim();
            CRM = Integer.parseInt(txt_CRM);
            String CPF = edPaciente.getText().trim();
            String tipo = edData.getText().trim();
            String txtData = edData.getText().trim();
            String txtHora = edHora.getText().trim();
            String informacoes = edInformacoes.getText().trim();
            String laudo = edLaudo.getText().trim();
            String txtLaboratorio = edLaboratorio.getText().trim();
            laboratorio = Integer.parseInt(txtLaboratorio);
            
            if((txt_CRM.equals("")) || (CPF.equals("")) || (tipo.equals("")) || (txtData.equals("")) || (txtHora.equals(""))
                    || (informacoes.equals("")) || (laudo.equals(""))){            
                lbErro.setText("Preencha os campos obrigatórios");
            } else {  
                Exame exame = new Exame(0,CRM,CPF,tipo,txtData,txtHora,laudo,informacoes,laboratorio);
                if (!flagUpdate) {
                    exame.novo();
                    JOptionPane.showMessageDialog(this, "Cadastrado com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE) ;              
                this.dispose();
                }
            }
        } catch (NumberFormatException e) {
            lbErro.setText("campo incorreto");        
        }
        
    }//GEN-LAST:event_btConfirmaMouseClicked

    private void btVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btVoltarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btVoltarMouseClicked

    private void btConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btConfirmaActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsereExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new InsereExame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConfirma;
    private javax.swing.JButton btVoltar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField edData;
    private javax.swing.JFormattedTextField edHora;
    private javax.swing.JTextArea edInformacoes;
    private javax.swing.JTextField edLaboratorio;
    private javax.swing.JTextField edLaudo;
    private javax.swing.JTextField edMedico;
    private javax.swing.JTextField edPaciente;
    private javax.swing.JTextField edTipo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbErro;
    // End of variables declaration//GEN-END:variables
    
 
}
