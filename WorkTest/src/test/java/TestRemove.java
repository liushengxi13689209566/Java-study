import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestRemove {
    @Test
    public void fun() {
        Map<String, String> map = Maps.newHashMap();
        map.put("1", "2");
        map.put("3", "4");
        map.put("5", "6");

        List<Map<String, String>> columns = Lists.newArrayList();
        columns.add(Maps.newHashMap(map));
        columns.add(Maps.newHashMap(map));
        columns.add(Maps.newHashMap(map));
        Iterator<Map<String, String>> iterator = columns.iterator();
        while (iterator.hasNext()) {
            Map<String, String> column = iterator.next();
            //转换字段类型为VarType类型
            VarType varType = null;
            if (varType == null) {
                iterator.remove();
            }
            column.put("columnType", String.valueOf(5555));
            System.out.println(column.get("columnType"));
        }
    }
}
