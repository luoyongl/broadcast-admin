package cn.wtu.broadcast.parent.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 上传结果数据
 */
public class UploadResult implements Serializable {

	private static final long serialVersionUID = -3371476021035270635L;
	/**
     * 上传是否成功
     */
    private Boolean status;
    /**
     * 输出文件地址
     */
    private String url;
    /**
     * 上传文件名
     */
    private String name;
    /**
     * 状态文本
     */
    private String state;
    /**
     * 文件类型
     */
    private String type;
    /**
     * 原始文件名
     */
    private String originalName;
    /**
     * 文件大小
     */
    private Long size;
    /**
     * 文件id
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

