package standardQuery.duplicate;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.Query;
import java.io.*;
import java.sql.*;

/**
 * @author luowei
 * @date 2018-09-19 18:22
 */
@Transactional(rollbackFor = Exception.class)
public class NormalJdbc {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        BufferedReader bufferedReader = null;
        try {
            //加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");

            //通过驱动管理类获取数据库链接
            connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/jpa?characterEncoding=utf-8", "root", "123");
            //定义sql语句 ?表示占位符
            StringBuilder stringBuilder = new StringBuilder();
            //读取sql文件
            File file = new File("E://sys_organization.sql");
            int count =0;
            Query query;
            String sql;
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            stringBuilder.append("INSERT INTO sys_organization (ID, NAME, parent_id, parents_id, type, STATUS, CREATETIME, updateTime, code, shen, shi, xian, custom_parent_id, custom_parents_id) VALUES ");
            String[] msg;
            int maxLen = 0;
            int parentMax = 0;
            int parentsMax = 0;
            int shenMax = 0;
            int shiMax = 0;
            int xianMax = 0;
            String xianMaxString = "";
            String shenMaxString = "";
            String shiMaxString = "";
            String parentIdString = "";
            String parentsIdString = "";
            String shen;
            String shi;
            String xian;
            String parentId;
            String parentsId;
            while ((line = bufferedReader.readLine()) != null) {
                try {
                    System.out.println(line);
                    if(line.contains("INSERT") || StringUtils.isEmpty(line)){
                        continue;
                    }
                    msg = line.split(", ");
                    line = msg[1].replace(",","");
                    shen = msg[9].replace(",","");
                    shi = msg[10].replace(",","");
                    xian = msg[11].replace(",","");
                    parentId = msg[2].replace(",","");
                    parentsId = msg[3].replace(",","");
                    System.out.println(line+"省："+shen+";市："+shi+"；县："+xian+";parentId:"+parentId+"parentsId"+parentsId);
                    int len = line.length();
                    int shenlen = shen.length();
                    int shilen = shi.length();
                    int xianlen = xian.length();
                    int parentlen = parentId.length();
                    int parentslen = parentsId.length();
                    if(len>maxLen){
                        maxLen = len;
                    }
                    if(shenlen>shenMax){
                        shenMax = shenlen;
                        shenMaxString = shen;
                    }
                    if(shilen>shiMax){
                        shiMax = shilen;
                        shiMaxString = shi;
                    }
                    if(xianlen>xianMax){
                        xianMax = xianlen;
                        xianMaxString = xian;
                    }
                    if(parentlen>parentMax){
                        parentMax = parentlen;
                    }
                    if(parentslen>parentsMax){
                        parentsMax = parentslen;
                    }
//                    line = line.replace(";",",");
//                    stringBuilder.append(line);
//                    count++;
//                    if(count%1000==0){
//                        sql = stringBuilder.toString().substring(0, stringBuilder.length()-1);
//                        System.out.println(sql);
//                        //获取预处理statement
//                        connection.prepareStatement(sql).execute();
//                        stringBuilder = new StringBuilder();
//                        stringBuilder.append("INSERT INTO sys_organization (ID, NAME, parent_id, parents_id, type, STATUS, CREATETIME, updateTime, code, shen, shi, xian, custom_parent_id, custom_parents_id) VALUES ");
//                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            System.out.println("==============================="
                    +maxLen+"shen:"+shenMaxString+shenMax+
                    "shi:"+shiMax+shiMaxString+
                    ";xian:"+xianMaxString+xianMax
            +";parent:"+parentIdString+parentMax+
            ";parents:"+parentsIdString+parentsMax);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //释放资源
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
