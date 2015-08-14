package com.kael.surf.server;

import com.google.protobuf.GeneratedMessage;
import com.kael.surf.core.Channel;

/**
 * 
 * @author hanyuanliang 2015-7-21 下午3:29:18
 */
public class Req {

	private String serviceName, methodName;
	private GeneratedMessage gm;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public GeneratedMessage getGm() {
		return gm;
	}

	public void setGm(GeneratedMessage gm) {
		this.gm = gm;
	}

	public static Req parse(Channel ch){
		Req r = new Req();
		r.setServiceName(ch.serviceName());
		r.setMethodName(ch.methodName());
		try {
			r.setGm((GeneratedMessage)ch.getClass().getMethod("getDefaultInstance", null)
			        .invoke(null, null));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return r;
	}
}
