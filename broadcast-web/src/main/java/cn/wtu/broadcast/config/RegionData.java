package cn.wtu.broadcast.config;

import cn.wtu.broadcast.openapi.api.RegionService;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.parent.constant.Constant;
import cn.wtu.broadcast.parent.pojo.ZTree;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 区域数据
 *
 * @author sueua
 * @since 2018-12-31
 */
@Component
public class RegionData implements InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(RegionData.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * 区域树形结构数据,适用simple模式
     */
    private static List<ZTree> zTreeList = new ArrayList<>();

    private static RegionService regionService;

    @Autowired
    public RegionData(RegionService regionService) {
        RegionData.regionService = regionService;
    }

    /**
     * 区域id对应区域名称Map
     */
    public static Map<Integer, String> getNameMap() {
        return zTreeList.stream().collect(Collectors.toMap(ZTree::getId, ZTree::getName));
    }

    /**
     * 区域id对应区域名称Map的JSON格式(一般直接在前端中使用)
     */
    public static String getNameMapJson() {
        try {
            return OBJECT_MAPPER.writeValueAsString(getNameMap());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return "[]";
    }

    /**
     * 树形结构list数据
     */
    public static List<ZTree> getZTreeList() {
        return zTreeList;
    }

    /**
     * 树形结构list数据的json(一般直接在前端中使用)
     */
    public static String getZTreeListJson() {
        try {
            return OBJECT_MAPPER.writeValueAsString(zTreeList);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return "[]";
    }
    /**
     * 树形结构list数据的json(一般直接在前端中使用)
     * 根據用戶查詢區域樹
     */
    public static String getUserZTreeList2Json() {
        try {
            return OBJECT_MAPPER.writeValueAsString(getUserZTreeList());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return "[]";
    }

    /**
     * 加载数据
     */
    public synchronized static void reload() {
        zTreeList.clear();
        regionService.selectList().forEach(division -> {
            ZTree zTree = new ZTree();
            zTree.setId(division.getfId());
            zTree.setName(division.getfName());
            zTree.setPid(division.getfParentNode());
            zTree.setLatitude(division.getfLatitude());
            zTree.setLongitude(division.getfLongitude());
            zTreeList.add(zTree);
        });
    }

    /**
     * 用户树形结构list数据
     */
    public static List<ZTree> getUserZTreeList() {
        try {
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            TUser tUser = (TUser) session.getAttribute(Constant.CURRENT_USER);
            if (tUser != null) {
                Integer regionId = tUser.getfRespectiveRegion();
                if (regionId != null) {
                    List<ZTree> userZTreeList = new ArrayList<>();
                    //加入顶级
                    zTreeList.forEach(zTree -> {
                        if (zTree.getId().equals(regionId)) {
                            userZTreeList.add(zTree);
                        }
                    });
                    //加入子级
                    getChild(userZTreeList,regionId);
                    return userZTreeList;
                } else {
                    return Collections.emptyList();
                }
            } else {
                return Collections.emptyList();
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            return Collections.emptyList();
        }
    }

    /**
     * 递归子树
     */
    private static void getChild(List<ZTree> userZTreeList, Integer regionId) {
        zTreeList.forEach(zTree -> {
            if (regionId.equals(zTree.getPid())) {
                userZTreeList.add(zTree);
                getChild(userZTreeList, zTree.getId());
            }
        });
    }

    @Override
    public void afterPropertiesSet() {
        reload();
    }
}
