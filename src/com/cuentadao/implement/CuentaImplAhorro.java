package com.cuentadao.implement;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.cuentadao.inter.CuentaDAO;
import com.cuentadao.modelos.Cliente;

public class CuentaImplAhorro implements CuentaDAO {

	public CuentaImplAhorro() {
	}
	
	public void deposito(double b) {
				
	}
	
	public void retiro(Cliente c,double ret){ //Solo sacar si se tiene arriba de 5 mil
		Calendar fecha = new  GregorianCalendar();
		int dia = fecha.get(Calendar.DAY_OF_WEEK);
		if((c.getCuenta().getbalance() > 5000) && (dia !=7 && dia !=1 ) ){
			c.getCuenta().setbalance((c.getCuenta().getbalance() - ret));
			System.out.println("Retiro de cuenta de ahorro exitoso!");
		}else{
			System.out.println("No puedes retirar, tienes menos de 5 mil pesos! ");
			
		}
	}

}
