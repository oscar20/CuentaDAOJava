package com.cuentadao.factory;

import com.cuentadao.implement.CuentaImplAhorro;
import com.cuentadao.implement.CuentaImplCheques;
import com.cuentadao.inter.CuentaDAO;
import com.cuentadao.modelos.Cuenta;

public class CuentaDAOFactory {

	public CuentaDAOFactory() {
	}
	
	public CuentaDAO getImplementacion(Cuenta mi_cuenta){
		if(mi_cuenta.getTipo().equals("ahorro")){
			CuentaDAO account = new CuentaImplAhorro();
			return account;
		}else{
			CuentaDAO account = new CuentaImplCheques();
			return  account;
		}
	}

}
