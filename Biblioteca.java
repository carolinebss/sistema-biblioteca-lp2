import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
        private List<ItemDoAcervo> acervo;
        private List<Usuario> ListadeUsuarios;
        private List<Emprestimo> registrosDeEmprestimos;
        private static final int PRAZO_EMPRESTIMO_DIAS = 14;
        private static final double VALOR_MULTA_POR_DIA = 0.75;

        public Biblioteca() {
            this.acervo = new ArrayList<>();
            this.ListadeUsuarios = new ArrayList<>();
            this.registrosDeEmprestimos = new ArrayList<>();
        }
        
        public void realizarEmprestimo (String idUsuario, String titulo) {
            Usuario usuarioDoEmprestimo = pesquisarPorUsuario(idUsuario);
            if(usuarioDoEmprestimo == null) {
                System.out.println("Erro: esse usuário não está cadastrado.");
                return;
            }
            ItemDoAcervo itemDoEmprestimo = pesquisarItemPorTitulo(titulo);
            if(itemDoEmprestimo == null) {
                System.out.println("Erro: esse livro não existe.");
                return;
            }
            if(itemDoEmprestimo.getStatus() == StatusLivro.EMPRESTADO) {
                System.out.println("Erro: esse livro já está emprestado.");
                return;
            }
            itemDoEmprestimo.setStatus(StatusLivro.EMPRESTADO);
            LocalDate dataEmprestimo = LocalDate.now();
            LocalDate dataDevolucaoPrevista = dataEmprestimo.plusDays(PRAZO_EMPRESTIMO_DIAS);
            Emprestimo emprestimo = new Emprestimo(itemDoEmprestimo, usuarioDoEmprestimo, dataEmprestimo, LocalDate.now());
            registrosDeEmprestimos.add(emprestimo);
            System.out.println("Emprestimo cadastrado com sucesso.");
            System.out.println("O item '"+itemDoEmprestimo.getTitulo()
                +"' foi emprestado para o usuário " + usuarioDoEmprestimo.getNome()
                +" na data " + emprestimo.getDataEmprestimo()
                +" e tem de ser devolvido em " + emprestimo.getDataDevolucaoPrevista());
    }
        public Emprestimo buscarEmprestimoAtivoPorItem(ItemDoAcervo item) {
            for (Emprestimo emprestimo: registrosDeEmprestimos) {
                if(emprestimo.getItem().getTitulo().equalsIgnoreCase(item.getTitulo())){
                  if(emprestimo.getDataDevolucaoPrevista() == null) {
                    return emprestimo;
                  }
                }
            }
            return null;
        }

        public void realizarDevolucao(String titulo) {
            ItemDoAcervo item = pesquisarItemPorTitulo(titulo);
            if (item == null) {
                System.out.println("Erro: esse Item não está cadastrado.");
                return;
            }
            Emprestimo emprestimo = buscarEmprestimoAtivoPorItem(item);
            if(emprestimo == null) {
                System.out.println("Esse emprestimo não existe.");
            }
            LocalDate hoje = LocalDate.now();
            long dias = ChronoUnit.DAYS.between(emprestimo.getDataDevolucaoPrevista(), hoje);
            
            if(dias > 0) {
                double multa = dias * VALOR_MULTA_POR_DIA;
                System.out.println("Item devolvido. Você precisou pegar uma multa de R$" + multa);
            } else {
                System.out.println("Item devolvido.");
            }
            emprestimo.getItem().setStatus(StatusLivro.DISPONIVEL);
            emprestimo.setDataDevolucaoPrevista(hoje);

        }
        
        public ItemDoAcervo pesquisarItemPorTitulo(String titulo) {
            for(ItemDoAcervo item : this.acervo){
                if(item.getTitulo().toLowerCase().equalsIgnoreCase(titulo)){
                    return item;
                }
            }
            return null;
        }

        public Usuario pesquisarPorUsuario(String id) {
            for(Usuario usuario: this.ListadeUsuarios){
                if(usuario.getId().equals(id)){
                    return usuario;
                }
            }
            return null;
        }

        public void listarAcervo() {
            System.out.println("Livros no Acervo");
            for(var item : acervo) {
                System.out.println(item);
            }
        }

         public void cadastratrarItem(ItemDoAcervo item) {
            this.acervo.add(item);
            System.out.println("O item" + item.getTitulo() + "foi cadastrado");
        }
       
        public void cadastratrarUsuario(Usuario usuario) {
            this.ListadeUsuarios.add(usuario);
            System.out.println("O Usuario" + usuario.getNome() + "foi cadastrado");
        }
        public static void main(String[] args) {
            Livro livroJavaComoProgramar = new Livro("Java como Programar", 2014, "Deitel");
            Livro livroDestruirVida = new Livro("Como destruir sua vida", 2025, "Caroline Barbosa");
            Usuario meuUsuario = new Usuario("Anna Caroline", "030");
            Biblioteca minhaBiblioteca = new Biblioteca();
            minhaBiblioteca.cadastratrarItem(livroJavaComoProgramar);
            minhaBiblioteca.cadastratrarItem(livroDestruirVida);
            minhaBiblioteca.cadastratrarUsuario(meuUsuario);
            minhaBiblioteca.listarAcervo();
            minhaBiblioteca.realizarEmprestimo("123", "Java como Porgramar");
            minhaBiblioteca.listarAcervo();
            minhaBiblioteca.realizarDevolucao("Java como Porgramar");
            minhaBiblioteca.listarAcervo();
            Revista revistaVeja = new Revista("Veja - Abril", 2015 , 1);
            minhaBiblioteca.cadastrarItem(revistaVeja);
            minhaBiblioteca.listarAcervo();
            
    }
}

