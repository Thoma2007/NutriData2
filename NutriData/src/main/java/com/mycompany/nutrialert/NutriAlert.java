package com.mycompany.nutrialert;

//Aqui importamos las clases que vamos a usar de otros paquetes

import modelo.Usuario;
import modelo.Alimento;
import modelo.ConsumoAlimento;

import controlador.AnalizadorNutricional;
import controlador.CatalogoAlimentos;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/*
Clase principal de sistema NutriData

Desde aqui se inicia la ejecucion completa del programa

En esta clase se encarga de:
Registrar al usuario con todos sus datos
Mostrar el catalogo de alimentos
Registra los consumos del usuario
Almacena la informacion nutricional
Ejecuta el analisador nutricional

*/

//holaaaa

public class NutriAlert {  

    public static void main(String[] args) {
                
        
        try {
            
            //Creamos el usuario
            Usuario usuario = new Usuario();
        
            //Almacenamos la informacion del cliente
            usuario.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del usuario: "));
            while(true){
                try {
                    usuario.setEdad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad:")));
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número entero para la edad.", "Dato invalido", JOptionPane.ERROR_MESSAGE);
                }
            }

            while (true) {
                try {
                    usuario.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso: ")));
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Debe ingresar un valor numérico válido para el peso (Ej: 70.5).", "Dato Inválido", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            while (true) {
                try {
                    usuario.setAltura(Double.parseDouble(JOptionPane.showInputDialog("Ingrese la altura: ")));
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Debe ingresar un valor numérico válido para la altura (Ej: 1.75).", "Dato Inválido", JOptionPane.ERROR_MESSAGE);
                }
            }
        
            //Creamos el ArrayList para registrar todos los consumos del usuario
        
            ArrayList<ConsumoAlimento> listaConsumos = new ArrayList<>();
            
            //Creamos el catalogo
            CatalogoAlimentos catalogo = new CatalogoAlimentos();
            
            int opc = 0;
            
            
            /*Este ciclo permite registrar
            varios alimentos consumidos hasta
            que el usuario desee salir
            */
            
            do {
                
                //Mostramos el catalogo de alimentos
                String menu = "Selecciones alimento\n\n";
                
                //Obtenemos el catalogo de los alimentos
                ArrayList<Alimento> alimentos = catalogo.getListaAlimentos();
                
                //Recorremos la lista de alimentos
                for (int i = 0; i < alimentos.size(); i++) {
                    
                    menu += (i + 1) + ". " + alimentos.get(i).getNombre() + "\n";                    
                    
                }
                
                //Mostramos el catalogo pero con scroll, para que no se salga de la pantalla
                JTextArea areaTexto = new JTextArea(menu);
                areaTexto.setEditable(false);
                
                JScrollPane scroll = new JScrollPane(areaTexto);
                scroll.setPreferredSize(new java.awt.Dimension(300, 400));
                
                //Mostrar el catalogo
                JOptionPane.showMessageDialog(null, scroll, "CATALOGO DE ALIMENTOS", JOptionPane.INFORMATION_MESSAGE);
                int opcionAlimento = 0;
                while (true) {
                    try {
                        opcionAlimento = Integer.parseInt(JOptionPane.showInputDialog("Seleccione un número de alimento"));
                        
                        // Validar que el número corresponda a un alimento de la lista
                        if (opcionAlimento >= 1 && opcionAlimento <= alimentos.size()) {
                            break; 
                        } else {
                            JOptionPane.showMessageDialog(null, "Error: El número seleccionado no está en el catálogo.", "Rango Inválido", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número entero.", "Dato Inválido", JOptionPane.ERROR_MESSAGE);
                    }
                }            
                
                //Seleccionar el alimento
                Alimento alimento = alimentos.get(opcionAlimento - 1);
                
                //Crear consumo
                ConsumoAlimento consumo = new ConsumoAlimento();
                
                //Guardamos los datos del consumo del usuario
                consumo.setUsuario(usuario);
                consumo.setAlimento(alimento);
                while (true) {
                    try {
                        consumo.setCantidad(Integer.parseInt(JOptionPane.showInputDialog("Cantidad: ")));
                        break;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número entero.", "Dato Inválido", JOptionPane.ERROR_MESSAGE);
                    }
                }
                consumo.setTipoComida(JOptionPane.showInputDialog("Tipo de comida: "));
                consumo.setFecha(JOptionPane.showInputDialog("Fecha: "));
                
                
                //Aqui guardamos el consumo en el ArrayLisr
                listaConsumos.add(consumo);
                
                //Ciclo de los consumos - CONTINUAR
                opc = JOptionPane.showConfirmDialog(null, "Desea agregar otro alimento");
                
            } while (opc == 0);
            
            
            //Ahora que ya tenemos el consumo del usuario
            //Invocamos a un metodo para analizar el consumo
            
            AnalizadorNutricional analizador = new AnalizadorNutricional();
            
            analizador.analizarConsumos(listaConsumos);
            
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Ocurrió un error. " + e.getMessage());
            
        }                                                                                                
    }
}