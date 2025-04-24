package proyecto_gm.TipoDocumento;

public class TipoDocumento {
    private String codigoTipoDoc;
    private String idModulo;
    private String descripcion;

    // Constructor
    public TipoDocumento(String codigoTipoDoc, String idModulo, String descripcion) {
        this.codigoTipoDoc = codigoTipoDoc;
        this.idModulo = idModulo;
        this.descripcion = descripcion;
    }

    // Getters
    public String getCodigoTipoDoc() {
        return codigoTipoDoc;
    }

    public String getIdModulo() {
        return idModulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // Setters
    public void setCodigoTipoDoc(String codigoTipoDoc) {
        this.codigoTipoDoc = codigoTipoDoc;
    }

    public void setIdModulo(String idModulo) {
        this.idModulo = idModulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
