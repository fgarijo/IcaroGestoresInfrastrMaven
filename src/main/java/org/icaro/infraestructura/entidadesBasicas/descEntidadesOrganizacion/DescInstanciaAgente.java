package org.icaro.infraestructura.entidadesBasicas.descEntidadesOrganizacion;

import org.icaro.infraestructura.entidadesBasicas.descEntidadesOrganizacion.jaxb.DescComportamientoAgente;
import org.icaro.infraestructura.entidadesBasicas.interfaces.InterfazGestion;
import org.icaro.infraestructura.entidadesBasicas.interfaces.InterfazUsoAgente;

public class DescInstanciaAgente extends DescInstancia {
	
	private DescComportamientoAgente  descComportamiento;
        private InterfazUsoAgente itfUso = null;
        private InterfazGestion itfGestion = null;
	
	
	public DescComportamientoAgente getDescComportamiento() {
		return descComportamiento;
	}
	public void setDescComportamiento(DescComportamientoAgente descComportamiento) {
		this.descComportamiento = descComportamiento;
	}
        public void setIntfUsoAgente(InterfazUsoAgente itfUsoAgte) {
		this.itfUso = itfUsoAgte;
	}
         public void setIntfGestionAgente(InterfazGestion itfGesAgte) {
		this.itfGestion = itfGesAgte;
	}
         public InterfazUsoAgente getIntfUsoAgente() {
		return itfUso;
	}
          public InterfazGestion getIntfGestionAgente() {
		return itfGestion;
	}
}
