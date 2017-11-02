
package snsoft.tss.quote.chance.cxf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "FtcCenterWebServiceBas", targetNamespace = "http://cxf.chance.quote.tss.snsoft/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface FtcCenterWebServiceBas {


    /**
     * 
     * @param jsonString
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "savePickUpGoods", targetNamespace = "http://cxf.chance.quote.tss.snsoft/", className = "snsoft.tss.quote.chance.cxf.SavePickUpGoods")
    @ResponseWrapper(localName = "savePickUpGoodsResponse", targetNamespace = "http://cxf.chance.quote.tss.snsoft/", className = "snsoft.tss.quote.chance.cxf.SavePickUpGoodsResponse")
    public String savePickUpGoods(
        @WebParam(name = "jsonString", targetNamespace = "")
        String jsonString);

    /**
     * 
     * @param jsonString
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPortGoods", targetNamespace = "http://cxf.chance.quote.tss.snsoft/", className = "snsoft.tss.quote.chance.cxf.GetPortGoods")
    @ResponseWrapper(localName = "getPortGoodsResponse", targetNamespace = "http://cxf.chance.quote.tss.snsoft/", className = "snsoft.tss.quote.chance.cxf.GetPortGoodsResponse")
    public String getPortGoods(
        @WebParam(name = "jsonString", targetNamespace = "")
        String jsonString);

    /**
     * 
     * @param jsonString
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "saveBoxGoods", targetNamespace = "http://cxf.chance.quote.tss.snsoft/", className = "snsoft.tss.quote.chance.cxf.SaveBoxGoods")
    @ResponseWrapper(localName = "saveBoxGoodsResponse", targetNamespace = "http://cxf.chance.quote.tss.snsoft/", className = "snsoft.tss.quote.chance.cxf.SaveBoxGoodsResponse")
    public String saveBoxGoods(
        @WebParam(name = "jsonString", targetNamespace = "")
        String jsonString);

    /**
     * 
     * @param jsonString
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "savePortGoods", targetNamespace = "http://cxf.chance.quote.tss.snsoft/", className = "snsoft.tss.quote.chance.cxf.SavePortGoods")
    @ResponseWrapper(localName = "savePortGoodsResponse", targetNamespace = "http://cxf.chance.quote.tss.snsoft/", className = "snsoft.tss.quote.chance.cxf.SavePortGoodsResponse")
    public String savePortGoods(
        @WebParam(name = "jsonString", targetNamespace = "")
        String jsonString);

    /**
     * 
     * @param jsonString
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "saveSignGoods", targetNamespace = "http://cxf.chance.quote.tss.snsoft/", className = "snsoft.tss.quote.chance.cxf.SaveSignGoods")
    @ResponseWrapper(localName = "saveSignGoodsResponse", targetNamespace = "http://cxf.chance.quote.tss.snsoft/", className = "snsoft.tss.quote.chance.cxf.SaveSignGoodsResponse")
    public String saveSignGoods(
        @WebParam(name = "jsonString", targetNamespace = "")
        String jsonString);

    /**
     * 
     * @param jsonString
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPickUpGoods", targetNamespace = "http://cxf.chance.quote.tss.snsoft/", className = "snsoft.tss.quote.chance.cxf.GetPickUpGoods")
    @ResponseWrapper(localName = "getPickUpGoodsResponse", targetNamespace = "http://cxf.chance.quote.tss.snsoft/", className = "snsoft.tss.quote.chance.cxf.GetPickUpGoodsResponse")
    public String getPickUpGoods(
        @WebParam(name = "jsonString", targetNamespace = "")
        String jsonString);

    /**
     * 
     * @param jsonString
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getBoxGoods", targetNamespace = "http://cxf.chance.quote.tss.snsoft/", className = "snsoft.tss.quote.chance.cxf.GetBoxGoods")
    @ResponseWrapper(localName = "getBoxGoodsResponse", targetNamespace = "http://cxf.chance.quote.tss.snsoft/", className = "snsoft.tss.quote.chance.cxf.GetBoxGoodsResponse")
    public String getBoxGoods(
        @WebParam(name = "jsonString", targetNamespace = "")
        String jsonString);

    /**
     * 
     * @param jsonString
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getSignGoods", targetNamespace = "http://cxf.chance.quote.tss.snsoft/", className = "snsoft.tss.quote.chance.cxf.GetSignGoods")
    @ResponseWrapper(localName = "getSignGoodsResponse", targetNamespace = "http://cxf.chance.quote.tss.snsoft/", className = "snsoft.tss.quote.chance.cxf.GetSignGoodsResponse")
    public String getSignGoods(
        @WebParam(name = "jsonString", targetNamespace = "")
        String jsonString);

    /**
     * 
     * @param jsonString
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getSeaportGoods", targetNamespace = "http://cxf.chance.quote.tss.snsoft/", className = "snsoft.tss.quote.chance.cxf.GetSeaportGoods")
    @ResponseWrapper(localName = "getSeaportGoodsResponse", targetNamespace = "http://cxf.chance.quote.tss.snsoft/", className = "snsoft.tss.quote.chance.cxf.GetSeaportGoodsResponse")
    public String getSeaportGoods(
        @WebParam(name = "jsonString", targetNamespace = "")
        String jsonString);

    /**
     * 
     * @param jsonString
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "saveSeaportGoods", targetNamespace = "http://cxf.chance.quote.tss.snsoft/", className = "snsoft.tss.quote.chance.cxf.SaveSeaportGoods")
    @ResponseWrapper(localName = "saveSeaportGoodsResponse", targetNamespace = "http://cxf.chance.quote.tss.snsoft/", className = "snsoft.tss.quote.chance.cxf.SaveSeaportGoodsResponse")
    public String saveSeaportGoods(
        @WebParam(name = "jsonString", targetNamespace = "")
        String jsonString);

}
