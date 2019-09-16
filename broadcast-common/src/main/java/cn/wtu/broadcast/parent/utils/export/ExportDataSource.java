package cn.wtu.broadcast.parent.utils.export;

import java.util.List;



/**
 * 描述: 数据导出,数据源
 * @author Hill
 *
 */
@SuppressWarnings("hiding")
public interface ExportDataSource<T>{
	<T> List<T> getData();
}
