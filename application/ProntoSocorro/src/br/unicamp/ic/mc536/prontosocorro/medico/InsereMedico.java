package br.unicamp.ic.mc536.prontosocorro.medico;

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
public class InsereMedico extends javax.swing.JFrame {

    /**
     * Creates new form CadastroClienteFisica
     */
    
    boolean flagUpdate;
    Medico medico;
    
    public InsereMedico() {
        initComponents();
        flagUpdate = false;
    }
    
    public InsereMedico(Medico m) {
        initComponents();
        medico = m;
        flagUpdate = true;
        inicializaCampos();
        edCRM.setEditable(false);
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        edNome = new javax.swing.JTextField();
        edCRM = new javax.swing.JTextField();
        edEspecialidade = new javax.swing.JTextField();
        btConfirma = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        lbErro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cadastro de Médicos:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 20, 550, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("* Nome:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 110, 60, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("* CRM:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 80, 60, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("* Especialidade:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 140, 100, 20);

        edNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(edNome);
        edNome.setBounds(130, 110, 260, 23);

        edCRM.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(edCRM);
        edCRM.setBounds(130, 80, 140, 23);

        edEspecialidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(edEspecialidade);
        edEspecialidade.setBounds(130, 140, 260, 23);

        btConfirma.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btConfirma.setText("CONFIRMA");
        btConfirma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btConfirmaMouseClicked(evt);
            }
        });
        jPanel1.add(btConfirma);
        btConfirma.setBounds(150, 220, 120, 40);

        btVoltar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btVoltar.setText("VOLTAR");
        btVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btVoltarMouseClicked(evt);
            }
        });
        jPanel1.add(btVoltar);
        btVoltar.setBounds(280, 220, 120, 40);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("* Campo Obrigatório");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(380, 180, 150, 17);

        lbErro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbErro.setForeground(new java.awt.Color(255, 0, 51));
        lbErro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbErro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lbErro);
        lbErro.setBounds(10, 360, 360, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, -2, 570, 280);

        setSize(new java.awt.Dimension(566, 316));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btConfirmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btConfirmaMouseClicked
        String txtCRM;
        int CRM;
        try {
            txtCRM = edCRM.getText().trim();
            CRM = Integer.parseInt(txtCRM);
            String nome = edNome.getText().trim();
            String especialidade = edEspecialidade.getText().trim();   
            if((txtCRM.equals("")) || (nome.equals("")) || (especialidade.equals(""))){            
                lbErro.setText("Preencha os campos obrigatórios");
            } else {  
                Medico medico = new Medico(CRM, nome, especialidade);
                if (flagUpdate) {
                    medico.novo();
                    JOptionPane.showMessageDialog(this, "Cadastrado com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    medico.alterar();
                    JOptionPane.showMessageDialog(this, "Alterado com sucesso!", "Atualização", JOptionPane.INFORMATION_MESSAGE);
                }
                
                this.dispose();
            }
        } catch (NumberFormatException e) {
            lbErro.setText("CRM inválido");        
        }
        
    }//GEN-LAST:event_btConfirmaMouseClicked

    private void btVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btVoltarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btVoltarMouseClicked

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
            java.util.logging.Logger.getLogger(InsereMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new InsereMedico().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConfirma;
    private javax.swing.JButton btVoltar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField edCRM;
    private javax.swing.JTextField edEspecialidade;
    private javax.swing.JTextField edNome;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbErro;
    // End of variables declaration//GEN-END:variables
    
    private void inicializaCampos() {
        edCRM.setText(""+medico.getCRM());
        edNome.setText(medico.getNome());
        edEspecialidade.setText(medico.getEspecialidade());
    }
}
