import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
        private List<Livro> acervo;
        private List<Usuario> ListadeUsuarios;
        private List<Emprestimo> registrosDeEmprestimos;
        private static final int PRAZO_EMPRESTIMO_DIAS = 14;
        private static final double VALOR_MULTA_POR_DIA = 0.75;
        private Emprestimo buscarEmprestimoAtivoPorLivro(Livro livro);
    

        public Biblioteca() {
            this.acervo = new ArrayList<>();,
            this.ListadeUsuarios = new ArrayList<>();
            this.registrosDeEmprestimos = new ArrayList<>();
        }
        
        public void realizarEmprestimo (String idUsuario, String titulo) {
            Usuario usuarioDoEmprestimo = pesquisarPorUsuario(idUsuario);
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
            LocalDate dataEmprestimo = LocalDate.now();
            LocalDate dataDevolucaoPrevista = dataEmprestimo.plusDays(PRAZO_EMPRESTIMO_DIAS);
            Emprestimo emprestimo = new Emprestimo(livroDoEmprestimo, usuarioDoEmprestimo, dataEmprestimo, LocalDate.now());
            registrosDeEmprestimos.add(emprestimo);
            System.out.println("Emprestimo cadastrado com sucesso.");
        }

        public Emprestimo buscarEmprestimoAtivoPorLivro(Livro livro) {
            for (Emprestimo emprestimo: registrosDeEmprestimos) {
                if(emprestimo.getLivro().getTitulo().equalsIgnoreCase(livro.getTitulo())){
                  if(emprestimo.getDataDevolucaoPrevista() == null) {
                    return emprestimo;
                  }
                }
            }
            return null;
        }

        public void realizarDevolucao(String titulo) {
            Livro livro = pesquisarLivroPorTitulo(titulo);
            if (livro == null) {
                System.out.println("Erro: esse livro não está cadastrado.");
                return;
            }
            Emprestimo emprestimo = buscarEmprestimoAtivoPorLivro(livro);
            if(emprestimo == null) {
                System.out.println("Esse emprestimo não existe.");
            }
            LocalDate hoje = LocalDate.now();
            long dias = ChronoUnit.DAYS.between(emprestimo.getDataDevolucaoPrevista(), hoje);
            
            if(dias > 0) {
                double multa = dias * VALOR_MULTA_POR_DIA;
                System.out.println("Você precisou pegar uma multa de R$" + multa);
            } else {
                System.out.println("Livro devolvido.");
            }
            emprestimo.getLivro().setStatus(StatusLivro.DISPONIVEL);
            emprestimo.setDataDevolucaoPrevista(hoje);

        }

        public Usuario pesquisarPorUsuario(String id) {
            for(Usuario usuario: this.ListadeUsuarios){
                if(usuario.getId().equalsIgnoreCase(id)){
                    return usuario;
                }
            }
            return null;
        }
        public Livro pesquisarLivroPorTitulo(String titulo) {
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
            return listaDeLivros;
        }

        public void listarAcervo() {
            System.out.println("Livros no Acervo");
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
        public static void main(String[] args) {
            Livro livroJavaComoProgramar = new Livro("Java como Programar", "Deitel", 2014);
            Livro livroDestruirVida = new Livro("Como destruir sua vida", "Caroline Barbosa", 2025);
            Usuario meuUsuario = new Usuario("Anna Caroline", "030");
            Biblioteca minhaBiblioteca = new Biblioteca();
            minhaBiblioteca.cadastratrarLivro(livroJavaComoProgramar);
            minhaBiblioteca.cadastratrarLivro(livroDestruirVida);
            minhaBiblioteca.cadastratrarUsuario(meuUsuario);
            minhaBiblioteca.listarAcervo();
            minhaBiblioteca.realizarEmprestimo("123", "Java como Porgramar");
            minhaBiblioteca.listarAcervo();
            minhaBiblioteca.realizarDevolucao("Java como Porgramar");
            minhaBiblioteca.listarAcervo();

            List<Livro> resultado = minhaBiblioteca.pesquisarLivroPorTermo("java");
            for (var livro : resultado) {
                System.out.println("Livros encontrados");
                System.out.println(livro);
            }
            minhaBiblioteca.listarAcervo();
    }
}
