package pxy;

import com.oocl.ivo.webservice.publish.proxy.IVOWebServiceProxy;

public class PxyTest {

	public static void main(String args[]) {

		String URL = "http://gengfo.corp.oocl.com:9999/IVO_RPTServer/IVORPTService";

		IVOWebServiceProxy proxy = new IVOWebServiceProxy();

		proxy._setSoapURL(URL);

		try {
			String result = proxy.helloOc4j("abc");
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("done");

	}

}
