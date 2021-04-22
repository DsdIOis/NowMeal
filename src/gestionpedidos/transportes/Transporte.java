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

public abstract class Transporte {
	/*
	- codigo : String
	- mapa : Mapa*/
	
	private String codigo;
	private Mapa mapa;
	/*+ Transporte (codigo : String, mapa : Mapa)
	 * 
	 */
	public Transporte (String codigo,Mapa mapa) {
		this.codigo=codigo;
		this.mapa=mapa;
	}
	
	/*
	 * +getCodigo():String 
	 */
	public String getCodigo() {
		return codigo;
	}
	/*
	 *+setCodigo()
	 */
	public void setCodigo(String codigo) {
		this.codigo=codigo;
	}
	
	/*
	 * + coste (posDestino : String) : double
	 * POST:  devuelve el coste en euros que supone para el transporte ir 
	 * desde su ubicaci車n actual hasta la ubicaci車n del objeto con c車digo posDestino.
	 */
	
	
	public double coste(String posDestino) {
		return coste(getCodigo(),posDestino);
	}
	

	/* + coste (cod1 : String, cod2 : String) : double
	 * POST: devuelve el coste en euros que supone para el transporte ir 
	 * desde la ubicaci車n del objeto con c車digo cod1 hasta la ubicaci車n del 
	 * objeto con c車digo cod2. Se declara como m谷todo abstracto que luego 
	 * se sobrescribe en las clases Moto, FurgonetaPropia y FurgonetaSubcontratada.
	 */
	
	
	public abstract double coste(String cod1,String cod2) ;
	
	
	/*
	 * # getMapa () : Mapa
	 */
	
	public Mapa getMapa() {
		return mapa;
	}
	
}
