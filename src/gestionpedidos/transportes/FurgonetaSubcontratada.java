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
public class FurgonetaSubcontratada extends Furgoneta{
	/*
	 * - eurosPKm : double = 1
	 */

	private double eurosPKm=1;
	
	
	/*
	 * + FurgonetaSubcontratada (codigo : String, mapa : Mapa, tara : double)
	 * POST: Inicializa los atributos del objeto con los
	 * argumentos recibidos como entrada.
	 */

	public FurgonetaSubcontratada(String codigo,Mapa mapa,double tara){
		super(codigo,mapa,tara);
	}
	/*
	 * getEurosPKm : double
	 */

	public double getEurosPKm() {
		return eurosPKm;
	}
	/*
	 * setEurosPKm : double
	 */

	public void setEurosPKm(double eurosPKm) {
		this.eurosPKm = eurosPKm;
	}

/*
 * coste (codOrigen : String, codDestino : String) : double
 * POST:  devuelve el coste en euros que supone para el transporte ir
 * desde la ubicaci車n del objeto con c車digo codPosOrigen hasta la ubicaci車n del objeto con c車digo
 * codPosDestino. Si la tara de la furgoneta es menor que 1000 Kg, el coste se calcula as赤
 * distancia(codPosOrigen, codPosDestino)*eurosPKm. En caso contrario, el coste se obtiene con la
 * f車rmula:
 * distancia(codPosOrigen, codPosDestino)*eurosPKm*1.10.
 */

	@Override
	public double coste(String codOrigen, String codDestino) {
		if (getTara()<1000)	return getMapa().distancia(codOrigen, codDestino)*eurosPKm;	
		else return getMapa().distancia(codOrigen, codDestino)*eurosPKm*1.10;
	}
	
	
}
