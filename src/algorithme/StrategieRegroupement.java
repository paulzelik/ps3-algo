package algorithme;

import classe.*;
import java.util.*;

public interface StrategieRegroupement {
	List<Groupe> formerGroupes(List<Etudiant> etudiants, List<Contrainte> contraintes, int tailleMin, int tailleMax);
}
