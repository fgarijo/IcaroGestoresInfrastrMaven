package org.icaro.infraestructura.patronAgenteReactivo.percepcion.factoriaEInterfaces.imp;


import org.icaro.infraestructura.patronAgenteReactivo.control.factoriaEInterfaces.ItfControlAgteReactivo;
import org.icaro.infraestructura.patronAgenteReactivo.factoriaEInterfaces.AgenteReactivoAbstracto;
import org.icaro.infraestructura.patronAgenteReactivo.percepcion.factoriaEInterfaces.FactoriaPercepcion;
import org.icaro.infraestructura.patronAgenteReactivo.percepcion.factoriaEInterfaces.PercepcionAbstracto;



/**
 * 
 *@author     F Garijo
 *@created    
 */

public class FactoriaPercepcionImp extends FactoriaPercepcion{  
	public PercepcionAbstracto crearPercepcion(){
//        return new PercepcionImp();
//        return new PercepcionImp2();
// En esta version la factoria crea el procesador de items y la clase que implmenta las interfaces de la percepcion
          return new PercepcionAgenteReactivoImp();
        //elijo la nica implementacin posible (aunque podra haber ms)
    
        }
 public  PercepcionAbstracto crearPercepcion(AgenteReactivoAbstracto agente,ItfControlAgteReactivo itfControl) {

       return new PercepcionAgenteReactivoImp(agente,new ProcesadorItemsPercepReactivo(agente,itfControl));
    }
}