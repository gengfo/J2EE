package proxy;

import com.oocl.ivo.webservice.publish.proxy.IVOWebServiceProxy;

public class ClientTest {

	public static void main(String args[]) {

		// try {
		// com.oocl.ivo.webservice.publish.ivowebservice.IVOWebServicePortClient
		// myPort = new
		// com.oocl.ivo.webservice.publish.ivowebservice.IVOWebServicePortClient();
		// // myPort.searchInvoiceList();
		// Com_oocl_ivo_frm_webservice_publish_IVOContext context =
		// IVOContextFactory
		// .buildContext();
		// Com_oocl_ivo_webservice_dto_invoice_search_SearchInvoiceListDTO
		// stlDto = new
		// Com_oocl_ivo_webservice_dto_invoice_search_SearchInvoiceListDTO();
		//
		// myPort.searchInvoiceList(context, stlDto);
		// System.out.println("calling " + myPort.getEndpoint());
		// // Add your own code here
		//
		// } catch (Exception ex) {
		// ex.printStackTrace();
		// }
		while (true) {
			IVOWebServiceProxy prx = new IVOWebServiceProxy();
			String result = "";
			try {
				result = prx.helloOc4j("abc");

				System.out.println(result + " "+ System.currentTimeMillis());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
