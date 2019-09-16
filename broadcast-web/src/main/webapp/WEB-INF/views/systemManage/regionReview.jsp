<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ page import="cn.wtu.broadcast.config.SystemConfig" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("ctx", request.getContextPath());
    request.setAttribute("config", SystemConfig.getMap());
%>
<!DOCTYPE html>
<html>
<head>
    <%@include file="../common/css.jsp" %>
    <style>
        div{
            margin: 0!important;
            padding: 0!important;
        }
        html{height: 100%!important;}
        body {
            background: url(${ctx}/static/img/picture/th1.jpg) no-repeat !important;
            background-size: cover !important;
            height: 100%;
        }
        .show_content{color: white;height: 100%;text-align: center}
        .content_top{height: 44%;padding: 1% 0 0 5%!important}
        .content_bottom{height: 48%;padding: 1% 0 0 5%!important}
        .content_top>div,
        .content_bottom>div{
            height: 100%;
            border: 1px solid #0f78d2;
            box-sizing: border-box;
        }
        .bottom_content{
            border: 1px solid #0f78d2;
            height: 50%;
        }
        .bottom_content>div{
            height: 100%;
            border: 1px solid #0f78d2; 
        }
        .title{
        	height: 8%;
        } 
		.col-sm-11 {
		    width: 92%;
		}
		h4, .h4 {
		    font-size: 150%;
		}
		.img-responsive {
		  	display: block;
		  	height: 100%;
		  	max-width: 100%;
		} 
		/*调整容器大小*/
		#myCarousel {
			width: 100%;
		}  
		/*调整圆圈链接ol位置*/
		.carousel-indicators {
			bottom: -5px;
		} 
		/* #carousel-example-generic {
			top:20px;
		} */
		.carousel-inner>.item>img {
		    display: block; 
		    max-width: 100%;
		    height: -webkit-fill-available;
		}   
    </style>
</head>
<body>
<div class="show_content">
    <div class="content_top title col-sm-11">
        <div><h4>广西隆林各县自治县简介</h4></div>
    </div>
    <div class="content_top col-sm-12">
        <div class="col-sm-7">
        	<c:forEach items="${realOneList }" var="one">
        		<%-- ${one.fRichTextContent } --%>
        		${one.fContent }
        	</c:forEach>
        </div>
        <div class="col-sm-4" >
        	<c:forEach items="${realOneList }" var="one">
				<img src="${one.fImageUrl }" class="img-responsive">
        	</c:forEach>
        </div>
    </div>
    <div class="content_bottom col-sm-12">
        <div class="col-sm-4">
        	<%-- <c:forEach items="${fourList }" var="four">
				<img src="${four.fImageUrl }" class="img-responsive">
        	</c:forEach> --%>
        	
        	
        	<div class="container" id="myCarousel">
				<!-- 轮播图容器 -->
				<div id="carousel-example-generic" class="carousel slide">
					<!-- 轮播图上的圆圈链接 -->
					<ol class="carousel-indicators radiou">
						<c:forEach items="${fourList }" var="four" varStatus="f">
							<c:if test="${f.index==0 }">
								<li data-target="#carousel-example-generic" data-slide-to="${f.index }" class="active"></li>
							</c:if>	
							<c:if test="${f.index!=0 }">
								<li data-target="#carousel-example-generic" data-slide-to="${f.index }"></li>
							</c:if>
								<!-- <li data-target="#carousel-example-generic" data-slide-to="2"></li> -->
						</c:forEach>
					</ol>
					<!-- 轮播图具体内容 -->
					<div class="carousel-inner">
						<c:forEach items="${fourList }" var="four" varStatus="f">
							<c:if test="${f.index==0 }">
								<div class="item active">
									<img src="${four.fImageUrl }" class="img-responsive">
								</div>
							</c:if>
							<c:if test="${f.index!=0 }">
								<div class="item">
									<img src="${four.fImageUrl }" class="img-responsive">
								</div>
							</c:if>
						</c:forEach>
						<!-- <div class="item">
							<img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1510077934469&di=d7d222fb5b5465fde75425e984cf2b90&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F7a899e510fb30f2478787ac5c295d143ac4b0311.jpg" style="height: 300px; width:600px">
						</div>
						<div class="item">
							<img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1510077977327&di=404f5cf97186c344d0a34a343f8be5b2&imgtype=0&src=http%3A%2F%2Fimg.autofan.com.cn%2F2016-12-05%2F16%2Ff206c101380a.JPG" style="height: 300px; width:600px">
						</div> -->
					</div>
					<!-- 轮播图上的向前一图切换链接 -->
					<a href="#carousel-example-generic" data-slide="prev" class="left carousel-control">
						<span class="glyphicon glyphicon-chevron-left"></span>
					</a>
					<!-- 轮播图上的向后一图切换链接 -->
					<a href="#carousel-example-generic" data-slide="next" class="right carousel-control">
						<span class="glyphicon glyphicon-chevron-right"></span>
					</a>
				</div>
			</div>
        	
        	
        	
        </div>
        <div class="col-sm-7">
            <c:forEach items="${twoList }" var="two">
	            <div class="col-sm-12 bottom_content">
	            	<p>${two.fMainTitle }
	            	<br>${two.fContent }
	            </div>
	         </c:forEach>
	         <c:forEach items="${threeList }" var="three">
	            <div class="col-sm-12 bottom_content">
	                <div class="col-sm-4">
	                	<p>${three.fSubheadingOne }
	                	<br>${three.fSubContentOne }
	                </div>
	                <div class="col-sm-4">
	                	<p>${three.fSubheadingTwo }
	                	<br>${three.fSubContentTwo }
	                </div>
	                <div class="col-sm-4">
	                	<p>${three.fSubheadingThree }
	                	<br>${three.fSubContentThree }
	                </div>
	            </div>
        	</c:forEach>
        </div>
    </div>
</div>
<%@include file="../common/js.jsp" %>
	<script type="text/javascript">
		$(".carousel").carousel({
			interval:3000 //每隔三秒自动轮播
		})
	</script>
</body>

</html>