package WashOut;

public class Timbrado_portProxy implements WashOut.Timbrado_port {
  private String _endpoint = null;
  private WashOut.Timbrado_port timbrado_port = null;
  
  public Timbrado_portProxy() {
    _initTimbrado_portProxy();
  }
  
  public Timbrado_portProxy(String endpoint) {
    _endpoint = endpoint;
    _initTimbrado_portProxy();
  }
  
  private void _initTimbrado_portProxy() {
    try {
      timbrado_port = (new WashOut.ServiceLocator()).gettimbrado_port();
      if (timbrado_port != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)timbrado_port)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)timbrado_port)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (timbrado_port != null)
      ((javax.xml.rpc.Stub)timbrado_port)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public WashOut.Timbrado_port getTimbrado_port() {
    if (timbrado_port == null)
      _initTimbrado_portProxy();
    return timbrado_port;
  }
  
  public WashOut.Timbrar_cfdi_result timbrar_cfdi(java.lang.String username, java.lang.String password, java.lang.String sxml) throws java.rmi.RemoteException{
    if (timbrado_port == null)
      _initTimbrado_portProxy();
    return timbrado_port.timbrar_cfdi(username, password, sxml);
  }
  
  public WashOut.Cancelar_cfdi_result cancelar_cfdi(java.lang.String username, java.lang.String password, java.lang.String rfcemisor, java.lang.String[] uuids, java.lang.String pfxbase64, java.lang.String pfxpassword) throws java.rmi.RemoteException{
    if (timbrado_port == null)
      _initTimbrado_portProxy();
    return timbrado_port.cancelar_cfdi(username, password, rfcemisor, uuids, pfxbase64, pfxpassword);
  }
  
  public WashOut.Cancelar_cfdi_certs_result cancelar_cfdi_certs(java.lang.String username, java.lang.String password, java.lang.String rfcemisor, java.lang.String[] uuids, java.lang.String cert_pem, java.lang.String llave_pem, java.lang.String llave_password) throws java.rmi.RemoteException{
    if (timbrado_port == null)
      _initTimbrado_portProxy();
    return timbrado_port.cancelar_cfdi_certs(username, password, rfcemisor, uuids, cert_pem, llave_pem, llave_password);
  }
  
  
}