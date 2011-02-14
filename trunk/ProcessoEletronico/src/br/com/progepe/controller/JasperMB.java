package br.com.progepe.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class JasperMB {

	Connection conexao;
	String saida;

	public void criaConexao() throws ClassNotFoundException, SQLException {
		String endereco = "jdbc:mysql://172.16.32.29:3306/ifpr";
		String usuario = "marlon";
		String senha = "ifpr";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexao = (Connection) DriverManager.getConnection(endereco,
					usuario, senha);
		} catch (ClassNotFoundException ex) {
			throw ex;
		} catch (SQLException ex) {
			throw ex;
		}
	}

	public Connection getConexao() {
		return conexao;
	}

	protected String getDiretorioReal(String diretorio) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		return session.getServletContext().getRealPath(diretorio);
	}

	@SuppressWarnings("unused")
	private String getContextPath() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		return session.getServletContext().getContextPath();
	}

	@SuppressWarnings("rawtypes")
	private void preenchePdf(JasperPrint print, String nomeDoJasper, HashMap parametros) throws JRException, Exception {
		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext(); // Context
		HttpServletResponse response = (HttpServletResponse) context
				.getResponse();
		byte[] arquivo = new byte[0];
		try {
			String caminho = getDiretorioReal(nomeDoJasper);
			JasperReport jasper = (JasperReport) JRLoader.loadObject(caminho);
			print = JasperFillManager.fillReport(jasper, parametros, conexao);
			arquivo = JasperExportManager.exportReportToPdf(print);

			response.setContentType("application/pdf");
			response.setContentLength(arquivo.length);

			OutputStream saida = response.getOutputStream();

			saida.write(arquivo, 0, arquivo.length);
			saida.flush();
			saida.close();
			FacesContext.getCurrentInstance().responseComplete();
		} catch (IOException ex) {
			System.out.println("Error in downloadFile: " + ex.getMessage());
			ex.printStackTrace();
		}

	}

	@SuppressWarnings("rawtypes")
	public void geraRelatorioPassandoResultSet(HashMap parametros,String nomeDoJasper)
			throws JRException {
		saida = null;
		String jasper = getDiretorioReal(nomeDoJasper);
		Connection conexao = null;
		try {
			// Abro a conexão com o banco
			conexao = getConexao();
			JasperPrint print = JasperFillManager.fillReport(jasper,
					parametros, conexao);
			// Gero o PDF
			preenchePdf(print, nomeDoJasper, parametros);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Sempre mando fechar a conexão, mesmo que tenha dado erro
				if (conexao != null)
					conexao.close();
			} catch (SQLException e) {
			}
		}
	}

	public ResultSet getResultSet(String sql) throws SQLException,
			ClassNotFoundException {
		Statement stmt = conexao.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
	}
}
