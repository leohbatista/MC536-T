
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unicamp.ic.mc536.prontosocorro.consulta;

import br.unicamp.ic.mc536.prontosocorro.Database;
import br.unicamp.ic.mc536.prontosocorro.diagnostico.Diagnostico;
import br.unicamp.ic.mc536.prontosocorro.medicamento.Medicamento;
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
    private ArrayList<String> listaDiagnosticos = new ArrayList<String>(); 
    private ArrayList<Prescricao> listaPrescricao = new ArrayList<Prescricao>(); 
   
    private Database d;

    public Consulta(int CRM, String CPF, Date data, Time hora, String diagnostico, String sintomas, String observacoes) {
        this.CRM = CRM;
        this.CPF = CPF;
        this.data = data;
        this.hora = hora;
        this.diagnostico = diagnostico;
        this.sintomas = sintomas;
        this.observacoes = observacoes;
        
        d = new Database();
        d.conecta(); 
    }

    public Consulta() {
        
    }
    
    
    
    public boolean novo() {               
        String query;        
        
        query = "INSERT INTO consulta (medico, paciente, data, hora, "
                + "diagnostico, sintomas, observacoes) VALUES ("
                + this.CRM + ","
                + "'" + this.CPF + "',"
                + "'" + this.data.toString() + "',"
                + "'" + this.hora.toString() + "',"
                + "'" + this.diagnostico + "',"
                + "'" + this.sintomas + "',"
                + "'" + this.observacoes + "'"
                + ");";      
        
        d.insere(query);
        
        Diagnostico d;          
        for (String diag : listaDiagnosticos) {
            d = new Diagnostico(this.CRM, this.CPF, this.data, this.hora, diag);
            d.novo();
        }
        listaPrescricao.stream().map((presc) -> {
            presc.setCPF(CPF);
            return presc;
        }).map((presc) -> {
            presc.setCRM(CRM);
            return presc;
        }).map((presc) -> {
            presc.setData(data);
            return presc;
        }).map((presc) -> {
            presc.setHora(hora);
            return presc;
        }).forEachOrdered((presc) -> {
            presc.novo();
        });                      
        
        return true;
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

    public static ResultSet consultar() {
        String query = 
                "SELECT c.*, p.nome as npaciente, m.nome as nmedico FROM consulta c INNER JOIN paciente p "
                + "INNER JOIN medico m ON c.medico=m.CRM AND c.paciente=p.CPF;";
        
        Database d = new Database();
        d.conecta();
        return d.consulta(query);
    }
    
    public static ResultSet consultar(String valor, short flag) {
        String query;
        switch(flag){
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

    public static ResultSet consultar(String valor1, String valor2,short flag) {
        String query;
        switch(flag){
            case 1:
                query= "SELECT * FROM consulta WHERE medico=" + valor1
                        + " AND paciente='" + valor2 + "';";                
            case 2:     // O filtro é o campo 
                query= "SELECT * FROM consulta WHERE data='" + valor1
                        + "' AND hora='" + valor2 + "';";
                break;
            default: 
                query = "SELECT * FROM consulta;";
                break;
            
        }
        
        Database d = new Database();
        d.conecta();
        return d.consulta(query);
    }  
    
    public static ResultSet consultar(String valor1, String valor2, String valor3, String valor4) {
        String query;
        
        query= "SELECT * FROM consulta WHERE medico=" + valor1
                + " and paciente='" + valor2 + "'"
                +" and data='" + valor3 + "'"
                +" and hora='" + valor4 + "'"
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
        return listaDiagnosticos;
    }

    public ArrayList<Prescricao> getListaPrescricao() {
        return listaPrescricao;
    }    
    
    public ArrayList<String> getListaDiagnosticosSelect() {
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

    public ArrayList<Prescricao> getListaPrescricaoSelect() {
        ResultSet rs = Prescricao.consultar(""+this.CRM,this.CPF,this.data,this.hora);
        Prescricao p;
        try {
            
            while(rs.next()) {
                p = new Prescricao(
                    rs.getInt("medico"),
                    rs.getString("paciente"),
                    rs.getDate("data"),
                    rs.getTime("hora"),
                    new Medicamento(rs.getInt("medicamento"),rs.getString("principio_ativo"),rs.getString("dosagem"),""),
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
    
    public static boolean validaData(int dia, int mes, int ano) {
        if (dia < 1 || dia > 31) {
            return false;
        } else if (mes < 1 || mes > 12) {
            return false;
        } else if (ano < 1900 || ano > 2099) {
            return false;
        } else if (mes == 2 && dia > 29) {
            return false;
        } else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11 ) && dia > 30) {
            return false;
        }
        
        return true;
    }
    
    public static boolean validaHora(int hora, int minuto) {
        if (hora < 0 || hora > 23) {
            return false;
        } else if (minuto < 0 || minuto > 59) {
            return false;
        }
        
        return true;
    }
    
    public String getDataConvertida() {
        String nData;
        String [] parts;
        
        parts = data.toString().split("-");
        
        nData = parts[2] + "/" + parts[1] + "/" + parts[0];
        
        return nData;
    }

    public void setDataConvertida(String data) {
        String nData;
        String [] parts;
        
        parts = data.split("/");
        
        nData = parts[2] + "-" + parts[1] + "-" + parts[0];
        
        this.data = Date.valueOf(nData);
    }

    
}