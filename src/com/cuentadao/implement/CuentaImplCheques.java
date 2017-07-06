package com.cuentadao.implement;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.cuentadao.inter.CuentaDAO;
import com.cuentadao.modelos.Cliente;

public class CuentaImplCheques implements CuentaDAO {

	public CuentaImplCheques() {
	}

	public void deposito(double b) {
		
	}

	public void retiro(Cliente c, double b) {
		Calendar fecha = new  GregorianCalendar();
		int dia = fecha.get(Calendar.DAY_OF_WEEK);
		if((dia !=7 && dia !=1 ) ){
			c.getCuenta().setbalance((c.getCuenta().getbalance() - b));
			System.out.println("Retiro en cuenta de cheques exitoso");
		}else{
			System.out.println("No puedes retirar en Sabado o Domingo");
		}
	}

}
