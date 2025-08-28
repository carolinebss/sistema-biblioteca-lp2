import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
        private List<Livro> acervo;
        private List<Usuario> ListadeUsuarios;
        private List<Emprestimo> registrosDeEmprestimos;

        public Biblioteca() {
            this.acervo = new ArrayList<>();
            this.ListadeUsuarios = new ArrayList<>();
            this.registrosDeEmprestimos = new ArrayList<>();
        }
        
        public void realizarEmprestimo (String idUsuario, String titulo) {
            Usuario usuarioDoEmprestimo = pesquisarPorUsuarioPorId(idUsuario);
            if(usuarioDoEmprestimo == null) {
                System.out.println("Erro: esse usuário não está cadastrado.");
                return;
            }
            Livro livroDoEmprestimo = pesquisarLivroPorTitulo(titulo);
            if(livroDoEmprestimo == null) {
                System.out.println("Erro: esse livro não existe.");
                return;
            }
            if(livroDoEmprestimo.getStatus() == StatusLivro.EMPRESTADO) {
                System.out.println("Erro: esse livro já está emprestado.");
                return;
            }
            livroDoEmprestimo.setStatus(StatusLivro.EMPRESTADO);
            Emprestimo emprestimo = new Emprestimo(livroDoEmprestimo, usuarioDoEmprestimo, LocalDate.now());
            registrosDeEmprestimos.add(emprestimo);
            System.out.println("Emprestimo cadastrado com sucesso.");
        }

        public void pesquisarPorUsuario(String id) {
            for(Usuario usuario: this.ListadeUsuarios){
                if(usuario.getId().equalsIgnoreCase(id)){
                    return id;
                }
            }
            return null;
        }

        public void pesquisarPorTitulo(String titulo) {
            for(Livro livro : this.acervo){
                if(livro.getTitulo().toLowerCase().equalsIgnoreCase(titulo)){
                    return livro;
                }
            }
            return null;
        }
        public List<Livro> pesquisarLivroPorTermo(String termo) {
            List<Livro> listaDeLivros = new ArrayList<>();
            for(Livro livro : acervo) {
                if(livro.getTitulo().toLowerCase().contains(termo.toLowerCase())) {
                    listaDeLivros.add(livro);
                }
            }

        }
        public void listarAcervo() {
            for(Livro livro : acervo) {
                System.out.println(livro);
            }

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
            Biblioteca minhaBiblioteca = new Biblioteca();
            minhaBiblioteca.cadastratrarLivro(livro1);
            minhaBiblioteca.cadastratrarUsuario(meuUsuario);
            List<Livro> resultado = minhaBiblioteca.pesquisarLivroPorTermo("java");
            for (var livro : resultado) {
                System.out.println("Livros encontrados");
                System.out.println(livro);
            }

           
    }


    }

