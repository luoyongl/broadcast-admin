package cn.wtu.broadcast.parent.enums;

public enum GeneralResponseEnum {

	//通用回复数据 return code码表 保留字
	reservedWord(4);
	
	private int number;

	private GeneralResponseEnum(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
