
package Modelo;

public class Autores extends NacionAutor {
    private int cod_autor;
    private String nom_autor;
    private String pseu_autor;
    private String app_autor;
    private String apm_autor;

    public Autores() {
    }

    public Autores(int cod_autor, String nom_autor, String pseu_autor, String app_autor, String apm_autor, String nom_nac, String nom_pais) {
        super(nom_nac, nom_pais);
        this.cod_autor = cod_autor;
        this.nom_autor = nom_autor;
        this.pseu_autor = pseu_autor;
        this.app_autor = app_autor;
        this.apm_autor = apm_autor;
    }

    public Autores(int cod_autor, String nom_autor, String pseu_autor) {
        this.cod_autor = cod_autor;
        this.nom_autor = nom_autor;
        this.pseu_autor = pseu_autor;
    }

    public Autores(int cod_autor, String nom_autor) {
        this.cod_autor = cod_autor;
        this.nom_autor = nom_autor;
    }

    
    public Autores(String nom_autor) {
        this.nom_autor = nom_autor;
    }

    public int getCod_autor() {
        return cod_autor;
    }

    public void setCod_autor(int cod_autor) {
        this.cod_autor = cod_autor;
    }

    public String getNom_autor() {
        return nom_autor;
    }

    public void setNom_autor(String nom_autor) {
        this.nom_autor = nom_autor;
    }

    public String getPseu_autor() {
        return pseu_autor;
    }

    public void setPseu_autor(String pseu_autor) {
        this.pseu_autor = pseu_autor;
    }

    public String getApp_autor() {
        return app_autor;
    }

    public void setApp_autor(String app_autor) {
        this.app_autor = app_autor;
    }

    public String getApm_autor() {
        return apm_autor;
    }

    public void setApm_autor(String apm_autor) {
        this.apm_autor = apm_autor;
    }
    
    @Override
    public String toString(){
    return nom_autor;
    }
}
