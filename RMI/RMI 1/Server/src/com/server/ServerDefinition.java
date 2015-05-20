package com.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.interf.test.TestRemote;

public class ServerDefinition extends UnicastRemoteObject implements TestRemote {

	/**
	 * Identificador único de la serialización (Default).
	 */
	private static final long serialVersionUID = 1L;

	protected ServerDefinition() throws RemoteException {
		super();
	}

    /**
     *
     * @param test Este parametro es solo para verificar que la palabra es "test"
     * @return false que quiere
     * @throws RemoteException
     */
	@Override
	public Boolean test(String test) throws RemoteException {
		if(test.equalsIgnoreCase("test")) return true;
		return false;
	}

    @Override
    public int multiplicar(int primerInt, int segundoInt) throws RemoteException {
        int resultado = 0;

        resultado = primerInt * segundoInt;

        return resultado ;
    }

    @Override
    public Boolean palindromear(String unaCadena) throws RemoteException {
        String otraCadena;
        otraCadena = ajustar(unaCadena);

        int inicio = 0;
        int last = otraCadena.length()-1;

        while (otraCadena.charAt(inicio) == otraCadena.charAt(last)){

            inicio++;
            last--;

            if (inicio == last)
                return true;

        }

        return false;
    }

    private String ajustar(String unaCadena){

        String otraCadena;


        otraCadena = unaCadena.toLowerCase().replaceAll(" ", "");

        return otraCadena;

    }


}
