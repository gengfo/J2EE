package com.oocl.ivo.webservice.publish;

public class IVOWebServiceImpl implements IVOWebService {

	public String helloOc4j(String ttt) {

		PlatformInfo pi = new PlatformInfo();

		return "Hello " + ttt + " in " + pi.currentJvmNo();
	}
}
