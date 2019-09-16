package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;
import java.util.Date;

public class RegionFeatureVO implements Serializable{
	
	private Integer fId;

    private String fMainTitle;

    private String fContent;

    private String fImageUrl;

    private String fSubheadingOne;

    private String fSubContentOne;

    private String fSubheadingTwo;

    private String fSubContentTwo;

    private String fSubheadingThree;

    private String fSubContentThree;

    private String fImageType;

    private Integer fBriefClassification;

    private Byte fSort;

    private Date fCreateTime;

    private Integer fCreatorId;

    private Date fUpdateTime;

    private Integer fOperatorId;

    private Boolean fDeleteFlag;

    private String fRichTextContent;

    private static final long serialVersionUID = 1L;

	public Integer getfId() {
		return fId;
	}

	public void setfId(Integer fId) {
		this.fId = fId;
	}

	public String getfMainTitle() {
		return fMainTitle;
	}

	public void setfMainTitle(String fMainTitle) {
		this.fMainTitle = fMainTitle;
	}

	public String getfContent() {
		return fContent;
	}

	public void setfContent(String fContent) {
		this.fContent = fContent;
	}

	public String getfImageUrl() {
		return fImageUrl;
	}

	public void setfImageUrl(String fImageUrl) {
		this.fImageUrl = fImageUrl;
	}

	public String getfSubheadingOne() {
		return fSubheadingOne;
	}

	public void setfSubheadingOne(String fSubheadingOne) {
		this.fSubheadingOne = fSubheadingOne;
	}

	public String getfSubContentOne() {
		return fSubContentOne;
	}

	public void setfSubContentOne(String fSubContentOne) {
		this.fSubContentOne = fSubContentOne;
	}

	public String getfSubheadingTwo() {
		return fSubheadingTwo;
	}

	public void setfSubheadingTwo(String fSubheadingTwo) {
		this.fSubheadingTwo = fSubheadingTwo;
	}

	public String getfSubContentTwo() {
		return fSubContentTwo;
	}

	public void setfSubContentTwo(String fSubContentTwo) {
		this.fSubContentTwo = fSubContentTwo;
	}

	public String getfSubheadingThree() {
		return fSubheadingThree;
	}

	public void setfSubheadingThree(String fSubheadingThree) {
		this.fSubheadingThree = fSubheadingThree;
	}

	public String getfSubContentThree() {
		return fSubContentThree;
	}

	public void setfSubContentThree(String fSubContentThree) {
		this.fSubContentThree = fSubContentThree;
	}

	public String getfImageType() {
		return fImageType;
	}

	public void setfImageType(String fImageType) {
		this.fImageType = fImageType;
	}

	public Integer getfBriefClassification() {
		return fBriefClassification;
	}

	public void setfBriefClassification(Integer fBriefClassification) {
		this.fBriefClassification = fBriefClassification;
	}

	public Byte getfSort() {
		return fSort;
	}

	public void setfSort(Byte fSort) {
		this.fSort = fSort;
	}

	public Date getfCreateTime() {
		return fCreateTime;
	}

	public void setfCreateTime(Date fCreateTime) {
		this.fCreateTime = fCreateTime;
	}

	public Integer getfCreatorId() {
		return fCreatorId;
	}

	public void setfCreatorId(Integer fCreatorId) {
		this.fCreatorId = fCreatorId;
	}

	public Date getfUpdateTime() {
		return fUpdateTime;
	}

	public void setfUpdateTime(Date fUpdateTime) {
		this.fUpdateTime = fUpdateTime;
	}

	public Integer getfOperatorId() {
		return fOperatorId;
	}

	public void setfOperatorId(Integer fOperatorId) {
		this.fOperatorId = fOperatorId;
	}

	public Boolean getfDeleteFlag() {
		return fDeleteFlag;
	}

	public void setfDeleteFlag(Boolean fDeleteFlag) {
		this.fDeleteFlag = fDeleteFlag;
	}

	public String getfRichTextContent() {
		return fRichTextContent;
	}

	public void setfRichTextContent(String fRichTextContent) {
		this.fRichTextContent = fRichTextContent;
	}
 
}
