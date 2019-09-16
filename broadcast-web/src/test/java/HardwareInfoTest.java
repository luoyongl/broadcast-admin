import cn.wtu.broadcast.parent.utils.FormatUtil;
import cn.wtu.broadcast.util.HardwareInfoUtil;
import com.sun.management.OperatingSystemMXBean;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.NetworkIF;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.util.Arrays;
import java.util.List;

/**
 * 硬件信息测试
 * <p>
 * 需要获得的信息:
 * - 1.cpu使用率:每个cpu的实时使用率,不用记入数据库
 * - 2.cpu使用记录:某个时间的使用百分比,记入数据库
 * - 3.内存使用分布:总大小,已用,可用
 * - 4.内存使用记录:某个时间的使用百分比,记入数据库
 * 5.网卡信息,包括网卡名称,ip,mac,数据包接收,下发数量,数据流量接收下发
 * - 6.磁盘:分区名称,容量,空闲容量,使用容量,百分比
 * 7.关键进程:tomcat mysql
 * 数据库制度:id,类型(cpu,Memory),总大小,已用大小,已用百分比,采集时间(创建时间)
 *
 * @author sueua
 * @since 2019-01-19
 */
public class HardwareInfoTest {

    public static void main(String[] args) {
        HardwareInfoUtil.getMemoryInfo();
        System.out.println(HardwareInfoUtil.getCpuCoreUseRatio());
        System.out.println(HardwareInfoUtil.getCpuPercentUsed());
        System.out.println(HardwareInfoUtil.getDiskPercentUsed());
        HardwareInfoUtil.getPartitionInfo();
        HardwareInfoUtil.getNetworkCardInfo();
    }

    private static void printMemory(GlobalMemory memory) {
        System.out.println("Memory: " + FormatUtil.formatBytes(memory.getAvailable()) + "/"
                + FormatUtil.formatBytes(memory.getTotal()));
        System.out.println("Swap used: " + FormatUtil.formatBytes(memory.getSwapUsed()) + "/"
                + FormatUtil.formatBytes(memory.getSwapTotal()));
    }

    private static void printCpu(CentralProcessor processor) {
        System.out.format("CPU load: %.1f%% (counting ticks)%n", processor.getSystemCpuLoadBetweenTicks() * 100);
        // per core CPU
        StringBuilder procCpu = new StringBuilder("CPU load per processor:");
        double[] load = processor.getProcessorCpuLoadBetweenTicks();
        for (double avg : load) {
            procCpu.append(String.format(" %.1f%%", avg * 100));
        }
        System.out.println(procCpu.toString());
    }

    private static void printFileSystem(FileSystem fileSystem) {
        System.out.println("File System:");

        System.out.format(" File Descriptors: %d/%d%n", fileSystem.getOpenFileDescriptors(),
                fileSystem.getMaxFileDescriptors());

        OSFileStore[] fsArray = fileSystem.getFileStores();
        for (OSFileStore fs : fsArray) {
            long usable = fs.getUsableSpace();
            long total = fs.getTotalSpace();
            System.out.format(
                    " %s (%s) [%s] %s of %s free (%.1f%%) is %s "
                            + (fs.getLogicalVolume() != null && fs.getLogicalVolume().length() > 0 ? "[%s]" : "%s")
                            + " and is mounted at %s%n",
                    fs.getName(), fs.getDescription().isEmpty() ? "file system" : fs.getDescription(), fs.getType(),
                    FormatUtil.formatBytes(usable), FormatUtil.formatBytes(fs.getTotalSpace()), 100d * usable / total,
                    fs.getVolume(), fs.getLogicalVolume(), fs.getMount());
        }
    }

    private static void printNetworkInterfaces(NetworkIF[] networkIFs) {
        System.out.println("Network interfaces:");
        for (NetworkIF net : networkIFs) {
            System.out.format(" Name: %s", net.getName());
            System.out.format("   MAC Address: %s %n", net.getMacaddr());
            System.out.format("   IPv4: %s %n", Arrays.toString(net.getIPv4addr()));
            boolean hasData = net.getBytesRecv() > 0 || net.getBytesSent() > 0 || net.getPacketsRecv() > 0
                    || net.getPacketsSent() > 0;
            System.out.format("   Traffic: received %s/%s%s; transmitted %s/%s%s %n",
                    hasData ? net.getPacketsRecv() + " packets" : "?",
                    hasData ? FormatUtil.formatBytes(net.getBytesRecv()) : "?",
                    hasData ? " (" + net.getInErrors() + " err)" : "",
                    hasData ? net.getPacketsSent() + " packets" : "?",
                    hasData ? FormatUtil.formatBytes(net.getBytesSent()) : "?",
                    hasData ? " (" + net.getOutErrors() + " err)" : "");
        }
    }

    private static void printProcesses(OperatingSystem os, GlobalMemory memory) {
        System.out.println("Processes: " + os.getProcessCount() + ", Threads: " + os.getThreadCount());
        // Sort by highest CPU
        List<OSProcess> procs = Arrays.asList(os.getProcesses(5, OperatingSystem.ProcessSort.NAME));

        System.out.println("   PID  %CPU %MEM       VSZ       RSS Name");
        for (int i = 0; i < procs.size(); i++) {
            OSProcess p = procs.get(i);
            System.out.format(" %5d %5.1f %4.1f %9s %9s %s%n", p.getProcessID(),
                    100d * (p.getKernelTime() + p.getUserTime()) / p.getUpTime(),
                    100d * p.getResidentSetSize() / memory.getTotal(), FormatUtil.formatBytes(p.getVirtualSize()),
                    p.getParentProcessID(), p.getName());
        }
    }

    //@Test
    public void getInfo() {
        /* Get a list of all filesystem roots on this system */
        File[] roots = File.listRoots();

        /* For each filesystem root, print some info */
        for (File root : roots) {
            System.out.print("磁盘: " + root.getAbsolutePath());
            System.out.print(" 总容量: " + FormatUtil.formatBytes(root.getTotalSpace()));
            System.out.print(" 可用容量: " + FormatUtil.formatBytes(root.getFreeSpace()));
            System.out.println(" 已用容量: " + FormatUtil.formatBytes(root.getTotalSpace() - root.getFreeSpace()));
        }
        for (int i = 0; i < 1000; i++) {
            OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
            System.out.print("物理总内存:" + FormatUtil.formatBytes(operatingSystemMXBean.getTotalPhysicalMemorySize()));
            System.out.print("已用内存:" + FormatUtil.formatBytes(operatingSystemMXBean.getTotalPhysicalMemorySize() - operatingSystemMXBean.getFreePhysicalMemorySize()));
            System.out.println("可用内存:" + FormatUtil.formatBytes(operatingSystemMXBean.getFreePhysicalMemorySize()));
            System.out.print("已用内存:" + FormatUtil.formatBytes(operatingSystemMXBean.getTotalPhysicalMemorySize() - operatingSystemMXBean.getFreeSwapSpaceSize()));
            System.out.println("可用内存:" + FormatUtil.formatBytes(operatingSystemMXBean.getFreeSwapSpaceSize()));
            //linux
            System.out.println("operatingSystemMXBean.getSystemCpuLoad():" + operatingSystemMXBean.getSystemCpuLoad());
            System.out.println("operatingSystemMXBean.getSystemLoadAverage():" + operatingSystemMXBean.getSystemLoadAverage());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
