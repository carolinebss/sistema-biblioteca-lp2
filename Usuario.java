import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Usuario implements Imprimivel, Validavel {

    private String nome;
    private String email;
    private String senha;
    private List<Livro> livrosEmprestados;

    public Usuario(String nome, String email, String senha){
        setNome(nome);
        setEmail(email);
        setSenha(senha);
        this.livrosEmprestados = new ArrayList<>(); 
    public void adicionarLivro (Livro livro){
        this.livrosEmprestados.add(livro);
    }

    public List<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        if(nome.isEmpty()){ 
            System.out.println("erro, campo vazio");
        }else{
            this.nome = nome.trim();
        }
    }
    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        if (email.isEmpty()) {
            System.out.println("erro, campo vazio");
        } else {
            this.email = email;
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if(senha.isEmpty()){
            System.out.println("erro, campo vazio");
        }else{
            this.senha = senha;
        }
    }

    @Override
    public String toString() {
        return "usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nome, usuario.nome) && Objects.equals(email, usuario.email) && Objects.equals(senha, usuario.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email, senha);
    }
}
