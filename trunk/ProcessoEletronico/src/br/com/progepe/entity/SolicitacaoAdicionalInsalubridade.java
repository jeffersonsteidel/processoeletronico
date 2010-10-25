package br.com.progepe.entity;

public class SolicitacaoAdicionalInsalubridade extends Solicitacao {

	private static final long serialVersionUID = 1L;

	private String tarefasDiarias;
	private String tarefasSemanais;
	private String tarefasMensais;
	private Boolean indRiscosFisicos;
	private String justRiscosFisicos;
	private Boolean indRiscosQuimicos;
	private String justRiscosQuimicos;
	private Boolean indRiscosBiologicos;
	private String justRiscosBiologicos;
	private Boolean indRiscosIrradiacaoIonizante;
	private String justRiscosIrradiacaoIonizante;

	public String getTarefasDiarias() {
		return tarefasDiarias;
	}

	public void setTarefasDiarias(String tarefasDiarias) {
		this.tarefasDiarias = tarefasDiarias;
	}

	public String getTarefasSemanais() {
		return tarefasSemanais;
	}

	public void setTarefasSemanais(String tarefasSemanais) {
		this.tarefasSemanais = tarefasSemanais;
	}

	public String getTarefasMensais() {
		return tarefasMensais;
	}

	public void setTarefasMensais(String tarefasMensais) {
		this.tarefasMensais = tarefasMensais;
	}

	public Boolean getIndRiscosFisicos() {
		return indRiscosFisicos;
	}

	public void setIndRiscosFisicos(Boolean indRiscosFisicos) {
		this.indRiscosFisicos = indRiscosFisicos;
	}

	public String getJustRiscosFisicos() {
		return justRiscosFisicos;
	}

	public void setJustRiscosFisicos(String justRiscosFisicos) {
		this.justRiscosFisicos = justRiscosFisicos;
	}

	public Boolean getIndRiscosQuimicos() {
		return indRiscosQuimicos;
	}

	public void setIndRiscosQuimicos(Boolean indRiscosQuimicos) {
		this.indRiscosQuimicos = indRiscosQuimicos;
	}

	public String getJustRiscosQuimicos() {
		return justRiscosQuimicos;
	}

	public void setJustRiscosQuimicos(String justRiscosQuimicos) {
		this.justRiscosQuimicos = justRiscosQuimicos;
	}

	public Boolean getIndRiscosBiologicos() {
		return indRiscosBiologicos;
	}

	public void setIndRiscosBiologicos(Boolean indRiscosBiologicos) {
		this.indRiscosBiologicos = indRiscosBiologicos;
	}

	public String getJustRiscosBiologicos() {
		return justRiscosBiologicos;
	}

	public void setJustRiscosBiologicos(String justRiscosBiologicos) {
		this.justRiscosBiologicos = justRiscosBiologicos;
	}

	public Boolean getIndRiscosIrradiacaoIonizante() {
		return indRiscosIrradiacaoIonizante;
	}

	public void setIndRiscosIrradiacaoIonizante(
			Boolean indRiscosIrradiacaoIonizante) {
		this.indRiscosIrradiacaoIonizante = indRiscosIrradiacaoIonizante;
	}

	public String getJustRiscosIrradiacaoIonizante() {
		return justRiscosIrradiacaoIonizante;
	}

	public void setJustRiscosIrradiacaoIonizante(
			String justRiscosIrradiacaoIonizante) {
		this.justRiscosIrradiacaoIonizante = justRiscosIrradiacaoIonizante;
	}

}
