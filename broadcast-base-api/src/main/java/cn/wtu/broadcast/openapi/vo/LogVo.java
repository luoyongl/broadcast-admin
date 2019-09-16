package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;

import cn.wtu.broadcast.openapi.model.TOperationLog;

/**
 * 操作日志
 *
 * @author sueua
 * @date 2019/1/4
 */
public class LogVo extends TOperationLog  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    /**
     * 序号
     */
    private Integer index;
    /**
     * 操作类新名称
     */
    private String operationType;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
}
