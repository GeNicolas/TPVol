package Model;

import javax.persistence.Entity;
import javax.persistence.Version;
@Entity
public class ClientMoral extends Client{
	
	
	private TitreMoral titre;
	private String siret;
	@Version
	private Version version;
	
	public ClientMoral () {
		
	}
	public ClientMoral(Long id, String nom, Integer numerotel, Integer numerofax, String email, TitreMoral titre, String siret) {
		super(id, nom, numerotel, numerofax, email);
		// TODO Auto-generated constructor stub
	}

	public TitreMoral getTitre() {
		return titre;
	}

	public void setTitre(TitreMoral titre) {
		this.titre = titre;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	
}
