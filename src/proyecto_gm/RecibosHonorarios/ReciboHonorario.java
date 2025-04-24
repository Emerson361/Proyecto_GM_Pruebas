
package proyecto_gm.RecibosHonorarios;

/**
 *
 * @author jeanv
 */
public class ReciboHonorario {

    String codigoRecibo, nroRecibo, ruc, nombres, apellidos, distrito, direccion, formaPago, concepto, fecha;
    float importeNeto, retencionIr, importeTotal;

    public ReciboHonorario(String codigoRecibo, String nroRecibo, String ruc, String nombres, String apellidos, String distrito, String direccion, String formaPago, String concepto, String fecha, float importeNeto, float retencionIr, float importeTotal) {
        this.codigoRecibo = codigoRecibo;
        this.nroRecibo = nroRecibo;
        this.ruc = ruc;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.distrito = distrito;
        this.direccion = direccion;
        this.formaPago = formaPago;
        this.concepto = concepto;
        this.fecha = fecha;
        this.importeNeto = importeNeto;
        this.retencionIr = retencionIr;
        this.importeTotal = importeTotal;
    }

    
    public ReciboHonorario() {
        // Constructor vacio
    }

    public String getCodigoRecibo() {
        return codigoRecibo;
    }

    public void setCodigoRecibo(String id) {
        this.codigoRecibo = codigoRecibo;
    }

    public String getNroRecibo() {
        return nroRecibo;
    }

    public void setNroRecibo(String nroRecibo) {
        this.nroRecibo = nroRecibo;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getImporteNeto() {
        return importeNeto;
    }

    public void setImporteNeto(float importeNeto) {
        this.importeNeto = importeNeto;
    }

    public float getRetencionIr() {
        return retencionIr;
    }

    public void setRetencionIr(float retencionIr) {
        this.retencionIr = retencionIr;
    }

    public float getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(float importeTotal) {
        this.importeTotal = importeTotal;
    }

}
