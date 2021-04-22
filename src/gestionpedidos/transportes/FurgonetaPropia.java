package gestionpedidos.transportes;
import gestionpedidos.mapa.*;
import anotacion.Programacion2;

@Programacion2 (
nombreAutor1 = "ZhengYu",
apellidoAutor1 = "Ye",
emailUPMAutor1 = "z.ye@alumnos.upm.es",
nombreAutor2 = "Jaime",
apellidoAutor2 = "L��pez Hidalgo", 
emailUPMAutor2 = "jaime.lopez.hidalgo@alumnos.upm.es"
	)
public class FurgonetaPropia extends Furgoneta{
	/*
	 * - velocidadMedia : double 
	 */
	private double velocidadMedia;
	/*
	 * - EUROS_P_HORA : double = 40
	 */

	private static final double EUROS_P_HORA =40;
	/*
	 * getVelocidadMedia : double
	 */

	public double getVelocidadMedia() {
		return velocidadMedia;
	}
	/*
	 * setVelocidadMedia : double
	 */

	public void setVelocidadMedia(double velocidadMedia) {
		this.velocidadMedia = velocidadMedia;
	}


	/*
	 * + FurgonetaPropia (codigo : String, mapa : Mapa, tara : double)
	 * POST: Inicializa los atributos del objeto con los argumentos
	 * recibidos como entrada.
	 */

	public FurgonetaPropia(String codigo,Mapa mapa,double tara){
		super(codigo,mapa,tara);
	}
	/*
	 * + coste (codOrigen : String, codDestino : String) : double
	 * POST:  devuelve el coste en euros que supone para el transporte ir
	 * desde la ubicaci��n del objeto con c��digo codPosOrigen hasta la ubicaci��n del objeto con c��digo
	 * codPosDestino. Si la tara de la furgoneta es menor que 500 Kg, el coste se calcula as��
	 * distancia(codPosOrigen, codPosDestino)*EUROS_P_HORA/velocidadMedia. En caso contrario,
	 * el coste se obtiene con la f��rmula:
	 * distancia(codPosOrigen, codPosDestino)*EUROS_P_HORA/velocidadMedia*1.10
	 */

	public double coste(String codOrigen,String codDestino) {
		if (getTara()<500) 	return (getMapa().distancia(codOrigen, codDestino)*EUROS_P_HORA)/getVelocidadMedia();	
		else return ((getMapa().distancia(codOrigen, codDestino)*EUROS_P_HORA)/getVelocidadMedia())*1.10;
	}
}
