/**
 * HelloService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package axisTest;

public interface HelloService extends javax.xml.rpc.Service {
    public java.lang.String gethelloAddress();

    public axisTest.Hello gethello() throws javax.xml.rpc.ServiceException;

    public axisTest.Hello gethello(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
