package com.cuentadao.dao;
import java.util.Scanner;

import com.cuentadao.factory.CuentaDAOFactory;
import com.cuentadao.inter.CuentaDAO;
import com.cuentadao.modelos.Banco;
import com.cuentadao.modelos.Cliente;
import com.cuentadao.modelos.Cuenta;


public class Test {
	static final Scanner text_in = new Scanner(System.in);
	static int select = -1;
	
	public static void main(String[] args) {
		
		Banco bank = new Banco();
		String nombre_cliente = "" ;
		String apellido_cliente = "";
		String balance_cuenta = "";
		double int_balance_cuenta = 0;
		String v_tipo_cuenta = "";
		while(select != 0 ){
			System.out.println("Ingresa la opcion que desees\n"
					+ "1.- Agregar cliente\n"
					+ "2.- Consultar numero de clientes\n"
					+ "3.- Realizar deposito\n"
					+ "0.- Salir");
			String valor_seleccionado = text_in.nextLine();
			select = Integer.parseInt(valor_seleccionado);
			switch(select){
				case 1:
					System.out.println("Ingrese nombre: ");
					nombre_cliente = text_in.nextLine();
					
					System.out.println("Ingrese apellido: ");
					apellido_cliente = text_in.nextLine();
					Cuenta cuenta_de_cliente = new Cuenta();
				
					System.out.println("Ingrese el balance de su cuenta: ");
					balance_cuenta = text_in.nextLine();
					int_balance_cuenta = Double.parseDouble(balance_cuenta);
					cuenta_de_cliente.setbalance(int_balance_cuenta);
					
					System.out.println("Ingrese el tipo de cuenta (cheques/ahorro): ");
					v_tipo_cuenta = text_in.nextLine();
					cuenta_de_cliente.setTipo(v_tipo_cuenta);
					Cliente cliente1 = new Cliente(nombre_cliente,apellido_cliente,cuenta_de_cliente);
					bank.addCliente(cliente1);
				break;
				case 2:
					System.out.println("El número de clientes es de: " + bank.getNCliente());
				break;
				case 3:
					System.out.println("Ingrese el nombre del cliente a buscar: ");
					nombre_cliente = text_in.nextLine();
					Cliente cliente_encontrado = bank.getCliente(nombre_cliente);
					System.out.println("Nombre: " + cliente_encontrado.getNombre() + "\n" + 
									   "Apellido: " + cliente_encontrado.getApellido() + "\n" + 
									   "Balance de cuenta: " + cliente_encontrado.getCuenta().getbalance() + "\n");
					/*System.out.println("Cliente encontrado: \n" +
											"Nombre: " + cliente_encontrado.getNombre() + "\n" + 
											"Apellido: " + cliente_encontrado.getApellido() + "\n" + 
											"Balance de cuenta: " + cliente_encontrado.getCuenta().getbalance() + "\n");
					*/
						
				break;
				default:
				break;
			}
		}
		
		
		
		Cuenta account = new Cuenta();
		account.setbalance(6000.0);
		
		Cliente nuevo_cliente = new Cliente();
		nuevo_cliente.setNombre("Arturo");
		nuevo_cliente.setApellido("Soto");
		nuevo_cliente.setCuenta(account);
		nuevo_cliente.getCuenta().setTipo("cheques");
		
		bank.addCliente(nuevo_cliente);
		System.out.println("El numero de clientes en el arreglo es de: " + bank.getNCliente());
		
		
		Cliente cliente_encontrado = bank.getCliente("Arturo");
		System.out.println("Cliente encontrado: " + cliente_encontrado.getApellido());
		
		
		CuentaDAOFactory factory = new CuentaDAOFactory();
		CuentaDAO accountdao = factory.getImplementacion(account);
		System.out.println(nuevo_cliente.getNombre() + " " + nuevo_cliente.getApellido() + " realizando un retiro....\n");
		accountdao.retiro(nuevo_cliente,300.0);
		System.out.println("El cliente " + nuevo_cliente.getNombre() + " " + nuevo_cliente.getApellido() + " tiene " 
							+ " una cuenta con un balance de: " + nuevo_cliente.getCuenta().getbalance());
	}

}
