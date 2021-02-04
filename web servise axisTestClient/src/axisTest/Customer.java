/**
 * Customer.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package axisTest;

public interface Customer extends java.rmi.Remote {
    public java.lang.String getCustomer(int id, java.lang.String firstName, java.lang.String lastName, java.lang.String birthdate) throws java.rmi.RemoteException;
}
