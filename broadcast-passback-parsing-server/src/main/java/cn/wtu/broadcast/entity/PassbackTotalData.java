package cn.wtu.broadcast.entity;

import java.io.Serializable;

public class PassbackTotalData implements Serializable{

	private static final long serialVersionUID = -6670045465247958979L;

	private PassbackHeadData head;
	
	private PassbackBodyData body;
	
	private PassbackSignData sign;

	public PassbackHeadData getHead() {
		return head;
	}

	public void setHead(PassbackHeadData head) {
		this.head = head;
	}

	public PassbackBodyData getBody() {
		return body;
	}

	public void setBody(PassbackBodyData body) {
		this.body = body;
	}

	public PassbackSignData getSign() {
		return sign;
	}

	public void setSign(PassbackSignData sign) {
		this.sign = sign;
	}
	
}
