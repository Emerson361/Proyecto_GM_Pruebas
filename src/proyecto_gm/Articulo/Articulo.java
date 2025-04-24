package proyecto_gm.Articulo;

public class Articulo {
    protected String CodigoArticulo;
    protected String IdCategoria;
    private String IdMarca;
    private String caracteristicas;
    protected String  descripcion;
    private Double cantidad;
    protected String categoriadescripcion;
    protected String marcadescripcion;

    public Articulo(String CodigoArticulo, String IdCategoria, String IdMarca, String caracteristicas, String descripcion, Double cantidad) {
        this.CodigoArticulo = CodigoArticulo;
        this.IdCategoria = IdCategoria;
        this.IdMarca = IdMarca;
        this.caracteristicas = caracteristicas;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }
    
    //get y set
    public String getcodigoArticulo() {
        return CodigoArticulo;
    }

    public void setCodigoArticulo(String CodigoArticulo) {
        this.CodigoArticulo = CodigoArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.IdCategoria = idCategoria;
    }

    public String getIdMarca() {
        return IdMarca;
    }

    public void setIdMarca(String IdMarca) {
        this.IdMarca = IdMarca;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

}
