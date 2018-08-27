import java.util.ArrayList;

public class Cliente {
    
    protected String id;
    protected String nombre;
    protected String genero;
    protected String tipo;
    protected ArrayList<Carro> carrosPrestados = new ArrayList<Carro>();
    
    public Cliente(String id, String nombre, String genero, String tipo){
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.tipo = tipo;
    }

    public void agregarCarro(Carro carrito){
        carrosPrestados.add(carrito);
    }
    
    public ArrayList getListCarros(){
        return carrosPrestados;
    }
}