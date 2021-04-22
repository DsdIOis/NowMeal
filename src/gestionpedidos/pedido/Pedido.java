package gestionpedidos.pedido;

import gestionpedidos.transportes.Transporte;
import anotacion.Programacion2;

@Programacion2 (
nombreAutor1 = "ZhengYu",
apellidoAutor1 = "Ye",
emailUPMAutor1 = "z.ye@alumnos.upm.es",
nombreAutor2 = "Jaime",
apellidoAutor2 = "L¨®pez Hidalgo", 
emailUPMAutor2 = "jaime.lopez.hidalgo@alumnos.upm.es"
	)

public class Pedido {
	// CÓDIGO DE APOYO
	private Cliente cliente;
	private PlatoComida[] comidas;
	private Restaurante restaurante;
	private double importe;	
	private Transporte transporte;
	private double peso;
	/*
	 * + Pedido (cliente : Cliente, comidas : PlatoComida[],
	 * restaurante : Restaurante)
	 * POST: Calcula el importe y el peso del pedido y se los 
	 * asigna a sus respectivos atributos.
	 */

	public Pedido(Cliente cliente, PlatoComida[] comidas, Restaurante restaurante) {		
		this.cliente=cliente;
		this.comidas=comidas;
		this.restaurante=restaurante;
		for(int i=0;i<comidas.length;i++) {
			importe += comidas[i].getPrecio();
			peso += comidas[i].getPeso();
		}

	}

/*
 * + getPeso () : double
 * POST: devuelve el peso total de los platos de comida.
 */

	
	public double getPeso(){
		
		return peso;
	}
	

/*
 * + coste (transporte : Transporte) : double
 * POST: devuelve el coste del pedido. Dicho 
 * coste se calcula sumando el importe, el 
 * coste que supone para el transporte dado ir 
 * desde su ubicaci¨®n actual hasta el restaurante
 * y el coste que supone para el transporte dado ir
 * desde el restaurante hasta el domicilio del cliente.
 */

	public double coste(Transporte transporte){
		double coste=0;
		for(int i=0;i<comidas.length;i++) {
			coste=coste+comidas[i].getPrecio();
		}
		coste=coste+transporte.coste(transporte.getCodigo(), restaurante.getCodigo())+
				transporte.coste(restaurante.getCodigo(),cliente.getCodigo());
		
		return coste;
	}
	
	// CÓDIGO DE APOYO
	public double getImporte(){
		return importe;
	}	

	// CÓDIGO DE APOYO
	public Transporte getTransporte() {
		return transporte;
	}

	// CÓDIGO DE APOYO
	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}
	
	// CÓDIGO DE APOYO
	public Cliente getCliente(){
		return cliente;
	}
	
	// CÓDIGO DE APOYO
	public Restaurante getRestaurante(){
		return restaurante;
	}
}
