//package standardQuery.duplicate;
//
//import entity.manytomany.Student;
//import entity.onetoone.Female;
//
//import javax.persistence.*;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//import java.io.*;
//import java.util.List;
//
///**
// * @author luowei
// * @date 2018-09-19 17:39
// */
//public class DuplicateData {
//    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entity_mapping");
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        StringBuilder stringBuilder = new StringBuilder("INSERT INTO sys_organization (ID, NAME, parent_id, parents_id, type, STATUS, CREATETIME, updateTime, code, shen, shi, xian, custom_parent_id, custom_parents_id) VALUES ");
//        //读取sql文件
//        File file = new File("E://sys_organization.sql");
//        BufferedReader bufferedReader = null;
//        int count =0;
//        Query query;
//        String sql;
//        try{
//            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                stringBuilder.append(line);
//                count++;
//                if(count%1==0){
//                    sql = stringBuilder.toString().substring(0, stringBuilder.length()-1);
//                    query = em.createQuery(sql);
//                    query.executeUpdate();
//                    System.out.println(count);
//                    stringBuilder = new StringBuilder("INSERT INTO sys_organization (ID, NAME, parent_id, parents_id, type, STATUS, CREATETIME, updateTime, code, shen, shi, xian, custom_parent_id, custom_parents_id) VALUES ");
//                }
//            }
//        }catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            if(bufferedReader!=null){
//                try {
//                    bufferedReader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        em.getTransaction().commit();
//        em.close();
//        emf.close();
//    }
//}
