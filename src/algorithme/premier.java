package algorithme;

import classe.*;

import java.util.*;

public class premier implements StrategieRegroupement {

    /**
     * Algorithme Glouton par Équilibre de Moyenne.
     * * Il trie les étudiants par moyenne décroissante et affecte chaque étudiant
     * au groupe existant qui minimise le nouvel écart maximal de moyenne entre tous les groupes,
     * tout en respectant les contraintes locales et les tailles maximales.
     */
    @Override
    public List<Groupe> formerGroupes(List<Etudiant> etudiants, List<Groupe> groupes, List<Contrainte> contraintes, int tailleMin, int tailleMax) throws Exception {
        
        // --- Vérifications de base ---
        if (etudiants == null || etudiants.isEmpty()) {
            throw new IllegalArgumentException("Aucun étudiant fourni.");
        }
        if (groupes == null) {
            groupes = new ArrayList<>(); // Permet de commencer avec une liste vide
        }
        if (tailleMax <= 0 || tailleMin <= 0 || tailleMax < tailleMin) {
            throw new IllegalArgumentException("Tailles minimales ou maximales invalides.");
        }
        
        // 1. Tri des étudiants (Préparation gloutonne: les plus fortes moyennes en premier)
        List<Etudiant> listeEtudiants = new ArrayList<>(etudiants);
        // Tri décroissant sur la moyenne
        listeEtudiants.sort((e1, e2) -> Double.compare(e2.getMoyenne(), e1.getMoyenne()));

        // --- Algorithme Glouton ---
        int compteurGroupes = groupes.size(); // Pour nommer les nouveaux groupes

        for (Etudiant e : listeEtudiants) {
            Groupe meilleurGroupe = null;
            // Critère glouton : Minimiser l'écart maximal de moyenne après l'ajout.
            double meilleurEcartMoyenne = Double.POSITIVE_INFINITY;

            // Option 1 : Tester l'ajout à un groupe existant
            for (Groupe g : groupes) {
                if (g.taille() < tailleMax) {
                    
                    // Vérification des contraintes locales
                    if (!respecteContraintesLocales(e, g, contraintes)) continue;

                    // Ajout temporaire pour évaluer l'impact
                    g.ajouter(e); 
                    
                    // Calculer l'impact de l'ajout sur l'équilibre des moyennes
                    double ecartActuel = calculerEcartMoyenneMax(groupes);
                    
                    // Si le nouvel écart est meilleur
                    if (ecartActuel < meilleurEcartMoyenne) {
                        meilleurEcartMoyenne = ecartActuel;
                        meilleurGroupe = g;
                    }
                    
                    g.retirer(e); // Retirer l'étudiant temporairement
                }
            }

            // Option 2 : Tester la création d'un nouveau groupe
            
            // Créer un groupe temporaire
            Groupe nouveauG = new Groupe("G" + (compteurGroupes + 1));
            nouveauG.ajouter(e);
            
            // Vérifier les contraintes locales pour ce nouveau groupe de taille 1
            if (respecteContraintesLocales(e, nouveauG, contraintes)) {
                
                // Calculer l'impact sur le critère M (écart max) si ce nouveau groupe est créé
                List<Groupe> groupesTemporaire = new ArrayList<>(groupes);
                groupesTemporaire.add(nouveauG);
                double ecartNouveau = calculerEcartMoyenneMax(groupesTemporaire);
                
                // Si la création d'un nouveau groupe est le meilleur choix
                if (meilleurGroupe == null || ecartNouveau < meilleurEcartMoyenne) {
                    meilleurEcartMoyenne = ecartNouveau;
                    meilleurGroupe = nouveauG;
                }
            }
            
            // Effectuer l'ajout définitif
            if (meilleurGroupe != null) {
                if (!groupes.contains(meilleurGroupe)) {
                    // C'est un nouveau groupe: l'ajouter à la liste définitive et incrémenter le compteur
                    groupes.add(meilleurGroupe);
                    compteurGroupes++;
                }
                
                // Ajouter l'étudiant au groupe (s'il n'y est pas déjà, comme c'est le cas pour un nouveau groupe)
                if (!meilleurGroupe.getMembres().contains(e)) {
                    meilleurGroupe.ajouter(e);
                }
                
            } else {
                 // Échec critique : L'étudiant ne peut être placé nulle part (contrainte non satisfaite)
                 throw new Exception("L'étudiant " + e.getId() + " ne peut être ajouté à aucun groupe tout en respectant les contraintes.");
            }
        }
        
        // --- Vérification Finale (Contraintes globales et Taille Min) ---
        if (!verifierValiditeFinale(groupes, tailleMin, contraintes)) {
             throw new Exception("Aucune solution valide trouvée : les contraintes globales ou de taille minimale n'ont pas été respectées.");
        }

        return groupes;
    }

    // --- Méthodes utilitaires ---

    /**
     * Vérifie si l'ajout d'un étudiant respecte toutes les contraintes locales.
     */
    private boolean respecteContraintesLocales(Etudiant e, Groupe g, List<Contrainte> contraintes) {
        if (contraintes != null) {
            for (Contrainte c : contraintes) {
                if (!c.verifierAjout(e, g)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Vérifie la taille minimale des groupes et les contraintes globales (si implémentées).
     */
    private boolean verifierValiditeFinale(List<Groupe> groupes, int tailleMin, List<Contrainte> contraintes) {
        // Vérification de la taille minimale
        for (Groupe g : groupes) {
            if (g.taille() < tailleMin) {
                return false;
            }
        }
        // *La vérification des contraintes globales doit être ajoutée ici si des contraintes globales existent.*
        return true;
    }
    
    /**
     * Calcule l'écart maximal de moyenne entre les groupes non vides.
     */
    private double calculerEcartMoyenneMax(List<Groupe> groupes) {
        if (groupes.isEmpty()) return 0.0;
        
        double minM = Double.POSITIVE_INFINITY;
        double maxM = Double.NEGATIVE_INFINITY;
        boolean hasNonEmptyGroup = false;

        for (Groupe g : groupes) {
            if (g.taille() > 0) {
                hasNonEmptyGroup = true;
                double mg = g.moyenneGroupe();
                minM = Math.min(minM, mg);
                maxM = Math.max(maxM, mg);
            }
        }
        
        return hasNonEmptyGroup ? (maxM - minM) : 0.0;
    }
}