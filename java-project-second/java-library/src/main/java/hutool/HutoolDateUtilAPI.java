package hutool;

import cn.hutool.core.date.DateUtil;

import java.util.Calendar;

/**
 * @author TomAndersen
 */
public class HutoolDateUtilAPI {
    public static void main(String[] args) {
        // cn.hutool.core.date.DateUtil.date()
        // 获取当前日期时间对应的 DateTime 对象
        System.out.println("DateUtil.date() = " + DateUtil.date());
        System.out.println("DateUtil.date(Calendar.getInstance()) = " + DateUtil.date(Calendar.getInstance()));
        System.out.println("DateUtil.date(System.currentTimeMillis()) = " + DateUtil.date(System.currentTimeMillis()));

        // 获取当前日期时间对应的 String 字符串，格式：yyyy-MM-dd HH:mm:ss
        System.out.println("DateUtil.now() = " + DateUtil.now());

        // 获取当前日期对应的 String 字符串，格式：yyyy-MM-dd
        System.out.println("DateUtil.today() = " + DateUtil.today());
    }
}
