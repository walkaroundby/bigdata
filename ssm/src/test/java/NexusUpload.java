import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;

/**
 * @author luowei
 * @date 2018/10/13 0:23
 */
public class NexusUpload {

    public static void main(String[] args) {
        String url = "http://nexus3.sdp.nd/service/rest/beta/components?repository=thirdparty";
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost uploadFile = new HttpPost(url);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.addTextBody("maven2.groupId", "yes", ContentType.TEXT_PLAIN);
            builder.addTextBody("maven2.artifactId", "yes", ContentType.TEXT_PLAIN);
            builder.addTextBody("maven2.version", "yes", ContentType.TEXT_PLAIN);
            builder.addTextBody("maven2.generate-pom", "yes", ContentType.TEXT_PLAIN);
            builder.addTextBody("maven2.packaging", "yes", ContentType.TEXT_PLAIN);
            builder.addTextBody("maven2.asset1.classifier", "yes", ContentType.TEXT_PLAIN);
            builder.addTextBody("maven2.asset1.extension", "jar", ContentType.TEXT_PLAIN);
            File f = new File("D://management-agent.jar");
            builder.addBinaryBody( "maven2.asset1", new FileInputStream(f), ContentType.APPLICATION_OCTET_STREAM,f.getName());
            HttpEntity multipart = builder.build();
            uploadFile.setEntity(multipart);
//            uploadFile.addHeader("Content-Type", "multipart/form-data");
            uploadFile.addHeader("Accept", "application/json");
            uploadFile.addHeader("Cookie","_ga=GA1.3.992409949.1539246294; userName=262337; nickName=%E7%BD%97%E4%BC%9F; userPass=VHlsV3Q1VjA0elRXcE5NRTVVV1MwLQ--; userInfoDesc=q7qBNOn9p4QeWfdH8duca%2FoAHWNBrUSkqTRSWnnsGTg%3D; isCheck=true; expTime=1540194819226; access_token=2BF77E636E553F7CFA1A52FB54C61059369C3B644E86994969E0F5CFC6ADB147A3D8B04043553CC7; mac_key=wTPz22PUrH; cur_domain=debug.sdp.nd; _ga=GA1.2.992409949.1539246294; _gid=GA1.2.1299884198.1539567919; _gid=GA1.3.1299884198.1539567919; NXSESSIONID=63bbd1c9-7a65-4871-8acb-39ab72cc7e57");
            CloseableHttpResponse response = httpClient.execute(uploadFile);
            HttpEntity responseEntity = response.getEntity();
//            String sResponse= EntityUtils.toString(responseEntity, "UTF-8");
//            System.out.println("Post 返回结果"+sResponse);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
