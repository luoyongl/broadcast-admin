package cn.wtu.broadcast.openapi.util;

public class RandomUtil {

	/**
	 * 生成某长度的随机数
	 * @param length
	 * @return
	 */
	public static int generateNum(int length){
		return (int)((Math.random()*9+1)*Math.pow(10,length-1));
	}
}
