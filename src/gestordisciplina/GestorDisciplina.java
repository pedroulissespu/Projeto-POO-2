package gestordisciplina;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import aluno.Aluno;

public class GestorDisciplina {
	
	//Todos os metodos usados ao decorrer do programa
	
	//Metodo de criar a pasta dos diretorios que vai ficar salvo os arquivos
    public void gerarDiretorios() {
        File diretorio = new File("DIRETORIO_GERAL");
        diretorio.mkdir();
        File subdir1 = new File(diretorio, "disciplinas");
        subdir1.mkdir();
        File subdir2 = new File(diretorio, "resultado");
        subdir2.mkdir();
        File subdir3 = new File(diretorio, "gabarito");
        subdir3.mkdir();
        File subdir4 = new File(subdir2, "resultado_nome");
        subdir4.mkdir();
        File subdir5 = new File(subdir2, "resultado_nota");
        subdir5.mkdir();
    }
    
    //Metodo de "Limpar" a tela
    public void limpaTela() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    //Metodo de loading improvisado
    public void loading() throws InterruptedException {
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.println();
    }

    //Metodo responsavel por gerar a disciplina e adicionar alunos
    public void gerarDisciplina() throws InterruptedException {
        String str = "";
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        System.out.print("Escreva o nome da disciplina : ");
        String nome = input.nextLine();
        File Disciplina = new File("DIRETORIO_GERAL/disciplinas/" + nome + ".txt"); /*Vai criar
        um arquivo .txt com a String fornecida*/

        while (true) {
            System.out.print("Digite o gabarito do aluno : ");
            String gabarito = input2.nextLine().toUpperCase();
            System.out.print("Nome do aluno : ");
            String aluno = input2.nextLine().toUpperCase();
            
            //Em ambas as strings vai ser feito a leitura e automaticamente ambas ja vão estar
            //Com letra maiuscula por conta do .toUpperCase()
            
            if (gabarito.length() == 10) {
                str += gabarito + "\t" + aluno + "\n"; //String armazenando o gabarito e o nome aluno
            } else {
                System.out.println("Foi registrado mais respostas ou menos respostas do que deveria");
            }
            //Caso o gabarito não tenha o tamanho desejado de 10 alternativas , não vai ser possivel
            //Registrar o aluno
            System.out.print("Deseja continuar com a operação colocando mais algum aluno ? 0 para não e 1 para sim : ");
            int opcao = input.nextInt();
            if (opcao == 0) {
                break;
            }
        }

        try {
            FileWriter fileWriter = new FileWriter(Disciplina);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(str);
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Erro durante a leitura/gravação dos dados :(");
        } //Vai escrever a String com os dados do gabarito e nome no arquivo gerado da disciplina
        System.out.println("Registro feito com sucesso");
        System.out.println("Operação realizada com sucesso");
        Thread.sleep(2000);
        System.out.println("Voltando para o menu principal");
        loading();
        limpaTela();
    }

    //Metodo de exibir as disciplinas que existe com seus nomes exatos
    public void exibeDisciplinas() throws InterruptedException {
        File disciplina = new File("DIRETORIO_GERAL/disciplinas/"); //File com o diretorio disciplina
        System.out.println("Disciplinas Existentes : ");
        
        //For do tipo disciplina que vai pecorrer todas as disciplinas existentes e listar
        for (File disciplinas : disciplina.listFiles()) {
            System.out.println("============================================");
            System.out.println("Disciplina : " + disciplinas.getName().replace(".txt", ""));
            //nesse System.out.println esta pegando o nome do arquivo txt e substituindo o .txt
            //por nada , um caractere vazio , para que nao apareça .txt na tela do usuario
            String aux = "";
            try {
                FileReader fileReader = new FileReader(disciplinas);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while (bufferedReader.ready()) {
                    aux += bufferedReader.readLine() + "\n";
                }
                bufferedReader.close();
                fileReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("Não foi possivel encontrar o arquivo :(");
            } catch (IOException e) {
                System.out.println("Erro durante a leitura/gravação dos dados :(");
            } //Try Catch com file reader para ler o que contem nas disciplinas e exibir
            //Os alunos e seus respectivos gabaritos
            System.out.println(aux);
            System.out.println("============================================");
        }

        System.out.println("Operação realizada com sucesso");
        Thread.sleep(5000);
        System.out.println("Exibindo o menu principal");
        loading();
    }

    //Metodo do professor/orientado gerar o cartao resposta
    public void gabaritoResposta() throws InterruptedException {
        String str = "";
        Scanner input = new Scanner(System.in);
        System.out.print("Nome da disciplina do gabarito : ");
        String gabaritoResposta = input.nextLine();
        //Criando um arquivo com o respectivo nome do gabarito e adiconando .txt no final
        File gabarito = new File("DIRETORIO_GERAL/gabarito/" + gabaritoResposta + ".txt");
        System.out.print("Digite o gabarito : ");
        str += input.nextLine().toUpperCase();
        if (str.length() == 10) {
            try {
                FileWriter fileWriter = new FileWriter(gabarito);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(str);
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Erro durante a leitura/gravação dos dados :(");
            }
            System.out.println("Gabarito feito com sucesso");
        } else {
            System.out.println("Gabarito invalido");
        } //Caso o gabarito possua mais que 10 letras/alternativas , o gabarito não vai ser criado
        	//Caso o contrario , o fileWriter vai escrever os dados que o usuario digitou no arquivo gabarito

        System.out.println("Operação realizada com sucesso");
        Thread.sleep(2000);
        System.out.println("Voltando para o menu principal");
        loading();
        limpaTela();
    }

    //Metodo de gerar os resultados e gerar a media geral de tal disciplina
    public void criarResultado() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o nome da disciplina : ");
        String nomeDisciplina = input.nextLine();
        //Acessando o arquivo txt da disciplina
        File disciplina = new File("DIRETORIO_GERAL/disciplinas/" + nomeDisciplina + ".txt");

        String aux = "";
        try {
            FileReader fileReader = new FileReader(disciplina);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()) {
                aux += bufferedReader.readLine() + "\n";
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Não foi possivel encontrar o arquivo :(");
        } catch (IOException e) {
            System.out.println("Erro durante a leitura/gravação dos dados :(");
        }
        String[] linhas = aux.split("\n"); //Lendo o arquivo da disciplina

        System.out.print("Digite o nome salvo do gabarito : ");
        String nomeGabarito = input.nextLine();
        File gabarito = new File("DIRETORIO_GERAL/gabarito/" + nomeGabarito + ".txt");

        String aux2 = "";
        try {
            FileReader fileReader = new FileReader(gabarito);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()) {
                aux2 += bufferedReader.readLine() + "\n";
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Não foi possivel encontrar o arquivo :(");
        } catch (IOException e) {
            System.out.println("Erro durante a leitura/gravação dos dados :(");
        }

        String gabaritos = aux2; //Lendo o arquivo do gabarito oficial

        ArrayList<Aluno> alunos = new ArrayList<Aluno>(); //Fazer um vetor de alunos

        for (String linha : linhas) {
            String respostasDoAluno = linha.split("\t")[0];
            String nomeDoAluno = linha.split("\t")[1];
            alunos.add(new Aluno(respostasDoAluno, nomeDoAluno));
        } //Adicionando os dados ao vetor dos alunos

        double media = alunos.stream().mapToDouble(aluno -> aluno.calcularNota(gabaritos)).average().getAsDouble();
        //Essa variavel vai ser a media geral da turma
        //o map to double esta pecorrendo todos os alunos e transformando em double
        //logo, com isso , eu fiz a seguinte coisa , que para cada transformação para double , eu vou
        //calcular a nota do aluno com o parametro sendo o gabarito oficial
        //e o average() com o getAsDouble() vai me devolver então a media geral da turma
        //Average é o responsavel por criar essa media de tudo
        //e o .stream é para poder usar todas as funções maptoDouble e o average !

        System.out.println("Media Geral : " + media);

        List<Aluno> ordemAlfabetica = alunos.stream().sorted(Comparator.comparing(Aluno::getNome))
                .collect(Collectors.toList());
        //Nessa lista , esta ordenando os alunos em ordem alfabetica
        //O comando .stream e o .sorted são os responsaveis pela ordenação em ordem alfabetica
        //o Comparator.comparing vai estar comparando os nomes dos alunos
        //e o collect vai estar fazendo então a lista

        File resultadoPorNome = new File("DIRETORIO_GERAL/resultado/resultado_nome/" + nomeDisciplina + ".txt");
        //E com isso , um arquivo com o nome da disciplina no diretorio resultado/resultado_nome
        //vai estar sendo salvo
        
        String out = "";
        for (Aluno aluno : ordemAlfabetica) {
            out += aluno.getNome() + "\t" + aluno.calcularNota(gabaritos) + "\n";
        }

        out += "Média Geral : \t" + media;

        try {
            FileWriter fileWriter = new FileWriter(resultadoPorNome);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(out);
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Erro durante a leitura/gravação dos dados :(");
        }
        //e aqui gravou os dados de ser ordenado por nome no arquivo
        
        List<Aluno> ordemDecrescenteDeNota = alunos.stream()
                .sorted(Comparator.comparing(aluno -> aluno.calcularNota(gabaritos), Comparator.reverseOrder()))
                .collect(Collectors.toList());
        //aqui é praticamente o msm esquema
        //o sorted vai estar ordenando fazendo a comparação com a nota dos alunos,
        //o Comparator.reverseOrder() vai ser o responsavel por deixar em ordem decrescente
        //e por fim , vai ser criado a lista

        File resultadoPorNota = new File("DIRETORIO_GERAL/resultado/resultado_nota/" + nomeDisciplina + ".txt");
        //Acessando o diretorio e criando o arquivo do resultado
        out = "";

        for (Aluno aluno : ordemDecrescenteDeNota) {
            out += aluno.getNome() + "\t" + aluno.calcularNota(gabaritos) + "\n";
        }

        out += "Media Geral : \t" + media;
        try {
            FileWriter fileWriter = new FileWriter(resultadoPorNota);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(out);
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Erro durante a leitura/gravação dos dados :(");
        }

        System.out.println("Operação realizada com sucesso");
        Thread.sleep(2000);
        System.out.println("Voltando para o menu principal");
        loading();
        limpaTela();
    }//Escrevendo o resultado em ordem decrescente no arquivo

    //Metodo de exibir os resultados
    public void exibeResultados() throws InterruptedException {
        File resultadoPorNome = new File("DIRETORIO_GERAL/resultado/resultado_nome/");
        //Acessando o diretorio do resultado por nome
        System.out.println("Resultados em ordem alfabetica : ");
        for (File file : resultadoPorNome.listFiles()) {
            System.out.println(file.getName().replace(".txt", ""));
            String aux = "";
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while (bufferedReader.ready()) {
                    aux += bufferedReader.readLine() + "\n";
                }
                bufferedReader.close();
                fileReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("Não foi possivel encontrar o arquivo :(");
            } catch (IOException e) {
                System.out.println("Erro durante a leitura/gravação dos dados :(");
            }

            System.out.println(aux);
        } //Nesse for , vai estar listando todas as diciplinas e seus resultados.

        File resultadorPorOrdemDecrescente = new File("DIRETORIO_GERAL/resultado/resultado_nota/");
        System.out.println("Resultador por nota em ordem decrescente : ");
        for (File file : resultadorPorOrdemDecrescente.listFiles()) {
            System.out.println(file.getName().replace(".txt", ""));
            String aux = "";
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while (bufferedReader.ready()) {
                    aux += bufferedReader.readLine() + "\n";
                }
                bufferedReader.close();
                fileReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("Não foi possivel encontrar o arquivo :(");
            } catch (IOException e) {
                System.out.println("Erro durante a leitura/gravação dos dados :(");
            }
            System.out.println(aux);
        } //O mesmo acontece nesse , porem em nota e em ordem decrescente

        System.out.println("Operação realizada com sucesso");
        Thread.sleep(5000);
        System.out.println("Exibindo o menu principal");
        loading();
    }

    public void exibeGabaritos() throws InterruptedException {
        File gabaritos = new File("DIRETORIO_GERAL/gabarito/");
        System.out.println("Gabaritos e seus respectivos nomes salvo : ");
        for (File gabarito : gabaritos.listFiles()) {
            System.out.println("============================================");
            System.out.println("Disciplina : " + gabarito.getName().replace(".txt", ""));
            String aux = "";
            try {
                FileReader fileReader = new FileReader(gabarito);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while (bufferedReader.ready()) {
                    aux += bufferedReader.readLine() + "\n";
                }
                bufferedReader.close();
                fileReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("Não foi possivel encontrar o arquivo :(");
            } catch (IOException e) {
                System.out.println("Erro durante a leitura/gravação dos dados :(");
            }
            //Acessa os arquivos e lista todos os gabaritos existentes e seus respectivos nomes
            System.out.println(aux);
            System.out.println("============================================");
        }
        System.out.println("Operação realizada com sucesso");
        Thread.sleep(5000);
        System.out.println("Exibindo o menu principal");
        loading();
    }
}