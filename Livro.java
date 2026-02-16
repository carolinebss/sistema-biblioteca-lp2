
public class Livro extends ItemDoAcervo implements Reservavel, Validavel {
    private boolean reservado;
    private String autor;
    private String isbn;


    public Livro(String titulo, String autor, int ano, String isbn) {
        super(titulo, ano);
        setAutor(autor);
        this.isbn = isbn;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        if (autor == null|| autor.isEmpty()) {
            System.out.println("Erro: título inválido.");
        } else {
            this.autor = autor;
        }
    }

    @Override
    public int getPrazo() {
        return 14;
    }
    @Override
    public String toString() {
        return "Livro '" + getTitulo() + "', de " + super.toString() + "Autor:" + autor + " (" + getAno() + ") - Status: " + getStatus();
    }
    @Override
    public double getMulta_Por_dia() {
        return 0.75;
    }
    @Override
    public String formatarParaEtiqueta() {
        return "LIVRO - Título: " + getTitulo() + " | Autor: " + autor;
    }
    @Override
    public void reservar() {
        reservado = true;
    }

    @Override
    public void cancelarReserva() {
        reservado = false;
    }
    public boolean isReservado() {
        return reservado;
    }
    @Override
    public boolean validar() {
        return getTitulo() != null && !getTitulo().isEmpty()
                && isbn != null && isbn.length() == 13;
    }

}
