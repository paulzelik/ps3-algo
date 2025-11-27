package contrainte;

import java.util.*;
import classe.*;

public class ContrainteCovoiturage {
    private Set<Set<String>> paires = new HashSet<>();

    public ContrainteCovoiturage(List<java.util.AbstractMap.SimpleEntry<String,String>> listePaires) {
        if (listePaires != null) {
            for (var e : listePaires) {
                Set<String> s = new HashSet<>();
                s.add(e.getKey());
                s.add(e.getValue());
                paires.add(s);
            }
        }
    }

    public boolean verifierAjout(Etudiant e, Groupe groupe) {
        // si e doit être avec quelqu'un, et cette personne n'est pas dans ce groupe -> on autorise l'ajout seulement si l'autre membre est aussi présent ou sera ajouté plus tard.
        // Pour sécurité, on empêche d'ajouter e dans un groupe qui contient un "contraire" absent mais présent dans un autre groupe.
        // Mise en oeuvre simple : si le groupe contient un partenaire, ok; sinon autoriser (on laisse au post-traitement de vérifier globalement).
        for (Set<String> paire : paires) {
            if (paire.contains(e.getId())) {
                // check if groupe contains the other
                for (String id : paire) {
                    if (!id.equals(e.getId())) {
                        boolean present = groupContainsId(groupe, id);
                        if (!present) {
                            // we allow local add (so greedy can try), but global check will fail if pair not satisfied
                            return true;
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean groupContainsId(Groupe g, String id) {
        return g.getMembres().stream().anyMatch(x -> x.getId().equals(id));
    }

    public boolean verifierGlobale(List<Groupe> groupes) {
        // chaque paire doit être située dans un même groupe
        for (Set<String> paire : paires) {
            boolean satisfied = false;
            for (Groupe g : groupes) {
                boolean allPresent = true;
                for (String id : paire) {
                    final String tid = id;
                    if (g.getMembres().stream().noneMatch(e -> e.getId().equals(tid))) {
                        allPresent = false; break;
                    }
                }
                if (allPresent) { satisfied = true; break; }
            }
            if (!satisfied) return false;
        }
        return true;
    }
}

