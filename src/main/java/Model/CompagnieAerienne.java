package Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity 
@Table(name="compagnie") 
@SequenceGenerator(name="seqCompagnie", sequenceName="seq_compagnie", allocationSize=1, initialValue=100) 

public class CompagnieAerienne {

	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqCompagnie")
	private Long id;
	
	@Column(name="nom")
	private String nom;
	
	@OneToMany (mappedBy="id.compagnie")
	private List<CompagnieAerienne> compagnieAerienne;
	
	@OneToMany (mappedBy="id.vol")
	private List<Vol> vols;
	
	@Version
	private int version;
	
	// *** Constructeurs ***

	public CompagnieAerienne(String nom) {
		super();
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

	public List<CompagnieAerienne> getCompagnieAerienne() {
		return compagnieAerienne;
	}

	public void setCompagnieAerienne(List<CompagnieAerienne> compagnieAerienne) {
		this.compagnieAerienne = compagnieAerienne;
	}

	public List<Vol> getVols() {
		return vols;
	}

	public void setVols(List<Vol> vols) {
		this.vols = vols;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	
	
	

}
