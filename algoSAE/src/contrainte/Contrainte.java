package contrainte;

import java.util.List;
import java.util.function.Predicate;

import classe.*;
import algorithme.*;

public class Contrainte {
    private String idContrainte;
    private String typeContrainte;
    private String valeurContrainte;
    private Predicate<Etudiant> regle;

    // Constructeur
    public Contrainte(String idContrainte, String typeContrainte, String valeurContrainte) {
        this.idContrainte = idContrainte;
        this.typeContrainte = typeContrainte;
        this.valeurContrainte = valeurContrainte;
        this.regle = creerRegle(typeContrainte, valeurContrainte);
    }

    private Predicate<Etudiant> creerRegle(String type, String valeur) {
        switch (type.toUpperCase()) {
            case "COVOITURAGE":
                return etudiant -> etudiant.getCovoiturage().equalsIgnoreCase(valeur);
            case "ANGLOPHONE":
                return etudiant -> etudiant.isAnglophone() == Boolean.parseBoolean(valeur);
            case "OPTION":
                return etudiant -> etudiant.getOptions().contains(valeur);
            case "GENRE":
                return etudiant -> etudiant.getGenre().equalsIgnoreCase(valeur);
            default:
                return etudiant -> true;
        }
    }

    public boolean estValidePour(Etudiant etudiant) {
        return regle.test(etudiant);
    }

    public String getIdContrainte() {
        return idContrainte;
    }

    public String getTypeContrainte() {
        return typeContrainte;
    }

    public String getValeurContrainte() {
        return valeurContrainte;
    }

    public boolean verifierAjout(Etudiant e, Groupe g){
        if (!regle.test(e)){
            return false;
        }
        switch (typeContrainte.toUpperCase()){
            case "COVOITURAGE":
                return verifierAjoutCovoiturage(e, g);
            case "ANGLOPHONE":
                return verifierAjoutAnglophone(e, g);

            case "OPTION":
                return verifierAjoutOption(e, g);

            case "GENRE":
                return verifierAjoutGenre(e, g);
        }
        return true;
    }

    public boolean verifierAjoutCovoiturage(Etudiant e, Groupe g){
        if (e.getCovoiturage() == null) return false;
        Covoiturage covoitId = e.getCovoiturage();
        for (Etudiant membre : g.getMembres()){
            if (membre.getCovoiturage() != null && !membre.getCovoiturage().equals(covoitId)) {
                return false;
            }
        }
        return true;
    }

    public boolean verifierAjoutAnglophone(Etudiant e, Groupe g){
        if (e.isAnglophone()){
            return g.Anglophone();
        }
        return true;
    }

    public boolean verifierAjoutOption(Etudiant e, Groupe g){
        return true;
    }

    private boolean verifierAjoutGenre(Etudiant e, Groupe g) {
        return true;
    }
    
}