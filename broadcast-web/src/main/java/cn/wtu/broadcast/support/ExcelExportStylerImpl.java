package cn.wtu.broadcast.support;

import cn.afterturn.easypoi.excel.export.styler.AbstractExcelExportStyler;
import org.apache.poi.ss.usermodel.*;

/**
 * 导出excel文件格式
 *
 * @author sueua
 * @since 2019-01-01
 */
public class ExcelExportStylerImpl extends AbstractExcelExportStyler {

    public ExcelExportStylerImpl(Workbook workbook) {
        super.createStyles(workbook);
    }

    /**
     * 列表头样式
     */
    @Override
    public CellStyle getHeaderStyle(short color) {
        return getBaseStyle(workbook);
    }

    /**
     * 标题样式
     */
    @Override
    public CellStyle getTitleStyle(short color) {
        return getBaseStyle(workbook);
    }

    /**
     * 数据奇数行样式
     */
    @Override
    public CellStyle stringNoneStyle(Workbook workbook, boolean isWarp) {
        return getBaseStyle(workbook);
    }

    /**
     * 数据偶数行样式
     */
    @Override
    public CellStyle stringSeptailStyle(Workbook workbook, boolean isWarp) {
        return getBaseStyle(workbook);
    }

    private CellStyle getBaseStyle(Workbook workbook) {
        CellStyle baseStyle = workbook.createCellStyle();
        BorderStyle borderStyle = BorderStyle.THIN;
        baseStyle.setBorderLeft(borderStyle);
        baseStyle.setBorderRight(borderStyle);
        baseStyle.setBorderBottom(borderStyle);
        baseStyle.setBorderTop(borderStyle);
        baseStyle.setAlignment(HorizontalAlignment.CENTER);
        baseStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return baseStyle;
    }
}