public class Etudiant {
    private String nom;
    private String prenom;
    private String numeroEtudiant;
    private int age;
    private String covoiturage; 
    private boolean anglophone; 
    private String genre;       
    private List<String> options;

    public Etudiant(String nom, String prenom, String numeroEtudiant, int age, String covoiturage, boolean anglophone, String genre, List<String> options) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroEtudiant = numeroEtudiant;
        this.age = age;
        this.covoiturage = covoiturage;
        this.anglophone = anglophone;
        this.genre = genre;
        this.options = options;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumeroEtudiant() {
        return numeroEtudiant;
    }

    public int getAge() {
        return age;
    }
    
    public String getCovoiturage() {
        return covoiturage;
    }

    public boolean isAnglophone() {
        return anglophone;
    }

    public String getGenre() {
        return genre;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNumeroEtudiant(String numeroEtudiant) {
        this.numeroEtudiant = numeroEtudiant;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public void setCovoiturage(String covoiturage) {
        this.covoiturage = covoiturage;
    }

    public void setAnglophone(boolean anglophone) {
        this.anglophone = anglophone;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public void afficherDetails() {
        System.out.println("Nom: " + nom);
        System.out.println("Prénom: " + prenom);
        System.out.println("Numéro Étudiant: " + numeroEtudiant);
        System.out.println("Âge: " + age + " ans");
        System.out.println("Covoiturage: " + covoiturage);
        System.out.println("Anglophone: " + anglophone);
        System.out.println("Genre: " + genre);
        System.out.println("Options: " + options);
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", numeroEtudiant='" + numeroEtudiant + '\'' +
                ", age=" + age +
                ", covoiturage='" + covoiturage + '\'' +
                ", anglophone=" + anglophone +
                ", genre='" + genre + '\'' +
                ", options=" + options +
                '}';
    }
}