package hutool;

import cn.hutool.core.collection.CollUtil;

import java.util.List;

/**
 * @author TomAndersen
 * @see cn.hutool.core.collection.CollUtil
 */
public class HutoolCollUtilAPI {
    public static void main(String[] args) {
        // cn.hutool.core.collection.CollUtil.isEqualList
        // 判断两个List中的元素是否每个都相等
        System.out.println("CollUtil.isEqualList(List.of(1, 2, 3), List.of(1, 3, 2)) = " +
            CollUtil.isEqualList(List.of(1, 2, 3), List.of(1, 3, 2)));
    }
}
