package classe;

import java.util.*;

import algorithme.StrategieRegroupement;

public class ForceBrute implements StrategieRegroupement{
	private double bestScore = Double.POSITIVE_INFINITY;
    private List<Groupe> bestSolution = new ArrayList<>();

    public List<Groupe> formerGroupes(List<Etudiant> etudiants, int tailleMin, int tailleMax){
        if (etudiants == null || etudiants.isEmpty()){
            throw new IllegalArgumentException("Aucun étudiant fourni");
        }
        if (etudiants.size() > 12){
            throw new IllegalArgumentException("Force brute limitée: réduire la taille (<=12)");
        }
        bestScore = Double.POSITIVE_INFINITY;
        bestSolution = new ArrayList<>();
        List<List<Etudiant>> actuel = new ArrayList<>();
        return bestSolution;
    }

    private double evaluerScore(List<Groupe> groupes){
        if (groupes.isEmpty()) return Double.POSITIVE_INFINITY;
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        int maxSansEnt = 0;
        for (Groupe g : groupes){
            double moyenneG = g.moyenneGroupe();
            min  = Math.min(min, moyenneG);
            max = Math.max(max, moyenneG);
            maxSansEnt = Math.max(maxSansEnt, g.nbSansEntreprise());

        }
        double M = max - min;
        double N = maxSansEnt;
        return M+N;
    }
}