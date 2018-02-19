/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.icaro.infraestructura.patronAgenteCognitivo.procesadorObjetivos.gestorTareas.imp;

import org.icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import org.icaro.infraestructura.entidadesBasicas.comunicacion.ComunicacionAgentes;
import org.icaro.infraestructura.patronAgenteCognitivo.factoriaEInterfacesPatCogn.AgenteCognitivo;
import org.icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Tarea;
import org.icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaAsincrona;
import org.icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;
import org.icaro.infraestructura.patronAgenteCognitivo.procesadorObjetivos.factoriaEInterfacesPrObj.ItfProcesadorObjetivos;
import org.icaro.infraestructura.patronAgenteCognitivo.procesadorObjetivos.gestorTareas.ItfGestorTareas;
import org.icaro.infraestructura.recursosOrganizacion.recursoTrazas.ItfUsoRecursoTrazas;
import org.icaro.infraestructura.recursosOrganizacion.recursoTrazas.imp.componentes.InfoTraza;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;

/**
 *
 * @author 
 */
public class GestorTareasImp implements ItfGestorTareas{
    private AgenteCognitivo agente;
    private ItfProcesadorObjetivos envioHechos;
    private ItfUsoRecursoTrazas trazas;
    private String identTarea;
    private ComunicacionAgentes comunicator;
    private TareaAsincrona tareaAsinc ;
    private String tareaAsincSimpleName;
    private TareaSincrona tareaSinc ;
    private String tareaSincSimpleName;
    private Map<String, TareaSincrona> tareasCreadas;
    private Logger log = Logger.getLogger(GestorTareasImp.class);
    private ExecutorService executorService1;
    private Future ejecucionHebra;
    
    public GestorTareasImp(AgenteCognitivo agente,ItfProcesadorObjetivos envioHechos){
        this.agente = agente;
        this.envioHechos = envioHechos;
        tareaAsincSimpleName = TareaAsincrona.class.getSimpleName();
        tareaSincSimpleName = TareaSincrona.class.getSimpleName();
        this.trazas= NombresPredefinidos.RECURSO_TRAZAS_OBJ;
        comunicator = new ComunicacionAgentes (agente.getIdentAgente());
        tareasCreadas = new HashMap <String, TareaSincrona>();
    }

    @Override
    public Tarea crearTarea(Class clase) throws Exception {
        Tarea tarea = (Tarea)clase.newInstance(); 
        tarea.setEnvioHechos(envioHechos);
        tarea.setAgente(agente);
        tarea.setIdentAgente (agente.getIdentAgente());
        tarea.setComunicator(comunicator);
//        String identTareaLong = tarea.getClass().getName();
//        identTarea = identTareaLong.substring(identTareaLong.lastIndexOf(".")+1);
        String identTarea = tarea.getClass().getSimpleName();
        tarea.setIdentTarea(identTarea);
        log.debug("Tarea creada:"+clase.getName());
        trazas = NombresPredefinidos.RECURSO_TRAZAS_OBJ;		
        return new TareaProxy(tarea);
    }
    @Override
    public TareaSincrona crearTareaSincrona(Class clase) throws Exception {
        String identTarea = clase.getSimpleName();
        if (tareasCreadas.containsKey(identTarea)) return tareasCreadas.get(identTarea);
        TareaSincrona tarea = (TareaSincrona)clase.newInstance(); 
        tarea.setEnvioHechos(envioHechos);
        tarea.setAgente(agente);
        tarea.setIdentAgente (agente.getIdentAgente());
        tarea.setComunicator(comunicator);
//        String identTareaLong = tarea.getClass().getName();
//        identTarea = identTareaLong.substring(identTareaLong.lastIndexOf(".")+1);
//        String identTarea = tarea.getClass().getSimpleName();
        tareasCreadas.put(identTarea, tarea);
        tarea.setIdentTarea(identTarea);
        log.debug("Tarea creada:"+clase.getName());
        tarea.setTrazas(NombresPredefinidos.RECURSO_TRAZAS_OBJ);	
        return tarea;
    }
    @Override
    public TareaSincrona crearTareaAsincrona(Class clase) throws Exception {
        String identTarea = clase.getSimpleName();
        if (tareasCreadas.containsKey(identTarea)) return tareasCreadas.get(identTarea);
        TareaAsincrona tarea = (TareaAsincrona)clase.newInstance(); 
        tarea.setEnvioHechos(envioHechos);
        tarea.setAgente(agente);
        tarea.setIdentAgente (agente.getIdentAgente());
        tarea.setComunicator(comunicator);
//        String identTareaLong = tarea.getClass().getName();
//        identTarea = identTareaLong.substring(identTareaLong.lastIndexOf(".")+1);
//        String identTarea = tarea.getClass().getSimpleName();
        tareasCreadas.put(identTarea, tarea);
        tarea.setIdentTarea(identTarea);
        log.debug("Tarea creada:"+clase.getName());
        tarea.setTrazas(NombresPredefinidos.RECURSO_TRAZAS_OBJ);	
        return tarea;
    }
    public void inicializarTarea(TareaSincrona tarea) throws Exception {
    //    TareaSincrona tarea = (TareaSincrona)clase.newInstance(); 
        tarea.setEnvioHechos(envioHechos);
        tarea.setAgente(agente);
        tarea.setIdentAgente (agente.getIdentAgente());
        tarea.setComunicator(comunicator);
        tarea.setIdentTarea(tarea.getClass().getSimpleName());
 //       log.debug("Tarea creada:"+clase.getName());
 //       tarea.trazas = NombresPredefinidos.RECURSO_TRAZAS_OBJ;	
 //       return tarea;
    }
    
    @Override
    public void ejecutar(Object... paramsEjecucion) throws Exception {
        Class claseTareaEjecutar = (Class)paramsEjecucion[0];
       // Extraccion de parametros y verificacion de la clase
        String superclase = claseTareaEjecutar.getSuperclass().getSimpleName();
        int numparam = paramsEjecucion.length -1;
        
   
        for (int i = 0; i<numparam; i++){
           paramsEjecucion[i]= paramsEjecucion[i+1];
        }
            paramsEjecucion[numparam]=null;
        if (superclase.equals(tareaSincSimpleName) ) {
            tareaSinc = crearTareaSincrona(claseTareaEjecutar);
            tareaSinc.ejecutar(paramsEjecucion);
        }
        else if (superclase.equals(tareaAsincSimpleName)){
             tareaAsinc = (TareaAsincrona) claseTareaEjecutar.newInstance();
             inicializarTarea(tareaAsinc);
             tareaAsinc.setParams(paramsEjecucion);
             ejecucionHebra = executorService1.submit(tareaAsinc);
//             tareaAsinc.comenzar();
        }
        else {
            this.trazas.trazar ( this.getClass().getSimpleName(), "Error en  la ejecucion de la tarea: "+ claseTareaEjecutar.getSimpleName() +
                    " debe extender a TareaSincrona o a TareaAsincrona ", InfoTraza.NivelTraza.error );
        }
        }
    }
 
