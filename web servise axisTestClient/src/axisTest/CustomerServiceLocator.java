/**
 * CustomerServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package axisTest;

public class CustomerServiceLocator extends org.apache.axis.client.Service implements axisTest.CustomerService {

    public CustomerServiceLocator() {
    }


    public CustomerServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CustomerServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Customer
    private java.lang.String Customer_address = "http://localhost:8080/axisTest/services/Customer";

    public java.lang.String getCustomerAddress() {
        return Customer_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CustomerWSDDServiceName = "Customer";

    public java.lang.String getCustomerWSDDServiceName() {
        return CustomerWSDDServiceName;
    }

    public void setCustomerWSDDServiceName(java.lang.String name) {
        CustomerWSDDServiceName = name;
    }

    public axisTest.Customer getCustomer() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Customer_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCustomer(endpoint);
    }

    public axisTest.Customer getCustomer(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            axisTest.CustomerSoapBindingStub _stub = new axisTest.CustomerSoapBindingStub(portAddress, this);
            _stub.setPortName(getCustomerWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCustomerEndpointAddress(java.lang.String address) {
        Customer_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (axisTest.Customer.class.isAssignableFrom(serviceEndpointInterface)) {
                axisTest.CustomerSoapBindingStub _stub = new axisTest.CustomerSoapBindingStub(new java.net.URL(Customer_address), this);
                _stub.setPortName(getCustomerWSDDServiceName());
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
        if ("Customer".equals(inputPortName)) {
            return getCustomer();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://axisTest", "CustomerService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://axisTest", "Customer"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Customer".equals(portName)) {
            setCustomerEndpointAddress(address);
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
