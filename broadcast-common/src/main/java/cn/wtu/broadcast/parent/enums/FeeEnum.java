package cn.wtu.broadcast.parent.enums;


public enum FeeEnum {
	  SYS_MJ("MJ", 100), 
	  SYS_ZK("ZK",101),
	  STS_GD("GD",102);
	    // 成员变量  
	    private String desc;  
	    private int index;  
	    // 构造方法  
	    private FeeEnum(String desc, int index) {  
	        this.desc = desc;  
	        this.index = index;  
	    }  
	    // 普通方法  
	    public static String getName(int index) {  
	        for (FeeEnum c : FeeEnum.values()) {  
	            if (c.getIndex() == index) {  
	                return c.desc;  
	            }  
	        }  
	        return null;  
	    }  
	  
	    public int getIndex() {  
	        return index;  
	    }  
	    public void setIndex(int index) {  
	        this.index = index;  
	    }
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}  
}



