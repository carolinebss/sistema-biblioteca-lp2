public class ItemDoAcervo {
    protected String titulo;
    protected int ano; 
    protected StatusLivro status;

    public ItemDoAcervo(String titulo, int ano) {
        setTitulo(titulo);
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
    
    public StatusLivro getStatus() {
        return status;

    }
    public void setStatus(StatusLivro status) {
        this.status = status;
    }
    

}

