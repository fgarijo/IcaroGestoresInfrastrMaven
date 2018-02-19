package org.icaro.infraestructura.clasesGeneradorasOrganizacion;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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

public class CreacionOrganizacion {

	public static void arranca(String organizacion) {
		// Se guarda el descriptor de la organización
        NombresPredefinidos.DESCRIPCION_XML_POR_DEFECTO = organizacion;

		// Crea el repositorio de interfaces
		ItfUsoRepositorioInterfaces repositorioInterfaces = null;
        try {
        	repositorioInterfaces = ClaseGeneradoraRepositorioInterfaces.instance();
            NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ = repositorioInterfaces;
        } 
        catch (Exception e) {
            System.err.println("Error. No se pudo crear el repositorio de interfaces.");
            e.printStackTrace();
        	System.exit(-1);
       }
        	    
    	// Crea el repositorio de trazas
        ItfUsoRecursoTrazas recursoTrazas = null;
        try {
        	recursoTrazas = ClaseGeneradoraRecursoTrazas.instance();
        	repositorioInterfaces.registrarInterfaz(
        			NombresPredefinidos.ITF_USO + NombresPredefinidos.RECURSO_TRAZAS,
        			recursoTrazas);
        	repositorioInterfaces.registrarInterfaz(
        			NombresPredefinidos.ITF_GESTION + NombresPredefinidos.RECURSO_TRAZAS,
        			recursoTrazas);
        	NombresPredefinidos.RECURSO_TRAZAS_OBJ = recursoTrazas;
        } 
        catch (Exception e) {
        	System.err.println("Error. No se pudo crear o registrar el recurso de trazas");
        	e.printStackTrace();
        	//no es error crítico
        }
        
        // Crea el iniciador que se encarga de crear el resto de componentes
        ItfGestionAgenteReactivo ItfGestIniciador = null;
        ItfUsoAgenteReactivo ItfUsoIniciador = null;
        try {
        	FactoriaAgenteReactivo.instancia().crearAgenteReactivo(NombresPredefinidos.NOMBRE_INICIADOR, NombresPredefinidos.COMPORTAMIENTO_PORDEFECTO_INICIADOR);

        	ItfGestIniciador = (ItfGestionAgenteReactivo) ClaseGeneradoraRepositorioInterfaces.instance().obtenerInterfaz(
        			NombresPredefinidos.ITF_GESTION + NombresPredefinidos.NOMBRE_INICIADOR);
        	ItfUsoIniciador = (ItfUsoAgenteReactivo) ClaseGeneradoraRepositorioInterfaces.instance().obtenerInterfaz(
        			NombresPredefinidos.ITF_USO + NombresPredefinidos.NOMBRE_INICIADOR);
        	
        	// Arranca la organizacion
        	if ((ItfGestIniciador != null)&& (ItfUsoIniciador!= null)) {
        		ItfGestIniciador.arranca();
        	}
        } 
        catch (Exception e) {
        	String msgUsuario = "Error. No se ha podido crear el gestor de organizacion con nombre " + NombresPredefinidos.NOMBRE_GESTOR_ORGANIZACION;
        	recursoTrazas.trazar(NombresPredefinidos.NOMBRE_GESTOR_ORGANIZACION, msgUsuario, NivelTraza.error);
        	System.err.println(msgUsuario);
        	System.exit(-1);
        }
	}		
}

