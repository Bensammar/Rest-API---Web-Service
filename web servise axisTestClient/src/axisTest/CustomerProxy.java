package axisTest;

public class CustomerProxy implements axisTest.Customer {
  private String _endpoint = null;
  private axisTest.Customer customer = null;
  
  public CustomerProxy() {
    _initCustomerProxy();
  }
  
  public CustomerProxy(String endpoint) {
    _endpoint = endpoint;
    _initCustomerProxy();
  }
  
  private void _initCustomerProxy() {
    try {
      customer = (new axisTest.CustomerServiceLocator()).getCustomer();
      if (customer != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)customer)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)customer)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (customer != null)
      ((javax.xml.rpc.Stub)customer)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public axisTest.Customer getCustomer() {
    if (customer == null)
      _initCustomerProxy();
    return customer;
  }
  
  public java.lang.String getCustomer(int id, java.lang.String firstName, java.lang.String lastName, java.lang.String birthdate) throws java.rmi.RemoteException{
    if (customer == null)
      _initCustomerProxy();
    return customer.getCustomer(id, firstName, lastName, birthdate);
  }
  
  
}