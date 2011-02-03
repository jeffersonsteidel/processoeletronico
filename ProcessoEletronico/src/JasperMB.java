import com.mysql.jdbc.Connection;

import br.com.progepe.dao.*;



public class JasperMB {
	public String geraRelatorioPassandoResultSet() { 
		String jasper = "/jasper/teste.jasper"; 
		Connection conexao = null; 
		try { 
		  conexao = new 
		   // Gero o ResultSet que será enviado a partir da conexão aberta
		  JRResultSetDataSource jrsds = new
		JRResultSetDataSource(getResultSet(conexao)); 
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
		 {  
		   { 
		return "exibeRelatorio"; 
		{
}
