package org.icaro.infraestructura.patronAgenteCognitivo.percepcion.imp;

import org.icaro.infraestructura.patronAgenteCognitivo.factoriaEInterfacesPatCogn.AgenteCognitivo;
import org.icaro.infraestructura.patronAgenteCognitivo.percepcion.FactoriaPercepcionAgenteCognitivo;
import org.icaro.infraestructura.patronAgenteCognitivo.percepcion.PercepcionAgenteCognitivo;
import org.icaro.infraestructura.patronAgenteCognitivo.procesadorObjetivos.factoriaEInterfacesPrObj.ItfProcesadorObjetivos;


/**
 * Implementation for Cognitive Agent Perception Factory
 * @author Carlos Celorrio
 *
 */
public class FactoriaPercepcionAgenteCognitivoImp extends FactoriaPercepcionAgenteCognitivo {


	@Override
//	public PercepcionAgenteCognitivo crearPercepcion( AgenteCognitivo cognitiveAgent) {
       public PercepcionAgenteCognitivo crearPercepcion( AgenteCognitivo cognitiveAgent, ItfProcesadorObjetivos itfProcesadorEvidencias){

            return new PercepcionAgenteCognitivoImp(cognitiveAgent);
	}

}
