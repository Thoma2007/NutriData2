package modelo;

/*
Esta clase representa el consumo de un alimento 
realizaso por un usuario

Aqui se hace una relacion
Usuario - Alimento

Ademas almacena:
-Cantidad consumida
-tipo de comida
-fecha

Esta clase conecta toda la informacion nutricional del sistema
*/

public class ConsumoAlimento {


    // ATRIBUTOS


    //Usuario que consume el alimento.

    private Usuario usuario;

    //Alimento consumido.

    private Alimento alimento;

    
    //Cantidad consumida.
     
    private int cantidad;

    
    //Tipo de comida:
    //-desayuno, almuerzo, cena, snack.
    
    private String tipoComida;

    
    //Fecha del consumo.
    
    private String fecha;


    // CONSTRUCTOR VACÍO


    public ConsumoAlimento() {

    }


    // CONSTRUCTOR COMPLETO


    public ConsumoAlimento(Usuario usuario,
                           Alimento alimento,
                           int cantidad,
                           String tipoComida,
                           String fecha) {

        this.usuario = usuario;
        this.alimento = alimento;
        this.cantidad = cantidad;
        this.tipoComida = tipoComida;
        this.fecha = fecha;
    }


    // GETTERS Y SETTERS
    //Para obtener y modificar la informacion


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}