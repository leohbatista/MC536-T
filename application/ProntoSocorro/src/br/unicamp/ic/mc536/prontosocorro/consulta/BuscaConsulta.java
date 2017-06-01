/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unicamp.ic.mc536.prontosocorro.consulta;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Administrador
 */
public class BuscaConsulta extends javax.swing.JFrame {

    /**
     * Creates new form ConsFuncionario
     */
    public BuscaConsulta() {
        initComponents();
    }
    
    private void search() {
        if (chSemFiltro.isSelected()){
            atualizaTabela(Consulta.consultar());
            lbErro.setText("");
        } else if(chMedico.isSelected()) {
            try {
                int crm = Integer.parseInt(edMedico.getText());
                atualizaTabela(Consulta.consultar(""+crm,(short)1));
                lbErro.setText("");
            } catch (NumberFormatException e) {
                lbErro.setText("O CRM do médico deve ser um valor numérico!");
            }
        } else if(chPaciente.isSelected()) {
            try {
                int cpf = Integer.parseInt(edMedico.getText());
                atualizaTabela(Consulta.consultar(""+cpf,(short)2));
                lbErro.setText("");
            } catch (NumberFormatException e) {
                lbErro.setText("O CPF do paciente deve ser somente os números!");
            }
        } else if(chData.isSelected()) {
            try {
                int ano = Integer.parseInt(edAno.getText());
                int mes = Integer.parseInt(edMes.getText());
                int dia = Integer.parseInt(edDia.getText());
                
                
                
                String data = ano + "-" + mes + "-" + dia;
                atualizaTabela(Consulta.consultar(data,(short)3));
                lbErro.setText("");
            } catch (NumberFormatException e) {
                lbErro.setText("Data inválida!");
            }
        } else if(chDataHora.isSelected()) {
            try {
                int ano = Integer.parseInt(edAno.getText());
                int mes = Integer.parseInt(edMes.getText());
                int dia = Integer.parseInt(edDia.getText());
                
                int hora = Integer.parseInt(edHora.getText());
                int minuto = Integer.parseInt(edMinuto.getText());
                
                if (!Consulta.validaData(dia,mes,ano) || 
                       !Consulta.validaHora(hora, minuto)) {
                    throw new InvalidDateTimeException();
                }
                
                String data = ""+ano;
                if (mes > 0 && mes < 10) {
                    data += "-0" + mes;
                } else {
                    data += "-" + mes;
                }
                
                if (dia > 0 && dia < 10) {
                    data += "-0" + dia;
                } else {
                    data += "-" + dia;
                }
                
                String horario = "";
                if (hora >= 0 && hora < 10) {
                    horario += "0" + hora + ":";
                } else {
                    horario += hora + ":";
                }
                
                if (minuto >= 0 && minuto < 10) {
                    horario += "0" + minuto + ":";
                } else {
                    horario += minuto + ":";
                }
                horario += "00";
                               
                atualizaTabela(Consulta.consultar(data,horario,(short)2));
                lbErro.setText("");
            } catch (NumberFormatException | InvalidDateTimeException e) {
                lbErro.setText("Data e/ou hora inválidas!");
            }
        }
    }
    
    protected void atualizaTabela(ResultSet rs){
        DefaultTableModel modelotabela = (DefaultTableModel) tabela.getModel();
        modelotabela.setColumnCount(6);
        modelotabela.setRowCount(0);

        tabela.getColumnModel().getColumn(0).setHeaderValue("CRM");
        tabela.getColumnModel().getColumn(1).setHeaderValue("Médico");
        tabela.getColumnModel().getColumn(2).setHeaderValue("CPF");
        tabela.getColumnModel().getColumn(3).setHeaderValue("Paciente");
        tabela.getColumnModel().getColumn(4).setHeaderValue("Data");
        tabela.getColumnModel().getColumn(5).setHeaderValue("Hora");
        int linha = 0;
        try{
            if(rs != null) {  
                while(rs.next()){
                      modelotabela.addRow(new String[modelotabela.getColumnCount()]);
                      modelotabela.setValueAt(rs.getString("medico"), linha, 0);
                      modelotabela.setValueAt(rs.getString("nmedico"), linha, 1);
                      modelotabela.setValueAt(rs.getString("paciente"), linha, 2);
                      modelotabela.setValueAt(rs.getString("npaciente"), linha, 0);
                      modelotabela.setValueAt(rs.getString("data"), linha, 0);
                      modelotabela.setValueAt(rs.getString("hora"), linha, 0);
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
        edMedico = new javax.swing.JTextField();
        edPaciente = new javax.swing.JTextField();
        edMinuto = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        chSemFiltro = new javax.swing.JCheckBox();
        chPaciente = new javax.swing.JCheckBox();
        chDataHora = new javax.swing.JCheckBox();
        chMedico = new javax.swing.JCheckBox();
        btLimpar = new javax.swing.JButton();
        chData = new javax.swing.JCheckBox();
        edAno = new javax.swing.JTextField();
        edHora = new javax.swing.JTextField();
        edDia = new javax.swing.JTextField();
        edMes = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        lbErro = new javax.swing.JLabel();
        btInserir = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        btVisualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Busca de Médicos");
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
        jLabel5.setText("Busca de Consultas");
        jPanel5.add(jLabel5);
        jLabel5.setBounds(0, 20, 850, 30);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Filtros de busca:");
        jPanel6.add(jLabel6);
        jLabel6.setBounds(40, 10, 140, 20);

        edMedico.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edMedico.setEnabled(false);
        jPanel6.add(edMedico);
        edMedico.setBounds(140, 40, 150, 25);

        edPaciente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edPaciente.setEnabled(false);
        jPanel6.add(edPaciente);
        edPaciente.setBounds(140, 70, 150, 25);

        edMinuto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edMinuto.setEnabled(false);
        jPanel6.add(edMinuto);
        edMinuto.setBounds(210, 130, 50, 25);

        btBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btBuscar.setText("BUSCAR");
        btBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btBuscarMouseClicked(evt);
            }
        });
        jPanel6.add(btBuscar);
        btBuscar.setBounds(700, 80, 100, 50);

        buttonGroup1.add(chSemFiltro);
        chSemFiltro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chSemFiltro.setSelected(true);
        chSemFiltro.setText("Sem Filtro");
        jPanel6.add(chSemFiltro);
        chSemFiltro.setBounds(590, 40, 97, 30);

        buttonGroup1.add(chPaciente);
        chPaciente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chPaciente.setText("Paciente (CPF)");
        chPaciente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chPacienteItemStateChanged(evt);
            }
        });
        jPanel6.add(chPaciente);
        chPaciente.setBounds(10, 70, 120, 24);

        buttonGroup1.add(chDataHora);
        chDataHora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chDataHora.setText("Hora");
        chDataHora.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chDataHoraItemStateChanged(evt);
            }
        });
        jPanel6.add(chDataHora);
        chDataHora.setBounds(10, 130, 110, 24);

        buttonGroup1.add(chMedico);
        chMedico.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chMedico.setText("Médico (CRM)");
        chMedico.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chMedicoItemStateChanged(evt);
            }
        });
        jPanel6.add(chMedico);
        chMedico.setBounds(10, 40, 120, 24);

        btLimpar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btLimpar.setText("Limpar");
        btLimpar.setToolTipText("");
        btLimpar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btLimparMouseClicked(evt);
            }
        });
        jPanel6.add(btLimpar);
        btLimpar.setBounds(700, 40, 100, 30);

        buttonGroup1.add(chData);
        chData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chData.setText("Data");
        chData.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chDataItemStateChanged(evt);
            }
        });
        jPanel6.add(chData);
        chData.setBounds(10, 100, 110, 24);

        edAno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edAno.setEnabled(false);
        jPanel6.add(edAno);
        edAno.setBounds(280, 100, 50, 25);

        edHora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edHora.setEnabled(false);
        jPanel6.add(edHora);
        edHora.setBounds(140, 130, 50, 25);

        edDia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edDia.setEnabled(false);
        jPanel6.add(edDia);
        edDia.setBounds(140, 100, 50, 25);

        edMes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edMes.setEnabled(false);
        jPanel6.add(edMes);
        edMes.setBounds(210, 100, 50, 25);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("/");
        jPanel6.add(jLabel15);
        jLabel15.setBounds(200, 100, 10, 20);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText(":");
        jPanel6.add(jLabel14);
        jLabel14.setBounds(200, 130, 10, 20);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("/");
        jPanel6.add(jLabel16);
        jLabel16.setBounds(270, 100, 10, 20);

        jPanel5.add(jPanel6);
        jPanel6.setBounds(20, 60, 810, 180);

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
        jScrollPane1.setBounds(20, 250, 810, 350);

        lbErro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbErro.setForeground(new java.awt.Color(255, 0, 51));
        lbErro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbErro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel5.add(lbErro);
        lbErro.setBounds(20, 610, 450, 30);

        btInserir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btInserir.setText("INSERIR");
        btInserir.setToolTipText("");
        btInserir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btInserirMouseClicked(evt);
            }
        });
        jPanel5.add(btInserir);
        btInserir.setBounds(20, 650, 110, 40);

        btVoltar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btVoltar.setText("VOLTAR");
        btVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btVoltarMouseClicked(evt);
            }
        });
        jPanel5.add(btVoltar);
        btVoltar.setBounds(730, 650, 100, 40);

        btVisualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btVisualizar.setText("VISUALIZAR");
        btVisualizar.setToolTipText("");
        btVisualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btVisualizarMouseClicked(evt);
            }
        });
        jPanel5.add(btVisualizar);
        btVisualizar.setBounds(140, 650, 140, 40);

        getContentPane().add(jPanel5);
        jPanel5.setBounds(0, 0, 850, 700);

        setSize(new java.awt.Dimension(866, 743));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btBuscarMouseClicked
        search();
    }//GEN-LAST:event_btBuscarMouseClicked

    private void chPacienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chPacienteItemStateChanged
        edPaciente.setEnabled(chPaciente.isSelected());
    }//GEN-LAST:event_chPacienteItemStateChanged

    private void chDataHoraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chDataHoraItemStateChanged
        edHora.setEnabled(chDataHora.isSelected());
        edMinuto.setEnabled(chDataHora.isSelected());
        
        edDia.setEnabled(chDataHora.isSelected());
        edMes.setEnabled(chDataHora.isSelected());
        edAno.setEnabled(chDataHora.isSelected());
    }//GEN-LAST:event_chDataHoraItemStateChanged

    private void chMedicoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chMedicoItemStateChanged
        edMedico.setEnabled(chMedico.isSelected());
    }//GEN-LAST:event_chMedicoItemStateChanged
 
    private void btLimparMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btLimparMouseClicked
        edMedico.setText("");
        edPaciente.setText("");
        edHora.setText("");
        edMinuto.setText("");        
        edDia.setText("");
        edMes.setText("");
        edAno.setText("");
        chSemFiltro.setSelected(true);
        btBuscarMouseClicked(evt);
    }//GEN-LAST:event_btLimparMouseClicked

    private void btInserirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btInserirMouseClicked
        InsereConsulta insere = new InsereConsulta();
        insere.setVisible(true);
    }//GEN-LAST:event_btInserirMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        search();
    }//GEN-LAST:event_formWindowActivated

    private void btVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btVoltarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btVoltarMouseClicked

    private void btVisualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btVisualizarMouseClicked
        if(tabela.getSelectedRowCount() != 0){
            int crm = Integer.parseInt(tabela.getValueAt(tabela.getSelectedRow(),0).toString());
            String cpf = tabela.getValueAt(tabela.getSelectedRow(),2).toString();
            String data = tabela.getValueAt(tabela.getSelectedRow(),4).toString();
            String hora = tabela.getValueAt(tabela.getSelectedRow(),5).toString();
            
            Consulta consulta = new Consulta(crm, cpf, Date.valueOf(""), Time.valueOf(hora), "", "", "");
            consulta.setDataConvertida(data);
            
            ResultSet rs = Consulta.consultar(""+crm,cpf,
                    consulta.getData().toString(),consulta.getHora().toString());
            try {
                lbErro.setText("");
                rs.next();
                consulta.setDiagnostico(rs.getString("diagnostico"));
                consulta.setSintomas(rs.getString("sintomas"));
                consulta.setObservacoes(rs.getString("observacoes"));
                consulta.getListaDiagnosticosSelect();
                consulta.getListaPrescricaoSelect();
                InsereConsulta view = new InsereConsulta(consulta);
                view.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(BuscaConsulta.class.getName()).log(Level.SEVERE, null, ex);
            }   
        } else {
            lbErro.setText("Selecione uma linha para alterar");
        }
    }//GEN-LAST:event_btVisualizarMouseClicked

    private void chDataItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chDataItemStateChanged
        edDia.setEnabled(chData.isSelected());
        edMes.setEnabled(chData.isSelected());
        edAno.setEnabled(chData.isSelected());
    }//GEN-LAST:event_chDataItemStateChanged

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
            java.util.logging.Logger.getLogger(BuscaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new BuscaConsulta().setVisible(true);
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btInserir;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btVisualizar;
    private javax.swing.JButton btVoltar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chData;
    private javax.swing.JCheckBox chDataHora;
    private javax.swing.JCheckBox chMedico;
    private javax.swing.JCheckBox chPaciente;
    private javax.swing.JCheckBox chSemFiltro;
    private javax.swing.JTextField edAno;
    private javax.swing.JTextField edDia;
    private javax.swing.JTextField edHora;
    private javax.swing.JTextField edMedico;
    private javax.swing.JTextField edMes;
    private javax.swing.JTextField edMinuto;
    private javax.swing.JTextField edPaciente;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbErro;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

    private static class InvalidDateTimeException extends Exception {

        public InvalidDateTimeException() {
        }
    }
}
