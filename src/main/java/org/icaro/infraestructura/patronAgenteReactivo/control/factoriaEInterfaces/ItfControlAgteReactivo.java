/*
 *  
 *
 *
 *  All rights reserved
 */
package org.icaro.infraestructura.patronAgenteReactivo.control.factoriaEInterfaces;

import org.icaro.infraestructura.entidadesBasicas.comunicacion.InfoContEvtMsgAgteReactivo;
import org.icaro.infraestructura.entidadesBasicas.interfaces.InterfazGestion;

 import org.icaro.infraestructura.patronAgenteReactivo.factoriaEInterfaces.ItfUsoAgenteReactivo;

/**
 * 
 *@author     F Garijo
 *@created    10 de enero  de 2014
 */

public interface ItfControlAgteReactivo extends InterfazGestion {

public void setGestorAReportar(ItfUsoAgenteReactivo itfUsoGestorAReportar);
public ItfUsoAgenteReactivo getGestorAReportar();
//public void procesarInfoControlAgteReactivo (InfoContEvtMsgAgteReactivo infoParaProcesar  );
public void procesarInfoControlAgteReactivo (Object infoParaProcesar  );
public void procesarInput (Object input, Object ...paramsAccion  );
public String getEstadoControlAgenteReactivo ( );
}
