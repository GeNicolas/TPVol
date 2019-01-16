package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
@Entity 
@Table(name="compagnie") 
@SequenceGenerator(name="seqCompagnie", sequenceName="seq_compagnie", allocationSize=1, initialValue=1000) 

public class CompagnieAerienne {

	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqCompagnie")
	private Long id;
	
	private String nom;
	
	@Version
	private int version;
	
	// *** Constructeurs ***

	public CompagnieAerienne(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public CompagnieAerienne() {
		super();
	}

	// *** Methodes ***
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
	

}
