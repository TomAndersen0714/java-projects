package hutool;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;

import java.util.Arrays;

/**
 * @author TomAndersen
 */
public class HutoolJSONUtil {
    public static void main(String[] args) {
        String jsonString = "[[-1,-1,2],[-1,0,1]]";
        JSONArray jsonArray = JSONUtil.parseArray(jsonString);
        int[][] array = new int[jsonArray.size()][];

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONArray innerArray = jsonArray.getJSONArray(i);
            array[i] = new int[innerArray.size()];
            for (int j = 0; j < innerArray.size(); j++) {
                array[i][j] = innerArray.getInt(j);
            }
        }

        System.out.println("array = " + Arrays.deepToString(array));
    }
}
