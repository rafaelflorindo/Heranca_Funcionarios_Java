public class Funcionario extends Pessoa{
    public double salario;
    public String data_admissao;
    public String cargo;

    public Funcionario(String nome, String dataNascimento, String cpf, double salario, String data_admissao, String cargo){
        super(nome, dataNascimento, cpf);
        this.setData_admissao(data_admissao);
        this.setCargo(cargo);
        this.setSalario(salario);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getData_admissao() {
        return data_admissao;
    }

    public void setData_admissao(String data_admissao) {
        this.data_admissao = data_admissao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public void imprimir(){
        super.imprimir();
        System.out.printf(" | %-10.2f | %-15s | %-20s%n", this.getSalario(), this.getData_admissao(), this.getCargo());
    }
}
