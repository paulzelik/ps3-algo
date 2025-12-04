package classe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private boolean demAnglophone;
    private List<String> options; 
    private Covoiturage covoiturage;

    private final Map<String, Double> notes;

    // Constructeur
    public Etudiant(String id, String nom, String prenom, double moyenne, String genre,
                    String typeBac, String statut, boolean hasCompany) {

        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("L'id étudiant ne peut pas être vide.");
        }

        this.id = id.trim();
        this.nom = nom == null ? "" : nom.trim();
        this.prenom = prenom == null ? "" : prenom.trim();
        this.moyenne = moyenne;
        this.genre = genre == null ? "" : genre.trim();
        this.typeBac = typeBac == null ? "" : typeBac.trim();
        this.statut = statut == null ? "" : statut.trim();
        this.hasCompany = hasCompany;

        this.notes = new HashMap<>();
        this.options = new ArrayList<>();
        this.demAnglophone = false;
        this.covoiturage = null;
    }
    
    // ---------------------------------------
    //              GETTERS
    //----------------------------------------

    public String getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() {return prenom;}
    public double getMoyenne() { return moyenne; }
    public String getGenre() { return genre; }
    public String getTypeBac() { return typeBac; }
    public String getStatut() { return statut; }
    public boolean hasCompany() { return hasCompany; }
    
    public Map<String, Double> getNotes(){ 
        return Map.copyOf(notes);
    }

    public boolean isAnglophone() {
       return demAnglophone;
    }

    public List<String> getOptions() {
        return Collections.unmodifiableList(options);
    }

    public Covoiturage getCovoiturage() {
        return covoiturage;
    }

    //-----------------------------------------------
    //                  SETTERS
    //-----------------------------------------------

    public void setNote(String matiere, double note){
        if (matiere == null || matiere.isBlank()){
            throw new IllegalArgumentException("matiere invalide");
        }
        notes.put(matiere.trim(), note);
        recalculMoyenne();
    }
    public void setDemandeAnglophone(boolean demAnglophone){
        this.demAnglophone = demAnglophone;
    }

    public void addOption(String option){
        if (option == null || option.isBlank()){
            throw new IllegalArgumentException("Option invalide");
        }
        if (!options.contains(option.trim())){
            options.add(option.trim());
        }
    }

    public void removeOption(String option) {
        options.remove(option);
    }

    public void setCovoiturage(Covoiturage covoiturage) {
        this.covoiturage = covoiturage;
    }

    //---------------------------------------------
    //          MÉTHODES
    //---------------------------------------------

    private void recalculMoyenne(){
        if (notes.isEmpty()) return;
        double somme = 0;
        for (double valeur : notes.values()){
            somme += valeur;
        }
        this.moyenne = somme / notes.size();
    }

    public boolean estApprenti(){
        return "apprenti".equalsIgnoreCase(statut);
    }

    public boolean estRedoublant() { 
        return "redoublant".equalsIgnoreCase(statut); 
    }

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

    
}
