import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public final class Application {
    private static Application instancia;
    public static Application getInstancia(){
        if(instancia == null){
            instancia = new Application();
        }
        return instancia;
    }

    public enum tipoCarro {
        FAM, SPT, STD
    }

    public static Carro hacerCarro(tipoCarro tipo, String placa, String cilindraje, String marca, String color, String transmision, int numeroPuestos, int valorHora, String seguro){
        switch (tipo) {
            case FAM:
                Carro fam = new CarroFamiliar(placa, cilindraje, marca, color, transmision, numeroPuestos, valorHora, seguro);
                return fam;
            case SPT:
                Carro spt = new CarroSport(placa, cilindraje, marca, color, transmision, numeroPuestos, valorHora, seguro);
                return spt;
            case STD:
                Carro std = new CarroStandar(placa, cilindraje, marca, color, transmision, numeroPuestos, valorHora, seguro);
                return std;
            default:
                throw new IllegalArgumentException("Tipo de carro no disponible");
        }
    }

    public static void main(String[] args) {
        Application app = new Application();
        System.out.println("------------------Pueba Singleton-----------------");
        Application appprueba1 = new Application();
        Application appprueba2 = new Application();
        System.out.println(appprueba1.getInstancia());
        System.out.println(appprueba2.getInstancia());
        System.out.println("--------------------------------------------------");
        ArrayList<Cliente> clientesInscritos = new ArrayList<Cliente>();
        ArrayList<Carro> carrosPrestados = new ArrayList<Carro>();
        Carro carro;
        Cliente cliente;
        Transaccion transaccion;
        Random rnd = new Random();
        int prueba = 10;
        while(prueba >=0){
            String[] nombres = {"Maria", "Diego","Juan"};
            String[] ids = {"1","2","3"};
            String[] generos = {"M","F"};
            String[] tipos = {"VIP","Normal"};
            String[] placas = {"HHH000","DDD111","QQQ333","TTT888","FFF666","QQQ444","AAA444","WWW555"};
            String[] cilindrajes = {"1500","1300","250","600","1200"};
            String[] marcas = {"Toyota","Nissan","Chevrolet","Mazda","Audi","Jaguar","BMW","Mercedes"};
            String[] colores = {"Gris","Azul","Rojo","Blanco"};
            String[] transmiciones = {"Mecanica","Automatica"};
            String[] seguros = {"Todo riesgo","Estandar"};
            String nombre = nombres[rnd.nextInt(nombres.length-1)];
            String id = ids[rnd.nextInt(ids.length-1)];
            String genero = generos[rnd.nextInt(generos.length-1)];
            String tipo = tipos[rnd.nextInt(tipos.length-1)];
            String placa = placas[rnd.nextInt(placas.length-1)];
            String cilindraje = cilindrajes[rnd.nextInt(cilindrajes.length-1)];
            String marca = marcas[rnd.nextInt(marcas.length-1)];
            String color = colores[rnd.nextInt(colores.length-1)];
            String transmision = transmiciones[rnd.nextInt(nombres.length-1)];
            int numeroPuestos = rnd.nextInt(10);
            int valorHora = numeroPuestos*50;
            String seguro = seguros[rnd.nextInt(seguros.length-1)];
            String fecha = "28/08/2018";
            String fechaEntrega = "29/08/2018";
            String fechaRegreso = "30/08/2018";
            if(numeroPuestos <= 2){
                carro = app.hacerCarro(tipoCarro.SPT, placa, cilindraje, marca, color, transmision, numeroPuestos, valorHora, seguro);
                if(carro.getStock()<=0){
                    System.out.println("No hay mas carros disponibles de este tipo");
                    System.exit(0);
                }
                else{
                    carro.disminuirStock();
                }
            }
            else if(numeroPuestos>=3 && numeroPuestos<=5){
                carro = app.hacerCarro(tipoCarro.STD, placa, cilindraje, marca, color, transmision, numeroPuestos, valorHora, seguro);
                if(carro.getStock()<=0){
                    System.out.println("No hay mas carros disponibles de este tipo");
                    System.exit(0);
                }
                else{
                    carro.disminuirStock();
                }
            }
            else{
                carro = app.hacerCarro(tipoCarro.FAM, placa, cilindraje, marca, color, transmision, numeroPuestos, valorHora, seguro);
                if(carro.getStock()<=0){
                    System.out.println("No hay mas carros disponibles de este tipo");
                    System.exit(0);
                }
                else{
                    carro.disminuirStock();
                }
            }

            cliente = new Cliente(id, nombre, genero, tipo);
            transaccion = new Transaccion(String.valueOf(100000 + rnd.nextInt(900000)), fecha, fechaEntrega, fechaRegreso, valorHora, 0, carro, cliente);

            if (!clientesInscritos.isEmpty() && clientesInscritos.contains(cliente)) {
                cliente.agregarCarro(carro);
                System.out.println("El cliente tiene mas de un carro arrendado");
            } else {
                clientesInscritos.add(cliente);
                cliente.agregarCarro(carro);
            }
            if (!carrosPrestados.isEmpty() && carrosPrestados.contains(carro)) {
                System.out.println("El carro no esta disponible");
                System.exit(0);
            } else {
                carrosPrestados.add(carro);
            }
            transaccion.hacerTransaccion(seguro);
            System.out.println("El carro que presto es de tipo " + carro.getTipo() + " y de este tipo quedan " + carro.getStock());
            System.out.println("El valor total de su transaccion es: " + (valorHora+transaccion.getValorTotal()));
            prueba--;
        }
    }
}