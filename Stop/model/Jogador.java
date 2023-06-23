package Stop.model;

public class Jogador {
	
    private String nome;
    private String apelido;
    private String nascimento;
    private String sexo;
    private int tempo;
    
	public Jogador(String nome, String apelido, String nascimento, String sexo, int tempo) {
		super();
		this.nome = nome;
		this.apelido = apelido;
		this.nascimento = nascimento;
		this.sexo = sexo;
		this.tempo = tempo;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
}

    
