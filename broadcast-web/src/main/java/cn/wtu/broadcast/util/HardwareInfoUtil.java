package cn.wtu.broadcast.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import cn.wtu.broadcast.openapi.model.BSystemInfoRecord;
import cn.wtu.broadcast.openapi.vo.NetworkCard;
import cn.wtu.broadcast.openapi.vo.Partition;
import cn.wtu.broadcast.parent.enums.SystemInfoTypeEnum;
import oshi.PlatformEnum;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.NetworkIF;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;

/**
 * 硬件采集信息工具类
 *
 * @author sueua
 * @since 2019-01-20
 */
public class HardwareInfoUtil {

    /**
     * 系统信息
     */
    private static final SystemInfo SYSTEM_INFO = new SystemInfo();

    /**
     * 百分比格式
     */
    private static final String PERCENT_FORMAT = "%.2f";

    /**
     * 操作系统
     */
    private static PlatformEnum platformEnum = SystemInfo.getCurrentPlatformEnum();

    private HardwareInfoUtil() {
    }

    /**
     * 获取内存信息
     */
    public static BSystemInfoRecord getMemoryInfo() {
        BSystemInfoRecord memoryInfo = new BSystemInfoRecord();
        GlobalMemory memory = SYSTEM_INFO.getHardware().getMemory();
        memoryInfo.setfInfoType(SystemInfoTypeEnum.MEMORY.getValue());
        memoryInfo.setfTotalValue(memory.getTotal());
        memoryInfo.setfUsedValue(memory.getTotal() - memory.getAvailable());
        memoryInfo.setfFreeValue(memory.getAvailable());
        memoryInfo.setfPercentUsed(String.format(PERCENT_FORMAT, 100d * (memory.getTotal() - memory.getAvailable()) / memory.getTotal()));
        return memoryInfo;
    }

    /**
     * 获取cpu利用率
     */
    public static String getCpuPercentUsed() {
        CentralProcessor processor = SYSTEM_INFO.getHardware().getProcessor();
        return String.format(PERCENT_FORMAT, processor.getSystemCpuLoadBetweenTicks() * 100);
    }

    /**
     * 获取cpu每核的利用率,单位%
     */
    public static List<String> getCpuCoreUseRatio() {
        CentralProcessor processor = SYSTEM_INFO.getHardware().getProcessor();
        double[] coreUseRatio = processor.getProcessorCpuLoadBetweenTicks();
        List<String> useRatioList = new ArrayList<>();
        for (double ratio : coreUseRatio) {
            useRatioList.add(String.format(PERCENT_FORMAT, ratio * 100));
        }
        return useRatioList;
    }

    /**
     * 获取分区信息
     */
    public static List<Partition> getPartitionInfo() {
        FileSystem fileSystem = SYSTEM_INFO.getOperatingSystem().getFileSystem();
        OSFileStore[] fileStores = fileSystem.getFileStores();
        List<Partition> partitions = new ArrayList<>();
        for (OSFileStore fileStore : fileStores) {
            long usableSpace = fileStore.getUsableSpace();
            long totalSpace = fileStore.getTotalSpace();
            Partition partition = new Partition();
            String partitionName;
            if (platformEnum == PlatformEnum.LINUX) {
                partitionName = fileStore.getVolume();
            } else {
                partitionName = fileStore.getMount();
            }
            partition.setPartitionName(partitionName);
            partition.setTotalValue(totalSpace);
            partition.setFreeValue(usableSpace);
            partition.setUsedValue(totalSpace - usableSpace);
            partition.setPercentUsed(String.format(PERCENT_FORMAT, 100d * (totalSpace - usableSpace) / totalSpace));
            partitions.add(partition);
        }
        return partitions;
    }

    /**
     * 获取磁盘已用百分比
     */
    public static String getDiskPercentUsed() {
        return getDiskPercentUsed(getPartitionInfo());
    }

    /**
     * 获取磁盘已用百分比
     */
    public static String getDiskPercentUsed(List<Partition> partitions) {
        long total = 0;
        long used = 0;
        for (Partition partition : partitions) {
            total += partition.getTotalValue();
            used += partition.getUsedValue();
        }
        if (total == 0) {
            return "0";
        }
        return String.format(PERCENT_FORMAT, 100d * used / total);
    }

    /**
     * 获取网卡信息
     */
    public static List<NetworkCard> getNetworkCardInfo() {
        NetworkIF[] networkIFs = SYSTEM_INFO.getHardware().getNetworkIFs();
        List<NetworkCard> networkCards = new ArrayList<>();
        for (NetworkIF net : networkIFs) {
            NetworkCard networkCard = new NetworkCard();
            networkCard.setCardName(net.getName());
            networkCard.setMacAddr(net.getMacaddr());
            networkCard.setIpAddr(ArrayUtils.toString(net.getIPv4addr(), "{-}").replaceAll("\\{(.*)}", "$1"));
            networkCard.setBytesRecv(net.getBytesRecv());
            networkCard.setBytesSent(net.getBytesSent());
            networkCard.setPacketsRecv(net.getPacketsRecv());
            networkCard.setPacketsSent(net.getPacketsSent());
            networkCards.add(networkCard);
        }
        return networkCards;
    }
}
