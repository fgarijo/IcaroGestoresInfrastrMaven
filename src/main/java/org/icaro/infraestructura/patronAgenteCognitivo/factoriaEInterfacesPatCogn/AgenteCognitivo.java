package org.icaro.infraestructura.patronAgenteCognitivo.factoriaEInterfacesPatCogn;

import org.icaro.infraestructura.entidadesBasicas.componentesBasicos.automatas.automataEFsinAcciones.ItfUsoAutomataEFsinAcciones;
import org.icaro.infraestructura.entidadesBasicas.comunicacion.EventoRecAgte;
import org.icaro.infraestructura.entidadesBasicas.comunicacion.MensajeSimple;
import org.icaro.infraestructura.entidadesBasicas.interfaces.InterfazGestion;
import org.icaro.infraestructura.patronAgenteCognitivo.percepcion.PercepcionAgenteCognitivo;
import org.icaro.infraestructura.patronAgenteCognitivo.procesadorObjetivos.factoriaEInterfacesPrObj.ProcesadorObjetivos;
import java.rmi.server.UnicastRemoteObject;

/**
 * Cognitive Agent abstract class that provides use and management interfaces
 * @author carf
 * @author Carlos Celorrio
 */
public abstract class AgenteCognitivo extends UnicastRemoteObject implements ItfUsoAgenteCognitivo, InterfazGestion {
	
    public AgenteCognitivo () throws java.rmi.RemoteException { }
    public abstract void setComponentesInternos(ItfUsoAutomataEFsinAcciones itfAutomataCiclVidaAgente,PercepcionAgenteCognitivo percepcion,ProcesadorObjetivos procObjetivos);
    public abstract void setEstado(String estado);
    @Override
    public abstract String getIdentAgente();
    public abstract ProcesadorObjetivos getControl();
    public abstract PercepcionAgenteCognitivo getPercepcion();
    @Override
    public abstract void aceptaMensaje(MensajeSimple mensaje);
    @Override
    public abstract void aceptaEvento(EventoRecAgte evento);
}
