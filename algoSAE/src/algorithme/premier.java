package algorithme;

import classe.*;
import contrainte.*;

import java.util.*;

public class premier implements StrategieRegroupement{

	@Override
	public List<Groupe> formerGroupes(List<Etudiant> etudiants, int tailleMin, int tailleMax, List<Contrainte> contraintes) {
		if (etudiants == null || etudiants.isEmpty()) {
			throw new IllegalArgumentException("Aucun étudiant fourni");
		}
		if (tailleMax <= 0) {
			throw new IllegalArgumentException("tailleMax invalide");
		}
		
		List<Etudiant> listeE = new ArrayList<>(etudiants);
		listeE.sort((a,b) -> Double.compare(b.getMoyenne(), a.getMoyenne()));
		
		int nbGroupes = (int)Math.ceil((double)listeE.size()/tailleMax);
		List<Groupe> groupes = new ArrayList<>();
		for (int i=0;i<nbGroupes;i++) groupes.add(new Groupe("G"+(i+1)));
		
		for (Etudiant e : listeE) {
			Groupe best = null;
			for (Groupe g : groupes) {
				if(g.taille()<tailleMax) {
					boolean ok = true;
					if (contraintes != null){
						for (Contrainte c : contraintes){
							if (!c.verifierAjout(e, g)){
								ok = false;
								break;
							}
						}
						if (ok){
							if(best == null || g.taille() < best.taille()){
								best = g;
							}
						}
					}
			}
		}
		if (best == null) {
			// créer un nouveau groupe s'il reste possible
			Groupe ng = new Groupe("G"+(groupes.size()+1));
			ng.ajouter(e);
			groupes.add(ng);
		} else {
			best.ajouter(e);
		}
        return groupes;
	}
	}

}
