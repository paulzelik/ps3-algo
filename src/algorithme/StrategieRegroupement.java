package algorithme;

import classe.*;
import java.util.*;

public interface StrategieRegroupement {

	/**
	 * Algorithme Glouton par Équilibre de Moyenne.
	 * * Il trie les étudiants par moyenne décroissante et affecte chaque étudiant
	 * au groupe existant qui minimise le nouvel écart maximal de moyenne entre tous les groupes,
	 * tout en respectant les contraintes locales et les tailles maximales.
	 */
	List<Groupe> formerGroupes(List<Etudiant> etudiants, List<Groupe> groupes, List<Contrainte> contraintes,
			int tailleMin, int tailleMax) throws Exception;
}
