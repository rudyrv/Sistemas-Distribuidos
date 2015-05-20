package com.interf.test;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface TestRemote extends Remote{

	/*
	 * En ésta interfaz se definen los métodos que deberá
	 * implementar el servidor.
	 *
	 * En caso de agregar métodos que reciban o envíen objetos
	 * Se debe tener encuenta el serializado de dicho objeto (Marshalling).
	 * Para éste ejemplo definimos un simple método test.
	 *
	 * @param test Un String a comparar, si es idéntico a la palabra "test".
	 *
	 * @return true en caso de que sea idéntico a "test".
	 */
	public Boolean test(String test) throws RemoteException;
    public int multiplicar(int a, int b) throws RemoteException;
    public Boolean palindromear(String unaCadena) throws RemoteException;

}
