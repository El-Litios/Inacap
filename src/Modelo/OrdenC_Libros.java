package Modelo;

public class OrdenC_Libros extends OrdenCompra3{
    private int precio;

    public OrdenC_Libros() {
    }

    public OrdenC_Libros(int precio, String folio_orden, String titulo_libro) {
        super(folio_orden, titulo_libro);
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
}
