package modelo;

/*
    La clase Alimento representa
    cada alimento disponible dentro del sistema

    Cada alimento tiene propiedades nutricionales
    distintas

    -Azúcar
    -Grasa
    -Calorías

    Estos datos se usan para realizar analisis
*/

public class Alimento {


    // ATRIBUTOS - características del alimento


    private int id;
    private String nombre;
    private double azucar;
    private double grasa;
    private double calorias;


    // CONSTRUCTOR VACÍO


    public Alimento() {

    }


    // CONSTRUCTOR LLENO


    public Alimento(int id, String nombre,
                     double azucar,
                     double grasa,
                     double calorias) {

        this.id = id;
        this.nombre = nombre;
        this.azucar = azucar;
        this.grasa = grasa;
        this.calorias = calorias;
    }


    // GETTERS Y SETTERS


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getAzucar() {
        return azucar;
    }

    public void setAzucar(double azucar) {
        this.azucar = azucar;
    }

    public double getGrasa() {
        return grasa;
    }

    public void setGrasa(double grasa) {
        this.grasa = grasa;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }
}
