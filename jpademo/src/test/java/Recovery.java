import java.io.*;
import java.sql.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author luowei
 * @date 2018-09-12 10:40
 */
public class Recovery {
    public static void main(String[] args) {
//        File file = new File("E://sys.sql");
//        Map<String, String> id_orgIdMap = new LinkedHashMap<>();
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
//            String data=null;
//            while((data=bufferedReader.readLine())!=null){
//                int index = data.indexOf("(");
//                data = data.substring(index, data.length());
//                String[] datas = data.split("', '");
//                String id = datas[0].replace("('", "");
//                String orgId = datas[1].replace("');", "");
//                id_orgIdMap.put(id, orgId);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(id_orgIdMap);
        String sql = "select acc from com.nd.esp.statistics.training.sys.entity.SysAccount acc join FETCH  acc.organization o where 1=1  and acc.role.id = :roleId  and ((o.id like '11%' and o.type=3) or (o.parentId like '11%' and o.type=4) or (o.id like '11%' and o.type=2)) and o.id != '111111110000' and acc.status in (4,5)  and find_in_set ('110000000000', o.parents_id)  and acc.status != :removeStatus  order by acc.updateTime desc";
        System.out.println(sql.indexOf("find"));
    }
}
