public abstract class Carro {
    protected String placa;
    protected String cilindraje;
    protected String marca;
    protected String color;
    protected String transmision;
    protected int numeroPuestos;
    protected int valorHora;

    public Carro(String placa, String cilindraje, String marca, String color, String transmision, int numeroPuestos, int valorHora){
        this.placa = placa;
        this.cilindraje = cilindraje;
        this.marca = marca;
        this.color = color;
        this.transmision = transmision;
        this.numeroPuestos = numeroPuestos;
        this.valorHora = valorHora;
    }

    public abstract void aumentarStock();
    public abstract void disminuirStock();
    public abstract int getStock();
    public abstract String getTipo();

    public int getValorHora(){
        return valorHora;
    }

    public String getPlaca(){
        return placa;
    }

}