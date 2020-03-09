/**
 * 
 */
package es.cifpcm.ejemplojsfgonzalezv.web.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Veronica Gonzalez
 *
 */
public class Actor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private Integer actorId;
	private Timestamp lastupdate;
	public final String getFirstName() {
		return firstName;
	}
	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public final String getLastName() {
		return lastName;
	}
	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public final Integer getActorId() {
		return actorId;
	}
	public final void setActorId(Integer actorId) {
		this.actorId = actorId;
	}
	public final Timestamp getLastupdate() {
		return lastupdate;
	}
	public final void setLastupdate(Timestamp lastupdate) {
		this.lastupdate = lastupdate;
	}
	public Actor() {
		// TODO Auto-generated constructor stub
	}
	
	public Actor(int actorId, String firstName, String lastName, Timestamp lastupdate) {
		this.actorId=actorId;
		this.firstName=firstName;
		this.lastName=lastName;
		this.lastupdate=lastupdate;
		// TODO Auto-generated constructor stub
	}

}
