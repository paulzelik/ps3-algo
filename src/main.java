import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class GestionGroupes {

    private static List<Etudiant> listeEtudiants = new ArrayList<>();

    public List<Etudiant> getListeEtudiants() {
        return listeEtudiants;
    }

    public static void main(String[] args) {
        

        listeEtudiants.add(new Etudiant("Durand", "Alice", "E001", 20, "Paris", true, "F", Arrays.asList("Info", "Anglais")));
        listeEtudiants.add(new Etudiant("Martin", "Bob", "E002", 21, "Paris", false, "M", Arrays.asList("Info")));
        listeEtudiants.add(new Etudiant("Lefevre", "Chloé", "E003", 19, "Versailles", true, "F", Arrays.asList("Marketing", "Anglais")));
        listeEtudiants.add(new Etudiant("Dubois", "David", "E004", 22, "Lyon", false, "M", Arrays.asList("Info")));

        Groupe groupeCovoit = new Groupe("Groupe Covoiturage Paris", 2);
        groupeCovoit.ajouterContrainte(new Contrainte("C1", "COVOITURAGE", "Paris"));
        groupeCovoit.ajouterContrainte(new Contrainte("C2", "ANGLOPHONE", "true"));

        Groupe groupeStandard = new Groupe("Groupe Standard", 2);
        groupeStandard.ajouterContrainte(new Contrainte("C3", "OPTION", "Info"));
        
        for (Etudiant etudiant : listeEtudiants) {
            /** A compléter avec les algorithmes. */
        }

        
        System.out.println("\nMembres de " + groupeCovoit.getNomGroupe() + " : " + groupeCovoit.getMembres());
        System.out.println("Membres de " + groupeStandard.getNomGroupe() + " : " + groupeStandard.getMembres());
    }
}