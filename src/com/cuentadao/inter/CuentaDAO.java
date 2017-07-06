package com.cuentadao.inter;

import com.cuentadao.modelos.Cliente;

public interface CuentaDAO { //Sera la interfaz

	//Solo declaro los metodos de la interfaz sin un comportamiento
	public void deposito(double b);
	
	public void retiro(Cliente c,double b);

}
