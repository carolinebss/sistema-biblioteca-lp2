public class Aluno extends Usuario {

    public Aluno(String nome, String email, String senha) {
        super(nome, email, senha);
    }
    @Override
    public String formatarParaEtiqueta() {
        return "CARTÃO DE ACESSO - Aluno: " + getNome() +
                " | Matrícula: " + getNome();
    }
    @Override
    public boolean validar() {
        return getNome() != null && getNome().length() > 3;
    }
}
