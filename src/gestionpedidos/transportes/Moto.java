package gestionpedidos.transportes;
import gestionpedidos.mapa.*;
import anotacion.Programacion2;

@Programacion2 (
nombreAutor1 = "ZhengYu",
apellidoAutor1 = "Ye",
emailUPMAutor1 = "z.ye@alumnos.upm.es",
nombreAutor2 = "Jaime",
apellidoAutor2 = "L車pez Hidalgo", 
emailUPMAutor2 = "jaime.lopez.hidalgo@alumnos.upm.es"
	)
public class Moto extends Transporte{
	/*
	 * - eurosPKm : double = 2
	 */

	private double eurosPKm=2;

/*
 * + Moto (codigo : String, mapa : Mapa)
 */

	public Moto(String codigo,Mapa mapa) {
		super(codigo,mapa);
	}
	/*
	 * + getEurosPKm : double
	 */

	public double getEurosPKm() {
		return eurosPKm;
	}
	/*
	 * + setEurosPKm : double
	 */

	public void setEurosPKm(double eurosPKm) {
		this.eurosPKm = eurosPKm;
	}
	
	/*
	 * + coste (codOrigen : String, codDestino : String) : double
	 * POST:devuelve el coste en euros que supone para el transporte ir
	 * desde la ubicaci車n del objeto con c車digo codPosOrigen hasta la ubicaci車n del objeto con c車digo
	 * codPosDestino
	 */
	
	@Override
	public double coste(String codOrigen, String codDestino) {

		return super.getMapa().distancia(codOrigen,codDestino)*eurosPKm;
	}
	
}
