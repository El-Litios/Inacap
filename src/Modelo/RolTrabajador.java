

package Modelo;

public class RolTrabajador {
    private int cod_rol;
    private String nom_rol;

    public RolTrabajador() {
    }

    public RolTrabajador(int cod_rol, String nom_rol) {
        this.cod_rol = cod_rol;
        this.nom_rol = nom_rol;
    }

    public RolTrabajador(String nom_rol) {
        this.nom_rol = nom_rol;
    }

    public int getCod_rol() {
        return cod_rol;
    }

    public void setCod_rol(int cod_rol) {
        this.cod_rol = cod_rol;
    }

    public String getNom_rol() {
        return nom_rol;
    }

    public void setNom_rol(String nom_rol) {
        this.nom_rol = nom_rol;
    }
    
    @Override
    public String toString(){
        return nom_rol;
    }
    
}
