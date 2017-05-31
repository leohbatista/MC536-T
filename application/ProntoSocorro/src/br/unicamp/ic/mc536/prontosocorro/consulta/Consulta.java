
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unicamp.ic.mc536.prontosocorro.consulta;

import br.unicamp.ic.mc536.prontosocorro.Database;
import br.unicamp.ic.mc536.prontosocorro.diagnostico.Diagnostico;
import br.unicamp.ic.mc536.prontosocorro.prescricao.Prescricao;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class Consulta {
    
    private int CRM;
    private String CPF;
    private Date data;
    private Time hora;
    private String diagnostico;
    private String sintomas;
    private String observacoes;
    private ArrayList<String> listaDiagnosticos; 
    private ArrayList<Prescricao> listaPrescricao; 
   
    private Database d;

    public Consulta(int CRM, String nome, String especialidade) {
        
        d = new Database();
        d.conecta();   
    }

    public boolean novo() {               
        String query;        
        boolean flag = false;
        query = "INSERT INTO consulta (medico, paciente, data, hora, "
                + "diagnostico, sintomas, observacoes) VALUES ("
                + this.CRM + ","
                + "'" + this.CPF + "',"
                + "'" + this.data + "'"
                + "'" + this.hora + "',"
                + "'" + this.diagnostico + "',"
                + "'" + this.sintomas + "',"
                + "'" + this.observacoes + "',"
                + ");";      
        
        flag = d.insere(query);
        
        if (flag) {
            Diagnostico d;          
            for (String diag : listaDiagnosticos) {
                d = new Diagnostico(this.CRM, this.CPF, this.data, this.hora, diag);
                d.novo();
            }
            for (Prescricao presc : listaPrescricao) {
                presc.setCPF(CPF);
                presc.setCRM(CRM);
                presc.setData(data);
                presc.setHora(hora);
                presc.novo();
            }
        }
        
        return flag;
    }
    
    public boolean alterar() {
        String query;       
        query = "UPDATE consulta SET "
                + "diagnostico='" + this.diagnostico + "',"
                + "sintomas='" + this.sintomas + "',"
                + "observacoes='" + this.observacoes + "'"
                + " WHERE crm=" + this.CRM 
                + " and paciente='" + this.CPF +"'"
                + " and data='" + this.data +"'"
                + " and hora='" + this.hora +"'";
     
        return d.atualiza(query); 
    }  
    
    public boolean excluir() {
        String query;       
        query = "DELETE FROM consulta WHERE crm=" + this.CRM 
                + " and paciente='" + this.CPF +"'"
                + " and data='" + this.data +"'"
                + " and hora='" + this.hora +"'";               
     
        return d.remove(query); 
    }

    public static ResultSet consultar(String valor, short campo) {
        String query;
        switch(campo){
            case 1:     // O filtro é o campo 
                query= "SELECT * FROM consulta WHERE medico=" + valor + ";";
                break;
            case 2:     // O filtro é o campo 
                query= "SELECT * FROM consulta WHERE paciente='" + valor + "%';";
                break;
            case 3:     // O filtro é o campo 
                query= "SELECT * FROM consulta WHERE data='" + valor + "';";
                break;
            default: 
                query = "SELECT * FROM consulta;";
                break;
        }
            
        Database d = new Database();
        d.conecta();
        return d.consulta(query);
    }

    public static ResultSet consultar(String valor1, String valor2) {
        String query;
        query= "SELECT * FROM consulta WHERE medico=" + valor1
                + " and paciente='" + valor2 + "';";                
            
        Database d = new Database();
        d.conecta();
        return d.consulta(query);
    }  
    
    public static ResultSet consultar(String valor1, String valor2, String valor3, String valor4) {
        String query;
        
        query= "SELECT * FROM consulta WHERE medico=" + valor1
                + " and paciente='" + valor2 + "'"
                +" and data='" + valor2 + "'"
                +" and hora='" + valor2 + "'"
                + ";";
            
        Database d = new Database();
        d.conecta();
        return d.consulta(query);
    } 

    public int getCRM() {
        return CRM;
    }

    public void setCRM(int CRM) {
        this.CRM = CRM;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public ArrayList<String> getListaDiagnosticos() {
        ResultSet rs = Diagnostico.consultar(""+this.CRM,this.CPF,this.data,this.hora);
        String d;
        try {
            while(rs.next()) {
                d = rs.getString("doenca");
                listaDiagnosticos.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        return listaDiagnosticos;
    }

    public void setListaDiagnosticos(ArrayList<String> listaDiagnosticos) {                      
        this.listaDiagnosticos = listaDiagnosticos;
    }

    public ArrayList<Prescricao> getListaPrescricao() {
        ResultSet rs = Prescricao.consultar(""+this.CRM,this.CPF,this.data,this.hora);
        Prescricao p;
        try {
            while(rs.next()) {
                p = new Prescricao(
                    rs.getInt("medico"),
                    rs.getString("paciente"),
                    rs.getDate("data"),
                    rs.getTime("hora"),
                    rs.getInt("medicamento"),
                    rs.getString("posologia"));
                listaPrescricao.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return listaPrescricao;
    }

    public void setListaPrescricao(ArrayList<Prescricao> listaPrescricao) {
        this.listaPrescricao = listaPrescricao;
    }
    
    
}