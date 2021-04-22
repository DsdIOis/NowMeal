package gestionpedidos;


import gestionpedidos.pedido.Pedido;
import gestionpedidos.transportes.Furgoneta;
import gestionpedidos.transportes.Moto;
import gestionpedidos.transportes.Transporte;
import list.ArrayList;
import queues.NaiveQueue;
import anotacion.Programacion2;

@Programacion2 (
nombreAutor1 = "ZhengYu",
apellidoAutor1 = "Ye",
emailUPMAutor1 = "z.ye@alumnos.upm.es",
nombreAutor2 = "Jaime",
apellidoAutor2 = "López Hidalgo", 
emailUPMAutor2 = "jaime.lopez.hidalgo@alumnos.upm.es"
	)
public class GestionRepartoLocal {	
	private ArrayList<Moto> motosDisponibles;
	private ArrayList<Furgoneta> furgonetasDisponibles;
	private NaiveQueue<Pedido> pedidosEsperandoMoto;
	private NaiveQueue<Pedido> pedidosEsperandoFurgoneta;
	

/*
 * - getCodList(disponibles : ArrayList<?>) : String
 */

	private static ArrayList<String> getCodList(ArrayList<?> disponibles) {
		ArrayList<String> salida = new ArrayList<>();
		for(int i=0; i<disponibles.size(); i++)
			salida.add(salida.size(),((Transporte) disponibles.get(i)).getCodigo());
		return salida;
	}
	
	/*
	 * - getClienteRestauranteList(disponibles : ArrayList<?>) : String
	 */

	private static ArrayList<String[]> getClienteRestauranteList(NaiveQueue<Pedido> pendientes){
		 ArrayList<String[]> salida = new ArrayList<>();
		 NaiveQueue<Pedido> aux = new NaiveQueue<>();
		while(!pendientes.isEmpty()) {
			Pedido pedido = pendientes.poll();
			
			salida.add(salida.size(),new String[]{pedido.getCliente().getCodigo(),
					pedido.getRestaurante().getCodigo()});
			aux.add(pedido);
		}
		while (!aux.isEmpty())
			 pendientes.add(aux.poll());
		
		return salida;
	}
	
	// C覦IGO DE APOYO
	private static String myArrayListToString (ArrayList<?> list){
		String salida = "";
		for(int i=0; i<list.size(); i++){
			salida += " " ;
			if (list.get(i) instanceof String[]){
				String[] item = (String[])list.get(i);
				for(int j=0; j<item.length; j++){
					salida += item[j] ;
				}	
			}else if (list.get(i) instanceof String){
				salida += (String)list.get(i);
			}
		}
			
		return salida;
	}
	
	// CÓIGO DE APOYO
	public String getDisponibles(){
		return "Motos Disponibles:" + myArrayListToString(getCodList(motosDisponibles)) + System.lineSeparator() +
			"Furgonetas Disponibles:" + myArrayListToString(getCodList(furgonetasDisponibles)) + System.lineSeparator();
			
	}
	
	// CÓIGO DE APOYO
	public String getEsperando(){
		return "Pedidos esperando moto:" + myArrayListToString(getClienteRestauranteList(pedidosEsperandoMoto)) + System.lineSeparator() +
				"Pedidos esperando furgoneta:" + myArrayListToString(getClienteRestauranteList(pedidosEsperandoFurgoneta)) + System.lineSeparator();
	}
	
	// CÓIGO DE APOYO
	public ArrayList<String> getCodMotosDisponibles(){
		return getCodList(motosDisponibles);
	}	
	
	// CÓIGO DE APOYO
	public ArrayList<String> getCodFurgoDisponibles(){
		return getCodList(furgonetasDisponibles);
			
	}
	
	// CÓIGO DE APOYO
	public ArrayList<String[]> getCodEsperandoMoto(){
		return getClienteRestauranteList(pedidosEsperandoMoto);
	}
	
	public ArrayList<String[]> getCodEsperandoFurgo(){
		return getClienteRestauranteList(pedidosEsperandoFurgoneta);
	}
	
	
	/*
	 * - PESO_MAX_MOTO: double = 20
	 */
	private static final double PESOMAXMOTO = 20;

	// C覦IGO DE APOYO
	public GestionRepartoLocal(){		
		
		this.motosDisponibles = new ArrayList<>();
		this.furgonetasDisponibles = new ArrayList<>();

		this.pedidosEsperandoFurgoneta = new NaiveQueue<>();
		this.pedidosEsperandoMoto = new NaiveQueue<>();
	}

	//PRE: el transporte no ha sido asignado a ninguna zona
	/*
	 * + add (transporte : Transporte) : void
	 * POST: añade el transporte dado al final 
	 * de la lista de motos disponibles o a la 
	 * lista de furgonetas disponibles dependiendo 
	 * de si el transporte dado es una moto o una furgoneta.
	 */

	public void add(Transporte transporte){
		if(transporte!=null) {
			if(transporte instanceof Moto) {
				Moto moto=(Moto) transporte;
				motosDisponibles.add(motosDisponibles.size(), moto);
			}
			else if (transporte instanceof Furgoneta) {
				Furgoneta furgoneta=(Furgoneta) transporte;
				furgonetasDisponibles.add(furgonetasDisponibles.size(),furgoneta);
			}
		}
	}
			
/*
 * + asignarPedido (pedido : Pedido) : void
 * PRE: el pedido no tiene asignado ning鷑 transporte
 * POST: asigna el pedido dado a un transporte 
 * disponible, si existe. Se distinguen dos casos:
 * 1. Si el peso del pedido es menor o igual que el
 * peso máximo que puede transportar una moto, se 
 * le asigna la moto de la lista de disponibles que 
 * minimice el coste del pedido. Si no existe ninguna 
 * moto disponible, se guarda el pedido al final de la 
 * lista de pedidos esperando una moto.
 * 2. En caso contrario, hay que utilizar una furgoneta
 * en lugar de una moto. Por tanto, se le asigna la furgoneta 
 * de la lista de disponibles que minimice el coste del pedido. 
 * Supondremos que ningún pedido sobrepasa la capacidad máxima 
 * de una furgoneta. Si no existe ninguna furgoneta disponible,
 * se guarda el pedido al final de la lista de pedidos esperando
 * una furgoneta.
 */
	public void asignarPedido(Pedido pedido){	
		if(pedido.getPeso()<=PESOMAXMOTO) {
			asignarPedidoAuxiliar(pedido,motosDisponibles,pedidosEsperandoMoto);
		}
		else {
			asignarPedidoAuxiliar(pedido,furgonetasDisponibles,pedidosEsperandoFurgoneta);
		}
		
	}

	/*
	 * 	-asignarPedidoAuxiliar(pedido:Pedido, transportesDisponibles:ArrayList<? extends Transporte>)
	 *	POST: Metodo auxiliar que asigna pedido sin saber que transporte es entre moto y furgoneta
	 * 
	 */
	private void asignarPedidoAuxiliar(Pedido pedido,ArrayList<? extends Transporte> transportesDisponibles,NaiveQueue<Pedido> transporteEsperando) {
		int transporteUso=posicionTransporteCosteMinimo(pedido,transportesDisponibles);
		if(transporteUso!=-1) {
			pedido.setTransporte(transportesDisponibles.get(transporteUso));
			transportesDisponibles.removeElementAt(transporteUso);;
		}
		else {
			transporteEsperando.add(pedido);
		}	
	}


	

	/*
	 * -posicionTransporteCosteMinimo(pedido:Pedido, transportesDisponibles:ArrayList<? extends Transporte>):int
	 * POST:Metodo auxiliar que devuelve la posicion del transporte que menos cuesta
	 * 
	 */
	private int posicionTransporteCosteMinimo(Pedido pedido,ArrayList<? extends Transporte> transportesDisponibles) {	
		if(transportesDisponibles.size()>0) {
			int pos=0;
			double costeMin=pedido.coste(transportesDisponibles.get(0));
			for(int i=1;i<transportesDisponibles.size();i++) {
				if(pedido.coste(transportesDisponibles.get(i))<costeMin) {
					pos=i;
					costeMin=pedido.coste(transportesDisponibles.get(i));
					}
				}
			return pos;
		}
		else return -1;
	}

	/*
	 * + notificarEntregaPedido (pedido : Pedido) : void
	 * PRE: el pedido tiene asignado un transporte
	 * POST: notifica la entrega del pedido dado. Eso implica
	 * que el transporte asignado al pedido dado pasa a estar 
	 * disponible. Por tanto, si hay pedidos esperando por una 
	 * moto y se acaba de quedar libre una, se asigna al pedido
	 * que lleve más tiempo esperando. Si el transporte que se
	 * acaba de quedar libre es una furgoneta, se actúa de forma
	 * análoga. Si no hay pedidos esperando por un transporte del
	 * tipo que se acaba de quedar libre, dicho transporte se guarda
	 * al final de la lista de transportes disponibles del mismo tipo.
	 */

	public void notificarEntregaPedido(Pedido pedido) {	
		add(pedido.getTransporte());
		if(!pedidoEsperandoTransporte(pedido).isEmpty()) {
			asignarPedido(pedidoEsperandoTransporte(pedido).poll());	
		}
	}
	
	
	
	/* 
	 * -pedidoEsperandoTransporte(pedido:Pedido):NaiveQueue<Pedido>
	 *  POST:Metodo auxiliar que decide si la lista de pedidos esperando es para moto o para furgoneta
	 */
	
	private NaiveQueue<Pedido> pedidoEsperandoTransporte(Pedido pedido){
		NaiveQueue<Pedido> resultado= new NaiveQueue<Pedido>();
		if(pedido.getTransporte() instanceof Moto) {
			resultado= pedidosEsperandoMoto;
		}
		else if(pedido.getTransporte() instanceof Furgoneta) {
			resultado= pedidosEsperandoFurgoneta;
		}
		return resultado;
	}
}