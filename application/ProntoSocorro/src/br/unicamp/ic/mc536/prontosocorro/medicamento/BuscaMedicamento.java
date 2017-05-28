/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unicamp.ic.mc536.prontosocorro.medicamento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Administrador
 */
public class BuscaMedicamento extends javax.swing.JFrame {

    /**
     * Creates new form ConsFuncionario
     */
    public BuscaMedicamento() {
        initComponents();
    }
    
    private void search() {
        if (chSemFiltro.isSelected()){
            atualizaTabela(Medicamento.consultar("",(short)-1));
            lbErro.setText("");
        } else if(chID.isSelected()) {
            try {
                int id = Integer.parseInt(edID.getText());
                atualizaTabela(Medicamento.consultar(""+id,(short)1));
                lbErro.setText("");
            } catch (NumberFormatException e) {
                lbErro.setText("O código deve ser um valor numérico!");
            }
        } else if(chPrincipio_Ativo.isSelected()) {
            atualizaTabela(Medicamento.consultar(edPrincipio_Ativo.getText(),(short)2));
            lbErro.setText("");
        }
    }
    
    protected void atualizaTabela(ResultSet rs){
        DefaultTableModel modelotabela = (DefaultTableModel) tabela.getModel();
        modelotabela.setColumnCount(4);
        modelotabela.setRowCount(0);

        tabela.getColumnModel().getColumn(0).setHeaderValue("ID");
        tabela.getColumnModel().getColumn(1).setHeaderValue("Princípio Ativo");
        tabela.getColumnModel().getColumn(2).setHeaderValue("Dosagem");
        tabela.getColumnModel().getColumn(3).setHeaderValue("Contra-Indicação");
        
        int linha = 0;
        try{
            if(rs != null) {  
                while(rs.next()){
                      modelotabela.addRow(new String[modelotabela.getColumnCount()]);
                      modelotabela.setValueAt(rs.getString("id_medicamento"), linha, 0);
                      modelotabela.setValueAt(rs.getString("principio_ativo"), linha, 1);
                      modelotabela.setValueAt(rs.getString("dosagem"), linha, 2);
                      modelotabela.setValueAt(rs.getString("contra_indicacao"), linha, 3);
                      linha++;
                  }
            }
        }catch(SQLException e){
            System.err.println("Erro: " + e);
        }
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
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        edID = new javax.swing.JTextField();
        edPrincipio_Ativo = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        chSemFiltro = new javax.swing.JCheckBox();
        chPrincipio_Ativo = new javax.swing.JCheckBox();
        chID = new javax.swing.JCheckBox();
        btLimpar = new javax.swing.JButton();
        btInserir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        lbErro = new javax.swing.JLabel();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Busca de Medicamentos");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel5.setName(""); // NOI18N
        jPanel5.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Busca Medicamento");
        jPanel5.add(jLabel5);
        jLabel5.setBounds(0, 20, 570, 30);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Filtros de busca:");
        jPanel6.add(jLabel6);
        jLabel6.setBounds(40, 10, 140, 20);

        edID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edID.setEnabled(false);
        jPanel6.add(edID);
        edID.setBounds(130, 40, 100, 23);

        edPrincipio_Ativo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edPrincipio_Ativo.setEnabled(false);
        jPanel6.add(edPrincipio_Ativo);
        edPrincipio_Ativo.setBounds(130, 70, 260, 23);

        btBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btBuscar.setText("BUSCAR");
        btBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btBuscarMouseClicked(evt);
            }
        });
        jPanel6.add(btBuscar);
        btBuscar.setBounds(420, 80, 100, 50);

        buttonGroup1.add(chSemFiltro);
        chSemFiltro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chSemFiltro.setSelected(true);
        chSemFiltro.setText("Sem Filtro");
        jPanel6.add(chSemFiltro);
        chSemFiltro.setBounds(315, 40, 95, 30);

        buttonGroup1.add(chPrincipio_Ativo);
        chPrincipio_Ativo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chPrincipio_Ativo.setText("Princípio ativo");
        chPrincipio_Ativo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chPrincipio_AtivoItemStateChanged(evt);
            }
        });
        jPanel6.add(chPrincipio_Ativo);
        chPrincipio_Ativo.setBounds(10, 70, 120, 25);

        buttonGroup1.add(chID);
        chID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chID.setText("ID");
        chID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chIDItemStateChanged(evt);
            }
        });
        jPanel6.add(chID);
        chID.setBounds(10, 40, 70, 25);

        btLimpar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btLimpar.setText("Limpar");
        btLimpar.setToolTipText("");
        btLimpar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btLimpar.setOpaque(false);
        btLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btLimparMouseClicked(evt);
            }
        });
        jPanel6.add(btLimpar);
        btLimpar.setBounds(420, 40, 100, 30);

        btInserir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btInserir.setText("INSERIR");
        btInserir.setToolTipText("");
        btInserir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btInserirMouseClicked(evt);
            }
        });
        jPanel6.add(btInserir);
        btInserir.setBounds(-60, 520, 110, 40);

        jPanel5.add(jPanel6);
        jPanel6.setBounds(20, 60, 530, 140);

        tabela.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 4"
            }
        ));
        tabela.setIntercellSpacing(new java.awt.Dimension(2, 2));
        jScrollPane1.setViewportView(tabela);

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(20, 210, 530, 320);

        lbErro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbErro.setForeground(new java.awt.Color(255, 0, 51));
        lbErro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbErro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel5.add(lbErro);
        lbErro.setBounds(20, 540, 350, 30);

        btVoltar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btVoltar.setText("VOLTAR");
        btVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btVoltarMouseClicked(evt);
            }
        });
        jPanel5.add(btVoltar);
        btVoltar.setBounds(450, 580, 100, 40);

        getContentPane().add(jPanel5);
        jPanel5.setBounds(0, 0, 570, 630);

        setSize(new java.awt.Dimension(585, 669));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btBuscarMouseClicked
        search();
    }//GEN-LAST:event_btBuscarMouseClicked

    private void chPrincipio_AtivoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chPrincipio_AtivoItemStateChanged
        edPrincipio_Ativo.setEnabled(chPrincipio_Ativo.isSelected());
    }//GEN-LAST:event_chPrincipio_AtivoItemStateChanged

    private void chIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chIDItemStateChanged
        edID.setEnabled(chID.isSelected());
    }//GEN-LAST:event_chIDItemStateChanged
 
    private void btLimparMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btLimparMouseClicked
        edID.setText("");
        edPrincipio_Ativo.setText("");
        chSemFiltro.setSelected(true);
        btBuscarMouseClicked(evt);
    }//GEN-LAST:event_btLimparMouseClicked

    private void btInserirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btInserirMouseClicked
        InsereMedicamento insere = new InsereMedicamento();
        insere.setVisible(true);
    }//GEN-LAST:event_btInserirMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        search();
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(BuscaMedicamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new BuscaMedicamento().setVisible(true);
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btInserir;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btVoltar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chID;
    private javax.swing.JCheckBox chPrincipio_Ativo;
    private javax.swing.JCheckBox chSemFiltro;
    private javax.swing.JTextField edID;
    private javax.swing.JTextField edPrincipio_Ativo;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbErro;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
