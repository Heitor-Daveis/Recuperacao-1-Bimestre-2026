import java.util.ArrayList;

public class FilaAtendimento {
    private ArrayList<Pessoa> pessoas;
    private int quantidadePessoas;
    private int proximaSenha;

    public FilaAtendimento() {
        pessoas = new ArrayList<>();
        quantidadePessoas = 0;
        proximaSenha = 1;
    }

    public boolean cadastrar(String nome, String cpf, String telefone, String dataNascimento) {
        for (int i = 0; i < quantidadePessoas; i++) {
            if (pessoas.get(i).getCpf().equals(cpf)) {
                return false;
            }
        }

        String senha;
        if (proximaSenha < 10) {
            senha = "A00" + proximaSenha;
        } else if (proximaSenha < 100) {
            senha = "A0" + proximaSenha;
        } else {
            senha = "A" + proximaSenha;
        }

        Pessoa pessoa = new Pessoa(nome, cpf, telefone, dataNascimento, senha);
        int posicao = 0;
        int anoNova = pessoa.getAnoNascimento();

        while (posicao < quantidadePessoas) {
            int anoAtual = pessoas.get(posicao).getAnoNascimento();
            if (anoNova >= anoAtual) {
                posicao = posicao + 1;
            }else{
                break;
            }
        }

        pessoas.add(posicao, pessoa);
        quantidadePessoas = quantidadePessoas + 1;
        proximaSenha = proximaSenha + 1;

        System.out.println ("Cadastro realizado com sucesso! Senha: " + senha);
        return true;
    }

    public void listarFila() {
        if (quantidadePessoas == 0) {
            System.out.println("A fila está vazia.");
            return;
        }

        System.out.println("Fila de Atendimento:");
        for (int i = 0; i < quantidadePessoas; i++) {
            System.out.println("\n" + pessoas.get(i));
        }
    }

    public void chamarProxima() {
        if (quantidadePessoas == 0) {
            System.out.println("A fila está vazia.");
            return;
        }

        Pessoa pessoa = pessoas.remove(0);
        quantidadePessoas = quantidadePessoas - 1;
        System.out.println("Chamando próxima pessoa da fila.");
        System.out.println(pessoa);
    }
}