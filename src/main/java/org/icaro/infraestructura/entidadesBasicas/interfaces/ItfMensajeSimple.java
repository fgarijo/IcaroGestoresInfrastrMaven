package org.icaro.infraestructura.entidadesBasicas.interfaces;

import org.icaro.infraestructura.entidadesBasicas.comunicacion.MensajeSimple;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ItfMensajeSimple extends Remote {
	
	 public void aceptaMensaje(MensajeSimple mensaje)throws RemoteException;

}
