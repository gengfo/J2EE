package com.oocl.ivo.webservice.publish.proxy;

import java.util.Vector;
import java.net.URL;
import java.util.Properties;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.apache.soap.Header;
import org.apache.soap.rpc.Call;
import org.apache.soap.rpc.Parameter;
import org.apache.soap.rpc.Response;
import org.apache.soap.Fault;
import org.apache.soap.SOAPException;
import org.apache.soap.Constants;
import org.apache.soap.encoding.SOAPMappingRegistry;
import org.apache.soap.encoding.soapenc.BeanSerializer;
import org.apache.soap.util.xml.QName;
import oracle.soap.transport.http.OracleSOAPHTTPConnection;
import oracle.soap.encoding.soapenc.EncUtils;

/**
 * Web service proxy: IVOWebService
 *     generated by Oracle WSDL toolkit (Version: 1.0).
 */
public class IVOWebServiceProxy {

    public IVOWebServiceProxy() {
        m_httpConnection = new OracleSOAPHTTPConnection();
        _setMaintainSession(true);
        
        Object untypedParams[] = {
            new String("helloOc4j"), new String("return"), new QName("http://www.w3.org/2001/XMLSchema","string")
        };

        String operationName;
        String paramName;
        QName returnType;
        SOAPMappingRegistry registry;
        org.apache.soap.util.xml.Deserializer deserializer;
        int x;
        for (x = 0; x < untypedParams.length; x += 3) {
            operationName = (String) untypedParams[x];
            paramName = (String) untypedParams[x+1];
            returnType = (QName) untypedParams[x+2];

            registry = (SOAPMappingRegistry) m_soapMappingRegistries.get(operationName);
            if (registry == null) {
                if (m_soapMappingRegistry != null) {
                    registry = new SOAPMappingRegistry(m_soapMappingRegistry);
                } else {
                    registry = new SOAPMappingRegistry();
                }
                m_soapMappingRegistries.put(operationName,registry);
            }

            try {
                deserializer = registry.queryDeserializer(returnType,Constants.NS_URI_SOAP_ENC);
                registry.mapTypes(Constants.NS_URI_SOAP_ENC, new QName("",paramName), null, null, deserializer);
            } catch(IllegalArgumentException e) {
            }
        }

    }

    public java.lang.String helloOc4j(java.lang.String param0) throws Exception {
        String soapActionURI = "urn:com-oocl-ivo-webservice-publish-IVOWebService/helloOc4j";
        String encodingStyleURI = "http://schemas.xmlsoap.org/soap/encoding/";
        Vector params = new Vector();
        params.add(new Parameter("param0", java.lang.String.class, param0, null));
        Response response = makeSOAPCallRPC("helloOc4j", params, encodingStyleURI, soapActionURI);
        Parameter returnValue = response.getReturnValue();
        return (java.lang.String)returnValue.getValue();

    }

    private Response makeSOAPCallRPC(String methodName, Vector params, String encodingStyleURI, String soapActionURI) throws Exception {
        Call call  = new Call();
        call.setSOAPTransport(m_httpConnection);
        SOAPMappingRegistry registry;
        if ((registry = (SOAPMappingRegistry)m_soapMappingRegistries.get(methodName)) != null)
            call.setSOAPMappingRegistry(registry);
        else if (m_soapMappingRegistry != null)
            call.setSOAPMappingRegistry(m_soapMappingRegistry);
        call.setTargetObjectURI(m_serviceID);
        call.setMethodName(methodName);
        call.setEncodingStyleURI(encodingStyleURI);
        call.setParams(params);
        if (m_headers != null)
            call.setHeader(m_headers);

        Response response = call.invoke(new URL(m_soapURL), soapActionURI);
        if (response.generatedFault()) {
            Fault fault = response.getFault();
            throw new SOAPException(fault.getFaultCode(), fault.getFaultString());
        }
        return response;

    }

    public String _getSoapURL() {
        return m_soapURL;

    }

    public void _setSoapURL(String soapURL) {
        m_soapURL = soapURL;

    }

    public String _getServiceID() {
        return m_serviceID;

    }

    public void _setServiceID(String serviceID) {
        m_serviceID = serviceID;

    }

    public SOAPMappingRegistry _getSOAPMappingRegistry() {
        return m_soapMappingRegistry;

    }

    public void _setSOAPMappingRegistry(SOAPMappingRegistry soapMappingRegistry) {
        m_soapMappingRegistry = soapMappingRegistry;

    }

    public boolean _getMaintainSession() {
        return m_httpConnection.getMaintainSession();

    }

    public void _setMaintainSession(boolean maintainSession) {
        m_httpConnection.setMaintainSession(maintainSession);

    }

    public void _setContext(Object ctx) throws Exception {
        try {
          Method m = OracleSOAPHTTPConnection.class.getMethod("setContext", new Class[]{Object.class});
          m.invoke(m_httpConnection, new Object[]{ctx});
        } catch (Exception e) {
          throw new Exception("Method setContext not supported by this soap version: " + e.getMessage());
        }

    }

    public Properties _getTransportProperties() {
        return m_httpConnection.getProperties();

    }

    public void _setTransportProperties(Properties properties) {
        m_httpConnection.setProperties(properties);

    }

    public String _getVersion() {
        return m_version;

    }

    public Header _getSOAPRequestHeaders() {
        return m_headers;

    }

    public void _setSOAPRequestHeaders(Header headers) {
        m_headers = headers;

    }


    private String m_serviceID = "urn:com-oocl-ivo-webservice-publish-IVOWebService";
    private String m_soapURL = "http://gengfo.corp.oocl.com:8888/IVO_RPTServer/IVORPTService";
    private OracleSOAPHTTPConnection m_httpConnection = null;
    private SOAPMappingRegistry m_soapMappingRegistry = null;
    private String m_version = "1.0";
    private HashMap m_soapMappingRegistries = new HashMap();
    private Header m_headers = null;

}