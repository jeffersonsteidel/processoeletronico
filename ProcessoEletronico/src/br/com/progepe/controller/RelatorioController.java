package br.com.progepe.controller;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

import javax.faces.context.FacesContext;

import net.sf.jasperreports.engine.JRException;


public class RelatorioController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	public void abrirRelatorioTeste() throws IOException{
		FacesContext.getCurrentInstance().getExternalContext()
		.redirect("relatorioTeste.jsp");
	}
	
	public String gerarRelatorioTeste() throws ClassNotFoundException, SQLException, JRException{
		JasperMB jasperMB = new JasperMB();
		jasperMB.criaConexao();
		jasperMB.geraRelatorioPassandoResultSet();
		return "";
	}
}
