<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleCustomerProxyid" scope="session" class="axisTest.CustomerProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleCustomerProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleCustomerProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleCustomerProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        axisTest.Customer getCustomer10mtemp = sampleCustomerProxyid.getCustomer();
if(getCustomer10mtemp == null){
%>
<%=getCustomer10mtemp %>
<%
}else{
        if(getCustomer10mtemp!= null){
        String tempreturnp11 = getCustomer10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String id_1id=  request.getParameter("id16");
        int id_1idTemp  = Integer.parseInt(id_1id);
        String firstName_2id=  request.getParameter("firstName18");
            java.lang.String firstName_2idTemp = null;
        if(!firstName_2id.equals("")){
         firstName_2idTemp  = firstName_2id;
        }
        String lastName_3id=  request.getParameter("lastName20");
            java.lang.String lastName_3idTemp = null;
        if(!lastName_3id.equals("")){
         lastName_3idTemp  = lastName_3id;
        }
        String birthdate_4id=  request.getParameter("birthdate22");
            java.lang.String birthdate_4idTemp = null;
        if(!birthdate_4id.equals("")){
         birthdate_4idTemp  = birthdate_4id;
        }
        java.lang.String getCustomer13mtemp = sampleCustomerProxyid.getCustomer(id_1idTemp,firstName_2idTemp,lastName_3idTemp,birthdate_4idTemp);
if(getCustomer13mtemp == null){
%>
<%=getCustomer13mtemp %>
<%
}else{
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getCustomer13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>