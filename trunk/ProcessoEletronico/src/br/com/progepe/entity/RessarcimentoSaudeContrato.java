package br.com.progepe.entity;

import java.io.Serializable;

public class RessarcimentoSaudeContrato implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8858939815459194427L;
	private Long codigo;
	private RessarcimentoSaude ressarcimentoSaude;
	private byte[] pagina;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public RessarcimentoSaude getRessarcimentoSaude() {
		return ressarcimentoSaude;
	}

	public void setRessarcimentoSaude(RessarcimentoSaude ressarcimentoSaude) {
		this.ressarcimentoSaude = ressarcimentoSaude;
	}

	public byte[] getPagina() {
		return pagina;
	}

	public void setPagina(byte[] pagina) {
		this.pagina = pagina;
	}

}
