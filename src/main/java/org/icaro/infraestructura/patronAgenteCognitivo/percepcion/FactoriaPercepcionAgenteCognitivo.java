package org.icaro.infraestructura.patronAgenteCognitivo.percepcion;

import org.icaro.infraestructura.patronAgenteCognitivo.factoriaEInterfacesPatCogn.AgenteCognitivo;
import org.icaro.infraestructura.patronAgenteCognitivo.percepcion.imp.FactoriaPercepcionAgenteCognitivoImp;
import org.icaro.infraestructura.patronAgenteCognitivo.percepcion.imp.FactoriaPercepcionAgenteCognitivoImp2;
import org.icaro.infraestructura.patronAgenteCognitivo.procesadorObjetivos.factoriaEInterfacesPrObj.ItfProcesadorObjetivos;


/**
 * Factory for Cognitive Agent Perception
 * @author Carlos Celorrio
 *
 */
public abstract class FactoriaPercepcionAgenteCognitivo {
	
	private static FactoriaPercepcionAgenteCognitivo instance;
	
	/**
     * Gets the singleton instance of this factory.
     * @return A cognitive agent perception factory
     */
	public static FactoriaPercepcionAgenteCognitivo instance() {
		if (instance == null)
			instance = new FactoriaPercepcionAgenteCognitivoImp2();
		
	return instance;
	}
	
	
	public abstract  PercepcionAgenteCognitivo crearPercepcion( AgenteCognitivo agenteCognitivo, ItfProcesadorObjetivos itfProcesadorEvidencias);

}
