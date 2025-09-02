public class Livro {
    private String titulo;
    private String autor;
    private int ano; 
    private StatusLivro status;

    public Livro(String titulo, String autor, int ano) {
        setTitulo(titulo);
        setAutor(autor);
        setAno(ano);
        this.status = StatusLivro.DISPONIVEL;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == ""){
            System.out.println("Erro: titulo inválido");
        } else {
            this.titulo = titulo;
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor == "") {
            System.out.println("Erro: autor inválido");
        } else {
            this.autor = autor;
        }
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        int ano_atual = 2025;
        if (ano > ano_atual) {
            System.out.println("Erro: ano inválido.");
        } else {
            this.ano = ano;
        }
    }
    
    @Override
    public String toString() {
         return "Livro '" + titulo + "', de " + autor + " (" + ano + ") - Status: " + status;
    }
    
    public StatusLivro getStatus() {
        return status;

    }
    public void setStatus(StatusLivro status) {
        this.status = status;
    }
    
}
