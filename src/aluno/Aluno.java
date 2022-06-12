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

        char[] respostaAluno = respostas.toCharArray(); //Transformando a string resposta em vetor de char
        char[] respostaGabarito = gabarito.toCharArray(); //Transformando a string gabarito em vetor de char

        boolean verificadorNota = true; //Verificador para ver se todas as respostas foram V ou F

        for(char letra: respostaAluno){
            if(letra != respostaAluno[0]){
                verificadorNota = false;
                break;
            }
        } //Nesse for a letra vai assumir todas as posições do vetor char respostaAluno e sempre vai
        	//Verificar se esta igual a primeira posição do vetor , ja que , se a letra assumir todas as posições até a 
        	//ultima posição do vetor char da resposta do aluno e continuar sendo igual , logo
        //Ele respondeu todas as alternativas iguais , caso contrario , o laço é quebrado
        //E a variavel booleana vira false
        	

        if(verificadorNota){
            return 0;
        } //Caso a variavel booleana permaneça verdadeira , entra nesse if e a nota do aluno vira 0

        for(int i = 0 ; i < respostaAluno.length ; i++){
            if(respostaAluno[i] == respostaGabarito[i])
                nota++;
        } //Nesse for esta sendo calculado a nota do aluno comparando cada um dos vetores resposta e gabarito

        return nota; //Retorna a nota do aluno
    }
    
    //Metodo para calcular a media do aluno que entra como parametro o gabarito oficial do professor
    //Esse metodo foi mais criado por conta de gerar a media geral da turma para double , se nao fosse
    //por conta disso , seria apenas 1 metodo
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