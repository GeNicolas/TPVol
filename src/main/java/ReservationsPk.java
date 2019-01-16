package Model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import Model.Client;
@Embeddable
public class ReservationsPk implements Serializable{

	@ManyToOne
	@JoinColumn(name="id_client")
	
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="id_reservation")
	private Reservation reservation;
	
	public ReservationsPk () {
		
	}

	public ReservationsPk(Client client, Reservation reservation) {
		super();
		this.client = client;
		this.reservation = reservation;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	
	
	
}
