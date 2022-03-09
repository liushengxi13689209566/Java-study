import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Objects;


public class YY {
    public static void main(String[] args) {
        Map<String, Object> mmp = Maps.newHashMap();
        Object obj = new Object();
        obj = 1;
        mmp.put("businessCode", obj);

        System.out.println(Objects.equals(mmp.get("businessCode"), 1));
    }
}
/**
 * @Param: $
 * @return: $
 * @Author: liushengxi
 * @Date: $
 * @Description: $
 */
