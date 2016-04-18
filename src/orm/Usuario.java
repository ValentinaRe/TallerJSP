/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package orm;

public class Usuario {
	public Usuario() {
	}
	
	private int uid;
	
	private String user;
	
	private String pass;
	
	private void setUid(int value) {
		this.uid = value;
	}
	
	public int getUid() {
		return uid;
	}
	
	public int getORMID() {
		return getUid();
	}
	
	public void setUser(String value) {
		this.user = value;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setPass(String value) {
		this.pass = value;
	}
	
	public String getPass() {
		return pass;
	}
	
	public String toString() {
		return String.valueOf(getUid());
	}
	
}
