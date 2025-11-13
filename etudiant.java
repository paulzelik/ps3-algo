public class Etudiant {
    private String nom;
    private String prenom;
    private int numeroEtudiant;
    private int age;

    // --- Constructeur ---
    /**
     * Constructeur pour créer un nouvel objet Etudiant.
     *
     * @param nom Le nom de l'étudiant.
     * @param prenom Le prénom de l'étudiant.
     * @param numeroEtudiant Le numéro d'étudiant unique.
     * @param age L'âge de l'étudiant.
     */
    public Etudiant(String nom, String prenom, String numeroEtudiant, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroEtudiant = numeroEtudiant;
        this.age = age;
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
-
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

    // --- Méthode Utile (Exemple) ---
    /**
     * Affiche les informations complètes de l'étudiant.
     */
    public void afficherDetails() {
        System.out.println("Nom: " + nom);
        System.out.println("Prénom: " + prenom);
        System.out.println("Numéro Étudiant: " + numeroEtudiant);
        System.out.println("Âge: " + age + " ans");
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", numeroEtudiant='" + numeroEtudiant + '\'' +
                ", age=" + age +
                '}';
    }
}