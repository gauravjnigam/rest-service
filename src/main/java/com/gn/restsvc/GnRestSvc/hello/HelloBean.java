package com.gn.restsvc.GnRestSvc.hello;

import lombok.Getter;

public class HelloBean {
	@Getter
	String helloStr;
	public HelloBean(String str) {
		this.helloStr = str;
	}

}
