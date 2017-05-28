
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unicamp.ic.mc536.prontosocorro.consulta;

import br.unicamp.ic.mc536.prontosocorro.Database;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
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
    private ArrayList<Diagnostico> listaDiagnosticos; 
    private ArrayList<Prescricao> listaPrescricao; 
   
    private Database d;

    public Consulta(int CRM, String nome, String especialidade) {
        
        d = new Database();
        d.conecta();   
    }

    public boolean novo() {               
        String query;        
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
        
        return d.insere(query);
    }
    
    public boolean alterar() {
        String query;       
        query = "UPDATE medico SET "
                + "nome='" + this.nome + "',"
                + "especialidade='" + this.especialidade + "'"
                + " WHERE crm=" + this.CRM + ";";
     
        return d.atualiza(query); 
    }  
    
    public boolean excluir() {
        String query;       
        query = "DELETE FROM medico WHERE crm="+this.CRM+";";               
     
        return d.remove(query); 
    }

    public static ResultSet consultar(String valor, short campo) {
        String query;
        switch(campo){
            case 1:     // O filtro é o campo CRM
                query= "SELECT * FROM medico WHERE crm = " + valor + ";";
                break;
            case 2:     // O filtro é o campo Nome
                query= "SELECT * FROM medico WHERE nome LIKE '" + valor + "%';";
                break;
            case 3:     // O filtro é o campo Especialidade
                query= "SELECT * FROM medico WHERE especialidade LIKE '" + valor + "%';";
                break;
            default: 
                query = "SELECT * FROM medico;";
                break;
        }
            
        Database d = new Database();
        d.conecta();
        return d.consulta(query);
    }    
    
    public static boolean verificaCRM(String CRM){
        Database d = new Database();
        d.conecta();
        ResultSet rs = d.consulta("SELECT count(*) AS n FROM medico WHERE crm='" + CRM +"';");
        try {
            rs.next();
            if(rs.getInt(1) > 0){
                return true;       
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int getCRM() {
        return CRM;
    }

    public void setCRM(int CRM) {
        this.CRM = CRM;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
    public static boolean verificaExclusao(int crm){
        ResultSet rs = consultar(crm+"",(short)1);
        try {
            return !rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;       
    }
    

}

