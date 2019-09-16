package cn.wtu.broadcast.entity.body;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cn.wtu.broadcast.entity.PassbackBodyData;

/**
 * 播发记录上报
 * @author Lenovo
 *
 */
public class PassbackBody0x16Data extends PassbackBodyData implements Serializable{

	private static final long serialVersionUID = 1121401218057767310L;

	/**
	 * 前端编码长度
	 */
	private String frontendCodeLength;
	/**
	 * 前端编码
	 */
	private String frontendCode;
	/**
	 * 播发记录数
	 */
	private String playRecordNumber;
	
	private List<RecordInfo> recordInfoList = new ArrayList<RecordInfo>();
	
	public static class RecordInfo{
		/**
		 * 通道号
		 */
		private String channelNumber;
		/**
		 * 播发状态
		 */
		private String playStatus;
		/**
		 * EBM_id
		 */
		private String ebmId;
		/**
		 * 任务类型
		 */
		private String taskType;
		/**
		 * 应急广播类型
		 */
		private String ebmType;
		/**
		 * 事件级别
		 */
		private String eventLevel;
		/**
		 * 事件类型
		 */
		private String eventType;
		/**
		 * 开始时间
		 */
		private String startTime;
		/**
		 * 结束时间
		 */
		private String endTime;
		/**
		 * 电话号码长度
		 */
		private String phoneLength;
		/**
		 * 电话号码
		 */
		private String phone;
		/**
		 * 音量大小
		 */
		private String volume;
		/**
		 * 覆盖区域数量
		 */
		private String coverRegionNumber;
		/**
		 * 区域码长度
		 */
		private String areaCodeLength;
		/**
		 * BCD编码的资源码信息
		 */
		private List<byte[]> coverageResourceCodings = new ArrayList<byte[]>();
		public String getChannelNumber() {
			return channelNumber;
		}
		public void setChannelNumber(String channelNumber) {
			this.channelNumber = channelNumber;
		}
		public String getPlayStatus() {
			return playStatus;
		}
		public void setPlayStatus(String playStatus) {
			this.playStatus = playStatus;
		}
		public String getEbmId() {
			return ebmId;
		}
		public void setEbmId(String ebmId) {
			this.ebmId = ebmId;
		}
		public String getTaskType() {
			return taskType;
		}
		public void setTaskType(String taskType) {
			this.taskType = taskType;
		}
		public String getEbmType() {
			return ebmType;
		}
		public void setEbmType(String ebmType) {
			this.ebmType = ebmType;
		}
		public String getEventLevel() {
			return eventLevel;
		}
		public void setEventLevel(String eventLevel) {
			this.eventLevel = eventLevel;
		}
		public String getEventType() {
			return eventType;
		}
		public void setEventType(String eventType) {
			this.eventType = eventType;
		}
		public String getStartTime() {
			return startTime;
		}
		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}
		public String getEndTime() {
			return endTime;
		}
		public void setEndTime(String endTime) {
			this.endTime = endTime;
		}
		public String getPhoneLength() {
			return phoneLength;
		}
		public void setPhoneLength(String phoneLength) {
			this.phoneLength = phoneLength;
		}
		
		public String getVolume() {
			return volume;
		}
		public void setVolume(String volume) {
			this.volume = volume;
		}
		public String getCoverRegionNumber() {
			return coverRegionNumber;
		}
		public void setCoverRegionNumber(String coverRegionNumber) {
			this.coverRegionNumber = coverRegionNumber;
		}
		public String getAreaCodeLength() {
			return areaCodeLength;
		}
		public void setAreaCodeLength(String areaCodeLength) {
			this.areaCodeLength = areaCodeLength;
		}
		public List<byte[]> getCoverageResourceCodingList() {
			return coverageResourceCodings;
		}
		public void setCoverageResourceCodingList(List<byte[]> coverageResourceCodings) {
			this.coverageResourceCodings = coverageResourceCodings;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		
	}

	public String getFrontendCodeLength() {
		return frontendCodeLength;
	}

	public void setFrontendCodeLength(String frontendCodeLength) {
		this.frontendCodeLength = frontendCodeLength;
	}

	public String getFrontendCode() {
		return frontendCode;
	}

	public void setFrontendCode(String frontendCode) {
		this.frontendCode = frontendCode;
	}

	public String getPlayRecordNumber() {
		return playRecordNumber;
	}

	public void setPlayRecordNumber(String playRecordNumber) {
		this.playRecordNumber = playRecordNumber;
	}

	public List<RecordInfo> getRecordInfoList() {
		return recordInfoList;
	}

	public void setRecordInfoList(List<RecordInfo> recordInfoList) {
		this.recordInfoList = recordInfoList;
	}
	
	
	
	
	
	
	
	
}
