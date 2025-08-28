public class Livro {
    private String titulo;
    private String autor;
    private int ano; 

    public Livro(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
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
        return "Livro{" + 
        "titulo='" + titulo + '\'' + 
        
    }
    public StatusLivro getStatus() {
        return status;

    }
    public void setStatus(StatusLivro status) {
        this.status = status;
    }
    
}


