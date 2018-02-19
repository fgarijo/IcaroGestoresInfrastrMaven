/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.icaro.infraestructura.patronAgenteCognitivo.procesadorObjetivos.gestorTareas.imp;

import org.icaro.infraestructura.patronAgenteCognitivo.factoriaEInterfacesPatCogn.AgenteCognitivo;
import org.icaro.infraestructura.patronAgenteCognitivo.procesadorObjetivos.factoriaEInterfacesPrObj.ItfProcesadorObjetivos;
import org.icaro.infraestructura.patronAgenteCognitivo.procesadorObjetivos.gestorTareas.ItfGestorTareas;
import org.icaro.infraestructura.patronAgenteCognitivo.procesadorObjetivos.gestorTareas.TaskManagerFactory;



/**
 *
 * @author carf
 */
public class TaskManagerFactoryImp extends TaskManagerFactory {

    @Override
    public ItfGestorTareas createTaskManager(AgenteCognitivo agent, ItfProcesadorObjetivos envioHechos) {
        return new GestorTareasImp(agent,envioHechos);
    }

}
