package cn.wtu.broadcast.parent.utils;

import java.text.DecimalFormat;

/**
 * 格式化工具
 *
 * @author sueua
 * @since 2019-01-20
 */
public class FormatUtil {

    private static final String[] UNITS = new String[]{"B", "KB", "MB", "GB", "TB", "PB", "EB"};

    private FormatUtil() {
    }

    /**
     * 字节格式化显示
     */
    public static String formatBytes(long bytes) {
        if (bytes <= 0) {
            return "0";
        }
        int digitGroups = (int) (Math.log10(bytes) / Math.log10(1024));
        return new DecimalFormat("#,##0.##").format(bytes / Math.pow(1024, digitGroups)) + UNITS[digitGroups];
    }
}
