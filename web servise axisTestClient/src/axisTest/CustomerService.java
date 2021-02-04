/**
 * CustomerService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package axisTest;

public interface CustomerService extends javax.xml.rpc.Service {
    public java.lang.String getCustomerAddress();

    public axisTest.Customer getCustomer() throws javax.xml.rpc.ServiceException;

    public axisTest.Customer getCustomer(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
