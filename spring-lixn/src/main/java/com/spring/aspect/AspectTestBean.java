package com.spring.aspect;

/**
 * @创建人 lixiangnan
 * @创建时间 2020/1/6
 * @描述
 */
public class AspectTestBean {

	private String testStr = "testStr";

	public String getTestStr() {
		return testStr;
	}

	public void setTestStr(String testStr) {
		this.testStr = testStr;
	}

	public void test(){
		System.out.println("test");
	}
}
