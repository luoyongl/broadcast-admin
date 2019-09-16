
		 function loadRegionTree(treeId,nodes) {
				var setting = {
		                view: {
		                    showIcon: false
		                },
						check: {
				            enable: true,
				            chkboxType: {"Y": "s", "N": "ps"}
		               /* "Y": "s"  选中时会影响son,
		                * "N": "ps" 取消时会影响parent和son */
				        },
						data: {
							simpleData: {
								enable: true,//使用简单json数据构造ztree节点
							}
						},
                callback: {
                    onCheck: function (event, treeId, treeNode) {
                        var parentNode = treeNode.getParentNode();
                        var treeObj = $.fn.zTree.getZTreeObj(treeId);
                        
                        if (treeNode.getCheckStatus().checked) {
                            if (parentNode && 2 === parentNode.check_Child_State) {
                             //   treeObj.checkNode(parentNode, true, false, true);
                            }
                        } else {
                            if (parentNode) {
                                treeObj.checkNode(parentNode, false, false, true);
                            }
                        }
                    }
                }
		 },treeId;
            
        $.fn.zTree.destroy(treeId);
        $.fn.zTree.init($("#" + treeId), setting, nodes);
        $.fn.zTree.getZTreeObj(treeId).expandAll(true);//全部展开
	   }


