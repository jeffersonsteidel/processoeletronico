package br.com.progepe.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class JasperMB {

	Connection conexao;
	String saida;

	public void criaConexao() throws ClassNotFoundException, SQLException {
		String endereco = "jdbc:mysql://localhost:3306/ifpr";
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

	private String getDiretorioReal(String diretorio) {
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

	private void preenchePdf(JasperPrint print) throws JRException, Exception {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext(); // Context    
        HttpServletResponse response = (HttpServletResponse) context.getResponse();    
        byte[] arquivo = new byte[0];  
		  try{
	        String caminho = getDiretorioReal("/WEB-INF/jasper/ralatorio1.jasper");  
	        JasperReport jasper = (JasperReport) JRLoader.loadObject(caminho);
	        print = JasperFillManager.fillReport(jasper, null, conexao);  
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


	public String geraRelatorioPassandoConexao() {
		saida = null;
		String jasper = getDiretorioReal("/WEB-INF/jasper/ralatorio1.jasper");
		Connection conexao = null;
		try {
			// Abro a conexão com o banco que será passada para o JasperReports
			conexao = getConexao();
			// Mando o jasper gerar o relatório
			JasperPrint print = JasperFillManager.fillReport(jasper, null,
					conexao);
			// Gero o PDF
			preenchePdf(print); // VEJA O MÉTODO NO CAPÍTULO 3 DO TUTORIAL
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
		return "exibeRelatorio";
	}

	public void geraRelatorioPassandoResultSet() throws JRException {
		saida = null;
		String jasper = getDiretorioReal("/WEB-INF/jasper/ralatorio1.jasper");
		Connection conexao = null;
		try {
			// Abro a conexão com o banco
			conexao = getConexao();
			// Gero o ResultSet que será enviado a partir da conexão aberta
			JRResultSetDataSource jrsds = new JRResultSetDataSource(
					getResultSet());
			// Mando o jasper gerar o relatório
			JasperPrint print = JasperFillManager.fillReport(jasper, null,
					jrsds);
			// Gero o PDF
			preenchePdf(print);
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

	public ResultSet getResultSet() throws SQLException, ClassNotFoundException {
		Statement stmt = conexao.createStatement();
		ResultSet rs = stmt
				.executeQuery("SELECT servidor.`serv_nome` AS servidor_serv_nome FROM `servidor` servidor");
		return rs;
	}

	// public static void main(String[] args) throws ClassNotFoundException,
	// SQLException {
	// JasperMB jasperMB = new JasperMB();
	// jasperMB.criaConexao();
	// jasperMB.getResultSet();
	// jasperMB.geraRelatorioPassandoResultSet();
	// }
}
