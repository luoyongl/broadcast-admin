package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;

/**
 * 磁盘分区
 *
 * @author sueua
 * @since 2019-01-21
 */
public class Partition implements Serializable {

    private static final long serialVersionUID = 5308639685926545303L;

    /**
     * 分区名称
     */
    private String partitionName;

    /**
     * 分区大小
     */
    private long totalValue;

    /**
     * 分区已用大小
     */
    private long usedValue;

    /**
     * 分区可用大小
     */
    private long freeValue;

    /**
     * 分区已用百分比
     */
    private String percentUsed;

    public String getPartitionName() {
        return partitionName;
    }

    public void setPartitionName(String partitionName) {
        this.partitionName = partitionName;
    }

    public long getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(long totalValue) {
        this.totalValue = totalValue;
    }

    public long getUsedValue() {
        return usedValue;
    }

    public void setUsedValue(long usedValue) {
        this.usedValue = usedValue;
    }

    public long getFreeValue() {
        return freeValue;
    }

    public void setFreeValue(long freeValue) {
        this.freeValue = freeValue;
    }

    public String getPercentUsed() {
        return percentUsed;
    }

    public void setPercentUsed(String percentUsed) {
        this.percentUsed = percentUsed;
    }
}
