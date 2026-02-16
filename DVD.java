public class DVD extends ItemDoAcervo implements Reservavel {

    private boolean reservado;
    private int Duracaominutos;

    public int getDuracaominutos(){
        return Duracaominutos;
    }

    public void setDuracaominutos(int duracaominutos){
        Duracaominutos = duracaominutos;
    }

    public DVD(String titulo, int ano, int duracaominutos){
        super(titulo, ano);
        setDuracaominutos(duracaominutos);
    }

    @Override
    public int getPrazo() {
        return 3;
    }
    @Override
    public double getMulta_Por_dia(){
        return 2.0;
    }
    @Override
    public String toString() {
        return "DVD "+ getTitulo()+ ", do ano " +getAno()+" -"+getDuracaominutos()+" min - STATUS:"+getStatus();
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
    public String formatarParaEtiqueta() {
        return "DVD - " + getTitulo() + " (" + getAno() + ")";
    }

}
