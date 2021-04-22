package gestionpedidos.transportes;
import gestionpedidos.mapa.*;
import anotacion.Programacion2;

@Programacion2 (
nombreAutor1 = "ZhengYu",
apellidoAutor1 = "Ye",
emailUPMAutor1 = "z.ye@alumnos.upm.es",
nombreAutor2 = "Jaime",
apellidoAutor2 = "L¨®pez Hidalgo", 
emailUPMAutor2 = "jaime.lopez.hidalgo@alumnos.upm.es"
	)


public abstract class Furgoneta extends Transporte{
	/*
	 * - tara : double
	 */
	private double tara;
	/*
	 * + Furgoneta (codigo : String, mapa : Mapa, tara : double)
	 */

	public Furgoneta(String codigo,Mapa mapa,double tara) {
		super(codigo,mapa);
		this.tara=tara;
	}
	/*
	 * + getTara : double
	 */

	public double getTara() {
		return tara;
	}
	/*
	 * + setTara : double
	 */

	public void setTara(double tara) {
		this.tara = tara;
	}
	
}
