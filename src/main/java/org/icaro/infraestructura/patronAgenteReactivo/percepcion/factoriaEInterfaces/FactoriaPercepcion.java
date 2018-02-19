package org.icaro.infraestructura.patronAgenteReactivo.percepcion.factoriaEInterfaces;

import org.icaro.infraestructura.patronAgenteReactivo.control.factoriaEInterfaces.ItfControlAgteReactivo;
import org.icaro.infraestructura.patronAgenteReactivo.factoriaEInterfaces.AgenteReactivoAbstracto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.icaro.infraestructura.patronAgenteReactivo.percepcion.factoriaEInterfaces.imp.FactoriaPercepcionImp;


/**
 * 
 *@author     Felipe Polo
 *@created    30 de noviembre de 2007
 */

public abstract class FactoriaPercepcion {
    
    private static FactoriaPercepcion instancia;
    
    public static FactoriaPercepcion instancia(){
        Log log = LogFactory.getLog(FactoriaPercepcion.class);
        if(instancia==null){
        	
//            String clase = System.getProperty("icaro.infraestructura.patronAgenteReactivo.percepcion.factoriaEInterfaces.imp",
//                    "icaro.infraestructura.patronAgenteReactivo.percepcion.factoriaEInterfaces.imp.FactoriaPercepcionImp");
//            try{
//                instancia = (FactoriaPercepcion)Class.forName(clase).newInstance();
//            }catch(Exception ex){
//                log.error("Implementacion de la Percepcion no encontrado",ex);
//            }
            return new FactoriaPercepcionImp();
        }
        return instancia;
    }
    
    public abstract PercepcionAbstracto crearPercepcion();
    public abstract PercepcionAbstracto crearPercepcion(AgenteReactivoAbstracto agente,ItfControlAgteReactivo itfControl);
    
}
