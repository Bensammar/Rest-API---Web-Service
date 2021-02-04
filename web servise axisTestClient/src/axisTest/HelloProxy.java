package axisTest;

public class HelloProxy implements axisTest.Hello {
  private String _endpoint = null;
  private axisTest.Hello hello = null;
  
  public HelloProxy() {
    _initHelloProxy();
  }
  
  public HelloProxy(String endpoint) {
    _endpoint = endpoint;
    _initHelloProxy();
  }
  
  private void _initHelloProxy() {
    try {
      hello = (new axisTest.HelloServiceLocator()).gethello();
      if (hello != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)hello)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)hello)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (hello != null)
      ((javax.xml.rpc.Stub)hello)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public axisTest.Hello getHello() {
    if (hello == null)
      _initHelloProxy();
    return hello;
  }
  
  public void setCustomer(int id, java.lang.String firstName, java.lang.String lastName, java.lang.String birthdate) throws java.rmi.RemoteException{
    if (hello == null)
      _initHelloProxy();
    hello.setCustomer(id, firstName, lastName, birthdate);
  }
  
  public java.lang.String getCustomer() throws java.rmi.RemoteException{
    if (hello == null)
      _initHelloProxy();
    return hello.getCustomer();
  }
  
  public void deleteCustomer(int id) throws java.rmi.RemoteException{
    if (hello == null)
      _initHelloProxy();
    hello.deleteCustomer(id);
  }
  
  public void updateCustomer(int id, java.lang.String firstName, java.lang.String lastName, java.lang.String birthdate) throws java.rmi.RemoteException{
    if (hello == null)
      _initHelloProxy();
    hello.updateCustomer(id, firstName, lastName, birthdate);
  }
  
  
}