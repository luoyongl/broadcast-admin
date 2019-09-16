package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class BReview implements Serializable {
    private Integer fId;

    private Byte fBigClassification;

    private Byte fReviewType;

    private Integer fReviewObjectId;

    private Byte fReviewResult;

    private Date fReviewTime;

    private Integer fReviewer;

    private String fRemark;

    private static final long serialVersionUID = 1L;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public Byte getfBigClassification() {
        return fBigClassification;
    }

    public void setfBigClassification(Byte fBigClassification) {
        this.fBigClassification = fBigClassification;
    }

    public Byte getfReviewType() {
        return fReviewType;
    }

    public void setfReviewType(Byte fReviewType) {
        this.fReviewType = fReviewType;
    }

    public Integer getfReviewObjectId() {
        return fReviewObjectId;
    }

    public void setfReviewObjectId(Integer fReviewObjectId) {
        this.fReviewObjectId = fReviewObjectId;
    }

    public Byte getfReviewResult() {
        return fReviewResult;
    }

    public void setfReviewResult(Byte fReviewResult) {
        this.fReviewResult = fReviewResult;
    }

    public Date getfReviewTime() {
        return fReviewTime;
    }

    public void setfReviewTime(Date fReviewTime) {
        this.fReviewTime = fReviewTime;
    }

    public Integer getfReviewer() {
        return fReviewer;
    }

    public void setfReviewer(Integer fReviewer) {
        this.fReviewer = fReviewer;
    }

    public String getfRemark() {
        return fRemark;
    }

    public void setfRemark(String fRemark) {
        this.fRemark = fRemark == null ? null : fRemark.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BReview other = (BReview) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfBigClassification() == null ? other.getfBigClassification() == null : this.getfBigClassification().equals(other.getfBigClassification()))
            && (this.getfReviewType() == null ? other.getfReviewType() == null : this.getfReviewType().equals(other.getfReviewType()))
            && (this.getfReviewObjectId() == null ? other.getfReviewObjectId() == null : this.getfReviewObjectId().equals(other.getfReviewObjectId()))
            && (this.getfReviewResult() == null ? other.getfReviewResult() == null : this.getfReviewResult().equals(other.getfReviewResult()))
            && (this.getfReviewTime() == null ? other.getfReviewTime() == null : this.getfReviewTime().equals(other.getfReviewTime()))
            && (this.getfReviewer() == null ? other.getfReviewer() == null : this.getfReviewer().equals(other.getfReviewer()))
            && (this.getfRemark() == null ? other.getfRemark() == null : this.getfRemark().equals(other.getfRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfBigClassification() == null) ? 0 : getfBigClassification().hashCode());
        result = prime * result + ((getfReviewType() == null) ? 0 : getfReviewType().hashCode());
        result = prime * result + ((getfReviewObjectId() == null) ? 0 : getfReviewObjectId().hashCode());
        result = prime * result + ((getfReviewResult() == null) ? 0 : getfReviewResult().hashCode());
        result = prime * result + ((getfReviewTime() == null) ? 0 : getfReviewTime().hashCode());
        result = prime * result + ((getfReviewer() == null) ? 0 : getfReviewer().hashCode());
        result = prime * result + ((getfRemark() == null) ? 0 : getfRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fId=").append(fId);
        sb.append(", fBigClassification=").append(fBigClassification);
        sb.append(", fReviewType=").append(fReviewType);
        sb.append(", fReviewObjectId=").append(fReviewObjectId);
        sb.append(", fReviewResult=").append(fReviewResult);
        sb.append(", fReviewTime=").append(fReviewTime);
        sb.append(", fReviewer=").append(fReviewer);
        sb.append(", fRemark=").append(fRemark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}