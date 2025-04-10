public class Aluno extends Pessoa{
    public String matricula;

    public Aluno(String nome, String dataNascimento, String cpf, String matricula){
        super(nome, dataNascimento, cpf);
        this.setMatricula(matricula);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public void imprimir(){
        System.out.printf("%-10s | ", this.getMatricula());
        super.imprimir();
        System.out.printf("%n");
    }

}
