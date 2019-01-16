package Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="aeroport")
@SequenceGenerator(name="seqAeroport",sequenceName="seq_aeroport", allocationSize=1, initialValue=10) 

@NamedQueries({
	@NamedQuery(name = "Aeroport.findAllWithVol", query = "select distinct a from Aeroport a left join fetch a.vols"),
	@NamedQuery(name = "Aeroport.findAllWithVille", query = "select distinct a from Aeroport a left join fetch a.ville") })


public class Aeroport {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqAeroport")
	private Long id;

	@Column(name="nom")
	private String nom;
	
	@OneToMany (mappedBy="id.vol")
	private List<Vol> vols;
	
	@ManyToMany
	private List<Ville> ville;
	
	@ManyToMany(mappedBy="id.aeroport")
	private List<Aeroport> aeroports;
	
	// *** Constructeur ***
	
	public Aeroport() {
		super();
	}

	public Aeroport(String nom, List<Ville> ville) {
		super();
		this.nom = nom;
		this.ville = ville;
	}
	
	// *** Methodes ***

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Ville> getVille() {
		return ville;
	}

	public void setVille(List<Ville> ville) {
		this.ville = ville;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aeroport other = (Aeroport) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}