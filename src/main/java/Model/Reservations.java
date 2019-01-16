package Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="Booking_flight")
public class Reservations {

	@Version
	private int version;
	
	@EmbeddedId
	private ReservationsPk key;
	
	
	public Reservations () {
		
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	public ReservationsPk getKey() {
		return key;
	}


	public void setKey(ReservationsPk key) {
		this.key = key;
	}
	
	
}
