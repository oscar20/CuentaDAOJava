package com.cuentadao.modelos;


public class Banco {
	private int num_clientes = 0;
	private Cliente[] arreglo_clientes = new Cliente[10];
		
	public Banco(){
		
	}
	
	public void addCliente(Cliente c){
		int numero_de_clientes = getNCliente();
		if(numero_de_clientes < 10){
			arreglo_clientes[numero_de_clientes] = c;
			System.out.println("El cliente: " + c.getNombre() + " " + c.getApellido() + " se agrego al arreglo");
			num_clientes = num_clientes + 1;
		}else{
			System.out.println("Excediste en el numero de Clientes en el arreglo");
		}
			
		
	}
	
	public int getNCliente(){
		return num_clientes;
	}
	
	public Cliente getCliente(String nombre_cliente){
		Cliente new_client = null;
		int num_clientes = getNCliente();
		for(int i=0;i<num_clientes;i++){
			if(arreglo_clientes[i].getNombre().equals(nombre_cliente))
				new_client = new Cliente(arreglo_clientes[i].getNombre(),arreglo_clientes[i].getApellido(),arreglo_clientes[i].getCuenta());
			else
				new_client = new Cliente();
		}
		return new_client;
	}
}
