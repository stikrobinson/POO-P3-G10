/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.modelo;

/**
 *
 * @author GENERATION 10
 */
public class CuentaRedSocial {
    
    private String cuenta;
    private RedSocial redSocial;
    
    public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public RedSocial getRedSocial() {
		return redSocial;
	}

	public void setRedSocial(RedSocial redSocial) {
		this.redSocial = redSocial;
	}

    public CuentaRedSocial(String s, RedSocial r){
      cuenta = s;
      redSocial = r;
    }
}
