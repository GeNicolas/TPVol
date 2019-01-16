package Model;

import javax.persistence.Entity;
import javax.persistence.Version;

@Entity
public class ClientEI extends Client{
			
		private TitrePhysique titre;
		private String prenom;
		@Version
		private int version;
		
		public ClientEI () {
			
		}
		
		
		public ClientEI(Long id, String nom, Integer numerotel, Integer numerofax, String email,TitrePhysique titre, String prenom) {
			super(id, nom, numerotel, numerofax, email);
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
		
		
}
