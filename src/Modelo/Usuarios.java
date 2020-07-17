
package Modelo;

public class Usuarios extends Cargo {
    private int cod_usu;
    private String nom_usu;
    private String pass_usu;

    public Usuarios() {
    }

    public Usuarios(int cod_usu, String nom_usu, String pass_usu, String nom_cargo) {
        super(nom_cargo);
        this.cod_usu = cod_usu;
        this.nom_usu = nom_usu;
        this.pass_usu = pass_usu;
    }

    public int getCod_usu() {
        return cod_usu;
    }

    public void setCod_usu(int cod_usu) {
        this.cod_usu = cod_usu;
    }

    public String getNom_usu() {
        return nom_usu;
    }

    public void setNom_usu(String nom_usu) {
        this.nom_usu = nom_usu;
    }

    public String getPass_usu() {
        return pass_usu;
    }

    public void setPass_usu(String pass_usu) {
        this.pass_usu = pass_usu;
    }
    
    
    
}
