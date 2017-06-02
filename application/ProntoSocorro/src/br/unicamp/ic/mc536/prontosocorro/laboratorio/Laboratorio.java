/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicamp.ic.mc536.prontosocorro.laboratorio;

import br.unicamp.ic.mc536.prontosocorro.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author filipe
 */
public class Laboratorio {
    private int nRegistro;
    private String nome;
    private String telefone;
    private String tipo;
    private String responsavel;
    private Database d;
        
    public Laboratorio(int nRegistro, String nome, String telefone, String tipo, String responsavel) {
        this.nRegistro = nRegistro;
        this.nome = nome;
        this.telefone = telefone;
        this.tipo = tipo;
        this.responsavel = responsavel;
        d = new Database();
        d.conecta();
    }
    
    public boolean novo() {               
        String query;        
        query = "INSERT INTO laboratorio (nregistro, nome, telefone, tipo, responsavel) VALUES ("
                + this.nRegistro + ",'" + this.nome + "','" + this.telefone + "','" + this.tipo
                + "','" + this.responsavel + "');";      
        
        return d.insere(query);
    }
    
    public boolean alterar() {
        String query;       
        query = "UPDATE laboratorio SET "
                + "nome='" + this.nome + "',"
                + "telefone='" + this.telefone + "',"
                + "tipo='" + this.tipo + "',"
                + "responsavel='" + this.responsavel + "' "
                + "where nRegistro='" + this.nRegistro + "';";
     
        return d.atualiza(query); 
    }  
    
    public boolean excluir() {
        String query;       
        query = "DELETE FROM laboratorio WHERE nRegistro='" + this.nRegistro + "';";               
     
        return d.remove(query); 
    }
    
    public static ResultSet consultar(String valor, short campo) {
        String query;
        switch(campo){
            case 1:     // o filtro é o nRegistro
                query= "SELECT * FROM laboratorio WHERE nRegistro LIKE '" + valor + "%';";
                break;
            case 2:     // O filtro é o campo Nome
                query= "SELECT * FROM laboratorio WHERE nome LIKE '" + valor + "%';";
                break;
            case 3:     // O filtro é o campo Tipo
                query= "SELECT * FROM laboratorio WHERE tipo LIKE '" + valor + "%';";
                break;

            default: 
                query = "SELECT * FROM laboratorio;";
                break;
        }
            
        Database d = new Database();
        d.conecta();
        return d.consulta(query);
    }
    
    public static boolean verificaExclusao(int nRegistro){
        ResultSet rs = consultar(""+nRegistro,(short)1);
        try {
            return !rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Laboratorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;       
    }

    public int getnRegistro() {
        return nRegistro;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getTipo() {
        return tipo;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setnRegistro(int nRegistro) {
        this.nRegistro = nRegistro;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    
}
