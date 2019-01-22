package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Version;

@Entity
public class ClientEI extends Client{
		@Column(name="title")	
		private TitrePhysique titre;
		@Column(name="first_name")
		private String prenom;
		@Version
		private int version;
		
		public ClientEI () {
			
		}
		
		
		public ClientEI( String nom, Integer numerotel, Integer numerofax, String email,TitrePhysique titre, String prenom) {
			super( nom, numerotel, numerofax, email);
			// TODO Auto-generated constructor stub


		}


		public TitrePhysique getTitre() {
			return titre;
		}


		public void setTitre(TitrePhysique titre) {
			this.titre = titre;
		}


		public String getPrenom() {
			return prenom;
		}


		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}


		public int getVersion() {
			return version;
		}


		public void setVersion(int version) {
			this.version = version;
		}
		
		
}
