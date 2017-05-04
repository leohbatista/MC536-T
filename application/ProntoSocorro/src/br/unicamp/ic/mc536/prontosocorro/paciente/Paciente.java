
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unicamp.ic.mc536.prontosocorro.paciente;

import br.unicamp.ic.mc536.prontosocorro.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class Paciente {
    
    private int CPF;
    private String nome;
    private String endereco;
    private String telefone;
   
    private Database d;

    public Paciente(int CPF, String nome, String endereco, String telefone) {
        this.CPF = CPF;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        d.conecta();
    }

    /*

    public boolean novo() {               
        String query;        
        query = "INSERT INTO medico (CRM, nome, especialidade) VALUES ("
                + this.CRM + ",'" + this.nome + "','" + this.especialidade + "');";      
        
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
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }*/

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
    /*public static boolean verificaExclusao(int crm){
        ResultSet rs = consultar(crm+"",(short)1);
        try {
            return !rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;       
    }*/
    

}

