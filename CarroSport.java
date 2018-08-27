public class CarroSport extends Carro {

    protected String seguro;
    protected static int stock = 20;
    public String tipo = "Sport";

    public CarroSport(String placa, String cilindraje, String marca, String color, String transmision, int numeroPuestos,int valorHora, String seguro){
        super(placa, cilindraje, marca, color, transmision, numeroPuestos, valorHora);
        this.seguro = seguro;
        
    }
    public  void aumentarStock(){
        stock = stock + 1;
    }

    public  void disminuirStock(){
        stock = stock - 1;
    }

    public  int getStock(){
        return stock;
    }

    public String getSeguro(){
        return seguro;
    }

    public String getTipo(){
        return tipo;
    }
    
}