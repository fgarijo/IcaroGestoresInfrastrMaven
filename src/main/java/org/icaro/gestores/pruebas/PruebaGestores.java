package org.icaro.gestores.pruebas;

import org.icaro.infraestructura.clasesGeneradorasOrganizacion.*;
import org.icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import org.icaro.infraestructura.entidadesBasicas.excepciones.ExcepcionEnComponente;
import org.icaro.infraestructura.patronAgenteReactivo.factoriaEInterfaces.FactoriaAgenteReactivo;
import org.icaro.infraestructura.patronAgenteReactivo.factoriaEInterfaces.ItfGestionAgenteReactivo;
import org.icaro.infraestructura.patronAgenteReactivo.factoriaEInterfaces.ItfUsoAgenteReactivo;
import org.icaro.infraestructura.recursosOrganizacion.configuracion.ItfUsoConfiguracion;
import org.icaro.infraestructura.recursosOrganizacion.recursoTrazas.ItfUsoRecursoTrazas;
import org.icaro.infraestructura.recursosOrganizacion.recursoTrazas.imp.ClaseGeneradoraRecursoTrazas;
import org.icaro.infraestructura.recursosOrganizacion.recursoTrazas.imp.componentes.InfoTraza.NivelTraza;
import org.icaro.infraestructura.recursosOrganizacion.repositorioInterfaces.ItfUsoRepositorioInterfaces;
import org.icaro.infraestructura.recursosOrganizacion.repositorioInterfaces.imp.ClaseGeneradoraRepositorioInterfaces;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PruebaGestores {

    private static final long serialVersionUID = 1L;

    /**
     * M�todo de arranque principal de la organizaci�n
     * 
     * @param args
     *            Entrada: ruta completa hasta el fichero de configuraci�n
     */
    public static void main(String args[]) {

        boolean herramientaArrancada = false;

        // creamos los recursos de la organizaci�n

        ItfUsoConfiguracion configuracionExterna = null;
        ItfUsoRecursoTrazas recursoTrazas = null;
        String msgUsuario;
       


       
            try {
            // Se crea el repositorio de interfaces y el recurso de trazas
               
                ItfUsoRepositorioInterfaces repositorioInterfaces = ClaseGeneradoraRepositorioInterfaces.instance();
                recursoTrazas = ClaseGeneradoraRecursoTrazas.instance();
                    repositorioInterfaces.registrarInterfaz(
                            NombresPredefinidos.ITF_USO + NombresPredefinidos.RECURSO_TRAZAS,
                            recursoTrazas);
                    repositorioInterfaces.registrarInterfaz(
                            NombresPredefinidos.ITF_GESTION + NombresPredefinidos.RECURSO_TRAZAS,
                            recursoTrazas);
                    // Guardamos el recurso de trazas y el repositorio de Itfs en la clase de nombres predefinidos
                     NombresPredefinidos.RECURSO_TRAZAS_OBJ = recursoTrazas;
                     NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ = repositorioInterfaces;
            //       NombresPredefinidos.DESCRIPCION_XML_POR_DEFECTO = NombresPredefinidos.RUTA_DESCRIPCIONES+args[0];
//                     NombresPredefinidos.DESCRIPCION_XML_POR_DEFECTO = args[0];
                } catch (Exception e) {
                    System.err.println("Error. No se pudo crear o registrar el recurso de trazas");
                    e.printStackTrace();
                //no es error critico
               }
            // Se crea el iniciador que se encargara de crear el resto de componentes

            ItfGestionAgenteReactivo ItfGestIniciador = null;
             ItfUsoAgenteReactivo ItfUsoIniciador = null;
                try {
    //                DescInstanciaAgente descGestor = configuracionExterna.getDescInstanciaGestor(NombresPredefinidos.NOMBRE_GESTOR_ORGANIZACION);
                    // creo el agente gestor de organizacion
                   
                    FactoriaAgenteReactivo.instancia().crearAgenteReactivo( NombresPredefinidos.NOMBRE_INICIADOR, NombresPredefinidos.COMPORTAMIENTO_PORDEFECTO_INICIADOR);
               
                    ItfGestIniciador = (ItfGestionAgenteReactivo) ClaseGeneradoraRepositorioInterfaces.instance().obtenerInterfaz(
                            NombresPredefinidos.ITF_GESTION + NombresPredefinidos.NOMBRE_INICIADOR);
                     ItfUsoIniciador = (ItfUsoAgenteReactivo) ClaseGeneradoraRepositorioInterfaces.instance().obtenerInterfaz(
                            NombresPredefinidos.ITF_USO + NombresPredefinidos.NOMBRE_INICIADOR);
                    // arranco la organizacion
                  if ((ItfGestIniciador != null)&& (ItfUsoIniciador!= null)) {
                    ItfGestIniciador.arranca();
           //     DescDefOrganizacion descOrganizacionaCrear = new DescDefOrganizacion();
           //     descOrganizacionaCrear.setIdentFicheroDefOrganizacion(args[0]);
           //         ItfUsoIniciador.aceptaEvento( new EventoRecAgte("crearOrganizacion",descOrganizacionaCrear, "main", "iniciador" ));
                // args[0] contiene el identificador del fichero que contiene la definicion de la organizacion a crear
            //        ItfUsoIniciador.aceptaEvento( new EventoRecAgte("crearOrganizacion",args[0], "main", "iniciador" ));
                        }
                } catch (ExcepcionEnComponente e) {
                    msgUsuario = "Error. No se ha podido crear el gestor de organizacion con nombre " + NombresPredefinidos.NOMBRE_GESTOR_ORGANIZACION;
                    recursoTrazas.trazar(NombresPredefinidos.NOMBRE_GESTOR_ORGANIZACION, msgUsuario, NivelTraza.error);
                    System.err.println(msgUsuario);
                    System.exit(1);
                }
                 catch (Exception e) {
                    msgUsuario = "Error. No se ha podido crear el gestor de organizacion con nombre " + NombresPredefinidos.NOMBRE_GESTOR_ORGANIZACION;
                    recursoTrazas.trazar(NombresPredefinidos.NOMBRE_GESTOR_ORGANIZACION, msgUsuario, NivelTraza.error);
                    System.err.println(msgUsuario);
                    System.exit(1);
                }
            }
     
    }
  