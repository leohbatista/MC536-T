/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicamp.ic.mc536.prontosocorro.tratamento;
 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.unicamp.ic.mc536.prontosocorro.Database;
import java.sql.ResultSet;

/**
 *
 * @author Administrador
 */
public class Tratamento {
    
    private int medicamento;
    private String principioAtivo;
    private String doenca;
    private String descricao;
   
    private Database d;

    public Tratamento(int medicamento, String principioAtivo, String doenca, String descricao) {
        this.medicamento = medicamento;
        this.principioAtivo = principioAtivo;
        this.doenca = doenca;
        this.descricao = descricao;
        d = new Database();
        d.conecta();   
    }
    

    public boolean novo() {               
        String query;        
        query = "INSERT INTO tratamento (medicamento, doenca, descricao) VALUES ("
                + this.medicamento + ",'" + this.doenca + "','" + this.descricao + "');";      
        
        return d.insere(query);
    }        

    public static ResultSet consultar(String valor,short campo) {
        String query;
        switch(campo){
            case 1:     // O filtro é a medicamento
                query = "SELECT t.*,m.principio_ativo FROM tratamento t INNER JOIN medicamento m "
                + "ON t.medicamento = m.id_medicamento WHERE t.medicamento=" + valor + ";";
                break;            
            case 2:     // O filtro é a principio ativo
                query = "SELECT t.*,m.principio_ativo FROM tratamento t INNER JOIN medicamento m "
                + "ON t.medicamento = m.id_medicamento WHERE m.principio_ativo LIKE '%" + valor + "%';";
                break;
            case 3:     // O filtro é a doenca
                query = "SELECT t.*,m.principio_ativo FROM tratamento t INNER JOIN medicamento m "
                + "ON t.medicamento = m.id_medicamento WHERE doenca LIKE '"+ valor +"%';";
                break;
            default: 
                query = "SELECT t.*,m.principio_ativo FROM tratamento t INNER JOIN medicamento m "
                + "ON t.medicamento = m.id_medicamento;";
                break;
        }
            
        Database d = new Database();
        d.conecta();
        return d.consulta(query);
    }    
    
    public static ResultSet consultar(String medic,String doenca) {
        String query;
        
        query = "SELECT t.* FROM tratamento t WHERE t.medicamento=" + medic + " "
                + "AND t.doenca='"+ doenca +"';";
                    
        Database d = new Database();
        d.conecta();
        return d.consulta(query);
    }
    
    public static ResultSet consultar() {
        String query;
        
        query = "SELECT t.*,m.principio_ativo FROM tratamento t INNER JOIN medicamento m "
                + "ON t.medicamento = m.id_medicamento;";
                    
        Database d = new Database();
        d.conecta();
        return d.consulta(query);
    }   
    
    public boolean excluir() {
        String query;       
        query = "DELETE FROM tratamento WHERE medicamento="+this.medicamento+" AND doenca='" + this.doenca + "';";               
     
        return d.remove(query); 
    }
    
    public boolean alterar() {
        String query;       
        query = "UPDATE tratamento SET "
                + "descricao='" + this.descricao + "'"             
                + " WHERE medicamento=" + this.medicamento + " "
                + "AND doenca='"+ this.doenca +"';";
     
        return d.atualiza(query); 
    }

    public int getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(int medicamento) {
        this.medicamento = medicamento;
    }

    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    public String getDoenca() {
        return doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}

