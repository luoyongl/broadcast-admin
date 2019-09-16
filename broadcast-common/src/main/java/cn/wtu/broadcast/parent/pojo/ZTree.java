package cn.wtu.broadcast.parent.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * zTree结构
 *
 * @author sueua
 * @since 2018-12-16
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ZTree implements Serializable {

    private static final long serialVersionUID = 154568385814065718L;

    private Integer id;

    @JsonProperty("pId")
    private Integer pid;

    private String name;

    private String icon;

    private Boolean checked;

    private String longitude;

    private String latitude;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
