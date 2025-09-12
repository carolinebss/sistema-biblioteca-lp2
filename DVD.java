public class DVD extends ItemDoAcervo {
    private int duracaoMinutos;

    public DVD(String titulo, int ano, int duracaoMinutos) {
        super(titulo, ano);
        this.duracaoMinutos = duracaoMinutos;
    }

    public int getduracaoMinutos() {
        return duracaoMinutos;
    }

    public void setduracaoMinutos(int duracaoMinutos){
        duracaoMinutos = duracaoMinutos;
    }

    @Override
    public int getPrazoEmprestimoDias() {
        return 3;
    }

    @Override
    public double getValorMultaPorDiaAtraso() {
        return 2.0;
    }

   @Override
    public String toString() {
        return "DVD '" + getTitulo() + "' (" + getAno() + ") - " + duracaoMinutos + " min - Status: " + getStatus();
    }
}
