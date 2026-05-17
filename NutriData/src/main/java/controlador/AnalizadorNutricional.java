package controlador;

import modelo.ConsumoAlimento;
import modelo.Usuario;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

/*
Esta clase se encarga de analizar 
la informacion nutricional del usuario

Procesa todos los consumos registrados 
y calcula:

-Azucar total 
-Grasa total
-Calorias totales

Tambien le genera la alerta si el usuario excede el limite 
nutricional

*/

public class AnalizadorNutricional {
   
    //Limites maximos recomendados para detectar excesos alimenticios
    private final double LIMITE_AZUCAR = 25;
    private final double LIMITE_GRASA = 70;
    private final double LIMITE_CALORIAS = 2000;
    
    /*
    Este metodo recibe el ArrayList de consumos alimenticios
    
    Luego:
    1.Recorre todos los consumos del usuario
    2.Calcula nutrientes totales
    3.Genera un resumen nutricional(Reporte de lo q consumio)
    4.Detecta Excesos
    5.Muestra alertas nutricionales(Si es el caso)
    
    */
    public void analizarConsumos(ArrayList<ConsumoAlimento> listaConsumos){
    
        //Variables acumuladoras        
        double totalAzucar = 0;
        double totalGrasa = 0;
        double totalCalorias = 0;
        
        //Resumen nutricional
        String resultado = "";
        resultado += "---- NUTRIDATA ----\n\n";
        
        //Obtener al usuario
        Usuario usuario = listaConsumos.get(0).getUsuario();
        
        resultado += "Usuario: " + usuario.getNombre() + "\n\n";
        resultado += "ALIMENTOS CONSUMIDOS\n\n";
        
        
        //Recorremos la lista
        for (ConsumoAlimento consumo : listaConsumos) {
            
            //Obtenemod los datos del consumo
            String nombreAlimento = consumo.getAlimento().getNombre();
            int cantidad = consumo.getCantidad();
            String tipoComida = consumo.getTipoComida();
            
            //Calculamos los nutrientes
            double azucar = consumo.getAlimento().getAzucar() * consumo.getCantidad();
            double grasa = consumo.getAlimento().getGrasa() * consumo.getCantidad();
            double calorias = consumo.getAlimento().getCalorias() * consumo.getCantidad();
            
            //Sumamos los acumuladores
            totalAzucar += azucar;
            totalGrasa += grasa;
            totalCalorias += calorias;
            
            //Agregamos esta informacion al reporte
            resultado += "- " + nombreAlimento + "\n";
            resultado += "Cantidad: " + cantidad + "\n";
            resultado += "Tipo de comida: " + tipoComida + "\n";
            resultado += "Azúcar: " + azucar + "\n";
            resultado += "Grasa: " + grasa + "\n";
            resultado += "Calorías: " + calorias + "\n";                                                             
        }
        
        //Total consumido
        resultado += "-----------------------------------\n\n";
        resultado += "Azúcar total: " + totalAzucar + "\n";
        resultado += "Grasa total: " + totalGrasa + "\n";
        resultado += "Calorías totales: " + totalCalorias + "\n\n";
            
        //Alerta nutricional, esta solo se mostrará 
        //si se excede alguno de los LIMITES_NUTRICIONALES
            
            
        //Alerta por exceso de azúcar            
        if (totalAzucar > LIMITE_AZUCAR) {

            resultado += "========================\n";

            resultado += "ALERTA\n";

            resultado += "Exceso de azúcar detectado\n";

            resultado += "Total: " + totalAzucar + "g\n";

            resultado += "========================\n";
        }       
            
        //Alerta por limite de grasa
        if (totalGrasa > LIMITE_GRASA) {

            resultado += "========================\n";

            resultado += "ALERTA\n";

            resultado += "Alto consumo de grasas\n";

            resultado += "Total: " + totalGrasa + "g\n";

            resultado += "========================\n";
        } 
            
        //Alerta por limite de calorias
        if (totalCalorias > LIMITE_CALORIAS) {

            resultado += "========================\n";

            resultado += "ALERTA\n";

            resultado += "Exceso calorico detectado\n";

            resultado += "Total: " + totalCalorias + "kcal\n";

            resultado += "========================\n";                
        }
        
        JTextArea  areaTexto = new JTextArea(resultado);
        
        areaTexto.setEditable(false);
        
        areaTexto.setLineWrap(true);
        
        areaTexto.setWrapStyleWord(true);
        
        //Scroll
        JScrollPane scroll = new JScrollPane(areaTexto);
        
        scroll.setPreferredSize(new java.awt.Dimension(500, 400));
        
        //Mostrar el resultado
        JOptionPane.showMessageDialog(null, scroll, "ANÁLISIS NUTRICIONAL", JOptionPane.INFORMATION_MESSAGE);
        
    
    }

    {
        System.out.println(Eroror);
    }

    
}
