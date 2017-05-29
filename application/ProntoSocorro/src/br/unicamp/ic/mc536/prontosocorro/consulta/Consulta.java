
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
import java.sql.Time;
import java.util.ArrayList;

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
}
