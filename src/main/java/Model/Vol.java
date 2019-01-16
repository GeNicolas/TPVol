package Model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;


@Entity 
@Table(name="vol") 
@SequenceGenerator(name="seqVol", sequenceName="seq_vol", allocationSize=1, initialValue=1000) 

public class Vol {

	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqVol")
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_depart")
	private Date dateDepart;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_arrive")
	private Date dateArrivee;
	
	@Temporal(TemporalType.TIME)
	@Column(name="heure_depart")
	private Date heureDepart;
	
	@Temporal(TemporalType.TIME)
	@Column(name="heure_arrive")
	private Date heureArrivee;
	
	@OneToOne
	@Column(name="reservation_id")
	private Reservation reservation;
	
	@Column(name="aeroport_id")
	private Aeroport aeroport;
	

	@Version
	private int version;
	
	@OneToMany(mappedBy="id.vol")
	private List<Vol> vol;
	
	@ManyToMany(mappedBy="id.vol_aeroport")
	private List<Vol> vols;
	
	// *** Constructeurs ***
	
	public Vol() {
		super();
	}
	
	public Vol(Date dateDepart, Date dateArrivee, Date heureDepart, Date heureArrivee) {
		super();
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
	}

	public Vol(Date dateDepart, Date dateArrivee, Date heureDepart, Date heureArrivee, Reservation reservation,
			Aeroport aeroport) {
		super();
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
		this.reservation = reservation;
		this.aeroport = aeroport;
	}

	
	// *** Methodes ***
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public Date getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(Date heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Aeroport getAeroport() {
		return aeroport;
	}

	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<Vol> getVol() {
		return vol;
	}

	public void setVol(List<Vol> vol) {
		this.vol = vol;
	}

}
