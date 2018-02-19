package org.icaro.infraestructura.patronAgenteCognitivo.percepcion;

import org.icaro.infraestructura.entidadesBasicas.interfaces.ItfEventoSimpe;
import org.icaro.infraestructura.entidadesBasicas.interfaces.ItfMensajeSimple;
import org.icaro.infraestructura.patronAgenteCognitivo.factoriaEInterfacesPatCogn.AgenteCognitivo;
import org.icaro.infraestructura.patronAgenteCognitivo.percepcion.imp.ProcesadorItems;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * Abstract Class for Cognitive Agent Perception
 * @author Carlos Celorrio
 *
 */
public abstract class PercepcionAgenteCognitivo implements ItfEventoSimpe, ItfMensajeSimple, ItfGestPercepcionAgenteCognitivo {
public abstract void SetParametrosPercepcionAgenteCognitivoImp(LinkedBlockingQueue<Object> colaEvtosyMsgs, ProcesadorItems prItems,AgenteCognitivo agente);
}
