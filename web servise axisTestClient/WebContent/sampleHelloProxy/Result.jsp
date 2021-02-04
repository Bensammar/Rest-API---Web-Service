<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleHelloProxyid" scope="session" class="axisTest.HelloProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleHelloProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleHelloProxyid.getEndpoint();
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
        sampleHelloProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        axisTest.Hello getHello10mtemp = sampleHelloProxyid.getHello();
if(getHello10mtemp == null){
%>
<%=getHello10mtemp %>
<%
}else{
        if(getHello10mtemp!= null){
        String tempreturnp11 = getHello10mtemp.toString();
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
        sampleHelloProxyid.setCustomer(id_1idTemp,firstName_2idTemp,lastName_3idTemp,birthdate_4idTemp);
break;
case 24:
        gotMethod = true;
        java.lang.String getCustomer24mtemp = sampleHelloProxyid.getCustomer();
if(getCustomer24mtemp == null){
%>
<%=getCustomer24mtemp %>
<%
}else{
        String tempResultreturnp25 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getCustomer24mtemp));
        %>
        <%= tempResultreturnp25 %>
        <%
}
break;
case 27:
        gotMethod = true;
        String id_5id=  request.getParameter("id30");
        int id_5idTemp  = Integer.parseInt(id_5id);
        sampleHelloProxyid.deleteCustomer(id_5idTemp);
break;
case 32:
        gotMethod = true;
        String id_6id=  request.getParameter("id35");
        int id_6idTemp  = Integer.parseInt(id_6id);
        String firstName_7id=  request.getParameter("firstName37");
            java.lang.String firstName_7idTemp = null;
        if(!firstName_7id.equals("")){
         firstName_7idTemp  = firstName_7id;
        }
        String lastName_8id=  request.getParameter("lastName39");
            java.lang.String lastName_8idTemp = null;
        if(!lastName_8id.equals("")){
         lastName_8idTemp  = lastName_8id;
        }
        String birthdate_9id=  request.getParameter("birthdate41");
            java.lang.String birthdate_9idTemp = null;
        if(!birthdate_9id.equals("")){
         birthdate_9idTemp  = birthdate_9id;
        }
        sampleHelloProxyid.updateCustomer(id_6idTemp,firstName_7idTemp,lastName_8idTemp,birthdate_9idTemp);
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