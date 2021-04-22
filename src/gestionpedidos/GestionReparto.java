package gestionpedidos;


import gestionpedidos.mapa.Mapa;
import gestionpedidos.mapa.PosicionXY;
import gestionpedidos.pedido.Pedido;
import gestionpedidos.transportes.Transporte;
import anotacion.Programacion2;

 @Programacion2 (
 nombreAutor1 = "ZhengYu",
 apellidoAutor1 = "Ye",
 emailUPMAutor1 = "z.ye@alumnos.upm.es",
 nombreAutor2 = "Jaime",
 apellidoAutor2 = "López Hidalgo", 
 emailUPMAutor2 = "jaime.lopez.hidalgo@alumnos.upm.es"
	)

public class GestionReparto {
	// C覦IGO DE APOYO
	private GestionRepartoLocal[] gestoresLocales;
	private Mapa mapa;

/*
 * + GestionReparto (mapa : Mapa)
 * POST: inicializa los atributos del objeto.
 */

	public GestionReparto(Mapa mapa){
		this.mapa=mapa;
		gestoresLocales=new GestionRepartoLocal[4];
		gestoresLocales[0]=new GestionRepartoLocal();
		gestoresLocales[1]=new GestionRepartoLocal();
		gestoresLocales[2]=new GestionRepartoLocal();
		gestoresLocales[3]=new GestionRepartoLocal();
	}
	
	//C覦IGO DE APOYO
	public Mapa getMapa() {
		return mapa;
	}
	
	// C覦IGO DE APOYO
	public String getEstadoGestorLocal(int i){
		return this.gestoresLocales[i].getDisponibles() + this.gestoresLocales[i].getEsperando();
	}
	
	// C覦IGO DE APOYO
	public String getEstadoGestorLocalNum(int i){
		return this.gestoresLocales[i].getCodMotosDisponibles().size() + ";" +
				this.gestoresLocales[i].getCodFurgoDisponibles().size() + ";" +
				this.gestoresLocales[i].getCodEsperandoMoto().size() + ";" +
				this.gestoresLocales[i].getCodEsperandoFurgo().size() ;
	}
	
	
	/*
	 * + addTransporteLocalidad (transporte : Transporte) : void
	 * PRE: el transporte no ha sido asignado a ninguna zona
	 * POST: añade el transporte dado al gestor de reparto local 
	 * que le corresponde por su ubicación en el mapa.
	 */


	public void addTransporteLocalidad(Transporte transporte) {

		gestoresLocales[posicionGestoresLocales(getMapa().getPosicion(transporte.getCodigo()))].add(transporte);

	}
		
	
	/*
	 * + asignarPedido (pedido : Pedido) : void
	 * PRE: el pedido no tiene asignado ning鷑 transporte
	 * POST: asigna el pedido dado al gestor de reparto 
	 * local que le corresponde por su ubicación en el mapa.
	 */

	public void asignarPedido(Pedido pedido){

		gestoresLocales[posicionGestoresLocales(getMapa().getPosicion(pedido.getCliente().getCodigo()))].asignarPedido(pedido);
		
	}
	
	

/*
 * + notificarEntregaPedido (pedido : Pedido) : void
 * PRE: el pedido tiene asignado un transporte
 * POST: notifica la entrega del pedido al gestor de 
 * reparto local que le corresponde mpor su ubicación en
 * el mapa.
 */


	public void notificarEntregaPedido(Pedido pedido){

		gestoresLocales[posicionGestoresLocales(getMapa().getPosicion(pedido.getTransporte().getCodigo()))].notificarEntregaPedido(pedido);
	}
	
	
	/*
	 * -posicionGestoresLocales(x,y,maxCoordX,maxCoordY: int) :int
	 * 	metodo auxiliar para determinar la posicion y a que zona pertenece el transporte
	 * 
	 */
	
	private int posicionGestoresLocales(PosicionXY pos) {
		int resultado=0;
		int x=pos.getX();
		int y=pos.getY();
		int maxCoordX=getMapa().getMaxCoordX();
		int maxCoordY=getMapa().getMaxCoordY();
		
		if(x>=0&&x<=maxCoordX/2&&y>=0&&y<=maxCoordY/2) {
			resultado=0;
		}
		else if(x>=0&&x<=maxCoordX/2&&y>=maxCoordY/2+1&&y<=maxCoordY) {
			resultado=1;
		}
		else if(x>=maxCoordX/2+1&&x<=maxCoordX&&y>=0&&y<=maxCoordY/2) {
			resultado=2;
		}
		else if(x>=maxCoordX/2+1&&x<=maxCoordX&&y>=maxCoordY/2+1&&y<=maxCoordY) {
			resultado=3;
		}
		return resultado;
	}
	
	
}
