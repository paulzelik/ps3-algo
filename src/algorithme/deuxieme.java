package algorithme;

import classe.*;
import java.util.*;

public class Deuxieme implements StrategieRegroupement {

    @Override
    public List<Groupe> formerGroupes(List<Etudiant> etudiants, int tailleMin = 10, int tailleMax) {
        if (etudiants == null || etudiants.isEmpty()) {
            throw new IllegalArgumentException("Aucun étudiant fourni");
        }

        List<Etudiant> listeTriee = new ArrayList<>(etudiants);
        listeTriee.sort(Comparator.comparingDouble(Etudiant::getMoyenne).reversed());

        List<Groupe> groupes = new ArrayList<>();
        for (Etudiant etudiant : listeTriee) {
            boolean assigne = false;

            for (Groupe groupe : groupes) {
                if (groupe.taille() < tailleMax && groupe.estValide(etudiant)) {
                    groupe.ajouter(etudiant);
                    assigne = true;
                    break; 
                }
            }

            if (!assigne) {
                Groupe nouveauGroupe = new Groupe("Groupe " + (groupes.size() + 1));
                
                nouveauGroupe.ajouter(etudiant);
                groupes.add(nouveauGroupe);
            }
        }
        
        
        return groupes;
    }
}