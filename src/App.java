import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FilaAtendimento fila = new FilaAtendimento();
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("1 - Cadastrar pessoa");
            System.out.println("2 - Listar fila");
            System.out.println("3 - Chamar próxima pessoa");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.print("Nome: ");
                String nome = scanner.nextLine();

                System.out.print("CPF (somente números): ");
                String cpf = scanner.nextLine();

                System.out.print("Telefone: ");
                String telefone = scanner.nextLine();

                System.out.print("Data de nascimento (dd/MM/aaaa): ");
                String dataNascimento = scanner.nextLine();

                if (cpf.length() != 11) {
                   System.out.println("CPF deve ter 11 números."); 
                } else if (dataNascimento.length() != 10) {
                    System.out.println("Data inválida. Use o formato dd/MM/aaaa.");
                } else { 
                    boolean cadastrou = fila.cadastrar(nome, cpf, telefone, dataNascimento);

                    if (!cadastrou) {
                        System.out.println("Esse CPF já está cadastrado na fila.");
                    }
                }
            } else if (opcao == 2) {
                fila.listarFila();
            }else if (opcao ==3) {
                fila.chamarProxima();
            } else if (opcao ==0) {
                System.out.println("Encerrando o programa...");
            } else {
                System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }
}