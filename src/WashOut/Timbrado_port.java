/**
 * Timbrado_port.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package WashOut;

public interface Timbrado_port extends java.rmi.Remote {
    public WashOut.Timbrar_cfdi_result timbrar_cfdi(java.lang.String username, java.lang.String password, java.lang.String sxml) throws java.rmi.RemoteException;
    public WashOut.Cancelar_cfdi_result cancelar_cfdi(java.lang.String username, java.lang.String password, java.lang.String rfcemisor, java.lang.String[] uuids, java.lang.String pfxbase64, java.lang.String pfxpassword) throws java.rmi.RemoteException;
    public WashOut.Cancelar_cfdi_certs_result cancelar_cfdi_certs(java.lang.String username, java.lang.String password, java.lang.String rfcemisor, java.lang.String[] uuids, java.lang.String cert_pem, java.lang.String llave_pem, java.lang.String llave_password) throws java.rmi.RemoteException;
}
