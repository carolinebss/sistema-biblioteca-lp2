import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
        private List<Livro> acervo;
        private List<Usuario> ListadeUsuarios;

        public Biblioteca() {
            this.acervo = new ArrayList<>();
            this.ListadeUsuarios = new ArrayList<>();
        }
        public void pesquisaPorTitulo(String titulo) {
            for(Livro livro : this.acervo){
                if(livro.getTitulo().toLowerCase().equalsIgnoreCase(titulo)){
                    return livro
                }
            }
            return null
        }

        public void cadastratrarLivro(Livro livro) {
            this.acervo.add(livro);
            System.out.println("O livro" + livro.getTitulo() + "foi cadastrado");

        }
        public void cadastratrarUsuario(Usuario usuario) {
            this.ListadeUsuarios.add(usuario);
            System.out.println("O Usuario" + usuario.getNome() + "foi cadastrado");

        }
        public void main(String[] args) {
            Livro livro1 = new Livro("Como destruir a sua vida", "Caroline Barbosa", 2025);
            Usuario meuUsuario = new Usuario("Caroll", "123");
            Biblioteca minhBiblioteca = new Biblioteca();
            minhBiblioteca.cadastratrarLivro(livro1);
            Livro livroEncontrado = minhBiblioteca.pesquisaPorTitulo("java");
    }


    }

