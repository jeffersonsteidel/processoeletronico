package br.com.progepe.entity;

import java.io.Serializable;

public class RessarcimentoSaudeContrato implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8858939815459194427L;
	private Long codigo;
	private Servidor servidor;
	private byte[] pagina;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public byte[] getPagina() {
		return pagina;
	}

	public void setPagina(byte[] pagina) {
		this.pagina = pagina;
	}

}
