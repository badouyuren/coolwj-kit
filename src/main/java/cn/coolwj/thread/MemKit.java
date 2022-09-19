package cn.coolwj.thread;
/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the god animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 */

import cn.coolwj.log.MaxPrime;

import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * @author Nigel Lee
 * @date 2022/9/19
 */
public class MemKit {

    public static void main(String[] args) {
        for (int i = 0; i < 10; ++i)
            testMemory(i);
    }

    private static void testMemory(int nChars) {
        long bytes = threadAllocatedBytes();
        char[] test = new char[nChars];
        String red = MaxPrime.readPrime();
        long bytes2 = threadAllocatedBytes();
        System.out.println("diff[" + +(nChars + 1) + "] = " + (bytes2 - bytes));
    }

    public static long threadAllocatedBytes() {
        try {
            return (Long) ManagementFactory.getPlatformMBeanServer().invoke(
                    new ObjectName(ManagementFactory.THREAD_MXBEAN_NAME), "getThreadAllocatedBytes",
                    new Object[]{Thread.currentThread().getId()}, new String[]{long.class.getName()});
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

}
