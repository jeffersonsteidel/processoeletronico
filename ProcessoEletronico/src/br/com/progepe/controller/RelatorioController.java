package br.com.progepe.controller;

import java.io.Serializable;
import java.sql.SQLException;

import net.sf.jasperreports.engine.JRException;


public class RelatorioController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	public void gerarRelatorioTeste() throws ClassNotFoundException, SQLException, JRException{
		JasperMB jasperMB = new JasperMB();
		jasperMB.criaConexao();
		jasperMB.geraRelatorioPassandoResultSet();	
	}
}
