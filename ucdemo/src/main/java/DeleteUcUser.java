import com.alibaba.fastjson.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;

/**
 * @author luowei
 * @date 2018-09-13 15:32
 */
public class DeleteUcUser {
    static RestTemplate restTemplate = new RestTemplate();
    public static void main(String[] args) {
        String user = "admin@EduStatistics";
        String pwd = "123456!@";
        String url = "http://101uccenter.beta.web.sdp.101.com/v0.93/organizations/481037541237/orgnodes/495334348452/users/2132757339";
        URI uri = URI.create(url);
        HttpHeaders httpHeaders = new HttpHeaders();
        try {
            httpHeaders.add("Content-Type", "application/json;charset=UTF-8");
            httpHeaders.add("Authorization", AuthorizationUtil.getAuth(user, pwd, "DELETE", uri));
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpEntity<String> requestEntity = new HttpEntity<String>(null, httpHeaders);
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class);
        System.out.println(result);
    }

}