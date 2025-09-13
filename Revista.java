public class Revista extends ItemDoAcervo{
    private int edicao;

    public Revista(String titulo, int ano, int edicao) {
        super(titulo, ano);
       this.edicao = edicao;        
    }
    public int getEdicao() {
        return edicao;
    }
    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }
    @Override
    public String toString() {
         return "Revista '" + getTitulo() + " (" + getAno() + ") - Status: " + getStatus() + "Edição -" + edicao;
    }

    @Override
    public int getPrazoEmprestimoDias(){
        return 10;
    }

    @Override
    public double getValorMultaPorDiaAtraso() {
        return 1.00;
    }

}
