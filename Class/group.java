import java.util.ArrayList;
import java.util.List;

public class Groupe {
    private String idGroupe;
    private String nomGroupe;
    private String typeGroupe;
    private int tailleMin; 
    private int tailleMax;
    private String etat;

    private List<Etudiant> membres = new ArrayList<>();
    private List<Contrainte> contraintes = new ArrayList<>();
    
    public Groupe(String idGroupe, String nomGroupe, String typeGroupe, int tailleMin, int tailleMax) {
        this.idGroupe = idGroupe;
        this.nomGroupe = nomGroupe;
        this.typeGroupe = typeGroupe;
        this.tailleMin = tailleMin;
        this.tailleMax = tailleMax;
        this.etat = "provisoire";
    }

    public String getIdGroupe() { return idGroupe; }
    public String getNomGroupe() { return nomGroupe; }
    public String getTypeGroupe() { return typeGroupe; }
    public int getTailleMax() { return tailleMax; }
    public int getTailleMin() { return tailleMin; }
    public String getEtat() { return etat; }
    public List<Etudiant> getMembres() { return membres; }
    public List<Contrainte> getContraintes() { return contraintes; }

    public void setContraintes(List<Contrainte> contraintes) { this.contraintes = contraintes; }
    public void setEtat(String etat) { this.etat = etat; }
    public void setTailleMax(int tailleMax) { this.tailleMax = tailleMax; }
    public void setTailleMin(int tailleMin) { this.tailleMin = tailleMin; }
    public void setTypeGroupe(String typeGroupe) { this.typeGroupe = typeGroupe; }
    public void setNomGroupe(String nomGroupe) { this.nomGroupe = nomGroupe; }
    public void setIdGroupe(String idGroupe) { this.idGroupe = idGroupe; }
    
    public void ajouterContrainte(Contrainte contrainte) {
        this.contraintes.add(contrainte);
    }

    public boolean ajouterEtudiant(Etudiant etudiant){
        if (membres.size() >= tailleMax){
            return false;
        }

        /** A dev */
        
        membres.add(etudiant);
        return true;
    }

    @Override
    public String toString() {
        return "Groupe{" +
                "idGroupe='" + idGroupe + '\'' +
                ", nomGroupe='" + nomGroupe + '\'' +
                ", typeGroupe='" + typeGroupe + '\'' +
                ", tailleMin=" + tailleMin +
                ", tailleMax=" + tailleMax +
                ", etat='" + etat + '\'' +
                ", membres=" + membres.size() +
                '}';
    }
}