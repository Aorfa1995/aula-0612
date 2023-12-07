package model;

public class curso {
	
	private int idcurso;
	private String nome;
	private int cargahoraria;
	private String tipocurso;
	public curso() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public curso(int idcurso, String nome, int cargahoraria, String tipocurso) {
		super();
		this.idcurso = idcurso;
		this.nome = nome;
		this.cargahoraria = cargahoraria;
		this.tipocurso = tipocurso;
	}


	public int getIdcurso() {
		return idcurso;
	}


	public void setIdcurso(int idcurso) {
		this.idcurso = idcurso;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	


	public int getCargahoraria() {
		return cargahoraria;
	}


	public void setCargahoraria(int cargahoraria) {
		this.cargahoraria = cargahoraria;
	}


	public String getTipocurso() {
		return tipocurso;
	}


	public void setTipocurso(String tipocurso) {
		this.tipocurso = tipocurso;
	}
	
	

}
