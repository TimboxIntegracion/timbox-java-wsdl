/**
 * Cancelar_cfdi_certs_result.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package WashOut;

public class Cancelar_cfdi_certs_result  implements java.io.Serializable {
    private java.lang.String acuse_cancelacion;

    private java.lang.String comprobantes_cancelados;

    public Cancelar_cfdi_certs_result() {
    }

    public Cancelar_cfdi_certs_result(
           java.lang.String acuse_cancelacion,
           java.lang.String comprobantes_cancelados) {
           this.acuse_cancelacion = acuse_cancelacion;
           this.comprobantes_cancelados = comprobantes_cancelados;
    }


    /**
     * Gets the acuse_cancelacion value for this Cancelar_cfdi_certs_result.
     * 
     * @return acuse_cancelacion
     */
    public java.lang.String getAcuse_cancelacion() {
        return acuse_cancelacion;
    }


    /**
     * Sets the acuse_cancelacion value for this Cancelar_cfdi_certs_result.
     * 
     * @param acuse_cancelacion
     */
    public void setAcuse_cancelacion(java.lang.String acuse_cancelacion) {
        this.acuse_cancelacion = acuse_cancelacion;
    }


    /**
     * Gets the comprobantes_cancelados value for this Cancelar_cfdi_certs_result.
     * 
     * @return comprobantes_cancelados
     */
    public java.lang.String getComprobantes_cancelados() {
        return comprobantes_cancelados;
    }


    /**
     * Sets the comprobantes_cancelados value for this Cancelar_cfdi_certs_result.
     * 
     * @param comprobantes_cancelados
     */
    public void setComprobantes_cancelados(java.lang.String comprobantes_cancelados) {
        this.comprobantes_cancelados = comprobantes_cancelados;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Cancelar_cfdi_certs_result)) return false;
        Cancelar_cfdi_certs_result other = (Cancelar_cfdi_certs_result) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.acuse_cancelacion==null && other.getAcuse_cancelacion()==null) || 
             (this.acuse_cancelacion!=null &&
              this.acuse_cancelacion.equals(other.getAcuse_cancelacion()))) &&
            ((this.comprobantes_cancelados==null && other.getComprobantes_cancelados()==null) || 
             (this.comprobantes_cancelados!=null &&
              this.comprobantes_cancelados.equals(other.getComprobantes_cancelados())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAcuse_cancelacion() != null) {
            _hashCode += getAcuse_cancelacion().hashCode();
        }
        if (getComprobantes_cancelados() != null) {
            _hashCode += getComprobantes_cancelados().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Cancelar_cfdi_certs_result.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:WashOut", "cancelar_cfdi_certs_result"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("acuse_cancelacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "acuse_cancelacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comprobantes_cancelados");
        elemField.setXmlName(new javax.xml.namespace.QName("", "comprobantes_cancelados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
