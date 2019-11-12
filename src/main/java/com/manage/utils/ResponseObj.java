package com.manage.utils;

import com.xdream.kernel.util.JsonUtil;


public class ResponseObj {

	private ResponseBase verify;
	
	private ResponseData data;
	

	public ResponseBase getVerify() {
		return verify;
	}

	public void setVerify(ResponseBase verify) {
		this.verify = verify;
	}

	public ResponseData getData() {
		return data;
	}

	public void setData(ResponseData data) {
		this.data = data;
	}
	

	public static void main(String[] args) throws Exception{
		ResponseObj obj = new ResponseObj();
		ResponseBase base = new ResponseBase();
		base.setSign("fail");
		base.setDesc("提交成功");
		obj.setVerify(base);
//		ResponseData data = new ResponseData();
//		data.setImageFileName("dddddddddddddd");
//		obj.setData(data);
		
		String json = JsonUtil.toJson(obj);
		System.out.println("Json:"+json);
		
		String test = "111.jpg";
		int index = test.lastIndexOf(".");
		if (index<0){
			System.out.println("1111111111111111111111");
			return;
		}
		System.out.println("index:"+index);
		String name = test.substring(index+1,test.length());
		System.out.println("name:"+name);
	}
	
}
