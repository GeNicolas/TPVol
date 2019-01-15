package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@Column(name="heure_arrive")
	private Date heureArrivee;
	
	@Version
	private int version;
	
	public Vol() {
		super();
	}

}
