package com.Innova4D.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.Innova4D.Interface.*;

public class ControlTower extends UnicastRemoteObject implements RemoteInterface {

	/*
	 * El constructor, protegido para asegurar la integridad de ControlTower.
	 * Protected: Accesible únicamente por ésta clase y sus subclases.
	 */
	protected ControlTower() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * { 0, 0, 0, 0, 0, 0, 0, 0 },
	 * { 0, 0, 0, 0, 0, 0, 0, 0 },
	 * { 0, 0, 0, 0, 0, 0, 0, 0 },
	 * { 0, 0, 0, 0, 0, 0, 0, 0 }
	 */
	private Object[][] mapaPista = new Object[4][8];

	private static final long serialVersionUID = 1L;

	/**
 	* Regresa el mapa de las pistas.
 	*/
	@Override
	public Object[][] getMapaPistas() throws RemoteException {
		return this.mapaPista;
	}

	/**
	 * Mueve un avión en la matriz, un bloque a la vez. Izq. Der.
	 */
	@Override
	public Boolean moverAvion(Avion a, int c) throws RemoteException {
		Boolean flag = false;
		int newY = a.getY() + 1;
		if (newY < 8) {
		try {
				this.mapaPista[c][a.getY()] = null;
				this.mapaPista[c][newY] = a;
				a.setX(0);
				a.setY(newY);
				flag = true;
			} catch (Exception e) {
				flag = false;
			}
		}
		return flag;
	}

  /**
 	* Busca por un avión en el mapa aéreo usando su ID.
 	* @param id El identificador del objeto.
 	* @param c  El carril donde se encuentra el objeto.
 	*/
	@Override
	public Avion getAvion(String id, int c) throws RemoteException {
		Avion a = null;
		for (int i = 0; i < 8; i++) {
		    if(this.mapaPista[c][i] != null){
		    	a = (Avion) this.mapaPista[c][i];
		    	if(!a.getId().equals(id))
		    		a = null;
		    }
		}
		return a;
	}

	@Override
	public Boolean checkInAvion(Avion a) throws RemoteException {
		if(this.mapaPista[a.getX()][a.getY()] == null)
			this.mapaPista[a.getX()][a.getY()] = a;
		return true;
	}

	/*
	 * Aquí comienzan los métodos del auto.
	 */

	@Override
	public Boolean checkInAuto(Auto a) throws RemoteException {
		if(this.mapaPista[a.getX()][a.getY()] == null)
			this.mapaPista[a.getX()][a.getY()] = a;
		return true;
	}
	@Override
	public Auto getAuto(String id, int c) throws RemoteException {
		Auto a = null;
		for (int i = 0; i < 8; i++) {
		    if(this.mapaPista[c][i] != null){
		    	a = (Auto) this.mapaPista[c][i];
		    	if(!a.getId().equals(id))
		    		a = null;
		    }
		}
		return a;
	}

	@Override
	public Boolean moverAuto(Auto a, int c) throws RemoteException {
		Boolean flag = false;
		int newY = a.getY() + 1;
		if (newY < 8) {
		try {
				this.mapaPista[c][a.getY()] = null;
				this.mapaPista[c][newY] = a;
				a.setX(0);
				a.setY(newY);
				flag = true;
			} catch (Exception e) {
				flag = false;
			}
		}
		return flag;
	}


    //Yate

    @Override
    public Boolean checkInYate(Yate yate) throws RemoteException {
        if(this.mapaPista[yate.getX()][yate.getY()] == null)
            this.mapaPista[yate.getX()][yate.getY()] = yate;
        return true;
    }
    @Override
    public Yate getYate(String id, int c) throws RemoteException {
        Yate yate = null;
        for (int i = 0; i < 8; i++) {
            if(this.mapaPista[c][i] != null){
                yate = (Yate) this.mapaPista[c][i];
                if(!yate.getId().equals(id))
                    yate = null;
            }
        }
        return yate;
    }

    @Override
    public Boolean moverYate(Yate yate, int c) throws RemoteException {
        Boolean flag = false;
        int newY = yate.getY() + 1;
        if (newY < 8) {
            try {
                this.mapaPista[c][yate.getY()] = null;
                this.mapaPista[c][newY] = yate;
                yate.setX(0);
                yate.setY(newY);
                flag = true;
            } catch (Exception e) {
                flag = false;
            }
        }
        return flag;
    }

    // Trailer

    @Override
    public Boolean checkInTrailer(Trailer trailer) throws RemoteException {
        if(this.mapaPista[trailer.getX()][trailer.getY()] == null)
            this.mapaPista[trailer.getX()][trailer.getY()] = trailer;
        return true;
    }
    @Override
    public Trailer getTrailer(String id, int c) throws RemoteException {
        Trailer trailer = null;
        for (int i = 0; i < 8; i++) {
            if(this.mapaPista[c][i] != null){
                trailer = (Trailer) this.mapaPista[c][i];
                if(!trailer.getId().equals(id))
                    trailer = null;
            }
        }
        return trailer;
    }

    @Override
    public Boolean moverTrailer(Trailer trailer, int c) throws RemoteException {
        Boolean flag = false;
        int newY = trailer.getY() + 1;
        if (newY < 8) {
            try {
                this.mapaPista[c][trailer.getY()] = null;
                this.mapaPista[c][newY] = trailer;
                trailer.setX(0);
                trailer.setY(newY);
                flag = true;
            } catch (Exception e) {
                flag = false;
            }
        }
        return flag;
    }




}
