package br.unicamp.ic.mc536.prontosocorro.doenca;
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
public class EmDoenca extends javax.swing.JFrame {

    /**
     * Creates new form CadastroClienteFisica
     */
    
    boolean flagUpdate;
    Doenca doenca;
    
    public EmDoenca() {
        initComponents();
        flagUpdate = false;
    }
    
    public EmDoenca(Doenca d) {
        initComponents();
        doenca = d;
        flagUpdate = false;
        inicializaCampos();
        edNome.setEditable(false);
        edCID.setEditable(false);
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
        btVoltar = new javax.swing.JButton();
        lbErro = new javax.swing.JLabel();
        edCID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        edNome = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Pacientes");
        setName("janela"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Detalhes da Doença");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 20, 550, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nome:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 110, 60, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("CID:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 70, 60, 30);

        btVoltar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btVoltar.setText("VOLTAR");
        btVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btVoltarMouseClicked(evt);
            }
        });
        jPanel1.add(btVoltar);
        btVoltar.setBounds(210, 180, 120, 40);

        lbErro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbErro.setForeground(new java.awt.Color(255, 0, 51));
        lbErro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbErro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lbErro);
        lbErro.setBounds(10, 360, 360, 30);

        edCID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(edCID);
        edCID.setBounds(130, 70, 140, 27);

        edNome.setColumns(20);
        edNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edNome.setLineWrap(true);
        edNome.setRows(3);
        jScrollPane1.setViewportView(edNome);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(130, 110, 380, 60);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, -2, 520, 230);

        setSize(new java.awt.Dimension(528, 249));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(EmDoenca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new EmDoenca().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btVoltar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField edCID;
    private javax.swing.JTextArea edNome;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbErro;
    // End of variables declaration//GEN-END:variables
    
    private void inicializaCampos() {
        edCID.setText(doenca.getCID());
        edNome.setText(doenca.getNome());
    }
}
