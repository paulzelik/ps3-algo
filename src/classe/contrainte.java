import java.util.List;
import java.util.function.Predicate;

public class Contrainte {
    private String idContrainte;
    private String typeContrainte;
    private String valeurContrainte;
    private Predicate<Etudiant> regle;

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
}