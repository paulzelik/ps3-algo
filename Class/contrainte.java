public class Contrainte {

    private int idContrainte;
    private String typeContrainte;
    private String descriptionContrainte;
    private String descriptionContraintes;
    private String parametresContraintes;

    public Contrainte(int idContrainte, String typeContrainte, String descriptionContrainte,
                      String descriptionContraintes, String parametresContraintes) {
        this.idContrainte = idContrainte;
        this.typeContrainte = typeContrainte;
        this.descriptionContrainte = descriptionContrainte;
        this.descriptionContraintes = descriptionContraintes;
        this.parametresContraintes = parametresContraintes;
    }


    public int getIdContrainte() {
        return idContrainte;
    }

    public String getTypeContrainte() {
        return typeContrainte;
    }

    public String getDescriptionContrainte() {
        return descriptionContrainte;
    }

    public String getDescriptionContraintes() {
        return descriptionContraintes;
    }

    public String getParametresContraintes() {
        return parametresContraintes;
    }


    public void setIdContrainte(int idContrainte) {
        this.idContrainte = idContrainte;
    }

    public void setTypeContrainte(String typeContrainte) {
        this.typeContrainte = typeContrainte;
    }

    public void setDescriptionContrainte(String descriptionContrainte) {
        this.descriptionContrainte = descriptionContrainte;
    }

    public void setDescriptionContraintes(String descriptionContraintes) {
        this.descriptionContraintes = descriptionContraintes;
    }

    public void setParametresContraintes(String parametresContraintes) {
        this.parametresContraintes = parametresContraintes;
    }

    public String toString() {
        return "Contrainte{" +
                "idContrainte=" + idContrainte +
                ", typeContrainte='" + typeContrainte + '\'' +
                ", descriptionContrainte='" + descriptionContrainte + '\'' +
                ", parametresContraintes='" + parametresContraintes + '\'' +
                '}';
    }
}