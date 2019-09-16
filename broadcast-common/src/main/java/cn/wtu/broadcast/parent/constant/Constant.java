package cn.wtu.broadcast.parent.constant;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
    * @ClassName: Constant
    * @Description: 常量类
    * @author huangjiakui
    * @date 2018年12月04日
    *
 */
public class Constant {
	
	public static final int PAGE_SIZE = 10;
	
	public static final int APP_PAGE_SIZE = 20;

	public static final String ADMIN = "admin";
	
	public static final String UPLOAD_FOLDER_NAME = "uploads";
	public static final String QRCODE_FOLDER_NAME = "qrcode";
	public static final String EQUIP_IMG_FOLDER_NAME = "equipImg";

	public static final String CURRENT_USER = "currentUser";
	public static final String CURRENT_COMPANY = "currentCompany";
	public static final String CURRENT_USER_PERMISSION = "userPermission";
	public static final String CURRENT_USER_MENU = "userMenu";

	public static final String API_CURRENT_USER = "currentApiUser";
	public static final String API_CURRENT_COMPANY = "currentApiCompany";
	public static final String API_CURRENT_USER_PERMISSION = "userApiPermission";
	public static final String API_CURRENT_USER_MENU = "userApiMenu";
	
	public static final Integer COMPANY_ADMIN_ID = 2;

	public static final Integer EQUIP_CONTROLLER_TYPE_ID = 1;
	public static final Integer EQUIP_FEED_SYS_ID = 8;
	/**
	 * 验证码类型
	 */
	public enum CaptchaType {
		/** 后台登录 */
		adminLogin,

		/** 找回密码 */
		findPassword,

		/** 重置密码 */
		resetPassword,

		/** 其它 */
		other
	}
	/**
	 * 说明：存放广播播发的音频播发进程Process，key值为广播ID, 线程为发送音频的Process
	 * 数据添加场景：发送音频流的时候添加到该集合里面
	 * 数据移除场景：1.正常发送完成时候移除对应集合数据
	 * 				2.点击停播时候，通过ID获取进程然后停止，最后移除对应集合数据
	 * 
	 * IP场合的进程时候key值为字符串IP+广播ID
	 */
	public static ConcurrentHashMap<String, List<Process>> tsAudioProcessMap = new ConcurrentHashMap<String, List<Process>>();
}