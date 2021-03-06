package br.unicamp.ic.mc536.prontosocorro.laboratorio;

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
public class InsereLaboratorio extends javax.swing.JFrame {

    /**
     * Creates new form CadastroClienteFisica
     */
    
    boolean flagUpdate;
    Laboratorio laboratorio;
    
    public InsereLaboratorio() {
        initComponents();
        flagUpdate = false;
    }
    
    public InsereLaboratorio(Laboratorio l) {
        initComponents();
        laboratorio = l;
        flagUpdate = true;
        inicializaCampos();
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
        edResponsavel = new javax.swing.JTextField();
        edNome = new javax.swing.JTextField();
        btConfirma = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        lbErro = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        edTelefone = new javax.swing.JFormattedTextField();
        edTipo = new javax.swing.JTextField();
        edRegistro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Pacientes");
        setName("janela"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cadastro de Laboratório");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 20, 550, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("* Telefone:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 140, 80, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("* Registro");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 70, 70, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("* Responsável:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 200, 100, 20);

        edResponsavel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(edResponsavel);
        edResponsavel.setBounds(130, 200, 260, 27);

        edNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(edNome);
        edNome.setBounds(130, 100, 260, 27);

        btConfirma.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btConfirma.setText("CONFIRMA");
        btConfirma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btConfirmaMouseClicked(evt);
            }
        });
        jPanel1.add(btConfirma);
        btConfirma.setBounds(150, 240, 120, 40);

        btVoltar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btVoltar.setText("VOLTAR");
        btVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btVoltarMouseClicked(evt);
            }
        });
        jPanel1.add(btVoltar);
        btVoltar.setBounds(280, 240, 120, 40);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("* Campo Obrigatório");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(400, 200, 150, 17);

        lbErro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbErro.setForeground(new java.awt.Color(255, 0, 51));
        lbErro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbErro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lbErro);
        lbErro.setBounds(10, 360, 360, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("* Tipo:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 170, 100, 20);

        try {
            edTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # - #### - ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edTelefone.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(edTelefone);
        edTelefone.setBounds(130, 140, 190, 30);

        edTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(edTipo);
        edTipo.setBounds(130, 170, 260, 27);
        jPanel1.add(edRegistro);
        edRegistro.setBounds(130, 70, 180, 26);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("* Nome");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 100, 60, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, -2, 570, 300);

        setSize(new java.awt.Dimension(566, 316));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btConfirmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btConfirmaMouseClicked
        try {
            int nRegistro = Integer.parseInt(edRegistro.getText().trim());
            String nome = edNome.getText().trim();
            String telefone = edTelefone.getText().trim();
            String tipo = edTipo.getText().trim();
            String responsavel = edResponsavel.getText().trim();
            
            
            if(((nome.equals("")) || (telefone.equals("")) || (tipo.equals(""))||(responsavel.equals(""))) ){            
                lbErro.setText("Preencha os campos obrigatórios");
            } else {  
                Laboratorio l = new Laboratorio(nRegistro, nome, telefone, tipo, responsavel);
                if (!flagUpdate) {
                    l.novo();
                    JOptionPane.showMessageDialog(this, "Cadastrado com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    l.alterar();
                    JOptionPane.showMessageDialog(this, "Alterado com sucesso!", "Atualização", JOptionPane.INFORMATION_MESSAGE);
                }
                
                this.dispose();
            }
        } catch (NumberFormatException e) {
            lbErro.setText("CPF inválido");        
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
            java.util.logging.Logger.getLogger(InsereLaboratorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new InsereLaboratorio().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConfirma;
    private javax.swing.JButton btVoltar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField edNome;
    private javax.swing.JTextField edRegistro;
    private javax.swing.JTextField edResponsavel;
    private javax.swing.JFormattedTextField edTelefone;
    private javax.swing.JTextField edTipo;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbErro;
    // End of variables declaration//GEN-END:variables
    
    private void inicializaCampos() {
        edRegistro.setText(laboratorio.getnRegistro()+"");
        edNome.setText(laboratorio.getNome());
        edTelefone.setText(laboratorio.getTelefone());
        edTipo.setText(laboratorio.getTipo());
        edResponsavel.setText(laboratorio.getResponsavel());
        edRegistro.setEditable(false);
    }
}
