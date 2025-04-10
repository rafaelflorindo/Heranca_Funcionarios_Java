public class Pessoa {
    public String nome;
    public String dataNascimento;
    public String cpf;

    public Pessoa(String nome, String dataNascimento, String cpf){
           this.setNome(nome);
           this.setCpf(cpf);
           this.setDataNascimento(dataNascimento);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void imprimir(){
        System.out.printf("%-21s | %-15s | %-12s ", getNome(), getDataNascimento(), getCpf());
    }
}
