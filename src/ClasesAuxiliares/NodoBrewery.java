package ClasesAuxiliares;

public class NodoBrewery {
    private Long id;
    private String name;
    int cantidad_de_resenias = 0;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCantidad_de_resenias(int cantidad_de_resenias) {
        this.cantidad_de_resenias = cantidad_de_resenias;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCantidad_de_resenias() {
        return cantidad_de_resenias;
    }

    public NodoBrewery(Long id, String name , int cantidad_de_resenias) {
        this.id = id;
        this.name = name;
        this.cantidad_de_resenias = cantidad_de_resenias;
    }

    public NodoBrewery(Long id, String name) {
        this.id = id;
        this.name = name;
        this.cantidad_de_resenias = 0;
    }



}
