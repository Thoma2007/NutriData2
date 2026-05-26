package com.mycompany.nutrialert;

//Aqui importamos las clases que vamos a usar de otros paquetes

import modelo.Usuario;
import modelo.Alimento;
import modelo.ConsumoAlimento;

import controlador.AnalizadorNutricional;
import controlador.CatalogoAlimentos;
import conexion.ConexionBD;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

            // CONEXION A LA BD
            Connection conexion = ConexionBD.conectar();

            int continuarUsuarios;

            do {
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

                // GUARDAR USUARIO EN BD
                String sqlUsuario = """
                    INSERT INTO usuario(nombre, edad, peso, altura)
                    VALUES (?, ?, ?, ?) """;

                PreparedStatement psUsuario = conexion.prepareStatement(sqlUsuario);

                psUsuario.setString(1, usuario.getNombre());
                psUsuario.setInt(2, usuario.getEdad());
                psUsuario.setDouble(3, usuario.getPeso());
                psUsuario.setDouble(4, usuario.getAltura());

                psUsuario.executeUpdate();

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

                    // GUARDAR SOLO EL ALIMENTO CONSUMIDO
                    String sqlBuscar = "SELECT * FROM alimento WHERE nombre = ?";

                    PreparedStatement psBuscar = conexion.prepareStatement(sqlBuscar);
                    psBuscar.setString(1, alimento.getNombre());

                    ResultSet rs = psBuscar.executeQuery();

                    if (!rs.next()) {

                        String sqlAlimento = """
                            INSERT INTO alimento(nombre, azucar, grasa, calorias)
                            VALUES (?, ?, ?, ?)""";

                        PreparedStatement psAlimento = conexion.prepareStatement(sqlAlimento);

                        psAlimento.setString(1, alimento.getNombre());
                        psAlimento.setDouble(2, alimento.getAzucar());
                        psAlimento.setDouble(3, alimento.getGrasa());
                        psAlimento.setDouble(4, alimento.getCalorias());

                        psAlimento.executeUpdate();
                    }

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

                //Preguntamos si desea registrar otro usuario
                continuarUsuarios = JOptionPane.showConfirmDialog(null, "¿Desea registrar otro usuario?", "Continuar", JOptionPane.YES_NO_OPTION);


            } while (continuarUsuarios == JOptionPane.YES_OPTION);

            JOptionPane.showMessageDialog(null, "Gracias por usar NutriData. \nNospi...");
            
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocurrió un error. " + e.getMessage());

        }
    }
}