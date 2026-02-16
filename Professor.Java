public class Professor extends Usuario {

    public Professor(String nome, String email, String senha) {
        super(nome, email, senha);
    }
    @Override
    public String formatarParaEtiqueta() {
        return "CARTÃO DE ACESSO - Professor: " + getNome() +
                " | Matrícula: " + getNome();
    }
    @Override
    public boolean validar() {
        return getNome() != null && getNome().length() > 3;
    }
}
