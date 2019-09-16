package cn.wtu.broadcast.parent.enums;


public enum CodeEnum {
	  SYS_OK("正常", 200), 
	  SYS_MUST_INPUT("必填字段",100),
	  SYS_ERR_EXCEPTION("系统异常", -100), 
	  SYS_TOO_MANY("找出多条记录", -101), 
	  SYS_ONLY_ONE("只有一条记录", -102),
	  SYS_NO_FOUND("没有找到该记录",-103),
	  SYS_PARAM_EXCEPTION("没有找到该记录",-104),
	  STS_EXSIT("数据已存在",-105);
	    // 成员变量  
	    private String desc;  
	    private int index;  
	    // 构造方法  
	    private CodeEnum(String desc, int index) {  
	        this.desc = desc;  
	        this.index = index;  
	    }  
	    // 普通方法  
	    public static String getName(int index) {  
	        for (CodeEnum c : CodeEnum.values()) {  
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



