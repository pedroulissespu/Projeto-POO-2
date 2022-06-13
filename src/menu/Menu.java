package menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import gestordisciplina.GestorDisciplina;

public class Menu {
    public Menu() throws IOException, InterruptedException, FileNotFoundException {

        GestorDisciplina gestao = new GestorDisciplina();
        gestao.gerarDiretorios();
        
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Seleciona alguma das opções a seguir para dar continuidade : ");
            System.out.println();
            System.out.println("[1] - Gerar Disciplina e Adicionar Alunos.");
            System.out.println("[2] - Criar Gabarito Resposta.");
            System.out.println("[3] - Fazer Resultado dos Alunos.");
            System.out.println("[4] - Exibir Disciplinas Geradas.");
            System.out.println("[5] - Exibir Resultados.");
            System.out.println("[6] - Exibir Gabaritos e seus Respectivos nomes salvo");
            System.out.println("[7] - Sair.");
            System.out.println();
            int opcao = input.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Opção 1 selecionada com sucesso , aguarde.");
                    gestao.loading();
                    gestao.limpaTela();
                    System.out.println("Opção de criar disciplina selecionada com sucesso");
                    gestao.gerarDisciplina();
                    break;
                case 2:
                    System.out.println("Opção 2 selecionada com sucesso , aguarde.");
                    gestao.loading();
                    gestao.limpaTela();
                    System.out.println("Opção de criar gabarito selecionada com sucesso");
                    gestao.gabaritoResposta();
                    break;
                case 3:
                    System.out.println("Opção 3 selecionada com sucesso , aguarde.");
                    gestao.loading();
                    gestao.limpaTela();
                    System.out.println("Opção de criar resultado selecionada com sucesso");
                    gestao.criarResultado();
                    break;
                case 4:
                    System.out.println("Opção 4 selecionada com sucesso , aguarde.");
                    gestao.loading();
                    gestao.limpaTela();
                    System.out.println("Opção de exibir disciplinas selecionada com sucesso");
                    gestao.exibeDisciplinas();
                    break;
                case 5:
                    System.out.println("Opção 5 selecionada com sucesso , aguarde.");
                    gestao.loading();
                    gestao.limpaTela();
                    System.out.println("Opção de exibir resultados selecionada com sucesso");
                    gestao.exibeResultados();
                    break;
                case 6:
                    System.out.println("Opção 6 selecionada com sucesso , aguarde.");
                    gestao.loading();
                    gestao.limpaTela();
                    System.out.println("Opção de exibir gabaritos e seus repectivos nomes selecionada com sucesso");
                    gestao.exibeGabaritos();
                    break;
                case 7:
                    gestao.limpaTela();
                    System.out.println("Saindo do Programa.");
                    gestao.loading();
                    System.out.println("Adeus , obrigado por usar o programa :)");
                    Thread.sleep(1500);
                    System.exit(0);
                    break;
                default:
                    System.out.println("OPÇÃO INVALIDA , DIGITE UMA OPÇÃO VALIDA DENTRE DAS OPÇÕES DE 1 ATÉ 7");
                    Thread.sleep(2000);
                    System.out.println("Voltando para o menu principal");
                    gestao.loading();
                    gestao.limpaTela();
                    break;
            }
        }
    }
}