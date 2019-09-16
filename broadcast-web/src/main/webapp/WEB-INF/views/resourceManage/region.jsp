<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ page import="cn.wtu.broadcast.config.DictionaryConfig,cn.wtu.broadcast.config.SystemConfig" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("ctx", request.getContextPath());
    request.setAttribute("config", SystemConfig.getMap());
    request.setAttribute("dict", DictionaryConfig.getListMap());
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>GIS地图回传</title>
    <%@include file="../common/css.jsp" %>
    <style>
        html {
            height: 100%;
        }

        .map_title {
            border: solid 1px red !important;
            background: none;
            color: red;
        }

        .amap-marker-label {
            border: none;
            background: none;
            padding: 0;
        }

        .form-group {
            padding-left: 0 !important;
        }

        label {
            text-align: left !important;
            height: 34px;
            line-height: 34px;
        }

        .device-info {
            width: 220px;
        }

        .device-info span {
            color: #b2b2b2;
            margin-right: 5px;
        }
    </style>
</head>
<body>
<div id="container" class="map" style="width: 100%;height: 100%"></div>
<%@include file="../common/js.jsp" %>
<script type="text/javascript"
        src="https://webapi.amap.com/maps?v=1.4.12&key=${config.amap_js_key}&plugin=AMap.DistrictSearch,AMap.MouseTool"></script>
<script type="text/javascript">
    $(function () {
        var county = ${county},
            devices = ${devices};
        var mapObj = {
            zoom: 11,
            mapStyle: "amap://styles/blue"
        };
        if (county.longitude && county.latitude && !isNaN(county.longitude) && !isNaN(county.latitude)) {
            mapObj.center = [county.longitude, county.latitude]//地图中心点
        }
        var map = new AMap.Map("container", mapObj);
        var infoWindow = new AMap.InfoWindow({offset: new AMap.Pixel(0, -30)});
        //绘制点
        $.each(devices, function (index, device) {
            //经纬度错误直接跳过
            if (isNaN(device.fLongitude) || isNaN(device.fDimension) || !device.fLongitude || !device.fDimension) {
                return true;
            }
            var marker = new AMap.Marker({
                position: [device.fLongitude, device.fDimension],
                draggable: true,
                label: {
                    offset: new AMap.Pixel(15, -20),
                    content: "<div class='map_title'>" + device.fDeviceName + "</div>"
                }
            });
            marker.content = '<div class="device-info"><div><span>设备名称:</span>' + (device.fDeviceName || '') + '</div><div><span>安装地址:</span>' + (device.fInstallAddress || '') + '</div><div><span>资源编码:</span>' + (device.fDeviceResourceCode || '') + '</div></div>';
            map.add(marker);
            marker.on('mouseover', function (e) {
                this.setIcon('https://webapi.amap.com/theme/v1.3/markers/n/mark_r.png');
                infoWindow.setContent(e.target.content);
                infoWindow.open(map, e.target.getPosition());
            });
            marker.on('mouseout', function (e) {
                this.setIcon('https://webapi.amap.com/theme/v1.3/markers/n/mark_b.png');
                infoWindow.close(map, e.target.getPosition());
            });
            marker.on('dragend', function (e) {
                layer.confirm('是否确认移动设备位置?', {icon: 3, title: '提示'},
                    function (index) {
                        layer.close(index);
                        layer.load(2);
                        var data = {
                            fLongitude: e.lnglat.getLng(),
                            fDimension: e.lnglat.getLat(),
                            fId: device.fId
                        };
                        $.post('', data, function (result) {
                            if (result.status !== 200) {
                                marker.setPosition([device.fLongitude, device.fDimension]);
                                layer.msg(result.msg, {icon: 2});
                            }
                            layer.closeAll('loading');
                        });
                    },
                    function (index) {
                        marker.setPosition([device.fLongitude, device.fDimension]);
                        layer.close(index);
                    });
            });
        });
        //绘制边界
        var district = null;
        var polygons = [];
        //加载行政区划插件
        if (!district) {
            //实例化DistrictSearch
            var opts = {
                subdistrict: 0,   //获取边界不需要返回下级行政区
                extensions: 'all',  //返回行政区边界坐标组等具体信息
                level: 'district'  //查询行政级别为 市
            };
            district = new AMap.DistrictSearch(opts);
        }
        //行政区查询
        district.search(county.name, function (status, result) {
            map.remove(polygons);//清除上次结果
            polygons = [];
            var bounds = result.districtList[0].boundaries;
            if (bounds) {
                for (var i = 0, l = bounds.length; i < l; i++) {
                    //生成行政区划polygon
                    var polygon = new AMap.Polygon({
                        strokeWeight: 2,
                        path: bounds[i],
                        fillOpacity: 0,
                        fillColor: '#80d8ff',
                        strokeColor: '#0091ea'
                    });
                    polygons.push(polygon);
                }
            }
            map.add(polygons);
            map.setFitView(polygons);//视口自适应
        });
    });
</script>
<script type="text/javascript">
</script>
</body>
</html>
