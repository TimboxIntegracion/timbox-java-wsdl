/**
 * ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package WashOut;

public class ServiceLocator extends org.apache.axis.client.Service implements WashOut.Service {

    public ServiceLocator() {
    }


    public ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for timbrado_port
    private java.lang.String timbrado_port_address = "https://staging.ws.timbox.com.mx/timbrado/action";

    public java.lang.String gettimbrado_portAddress() {
        return timbrado_port_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String timbrado_portWSDDServiceName = "timbrado_port";

    public java.lang.String gettimbrado_portWSDDServiceName() {
        return timbrado_portWSDDServiceName;
    }

    public void settimbrado_portWSDDServiceName(java.lang.String name) {
        timbrado_portWSDDServiceName = name;
    }

    public WashOut.Timbrado_port gettimbrado_port() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(timbrado_port_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return gettimbrado_port(endpoint);
    }

    public WashOut.Timbrado_port gettimbrado_port(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            WashOut.Timbrado_bindingStub _stub = new WashOut.Timbrado_bindingStub(portAddress, this);
            _stub.setPortName(gettimbrado_portWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void settimbrado_portEndpointAddress(java.lang.String address) {
        timbrado_port_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (WashOut.Timbrado_port.class.isAssignableFrom(serviceEndpointInterface)) {
                WashOut.Timbrado_bindingStub _stub = new WashOut.Timbrado_bindingStub(new java.net.URL(timbrado_port_address), this);
                _stub.setPortName(gettimbrado_portWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("timbrado_port".equals(inputPortName)) {
            return gettimbrado_port();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:WashOut", "service");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:WashOut", "timbrado_port"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("timbrado_port".equals(portName)) {
            settimbrado_portEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
