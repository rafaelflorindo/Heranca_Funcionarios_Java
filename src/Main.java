import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    static ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

    static String nome, cpf, dataNascimento, matricula, disciplina, cargo, data_admissao;
    static double salario;

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("***********************************");
            System.out.println("Função de Cadastro");
            System.out.println("1 - Aluno");
            System.out.println("2 - Funcionario");
            System.out.println("3 - Professor");
            System.out.println("Função de Listar");
            System.out.println("4 - Listar Geral");
            System.out.println("5 - Listar Aluno");
            System.out.println("6 - Listar Funcionários");
            System.out.println("7 - Listar Professores");
            System.out.println("8 - Sair");
            System.out.println("Escolha uma opção abaixo:");
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao){
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    cadastrarFuncionario();
                    break;
                case 3:
                    cadastrarProfessor();
                    break;
                case 4:
                    if(!pessoas.isEmpty()) {
                        for (Pessoa p : pessoas) {
                            p.imprimir();
                        }
                    }else {
                        System.out.println("Não há dados cadastrados no sitema!!!");
                    }
                    break;
                case 5:
                    listarAluno();
                    break;
                case 6:
                    listarFuncionario();
                    break;
                case 7:
                    listarProfessor();
                case 8:
                    System.out.println("Saindo do Sistema!!!");
                    break;
                default:
                    System.out.println("Opção Errada, tente novamente!!!");
                    break;
            }
        }while (opcao != 8);
    }

    public static void cadastrarAluno(){
        System.out.println("***** DADOS CADASTRAIS DO ALUNO *****");
        boolean status;
        do {
            System.out.println("Matrícula: ");
            matricula = scan.nextLine();
            if (matricula.isEmpty()) {
                System.out.println("A matrícula não pode ser vazia. Tente novamente!!!");
                status = false;
            } else {
                status = true;
            }
        } while (!status);
        cadastrarComum();
        /*Aluno alu1 = new Aluno(nome, dataNascimento, cpf, matricula);
        pessoas.add(alu1);*/
        try{
            pessoas.add(new Aluno(nome, dataNascimento, cpf, matricula));
            System.out.println("Aluno foi cadastrado com sucesso!!!");
        }catch (Exception e){
            System.out.println("Erro ao Cadasrar o aluno.");
        }

    }
    public static void cadastrarComum() {
        System.out.println("Nome: ");
        nome = scan.nextLine();

        System.out.println("CPF: ");
        cpf = scan.nextLine();

        System.out.println("Data de nascimento: ");
        dataNascimento = scan.nextLine();
    }

    public static void cadastrarProfessor() {
        System.out.println("***** DADOS CADASTRAIS DO PROFESSOR *****");
        cadastrarComum();
        System.out.println("Disciplina: ");
        disciplina = scan.nextLine();

        boolean status;
        do{
            System.out.println("Salário: ");
            salario = scan.nextDouble();
            if (salario < 0){
                System.out.println("Salário não pode ser negativo. Tente novamente!!!");
                status=false;
            }else {
                status = true;
            }
        }while (!status);

        try {
            pessoas.add(new Professor(nome, dataNascimento, cpf, salario, disciplina));
            System.out.println("Professor foi cadastrado com sucesso!!!");
        }catch (Exception e){
            System.out.println("Erro ao Cadastrar o Professor.");
        }


        scan.nextLine();
    }
    public static void cadastrarFuncionario() {

        System.out.println("***** DADOS CADASTRAIS DO FUNCIONARIO *****");
        cadastrarComum();

        System.out.println("Cargo: ");
        cargo = scan.nextLine();
        System.out.println("Data de Admissão: ");
        data_admissao = scan.nextLine();

        boolean status;
        do{
            System.out.println("Salário: ");
            salario = scan.nextDouble();
            if (salario < 0){
                System.out.println("Salário não pode ser negativo");
                status=false;
            }else {
                status = true;
            }
        }while (!status);
        scan.nextLine();
        try{
            pessoas.add(new Funcionario(nome, dataNascimento, cpf, salario, data_admissao, cargo));
            System.out.println("Funcionario foi cadastrado com sucesso!!!");
        }catch (Exception e){
            System.out.println("Erro ao Cadastrar o Funcionario.");
        }

    }

    public static void listarAluno(){
        System.out.println("***** DADOS CADASTRAIS DOS ALUNOS *****");

        boolean status = false;
        if(!pessoas.isEmpty()) {
            System.out.printf("%-10s | %-21s | %-15s | %-13s%n",
                "MATRICULA", "NOME", "DATA NASCIMENTO", "CPF");
            System.out.println("--------------------------------------------------------------------------------------");

            for (Pessoa p : pessoas) {
                if (p instanceof Aluno) {
                    p.imprimir();
                    status = true;
                }
            }
        }else {
            System.out.println("Não há dados cadastrados no sitema!!!");
        }
        if(!status) System.out.println("Não há Alunos cadastrados no sitema!!!");
    }
    public static void listarFuncionario(){
        System.out.println("***** DADOS CADASTRAIS DO FUNCIONÁRIOS *****");

        System.out.printf("%-21s | %-15s | %-13s | %-10s | %-15s | %-20s%n",
                "NOME", "DATA NASCIMENTO", "CPF", "SALÁRIO", "DATA ADMISSÃO", "CARGO");
        System.out.println("--------------------------------------------------------------------------------------");

        if(!pessoas.isEmpty()) {
            for (Pessoa p : pessoas) {
                if (p instanceof Funcionario) {
                    p.imprimir();
                }
            }
        }else {
            System.out.println("Não há dados cadastrados no sitema!!!");
        }
    }
    public static void listarProfessor(){
        System.out.println("***** DADOS CADASTRAIS DO PROFESSORES *****");
        System.out.printf("%-25s | %-19s | %-13s | %-10s | %-20s%n",
                "NOME", "DATA NASCIMENTO", "CPF", "SALÁRIO", "DISCIPLINA");
        System.out.println("--------------------------------------------------------------------------------------");

        if(!pessoas.isEmpty()) {
            for (Pessoa p : pessoas) {
                if (p instanceof Professor) {
                    p.imprimir();
                }
            }
        }else {
            System.out.println("Não há dados cadastrados no sitema!!!");
        }
    }
}