package classe;

import java.util.*;

import algorithme.StrategieRegroupement;
import contrainte.Contrainte;

public class ForceBrute implements StrategieRegroupement{
	private double bestScore = Double.POSITIVE_INFINITY;
    private List<Groupe> bestSolution = new ArrayList<>();

    public List<Groupe> formerGroupes(List<Etudiant> etudiants, int tailleMin, int tailleMax, List<Contrainte> contraintes, Map<String, Object> param) throws Exception{
        if (etudiants == null || etudiants.isEmpty()){
            throw new IllegalArgumentException("Aucun étudiant fourni");
        }
        if (tailleMax < 1 || tailleMin < 1 || tailleMax < tailleMin){
            throw new IllegalArgumentException("Tailles invalides.");
        }
        int n = etudiants.size();
        int limit = param != null && param.containsKey("bruteLimit") ? (Integer) param.get("bruteLimit") : 12;
        if (n > limit) throw new IllegalArgumentException("Force brute limitée à " + limit + " étudiants (actuels: " + n + ")");

        bestScore = Double.POSITIVE_INFINITY;
        bestSolution = null;

        List<Etudiant> liste = new ArrayList<>(etudiants);
        liste.sort((a,b) -> Double.compare(b.getMoyenne(), a.getMoyenne()));
        if (bestSolution == null) {
            throw new Exception("Aucune solution valide trouvée (force brute).");
        }
        return bestSolution;
        
    }

    
    private void backtrack(List<Etudiant> list, int idx, List<Groupe> current,
                           int tailleMin, int tailleMax, List<Contrainte> contraintes) {
        if (idx == list.size()) {
            // feuille : vérifier tailles minimales
            for (Groupe g : current) {
                if (g.taille() < tailleMin) return;
            }
            // vérifier contraintes globales
            if (contraintes != null) {
                for (Contrainte c : contraintes) {
                    if (!c.verifierGlobale(current)) return;
                }
            }
            double score = evaluerScore(current);
            if (score < bestScore) {
                bestScore = score;
                // deep copy solution
                bestSolution = new ArrayList<>();
                for (Groupe g : current) bestSolution.add(g.clone());
            }
            return;
        }

        Etudiant e = list.get(idx);

        // Branch & Bound : estimation minimale possible du score pour prune
        // (simple bound : si current already worse than best -> prune)
        // On peut améliorer l'estimation, mais ici simple check:
        if (bestScore < Double.POSITIVE_INFINITY) {
            // compute current min/max means quickly
            double minM = Double.POSITIVE_INFINITY, maxM = Double.NEGATIVE_INFINITY;
            int maxSans = 0;
            for (Groupe g : current) {
                double mg = g.moyenneGroupe();
                if (g.taille() > 0) {
                    minM = Math.min(minM, mg);
                    maxM = Math.max(maxM, mg);
                }
                maxSans = Math.max(maxSans, g.nbSansEntreprise());
            }
            if (minM != Double.POSITIVE_INFINITY) {
                double partialScore = (maxM - minM) + maxSans;
                if (partialScore >= bestScore) {
                    // il est peu probable d'améliorer; prune
                    // NOTE: c'est une heuristique, pas un critère parfait
                    // mais aide à réduire l'exploration
                    return;
                }
            }
        }

        // Option 1 : créer un nouveau groupe avec e
        Groupe newG = new Groupe("G" + (current.size() + 1));
        newG.ajouter(e);

        // vérifier contraintes locales pour un nouveau groupe
        boolean okNew = true;
        if (contraintes != null) {
            for (Contrainte c : contraintes) {
                if (!c.verifierAjout(e, newG)) { okNew = false; break; }
            }
        }
        if (okNew) {
            current.add(newG);
            backtrack(list, idx + 1, current, tailleMin, tailleMax, contraintes);
            current.remove(current.size() - 1);
        }

        // Option 2 : essayer d'ajouter e dans un groupe existant
        for (Groupe g : current) {
            if (g.taille() >= tailleMax) continue;

            boolean ok = true;
            if (contraintes != null) {
                for (Contrainte c : contraintes) {
                    if (!c.verifierAjout(e, g)) { ok = false; break; }
                }
            }
            if (!ok) continue;

            g.ajouter(e);
            backtrack(list, idx + 1, current, tailleMin, tailleMax, contraintes);
            g.retirer(e);
        }
    }

    private double evaluerScore(List<Groupe> groupes) {
        if (groupes == null || groupes.isEmpty()) return Double.POSITIVE_INFINITY;
        double min = Double.POSITIVE_INFINITY, max = Double.NEGATIVE_INFINITY;
        int maxSans = 0;
        for (Groupe g : groupes) {
            if (g.taille() == 0) continue;
            double mg = g.moyenneGroupe();
            min = Math.min(min, mg);
            max = Math.max(max, mg);
            maxSans = Math.max(maxSans, g.nbSansEntreprise());
        }
        if (min == Double.POSITIVE_INFINITY) return Double.POSITIVE_INFINITY;
        return (max - min) + maxSans;
    }
}