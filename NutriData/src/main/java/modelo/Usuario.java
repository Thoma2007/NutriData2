package modelo;

/*
La clase Usuario representa a las personas
que van a usar NUTRIDATA

Aqui se guardan los datos personales de cada 
usuario, para poder realizar analisis nutricionales

Guardamos:
-nombre
-edad
-peso
-altura

Esta clase funciona como un modelo de datos

*/
public class Usuario {
    
    //------------------
    //Atributos
    //------------------
    
    private int id;
    private String nombre;
    private int edad;
    private double peso;
    private double altura;
    
    
    //Constructor vacio
    //Permite crear un usuario vacio

    public Usuario() {
    }
    
    

    //Constructor lleno
    //Permite crear un usuario con todos sus datos   

    public Usuario(int id, String nombre, int edad, double peso, double altura) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }
    
    //Getters y Setters
    //Para obtener y modificar los datos      

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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    
    
    
}