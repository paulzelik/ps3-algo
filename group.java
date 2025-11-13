import java.util.ArrayList;

public class Groupe {
    private String idGroupe;
    private String nomGroupe;
    private String typeGroupe;
    private int tailleMax;
    private String etat;

    private List<Etudiant> membres = new ArrayList<>();
    
    public Groupe(String idGroupe, String nom, String type, int tailleMin, int tailleMax) {
        this.idGroupe = idGroupe;
        this.nom = nom;
        this.type = type;
        this.tailleMax = tailleMax;
        this.etat = "provisoire";
    }

    public String getIdGroupe() { return idGroupe; }
    public String getNom() { return nom; }
    public String getType() { return type; }
    public int getTailleMax() { return tailleMax; }
    public int getTailleMin() { return tailleMin; }
    public String getEtat() { return etat; }
    public List<Etudiant> getMembres() { return membres; }
    public void setContraintes(List<Contrainte> contraintes) { this.contraintes = contraintes; }


    public boolean ajouterEtudiant(Etudiant e){
        
    }


    @Override
    public String toString() {
        return "Groupe{" +
                "nom='" + nomGroupe + '\'' +
                ", typeGroupe='" + typeGroupe + '\'' +
                ", tailleMax='" + tailleMax + '\'' +
                ", etat=" + etat +
                '}';
    }


}
