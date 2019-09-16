package cn.wtu.broadcast.parent.utils.export.csv;

import java.io.OutputStream;

import cn.wtu.broadcast.parent.utils.export.DataField;
import cn.wtu.broadcast.parent.utils.export.ExportDataSource;
import cn.wtu.broadcast.parent.utils.export.txt.TxtDataExportor;

 


/**
 * 描述: csv格式数据导出工具
 * @author Hill
 *
 */
public class CsvDataExportor<T> extends TxtDataExportor<T> {
	public CsvDataExportor(DataField[] fields, ExportDataSource<T> dataSource,OutputStream os) {
		super(fields, dataSource, os,",");
	}
}
