public class Pessoa {
    private String nome;
    private String cpf;
    private String telefone;
    private String dataNascimento;
    private String senha;

    public Pessoa(String nome, String cpf, String telefone, String dataNascimento, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public int getAnoNascimento(){
        String anoTexto = dataNascimento.substring(6, 10);
        return Integer.parseInt(anoTexto);
    }

    public String toString(){
        return  "Senha: " + senha +
               "\nNome: " + nome +
               "\nCPF: " + cpf +
               "\nTelefone: " + telefone +
               "\nData de nascimento: " + dataNascimento + "\n";
    }
}
