package classe;

import java.util.List;
import java.util.ArrayList;

public class CreationGroupe {
	private List<Etudiant> etudiants;
    private List<Contrainte> contraintes;
    private int tailleMin;
    private int tailleMax;
    private List<Groupe> groupes;
    
    public CreationGroupe(List<Etudiant> etudiants, List<Contrainte> contraintes, int tailleMin, int tailleMax) {
        this.etudiants = new ArrayList<>(etudiants);
        this.contraintes = contraintes;
        this.tailleMin = tailleMin;
        this.tailleMax = tailleMax;
        this.groupes = new ArrayList<>();
    }
    
    public void creergroupesG(String methode) {
    	int nbGroupes = (int) Math.ceil((double) etudiants.size() / tailleMax);
    	List<List<Etudiant>> groupes = new ArrayList<>();
    	for (int i =0; i < nbGroupes; i++) {
    		groupes.add(new ArrayList<>());
    	}
    }
}
