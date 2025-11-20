package classe;

import java.util.*;

public class Groupe {
	private String id;
	private List<Etudiant> membres = new ArrayList<>();
	
	public Groupe(String id) {
        if (id == null || id.isEmpty()) throw new IllegalArgumentException("id groupe invalide");
        this.id = id;
    }
	
	public String getId() { return id; }
    public List<Etudiant> getMembres() { 
    	return Collections.unmodifiableList(membres); 
    }
    
    public boolean ajouter(Etudiant e) {
    	if (e == null) throw new IllegalArgumentException("étudiant nul");
    	
    	return membres.add(e);
    }
    
    public boolean retirer(Etudiant e) {
    	return membres.remove(e);
    }
    
    public int taille() { 
    	return membres.size(); 
    }
    
    public double moyenneGroupe() {
        if (membres.isEmpty()) return 0.0;
        return membres.stream().mapToDouble(Etudiant::getMoyenne).average().orElse(0.0);
    }
    
    @Override
    public String toString() {
        return "Groupe{" 
        		+ id + ", taille=" 
        		+ taille() + ", moy=" 
        		+ String.format("%.2f", moyenneGroupe()) + "}";
    }
}
