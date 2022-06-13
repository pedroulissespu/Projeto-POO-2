package aluno;

public class Aluno {
    private String respostas;
    private String nome;

    public Aluno(String respostas, String nome){
        this.respostas = respostas;
        this.nome = nome;
    }

    public int gerarMedia(String respostas, String gabarito){
        int nota = 0;

        char[] respostaAluno = respostas.toCharArray();
        char[] respostaGabarito = gabarito.toCharArray();

        boolean verificadorNota = true;

        for(char letra: respostaAluno){
            if(letra != respostaAluno[0]){
                verificadorNota = false;
                break;
            }
        }        	

        if(verificadorNota){
            return 0;
        }

        for(int i = 0 ; i < respostaAluno.length ; i++){
            if(respostaAluno[i] == respostaGabarito[i])
                nota++;
        }

        return nota;
    }
    
    public double calcularNota(String gabarito){
        return gerarMedia(this.respostas, gabarito);
    }

    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRespostas() {
		return respostas;
	}

	public void setRespostas(String respostas) {
		this.respostas = respostas;
	}
}