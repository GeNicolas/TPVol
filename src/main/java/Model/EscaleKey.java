package Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Embeddable
public class EscaleKey  implements Serializable{

	@ManyToMany
	@JoinColumn(name="vol_id")
	List<Vol> vol;
	
	@ManyToMany
	@JoinColumn(name="aeroport_id")
	List<Aeroport> aeroport;
	
	public EscaleKey() {
		super();
	}

	public EscaleKey(List<Vol> vol, List<Aeroport> aeroport) {
		super();
		this.vol = vol;
		this.aeroport = aeroport;
	}

	public List<Vol> getVol() {
		return vol;
	}

	public void setVol(List<Vol> vol) {
		this.vol = vol;
	}

	public List<Aeroport> getAeroport() {
		return aeroport;
	}

	public void setAeroport(List<Aeroport> aeroport) {
		this.aeroport = aeroport;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aeroport == null) ? 0 : aeroport.hashCode());
		result = prime * result + ((vol == null) ? 0 : vol.hashCode());
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
		EscaleKey other = (EscaleKey) obj;
		if (aeroport == null) {
			if (other.aeroport != null)
				return false;
		} else if (!aeroport.equals(other.aeroport))
			return false;
		if (vol == null) {
			if (other.vol != null)
				return false;
		} else if (!vol.equals(other.vol))
			return false;
		return true;
	}
	
	

}
