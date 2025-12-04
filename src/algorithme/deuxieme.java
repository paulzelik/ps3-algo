package algorithme;

import classe.Contrainte;
import classe.Etudiant;
import classe.Groupe;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class deuxieme implements StrategieRegroupement {

    @Override
    public List<Groupe> formerGroupes(List<Etudiant> etudiants, List<Contrainte> contraintes, int tailleMin, int tailleMax) {
        /** 
         * 
         * Fonction qui va permettre de crée des groupes en respectant les contraintes
         * @param etudiants : liste des étudiants à regrouper
         * @param contraintes : liste des contraintes à respecter
         * @param tailleMin : taille minimale d'un groupe
         * @param tailleMax : taille maximale d'un groupe
         * @return liste des groupes formés
         * 
         */
        List<Groupe> groupesFinaux = new ArrayList<>();
        List<Etudiant> etudiantsRestants = new ArrayList<>(etudiants);
        int groupCounter = 1;

        if (contraintes != null) {
            for (Contrainte contrainte : contraintes) {
                List<Etudiant> etudiantsFiltres = etudiantsRestants.stream()
                        .filter(contrainte::estValidePour)
                        .collect(Collectors.toList());
                
                if (!etudiantsFiltres.isEmpty()) {
                    etudiantsRestants.removeAll(etudiantsFiltres);

                    String nomGroupePrefix = "Groupe " + contrainte.getTypeContrainte() + " ";
                    List<Groupe> groupesContraints = formerGroupesEquilibres(etudiantsFiltres, tailleMin, tailleMax, nomGroupePrefix, groupCounter);
                    
                    for (Groupe groupe : groupesContraints) {
                        groupe.ajouterContrainte(contrainte);
                    }
                    
                    groupesFinaux.addAll(groupesContraints);
                    groupCounter += groupesContraints.size();
                }
            }
        }

        if (!etudiantsRestants.isEmpty()) {
            List<Groupe> groupesRestants = formerGroupesEquilibres(etudiantsRestants, tailleMin, tailleMax, "Groupe ", groupCounter);
            groupesFinaux.addAll(groupesRestants);
        }

        return groupesFinaux;
    }

    private List<Groupe> formerGroupesEquilibres(List<Etudiant> etudiants, int tailleMin, int tailleMax, String nomGroupePrefix, int startCounter) {
        /**
         * Fonction qui va permettre de créer des groupes équilibrés en fonction des moyennes des étudiants
         * @param etudiants : liste des étudiants à regrouper
         * @param tailleMin : taille minimale d'un groupe
         * @param tailleMax : taille maximale d'un groupe
         * @param nomGroupePrefix : préfixe du nom du groupe
         * @param startCounter : compteur de départ pour nommer les groupes
         * @return liste des groupes formés
         * 
         */
        
        List<Groupe> groupes = new ArrayList<>();
        if (etudiants == null || etudiants.isEmpty()) {
            return groupes;
        }

        List<Etudiant> etudiantsTries = new ArrayList<>(etudiants);
        etudiantsTries.sort(Comparator.comparingDouble(Etudiant::getMoyenne).reversed());
        
        int totalEtudiants = etudiantsTries.size();
        int tiers = totalEtudiants / 3;
        int mid1 = Math.min(tiers, etudiantsTries.size());
        int mid2 = Math.min(tiers * 2, etudiantsTries.size());

        List<Etudiant> bons = new ArrayList<>(etudiantsTries.subList(0, mid1));
        List<Etudiant> moyens = new ArrayList<>(etudiantsTries.subList(mid1, mid2));
        List<Etudiant> faibles = new ArrayList<>(etudiantsTries.subList(mid2, totalEtudiants));

        int groupCounter = startCounter;
        while (!bons.isEmpty() || !moyens.isEmpty() || !faibles.isEmpty()) {
            Groupe groupe = new Groupe(nomGroupePrefix + (groupCounter++));
            
            while (groupe.taille() < tailleMax) {
                boolean addedInLoop = false;
                if (groupe.taille() < tailleMax && !bons.isEmpty()) {
                    groupe.ajouter(bons.remove(0));
                    addedInLoop = true;
                }
                if (groupe.taille() < tailleMax && !faibles.isEmpty()) {
                    groupe.ajouter(faibles.remove(0));
                    addedInLoop = true;
                }
                if (groupe.taille() < tailleMax && !moyens.isEmpty()) {
                    groupe.ajouter(moyens.remove(0));
                    addedInLoop = true;
                }
                if (!addedInLoop) {
                    break;
                }
            }
            groupes.add(groupe);
        }
        return groupes;
    }
}