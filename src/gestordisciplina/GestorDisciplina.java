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

    public void limpaTela() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

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

    public void gerarDisciplina() throws InterruptedException {
        String str = "";
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        System.out.print("Escreva o nome da disciplina : ");
        String nome = input.nextLine();
        File Disciplina = new File("DIRETORIO_GERAL/disciplinas/" + nome + ".txt");

        while (true) {
            System.out.print("Digite o gabarito do aluno : ");
            String gabarito = input2.nextLine().toUpperCase();
            System.out.print("Nome do aluno : ");
            String aluno = input2.nextLine().toUpperCase();
            if (gabarito.length() == 10) {
                str += gabarito + "\t" + aluno + "\n";
            } else {
                System.out.println("Foi registrado mais respostas ou menos respostas do que deveria");
            }
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
        }

        System.out.println("Registro feito com sucesso");
        System.out.println("Operação realizada com sucesso");
        Thread.sleep(2000);
        System.out.println("Voltando para o menu principal");
        loading();
        limpaTela();
    }

    public void exibeDisciplinas() throws InterruptedException {
        File disciplina = new File("DIRETORIO_GERAL/disciplinas/");
        System.out.println("Disciplinas Existentes : ");
        for (File disciplinas : disciplina.listFiles()) {
            System.out.println("============================================");
            System.out.println("Disciplina : " + disciplinas.getName().replace(".txt", ""));
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
            }
            System.out.println(aux);
            System.out.println("============================================");
        }

        System.out.println("Operação realizada com sucesso");
        Thread.sleep(5000);
        System.out.println("Exibindo o menu principal");
        loading();
    }

    public void gabaritoResposta() throws InterruptedException {
        String str = "";
        Scanner input = new Scanner(System.in);
        System.out.print("Nome da disciplina do gabarito : ");
        String gabaritoResposta = input.nextLine();
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
        }

        System.out.println("Operação realizada com sucesso");
        Thread.sleep(2000);
        System.out.println("Voltando para o menu principal");
        loading();
        limpaTela();
    }

    public void criarResultado() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o nome da disciplina : ");
        String nomeDisciplina = input.nextLine();
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
        String[] linhas = aux.split("\n");

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

        String gabaritos = aux2;

        ArrayList<Aluno> alunos = new ArrayList<Aluno>();

        for (String linha : linhas) {
            String respostasDoAluno = linha.split("\t")[0];
            String nomeDoAluno = linha.split("\t")[1];
            alunos.add(new Aluno(respostasDoAluno, nomeDoAluno));
        }

        double media = alunos.stream().mapToDouble(aluno -> aluno.calcularNota(gabaritos)).average().getAsDouble();

        System.out.println("Media Geral : " + media);

        List<Aluno> ordemAlfabetica = alunos.stream().sorted(Comparator.comparing(Aluno::getNome))
                .collect(Collectors.toList());

        File resultadoPorNome = new File("DIRETORIO_GERAL/resultado/resultado_nome/" + nomeDisciplina + ".txt");

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

        List<Aluno> ordemDecrescenteDeNota = alunos.stream()
                .sorted(Comparator.comparing(aluno -> aluno.calcularNota(gabaritos), Comparator.reverseOrder()))
                .collect(Collectors.toList());

        File resultadoPorNota = new File("DIRETORIO_GERAL/resultado/resultado_nota/" + nomeDisciplina + ".txt");

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
    }

    public void exibeResultados() throws InterruptedException {
        File resultadoPorNome = new File("DIRETORIO_GERAL/resultado/resultado_nome/");
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
        }

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
        }

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
            System.out.println(aux);
            System.out.println("============================================");
        }
        System.out.println("Operação realizada com sucesso");
        Thread.sleep(5000);
        System.out.println("Exibindo o menu principal");
        loading();
    }
}