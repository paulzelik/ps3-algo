package classe;

import java.util.Objects;

public class Etudiant {
	private String id;
	private String nom;
    private String prenom;
    private String genre;
    private String typeBac;
    private String statut;
    private boolean hasCompany;
    private double moyenne;

    public Etudiant(String id, String nom, String prenom, double moyenne, String genre,
            String typeBac, String statut, boolean hasCompany) {
	if (id == null || id.isEmpty()) throw new IllegalArgumentException("id étudiant invalide");
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.moyenne = moyenne;
		this.genre = genre;
		this.typeBac = typeBac;
		this.statut = statut;
		this.hasCompany = hasCompany;
    }
    
    public String getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() {return prenom;}
    public double getMoyenne() { return moyenne; }
    public String getGenre() { return genre; }
    public String getTypeBac() { return typeBac; }
    public String getStatut() { return statut; }
    public boolean hasCompany() { return hasCompany; }
    

    @Override
    public String toString() {
        return id + ":" + nom 
        		+ " (moy=" + moyenne + ", " 
        		+ statut 
        		+ (hasCompany ? ", en entreprise" : ", sans entreprise") 
        		+ ")";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Etudiant)) return false;
        Etudiant e = (Etudiant) o;
        return id.equals(e.id);
    }
    
    @Override
    public int hashCode() {
    	return Objects.hash(id);
    }

    public boolean isAnglophone() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isAnglophone'");
    }

    public String getOptions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOptions'");
    }

    public String getCovoiturage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCovoiturage'");
    }
}
