package entity;

public class Certification {
    private String idE;
    private String idP;

    public Certification() {
    }

    public Certification(String idE, String idP) {
        this.idE = idE;
        this.idP = idP;
    }

    public String getIdE() {
        return idE;
    }

    public void setIdE(String idE) {
        this.idE = idE;
    }

    public String getIdP() {
        return idP;
    }

    public void setIdP(String idP) {
        this.idP = idP;
    }

    @Override
    public String toString() {
        return "Certification{" +
                "idE='" + idE + '\'' +
                ", idP='" + idP + '\'' +
                '}';
    }
}
