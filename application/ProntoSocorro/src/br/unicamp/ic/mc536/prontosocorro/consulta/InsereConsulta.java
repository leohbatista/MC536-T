package br.unicamp.ic.mc536.prontosocorro.consulta;

import br.unicamp.ic.mc536.prontosocorro.doenca.GetDoenca;
import br.unicamp.ic.mc536.prontosocorro.medicamento.GetMedicamento;
import br.unicamp.ic.mc536.prontosocorro.prescricao.Prescricao;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
public class InsereConsulta extends javax.swing.JFrame {

    /**
     * Creates new form CadastroClienteFisica
     */
    
    private boolean flagView;
    private Consulta consulta;
    
    public InsereConsulta() {
        initComponents();
        flagView = false;
        consulta = new Consulta();
        atualizaTabelaDiagnostico();
        atualizaTabelaPrescricao();
    }
    
    public InsereConsulta(Consulta c) {
        initComponents();
        consulta = c;
        flagView = true;
        inicializaCampos();
        atualizaTabelaDiagnostico();
        atualizaTabelaPrescricao();
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
        edMinuto = new javax.swing.JTextField();
        btConfirma = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        lbErro = new javax.swing.JLabel();
        edMedico = new javax.swing.JTextField();
        edDia = new javax.swing.JTextField();
        edMes = new javax.swing.JTextField();
        edAno = new javax.swing.JTextField();
        edHora = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taObservacoes = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        taDiagnostico = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        taSintomas = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        btPaciente = new javax.swing.JButton();
        btDelDiagnostico = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbPrescricao = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbDiagnostico = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btMedico = new javax.swing.JButton();
        btAddDiagnostico = new javax.swing.JButton();
        btAddPrescricao = new javax.swing.JButton();
        btDelPrescrição = new javax.swing.JButton();
        lbPaciente = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbMedico = new javax.swing.JLabel();
        edPaciente = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Médicos");
        setName("janela"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Registro de Consultas:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 20, 1020, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("* Paciente");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 110, 80, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("* Hora:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(760, 110, 60, 20);

        edMinuto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(edMinuto);
        edMinuto.setBounds(880, 110, 40, 23);

        btConfirma.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btConfirma.setText("CONFIRMA");
        btConfirma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btConfirmaMouseClicked(evt);
            }
        });
        jPanel1.add(btConfirma);
        btConfirma.setBounds(400, 730, 120, 40);

        btVoltar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btVoltar.setText("VOLTAR");
        btVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btVoltarMouseClicked(evt);
            }
        });
        jPanel1.add(btVoltar);
        btVoltar.setBounds(530, 730, 120, 40);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("* Campo Obrigatório");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(840, 690, 150, 17);

        lbErro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbErro.setForeground(new java.awt.Color(255, 0, 51));
        lbErro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbErro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lbErro);
        lbErro.setBounds(30, 690, 360, 30);

        edMedico.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(edMedico);
        edMedico.setBounds(100, 80, 140, 23);

        edDia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(edDia);
        edDia.setBounds(820, 80, 40, 23);

        edMes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(edMes);
        edMes.setBounds(880, 80, 40, 23);

        edAno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(edAno);
        edAno.setBounds(940, 80, 50, 23);

        edHora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(edHora);
        edHora.setBounds(820, 110, 40, 23);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("* Médico:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 80, 60, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("/");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(930, 80, 10, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Observações:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(680, 160, 100, 20);

        taObservacoes.setColumns(20);
        taObservacoes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        taObservacoes.setLineWrap(true);
        taObservacoes.setRows(5);
        jScrollPane1.setViewportView(taObservacoes);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(680, 190, 310, 160);

        taDiagnostico.setColumns(20);
        taDiagnostico.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        taDiagnostico.setLineWrap(true);
        taDiagnostico.setRows(5);
        jScrollPane2.setViewportView(taDiagnostico);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(350, 190, 310, 160);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Diagnóstico:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(350, 160, 80, 20);

        taSintomas.setColumns(20);
        taSintomas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        taSintomas.setLineWrap(true);
        taSintomas.setRows(5);
        jScrollPane3.setViewportView(taSintomas);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(20, 190, 310, 160);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Prescrição:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(310, 370, 160, 30);

        btPaciente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btPaciente.setText("Selecionar");
        btPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btPacienteMouseClicked(evt);
            }
        });
        jPanel1.add(btPaciente);
        btPaciente.setBounds(250, 110, 110, 30);

        btDelDiagnostico.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btDelDiagnostico.setText("Remover");
        btDelDiagnostico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btDelDiagnosticoMouseClicked(evt);
            }
        });
        jPanel1.add(btDelDiagnostico);
        btDelDiagnostico.setBounds(140, 400, 110, 30);

        tbPrescricao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tbPrescricao);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(300, 440, 690, 230);

        tbDiagnostico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tbDiagnostico);

        jPanel1.add(jScrollPane5);
        jScrollPane5.setBounds(30, 440, 230, 230);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Sintomas:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(20, 160, 80, 20);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Doenças Diagnosticadas:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(40, 370, 160, 30);

        btMedico.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btMedico.setText("Selecionar");
        btMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btMedicoMouseClicked(evt);
            }
        });
        jPanel1.add(btMedico);
        btMedico.setBounds(250, 80, 110, 30);

        btAddDiagnostico.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btAddDiagnostico.setText("Adicionar");
        btAddDiagnostico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAddDiagnosticoMouseClicked(evt);
            }
        });
        jPanel1.add(btAddDiagnostico);
        btAddDiagnostico.setBounds(30, 400, 110, 30);

        btAddPrescricao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btAddPrescricao.setText("Adicionar");
        btAddPrescricao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAddPrescricaoMouseClicked(evt);
            }
        });
        jPanel1.add(btAddPrescricao);
        btAddPrescricao.setBounds(310, 400, 110, 30);

        btDelPrescrição.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btDelPrescrição.setText("Remover");
        btDelPrescrição.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btDelPrescriçãoMouseClicked(evt);
            }
        });
        jPanel1.add(btDelPrescrição);
        btDelPrescrição.setBounds(420, 400, 110, 30);

        lbPaciente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(lbPaciente);
        lbPaciente.setBounds(370, 110, 370, 20);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText(":");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(870, 110, 10, 20);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("/");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(870, 80, 10, 20);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("* Data:");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(760, 80, 60, 20);

        lbMedico.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(lbMedico);
        lbMedico.setBounds(370, 80, 370, 20);

        try {
            edPaciente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edPaciente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(edPaciente);
        edPaciente.setBounds(100, 110, 140, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1020, 780);

        setSize(new java.awt.Dimension(1037, 816));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btVoltarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btVoltarMouseClicked

    private void btConfirmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btConfirmaMouseClicked
                        
        try {
            int medico = Integer.parseInt(edMedico.getText().trim());
            String paciente = edPaciente.getText().trim();
            int ano,mes,dia,hora,minuto;                        
            
            ano = Integer.parseInt(edAno.getText());
            mes = Integer.parseInt(edMes.getText());
            dia = Integer.parseInt(edDia.getText());
            hora = Integer.parseInt(edHora.getText());
            minuto = Integer.parseInt(edMinuto.getText());
            
            if(medico == 0) {
                lbErro.setText("Selecione um médico");
            } else if (paciente.equals("")) {
                lbErro.setText("Selecione um paciente");
            } else if (!Consulta.validaData(dia,mes,ano)) {                   
                lbErro.setText("Data Inválida");
            } else if (!Consulta.validaHora(hora,minuto) 
                    || edHora.getText().equals("")|| edMinuto.getText().equals("")) {                   
                lbErro.setText("Hora Inválida");
            } else {
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
                
                Consulta c = new Consulta(medico, paciente, Date.valueOf(data), Time.valueOf(horario),
                        taDiagnostico.getText(), taSintomas.getText(),taObservacoes.getText()); 
                c.setListaDiagnosticos(consulta.getListaDiagnosticos());
                c.setListaPrescricao(consulta.getListaPrescricao());
                c.novo();
                JOptionPane.showMessageDialog(this, "Cadastrado com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                              
                this.dispose();
            }
        } catch (NumberFormatException e) {
            lbErro.setText("Data e hora precisam ser numéricos");
        }
    }//GEN-LAST:event_btConfirmaMouseClicked

    private void btPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPacienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btPacienteMouseClicked

    private void btDelDiagnosticoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDelDiagnosticoMouseClicked
        int d = tbDiagnostico.getSelectedRow();
        this.consulta.getListaDiagnosticos().remove(d);
        atualizaTabelaDiagnostico();
    }//GEN-LAST:event_btDelDiagnosticoMouseClicked

    private void btMedicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btMedicoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btMedicoMouseClicked

    private void btAddDiagnosticoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddDiagnosticoMouseClicked
        GetDoenca doenca = new GetDoenca(this);
        doenca.setVisible(true);
    }//GEN-LAST:event_btAddDiagnosticoMouseClicked

    private void btAddPrescricaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddPrescricaoMouseClicked
        GetMedicamento med = new GetMedicamento(this);
        med.setVisible(true);        
    }//GEN-LAST:event_btAddPrescricaoMouseClicked

    private void btDelPrescriçãoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDelPrescriçãoMouseClicked
        int p = tbPrescricao.getSelectedRow();
        this.consulta.getListaPrescricao().remove(p);
        atualizaTabelaPrescricao();
    }//GEN-LAST:event_btDelPrescriçãoMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        atualizaTabelaPrescricao();
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(InsereConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new InsereConsulta().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddDiagnostico;
    private javax.swing.JButton btAddPrescricao;
    private javax.swing.JButton btConfirma;
    private javax.swing.JButton btDelDiagnostico;
    private javax.swing.JButton btDelPrescrição;
    private javax.swing.JButton btMedico;
    private javax.swing.JButton btPaciente;
    private javax.swing.JButton btVoltar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField edAno;
    private javax.swing.JTextField edDia;
    private javax.swing.JTextField edHora;
    private javax.swing.JTextField edMedico;
    private javax.swing.JTextField edMes;
    private javax.swing.JTextField edMinuto;
    private javax.swing.JFormattedTextField edPaciente;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lbErro;
    private javax.swing.JLabel lbMedico;
    private javax.swing.JLabel lbPaciente;
    private javax.swing.JTextArea taDiagnostico;
    private javax.swing.JTextArea taObservacoes;
    private javax.swing.JTextArea taSintomas;
    private javax.swing.JTable tbDiagnostico;
    private javax.swing.JTable tbPrescricao;
    // End of variables declaration//GEN-END:variables
    
    private void inicializaCampos() {
        edMedico.setEditable(false);
        edPaciente.setEditable(false);
        edDia.setEditable(false);
        edMes.setEditable(false);
        edAno.setEditable(false);
        edHora.setEditable(false);
        edMinuto.setEditable(false);
        taDiagnostico.setEditable(false);
        taObservacoes.setEditable(false);
        taSintomas.setEditable(false);
        btMedico.setEnabled(false);
        btPaciente.setEnabled(false);
        tbDiagnostico.setEnabled(false);
        tbPrescricao.setEnabled(false);
        btAddDiagnostico.setEnabled(false);
        btAddPrescricao.setEnabled(false);
        btDelDiagnostico.setEnabled(false);
        btDelPrescrição.setEnabled(false);
        btConfirma.setEnabled(false);
        
        
        edMedico.setText(""+consulta.getCRM());
        edPaciente.setText(consulta.getCPF());
        
        String [] data = consulta.getData().toString().split("-");
        String [] hora = consulta.getHora().toString().split(":");
        edAno.setText(data[0]);
        edMes.setText(data[1]);
        edDia.setText(data[2]);
        edHora.setText(hora[0]);
        edMinuto.setText(hora[1]);
        
        taDiagnostico.setText(consulta.getDiagnostico());
        taSintomas.setText(consulta.getSintomas());
        taObservacoes.setText(consulta.getObservacoes());
    }
    
    public void atualizaTabelaDiagnostico(){
        DefaultTableModel modelotabela = (DefaultTableModel) tbDiagnostico.getModel();
        modelotabela.setColumnCount(1);
        modelotabela.setRowCount(0);

        tbDiagnostico.getColumnModel().getColumn(0).setHeaderValue("CID");
        int linha = 0;
        
        ArrayList<String> diag = consulta.getListaDiagnosticos();
        for (Iterator iterator = diag.iterator(); iterator.hasNext(); linha++) {
            String next = (String) iterator.next();
            modelotabela.addRow(new String[modelotabela.getColumnCount()]);
            modelotabela.setValueAt(next, linha, 0);                     
        }                                
    }
    
    public void atualizaTabelaPrescricao(){
        DefaultTableModel modelotabela = (DefaultTableModel) tbPrescricao.getModel();
        modelotabela.setColumnCount(3);
        modelotabela.setRowCount(0);

        tbPrescricao.getColumnModel().getColumn(0).setHeaderValue("Princípio Ativo");
        tbPrescricao.getColumnModel().getColumn(1).setHeaderValue("Dosagem");
        tbPrescricao.getColumnModel().getColumn(2).setHeaderValue("Posologia");
        int linha = 0;
        
       
        ArrayList<Prescricao> diag = consulta.getListaPrescricao();        
        for (Iterator iterator = diag.iterator(); iterator.hasNext(); linha++) {
            Prescricao next = (Prescricao) iterator.next();
            modelotabela.addRow(new String[modelotabela.getColumnCount()]);
            modelotabela.setValueAt(next.getMedicamento().getPrincipio_ativo(), linha, 0);                     
            modelotabela.setValueAt(next.getMedicamento().getDosagem(), linha, 1);
            modelotabela.setValueAt(next.getPosologia(), linha, 2);            
        }
       
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }        
}
