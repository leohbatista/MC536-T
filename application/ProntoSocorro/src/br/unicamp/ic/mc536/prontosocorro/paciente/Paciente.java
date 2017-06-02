
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
    
    private String CPF;
    private String nome;
    private String endereco;
    private String telefone;
   
    private Database d;

    public Paciente(String CPF, String nome, String endereco, String telefone) {
        this.CPF = CPF;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        d = new Database();
        d.conecta();
    }

   

    public boolean novo() {               
        String query;        
        query = "INSERT INTO paciente (cpf, nome, endereco, telefone) VALUES ("
                + this.CPF + ",'" + this.nome + "','" + this.endereco + "','" + this.telefone + "');";      
        
        return d.insere(query);
    }
    
    public boolean alterar() {
        String query;       
        query = "UPDATE paciente SET "
                + "nome='" + this.nome + "',"
                + "endereco='" + this.endereco + "',"
                + "telefone='" + this.telefone + "' "
                + "where cpf='" + this.CPF + "';";
     
        return d.atualiza(query); 
    }  
    
    public boolean excluir() {
        String query;       
        query = "DELETE FROM paciente WHERE cpf='" + this.CPF + "';";               
     
        return d.remove(query); 
    }

    public static ResultSet consultar(String valor, short campo) {
        String query;
        switch(campo){
            case 1:     // o filtro é o CPF
                query= "SELECT * FROM paciente WHERE cpf LIKE '" + valor + "%';";
                break;
            case 2:     // O filtro é o campo Nome
                query= "SELECT * FROM paciente WHERE nome LIKE '" + valor + "%';";
                break;
            default: 
                query = "SELECT * FROM paciente;";
                break;
        }
            
        Database d = new Database();
        d.conecta();
        return d.consulta(query);
    }    
    
    public static boolean verificaCPF(String CPF){
        Database d = new Database();
        d.conecta();
        ResultSet rs = d.consulta("SELECT count(*) AS n FROM paciente WHERE cpf='" + CPF +"';");
        try {
            rs.next();
            if(rs.getInt(1) > 0){
                return true;       
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
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

    
    public static boolean verificaExclusao(String cpf){
        ResultSet rs = consultar(cpf+"",(short)1);
        try {
            return !rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;       
    }
    

}

