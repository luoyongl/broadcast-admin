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
    <title>区域管理</title>
    <%@include file="../common/css.jsp" %>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/js/openlayers@4.3.3/ol.css">
    <style>
        html {
            height: 100%;
        }

        .info {
            position: absolute;
            top: 30px;
            right: 20px;
            padding: 10px 20px;
            background: rgb(0, 0, 0, 0.5);
            border-radius: 5px;
            z-index: 19881234;
            /* color: #fff; */
            color: #333;
            font-weight: bold;
        }

        .info img {
            width: 32px;
            margin: 5px 30px 5px 0;
        }

        .offline {
            background-color: #ff404c;
        }

        .ol-popup {
            position: absolute;
            bottom: 12px;
            left: 0;
            background: rgb(0, 0, 0, 0.5);
            border-radius: 5px;
            padding: 10px;
            color: #fff;
            width: 250px;
        }

        .device-label {
            margin-right: 5px;
            font-weight: bold;
            color: #333;
        }

        .device-info {
            font-weight: bold;
            color: #333;
        }
    </style>
</head>
<body>
<div class="info">
    <div><img src="${ctx}/static/img/state/ip-0.png">IP播放</div>
    <div><img src="${ctx}/static/img/state/ip-1.png">IP在线</div>
    <div><img src="${ctx}/static/img/state/ip-2.png">IP离线</div>
    <div><img src="${ctx}/static/img/state/4g-0.png">4G播放</div>
    <div><img src="${ctx}/static/img/state/4g-1.png">4G在线</div>
    <div><img src="${ctx}/static/img/state/4g-2.png">4G离线</div>
</div>
<div id="map"></div>
<div id="popup" class="ol-popup">
    <a href="#" id="popup-closer" class="ol-popup-closer"></a>
    <div id="popup-content"></div>
</div>
<%@include file="../common/js.jsp" %>
<script src="${ctx}/static/js/openlayers@4.3.3/ol.js"></script>
<script type="text/javascript">
    $(function () {
        var county = ${county};
            devices = ${devices};
        var stateMap = {
            0: '广播',
            1: '在线',
            2: '离线',
            3: '停电',
            4: '故障'
        };
        var imgMap = {
            '1-0': '${ctx}/static/img/state/4g-0.png',
            '1-1': '${ctx}/static/img/state/4g-1.png',
            '1-2': '${ctx}/static/img/state/4g-2.png',
            '2-0': '${ctx}/static/img/state/ip-0.png',
            '2-1': '${ctx}/static/img/state/ip-1.png',
            '2-2': '${ctx}/static/img/state/ip-2.png'
        };
        var minZoom = 1;
        var maxZoom = 14;
        var centX = (county.longitude * 1) || 105.342363;
        var centY = (county.latitude * 1) || 24.774318;
        var epsg = 'EPSG:3857';
        var projection = ol.proj.get(epsg);
        var url = '${config.amap_offline_url}';
        // 初始化显示视图
        var view = new ol.View({
            center: ol.proj.transform([centX, centY], 'EPSG:4326', epsg),
            projection: projection,
            zoom: 10,
            minZoom: minZoom
        });
        // 初始化地图
        var map = new ol.Map({
            controls: ol.control.defaults().extend([]),
            layers: [
                new ol.layer.Tile({
                    source: new ol.source.XYZ({
                        attributions: 'GIS地图',
                        minZoom: minZoom,
                        maxZoom: maxZoom,
                        projection: projection,
                        tileSize: 256,
                        url: url
                    })
                })],
            loadTilesWhileAnimating: true,
            target: 'map',
            view: view
        });
        $.each(devices, function (i, device) {
            var deviceMode = '2', deviceState = device.fDeviceState;
            if ("移动通信网络" === device.fBackMode) {
                deviceMode = '1';
            }
            if (deviceState > 2) {
                deviceState = 2;
            }
            //经纬度错误直接跳过
            if (!device.fLongitude || !device.fDimension || isNaN(device.fLongitude) || isNaN(device.fDimension)) {
                return true;
            }
            var vectorLayer1 = new ol.layer.Vector({
                source: new ol.source.Vector({
                    features: [new ol.Feature({
                        geometry: new ol.geom.Point(ol.proj.fromLonLat([device.fLongitude * 1, device.fDimension * 1])),
                        name: device.fDeviceName || '',
                        code: device.fDeviceResourceCode || '',
                        state: device.fDeviceState,
                        mode: device.fBackMode || '有线IP网络',
                        region: device.region || ''
                    })]
                }),
                style: new ol.style.Style({
                    image: new ol.style.Icon({
                        src: imgMap[deviceMode + '-' + deviceState],
                        size: [50, 50]
                    })
                })
            });
            //添加进map层
            map.addLayer(vectorLayer1);
        });
        var container = document.getElementById("popup");
        var content = document.getElementById("popup-content");
        var popupCloser = document.getElementById("popup-closer");
        var overlay = new ol.Overlay({
            //设置弹出框的容器
            element: container,
            //是否自动平移，即假如标记在屏幕边缘，弹出时自动平移地图使弹出框完全可见
            autoPan: true,
            autoPanAnimation: {
                duration: 250
                //当Popup超出地图边界时，为了Popup全部可见，地图移动的速度.
            }
        });
        map.on('pointermove', function (e) {
            //获取像素区域
            var pixel = map.getEventPixel(e.originalEvent);
            var flag = false;
            map.forEachFeatureAtPixel(pixel, function (feature) {
            	if(typeof(feature.R.name)== "undefined") return;
                var coodinate = e.coordinate;
                //设置弹出框内容，可以HTML自定义
                content.innerHTML = '<div><span class="device-label">设备名称:</span><span class="device-info">' + feature.R.name + '</span></div>\n' +
                    '    <div><span class="device-label">资源编码:</span><span class="device-info">' + feature.R.code + '</span></div>\n' +
                    '    <div><span class="device-label">所属区域:</span><span class="device-info">' + feature.R.region + '</span></div>\n' +
                    '    <div><span class="device-label">设备状态:</span><span class="device-info">' + (stateMap[feature.R.state] || '') + '</span></div>\n' +
                    '    <div><span class="device-label">回传模式:</span><span class="device-info">' + feature.R.mode + '</span></div>';
                //设置overlay的显示位置
                overlay.setPosition(coodinate);
                flag = true;
            });
            if (flag) {
                //显示overlay
                map.addOverlay(overlay);
            } else
                map.removeOverlay(overlay);
        });
        
        //动态指向              point为 [120.1,15.2]形式
        function createFeature(point){
        	var geom = new ol.geom.Point(ol.proj.transform(point,'EPSG:4326', 'EPSG:3857'));
            return new ol.Feature(geom);
        } 
        var duration = 3000;
        function flash(feature) {
            var start = new Date().getTime();
            var listenerKey;

            function animate(event) {
              var vectorContext = event.vectorContext;
              var frameState = event.frameState;
              var flashGeom = feature.getGeometry().clone();
              var elapsed = frameState.time - start;
              var elapsedRatio = elapsed / duration;
              // radius will be 5 at start and 30 at end.
              var radius = ol.easing.easeOut(elapsedRatio) * 25 + 5;
              var opacity = ol.easing.easeOut(1 - elapsedRatio);

              var style = new ol.style.Style({
                image: new ol.style.Circle({
                  radius: radius,
                  snapToPixel: false,
                  stroke: new ol.style.Stroke({
                    color: 'rgba(255, 0, 0, ' + opacity + ')',
                    width: 0.4 + opacity
                  })
                })
              });

              vectorContext.setStyle(style);
              vectorContext.drawGeometry(flashGeom);
              if (elapsed > duration) {
                ol.Observable.unByKey(listenerKey);
                return;
              } 
              // tell OpenLayers to continue postcompose animation
              map.render();
            }
            listenerKey = map.on('postcompose', animate);
          }
        //声明连线要展示的图层 (图层的添加顺序会用心覆盖效果)
        var vector_line;
        //声明连线数组
        var coordinatesPolygon = new Array();
        //定义计时器
        var timer = null;
        function toline(startPoint,endPoint){
  			coordinatesPolygon.push(startPoint);
  			coordinatesPolygon.push(endPoint);
  		    //瓦片图层
  		    var tileLayer = new ol.layer.Tile({
  		        source:new ol.source.OSM()
  		    });
  		    var source = new ol.source.Vector();
  		    //矢量图层
  		    vector_line = new ol.layer.Vector({
  		        source: source,
  		        style: new ol.style.Style({  		        
  		            stroke: new ol.style.Stroke({//地图连线的样式
  		                color: 'red',//颜色
  		                width: 3//宽度
  		            }),
  		            image: new ol.style.Circle({
  		                radius: 10,
  		                fill: new ol.style.Fill({
  		                    color: '#ffcc33'
  		                })
  		            })
  		        })
  		    });
  		    //多边形此处注意一定要是[坐标数组]
  		    var plygon = new ol.geom.Polygon([coordinatesPolygon]);
  		    //多边形要素类
  		    var feature = new ol.Feature({
  		        geometry: plygon,
  		    });  		
  		    source.addFeature(feature);  		 
  		    map.addLayer(vector_line);
  		 
  		}
        window.setInterval(function(){
        	 $.ajax({
                 url: "${ctx}/monitor/GISMapReturn/selectConnectInfos",
                 async: true,
                 method: 'POST',
                 cache:false,
                 success: function (data) {
                 	if(data.status==200){
                 	   map.removeLayer(vector_line);
                 	   var resultList = data.data;
                 	   if(resultList.length==0||resultList==null){
	                 	   if(timer!=null){
	           				   clearInterval(timer);
	           			   }
                 		   return;
                 	   }else{
                 		   if(timer!=null){
            				   clearInterval(timer);
            			   }
                 		   var startPoint;
                 		   var endPoint;
                 		   var flashPoints = new Array();
                 		   var lastEndPointX;
                 		   var lastEndPointY;
                 		   var repeatFlag = 0; //用于标记闪烁点是否已经存在
                 		   for(var i=0;i<resultList.length;i++){
                 			   if((resultList[i].startPointX==0&&resultList[i].startPointY==0)||(resultList[i].endPointX==0&&resultList[i].endPointY==0)){
                 				   continue;
                 			   }else{
                 				   startPoint = ol.proj.transform([resultList[i].startPointX,resultList[i].startPointY], 'EPSG:4326', 'EPSG:3857');
                         		   endPoint = ol.proj.transform([resultList[i].endPointX,resultList[i].endPointY], 'EPSG:4326', 'EPSG:3857');
                         		   toline(startPoint,endPoint);
                         		   if(i>0){
                         			   for(var j=0;j<flashPoints.length;j++){
                         				   if((flashPoints[j][0]==resultList[i].endPointX) && (flashPoints[j][1]==resultList[i].endPointY)){
                         					   repeatFlag=1;
                         					   break;
                             			   }
                         			   }                			 
                         		   }
                         		   if(repeatFlag==0&&resultList[i].flashFlag==0){
                         			   flashPoints.push([resultList[i].endPointX,resultList[i].endPointY]);
                         		   }
                         		   repeatFlag=0;
                 			   }	
                     	   }
                 		   //使闪烁点闪烁
                 		   var falshFeature;
                 		   timer = window.setInterval(function(){
                 			   for(var i=0;i<flashPoints.length;i++){
                 				   falshFeature = createFeature(flashPoints[i]);
                 				   flash(falshFeature);
                 			   }                     		      	 
                 		   }, 2000);
                 	   }
                 	
                 	}			
                 }
             })                   		      	 
	    }, 5000);
       

/*         //若线路已展示,清除
        map.removeLayer(vector_line);
		var startPoint = ol.proj.transform([105.169,24.732], 'EPSG:4326', 'EPSG:3857');//单个坐标点信息
		var endPoint = ol.proj.transform([105.429,26.8374], 'EPSG:4326', 'EPSG:3857');
		toline(startPoint,endPoint); */

	/* 	var timer = window.setInterval(function(){
      	  flash(endFeature);
        }, 2000);   */

    });
</script>
</body>
</html>
