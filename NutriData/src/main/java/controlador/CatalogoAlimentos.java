package controlador;

import modelo.Alimento;
import java.util.ArrayList;

/*
Esta clase administra el catalogo 
general de alimentos del sistema

Aqui se cargan alimentos predefinidos junto 
con su informacion nutricional

Este catalogo permite que el usuario 
seleccione alimentos ya registrados, 
para evitar ingresar datos manualmente
*/

public class CatalogoAlimentos {


    /* 
    ArrayList que almacena todos los
    alimentos disponibles
    
    */
    private ArrayList<Alimento> listaAlimentos;

    
    /*
    El constructor inicializa la lista de alimentos 
    y carga automaticamente el catalogo de alimentos
    */
    public CatalogoAlimentos() {

        listaAlimentos = new ArrayList<>();

        cargarAlimentos();
    }

    
    /*
    Este metodo crea y registra todos los alimentos de tipo Alimento
    
    Cada alimento contiene:
    -Cantidad de azúcar
    -Cantidad de grasa
    -cantidad de calorias
    */    
    public void cargarAlimentos() {

    Alimento agua = new Alimento();
    agua.setNombre("Agua");
    agua.setAzucar(0);
    agua.setGrasa(0);
    agua.setCalorias(0);
    listaAlimentos.add(agua);

    Alimento te = new Alimento();
    te.setNombre("Te");
    te.setAzucar(0);
    te.setGrasa(0);
    te.setCalorias(5);
    listaAlimentos.add(te);

    Alimento malteada = new Alimento();
    malteada.setNombre("Malteada");
    malteada.setAzucar(35);
    malteada.setGrasa(12);
    malteada.setCalorias(380);
    listaAlimentos.add(malteada);
    
    Alimento gaseosa = new Alimento();
    gaseosa.setNombre("Gaseosa");
    gaseosa.setAzucar(40);
    gaseosa.setGrasa(0);
    gaseosa.setCalorias(150);
    listaAlimentos.add(gaseosa);

    Alimento jugoCaja = new Alimento();
    jugoCaja.setNombre("Jugo de caja");
    jugoCaja.setAzucar(30);
    jugoCaja.setGrasa(0);
    jugoCaja.setCalorias(120);
    listaAlimentos.add(jugoCaja);

    Alimento cafe = new Alimento();
    cafe.setNombre("Cafe");
    cafe.setAzucar(5);
    cafe.setGrasa(1);
    cafe.setCalorias(30);
    listaAlimentos.add(cafe);

    Alimento bebidaEnergetica = new Alimento();
    bebidaEnergetica.setNombre("Bebida energetica");
    bebidaEnergetica.setAzucar(45);
    bebidaEnergetica.setGrasa(0);
    bebidaEnergetica.setCalorias(180);
    listaAlimentos.add(bebidaEnergetica);

    Alimento pizza = new Alimento();
    pizza.setNombre("Pizza");
    pizza.setAzucar(5);
    pizza.setGrasa(20);
    pizza.setCalorias(300);
    listaAlimentos.add(pizza);

    Alimento hamburguesa = new Alimento();
    hamburguesa.setNombre("Hamburguesa");
    hamburguesa.setAzucar(8);
    hamburguesa.setGrasa(25);
    hamburguesa.setCalorias(500);
    listaAlimentos.add(hamburguesa);

    Alimento perroCaliente = new Alimento();
    perroCaliente.setNombre("Perro caliente");
    perroCaliente.setAzucar(6);
    perroCaliente.setGrasa(18);
    perroCaliente.setCalorias(350);
    listaAlimentos.add(perroCaliente);

    Alimento papasFritas = new Alimento();
    papasFritas.setNombre("Papas fritas");
    papasFritas.setAzucar(1);
    papasFritas.setGrasa(15);
    papasFritas.setCalorias(320);
    listaAlimentos.add(papasFritas);
    
    Alimento papitas = new Alimento();
    papitas.setNombre("Papitas de paquete");
    papitas.setAzucar(2);
    papitas.setGrasa(16);
    papitas.setCalorias(320);
    listaAlimentos.add(papitas);

    Alimento galletas = new Alimento();
    galletas.setNombre("Galletas");
    galletas.setAzucar(20);
    galletas.setGrasa(8);
    galletas.setCalorias(210);
    listaAlimentos.add(galletas);

    Alimento mani = new Alimento();
    mani.setNombre("Mani");
    mani.setAzucar(3);
    mani.setGrasa(14);
    mani.setCalorias(170);
    listaAlimentos.add(mani);

    Alimento barras = new Alimento();
    barras.setNombre("Barra de cereal");
    barras.setAzucar(12);
    barras.setGrasa(4);
    barras.setCalorias(140);
    listaAlimentos.add(barras);

    Alimento pastel = new Alimento();
    pastel.setNombre("Pastel");
    pastel.setAzucar(35);
    pastel.setGrasa(12);
    pastel.setCalorias(400);
    listaAlimentos.add(pastel);

    Alimento helado = new Alimento();
    helado.setNombre("Helado");
    helado.setAzucar(28);
    helado.setGrasa(10);
    helado.setCalorias(250);
    listaAlimentos.add(helado);

    Alimento chocolate = new Alimento();
    chocolate.setNombre("Chocolate");
    chocolate.setAzucar(24);
    chocolate.setGrasa(14);
    chocolate.setCalorias(210);
    listaAlimentos.add(chocolate);

    // Continúa exactamente igual...
    }

    //metodo para obtener la lista de los alimentos
    public ArrayList<Alimento> getListaAlimentos(){

        return listaAlimentos;

    }
}