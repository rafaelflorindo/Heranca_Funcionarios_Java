public class Professor extends Pessoa{
    public double salario;
    public String disciplina;

    public Professor(String nome, String dataNascimento, String cpf, double salario, String disciplina){
        super(nome, dataNascimento, cpf);
        this.setDisciplina(disciplina);
        this.setSalario(salario);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    @Override
    public void imprimir(){
        super.imprimir();
        System.out.printf(" | %-10.2f | %-20s%n", this.getSalario(), this.getDisciplina());
    }

}
