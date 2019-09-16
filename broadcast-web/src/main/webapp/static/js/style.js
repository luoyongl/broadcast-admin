$('.headnav.pull-left li').on('click',function(e){
    $(this).addClass('selected') //为选中项添加高亮
    .siblings().removeClass('selected').end;//去除其他项的高亮形式
})


$('.leftmenu dt').on('click',function(e){
      $('.leftmenu dt').removeClass('selected');  // 删除其他兄弟元素的样式
        $(this).addClass('selected');             // 添加当前元素的样式
})

$('.dropdown').on('click',function(){
  $(this).children("span").toggleClass("on");
})

$('.leftmenu dd ul li').on('click',function(e){
     $(this).addClass('selected') //为选中项添加高亮
     .siblings().removeClass('selected').end;//去除其他项的高亮形式
})

/**
 * 三级菜单背景条滑动
 */
$(".leftmenu dl dd ul>li").mouseenter(
		function(){
			var clientWidth=$(window).width();
			var n=$(this).index();    
			if(clientWidth<=1400){
				$(this).parent().children("span").animate({top:33*(n-1)},150);
			}else{
				$(this).parent().children("span").animate({top:43*(n-1)},150);
			}
            	
			
		}
 )

$(".headnav.pull-left>li").mouseenter(	
		function(){
			var clientWidth=$(window).width();
			var n=$(this).index();
			if(clientWidth<=1400){
				if(n!=0){
	            	$(this).parent().children("span").animate({marginLeft:5+102*n},150);
	            }else{
	            	$(this).parent().children("span").animate({marginLeft:7},150);
	            }
			}else{
				if(n!=0){
	            	$(this).parent().children("span").animate({marginLeft:5+112*n},150);
	            }else{
	            	$(this).parent().children("span").animate({marginLeft:7},150);
	            }
			}
           
            
		}
 )

$(".head .pull-left").mouseleave(
		function(){
		var clientWidth=$(window).width();
       	var index=$('.head .pull-left .selected').index();
       	if(clientWidth<=1400){
       		if(index==-1){
       			$(this).children("span").animate({marginLeft:7},100);
       		}else{
       			$(this).children("span").animate({marginLeft:7+102*index},100);
       		}
       	}else{
       		if(index==-1){
       			$(this).children("span").animate({marginLeft:5},100);
       		}else{
       			$(this).children("span").animate({marginLeft:5+112*index},100);
       		}
       	}
       	
	}
 )
  
$('.nav.nav-tabs li').on('click',function(e){
    $(this).addClass('selected_tab') //为选中项添加高亮
    .siblings().removeClass('selected_tab').end;//去除其他项的高亮形式
})
  //左侧导航切换出右侧页面ifream
  $(".leftmenu dl dt").click(function(){
    var _link = $(this).children("a").attr('_link');
  $("#main").attr('src',_link);
  });

//左侧导航三级菜单切换出右侧页面ifream
		$(".leftmenu dl dd ul li a").click(function(){
			var _link = $(this).attr('_link');
			//alert(_link)
		$("#main").attr('src',_link);
		});

//一级菜单切换出右侧页面ifream
		$(".headnav li a").click(function(){
			var _link = $(this).attr('_link');
			//alert(_link)
		$("#main").attr('src',_link);
		});
		
$('.nav.nav-tabs li').on('click',function(){;
  var index=$(this).index();
  $('.tab_modal').eq(index).addClass('show') //为选中项添加高亮
  .siblings().removeClass('show').end;//去除其他项的高亮形式
  
  $('.btn_modal').eq(index).addClass('show') //为选中项添加高亮
  .siblings().removeClass('show').end;//去除其他项的高亮形式
});

$('.nav.nav-tabs li').on('click',function(){;
  var index=$(this).index();
  $('.tablemodelshenhe').eq(index).addClass('showshenhe') //为选中项添加高亮
  .siblings().removeClass('showshenhe').end;//去除其他项的高亮形式
});

