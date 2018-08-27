import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;

public class Transaccion {

    protected String id;
    protected String fecha;
    protected String fechaEntrega;
    protected String fechaRegreso;
    protected int valorHora;
    protected int valorTotal;
    protected Carro carro;
    protected Cliente cliente;

    public Transaccion(String id, String fecha, String fechaEntrega, String fechaRegreso, int valorHora, int valorTotal, Carro carro, Cliente cliente){
        this.id = id;
        this.fecha = fecha;
        this.fechaEntrega = fechaEntrega;
        this.fechaRegreso = fechaRegreso;
        this.valorHora = valorHora;
        this.valorTotal = valorTotal;
        this.carro = carro;
        this.cliente = cliente;
    }

    public long horasEntreDias(){
        long diferencia = 0;
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date primeraFecha = formato.parse(fechaEntrega);
            Date segundaFecha = formato.parse(fechaRegreso);
            diferencia = segundaFecha.getTime() - primeraFecha.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TimeUnit.HOURS.convert(diferencia, TimeUnit.MILLISECONDS);
    }

    public void hacerTransaccion(String seguro){

        if (seguro == "Todo riesgo") {
            valorTotal = 200;
        } else if (seguro == "Estandar"){
            valorTotal = 100;
        }

        valorTotal = valorTotal + (int)horasEntreDias()*valorHora;
    }

    public int getValorTotal(){
        return valorTotal;
    }

    public Carro getCarro(){
        return carro;
    }

    public Cliente getCliente(){
        return cliente;
    }
}