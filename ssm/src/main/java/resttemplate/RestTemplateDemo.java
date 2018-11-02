package resttemplate;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import java.awt.print.Book;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * @author luowei
 * @date 2018-09-13 16:18
 */
public class RestTemplateDemo {
    static RestTemplate restTemplate = new RestTemplate();
    public static void main(String[] args) {
        ResponseEntity<String> responseEntity;
        //无参数get请求
//        responseEntity = getForEntity("http://HELLO-SERVICE/hello", String.class);
        //url里带String参数的get查询
//        responseEntity = getForEntityWithStringParam("http://HELLO-SERVICE/hello", String.class);
        //url里带map参数的get查询
//        responseEntity = getForEntityWithMapParam("http://HELLO-SERVICE/hello", String.class);
        //参数封装到uri类里的get访问
//        responseEntity = getForEntityByUri("http://HELLO-SERVICE/hello", String.class);
        //post请求携带body参数
//        responseEntity = postForEntityWithBody("http://HELLO-SERVICE/hello", String.class);
        //post请求携带header和body
//        responseEntity = postForEntityWithBodyAndHeader("http://HELLO-SERVICE/hello", String.class);
        //携带header的Delete请求
//        responseEntity = deleteForEntityWithBodyAndHeader("http://HELLO-SERVICE/hello", String.class);
        responseEntity = getForEntity("http://jenkins.cc.service.test.sdp.nd/queue/api/json?depth=1&pretty=true&tree=items[task[name[*]]]", String.class);
        String body = responseEntity.getBody();
        HttpStatus statusCode = responseEntity.getStatusCode();
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpHeaders headers = responseEntity.getHeaders();
        StringBuffer result = new StringBuffer();
        result.append("responseEntity.getBody()：").append(body).append("<hr>")
                .append("responseEntity.getStatusCode()：").append(statusCode).append("<hr>")
                .append("responseEntity.getStatusCodeValue()：").append(statusCodeValue).append("<hr>")
                .append("responseEntity.getHeaders()：").append(headers).append("<hr>");
        System.out.println(result);
    }

    /**
     * 无参数get请求
     * @param url get请求的地址
     * @param clazz 希望返回的body类型
     * @return
     */
    private static ResponseEntity<String> getForEntity(String url, Class<String> clazz) {
        return restTemplate.getForEntity(url, String.class);
    }

    /**
     * url里带String参数的查询
     * @param url
     * @param clazz
     * @return
     */
    private static ResponseEntity<String> getForEntityWithStringParam(String url, Class<String> clazz) {
        return restTemplate.getForEntity("http://localhost:8080/v1.0/accounts?status=&orgName=&userName=&roleId=06&check=true&parentId={1}&page=1&size=20", String.class, "110000000000");
    }

    /**
     * url里带map参数的查询
     * map的key即为前边占位符的名字，map的value为参数值
     * @param url
     * @param clazz
     * @return
     */
    private static ResponseEntity<String> getForEntityWithMapParam(String url, Class<String> clazz) {
        Map<String, String> map = new HashMap();
        map.put("name", "李四");
        return restTemplate.getForEntity("http://localhost:8080/v1.0/accounts?status=&orgName=&userName=&roleId=06&check=true&parentId={name}&page=1&size=20", String.class, map);
    }

    /**
     * 参数封装到uri类里访问
     * @param s
     * @param stringClass
     * @return
     */
    private static ResponseEntity<String> getForEntityByUri(String s, Class<String> stringClass) {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://localhost:8080/v1.0/accounts?status=&orgName=&userName=&roleId=06&check=true&parentId={1}&page=1&size=20").build().expand("110000000000").encode();
        URI uri = uriComponents.toUri();
        return restTemplate.getForEntity(uri, String.class);
    }

    /**
     * post请求携带body参数
     * @param url
     * @param stringClass
     * @return
     */
    private static ResponseEntity<Book> postForEntityWithBody(String url, Class<String> stringClass) {
        Book book = new Book();
        return restTemplate.postForEntity("http://HELLO-SERVICE/getbook2", book, Book.class);
    }

    /**
     * post请求携带header和body
     * @param url
     * @param stringClass
     * @return
     */
    private static ResponseEntity<String> postForEntityWithBodyAndHeader(String url, Class<String> stringClass) {
        String pp = "http://ucproxy.dev.web.nd/proxy/preproduct?url=";
        String common_data_collect = "http://common-data-collect.debug.web.nd";
        String commonUrl = "/v0.1/m/application_server";
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("x-loginname", "890425@nd");
        requestHeaders.add("x-password", "890425LTA");
        requestHeaders.setContentType(MediaType.parseMediaType("application/json"));
        requestHeaders.add("Accept", MediaType.APPLICATION_JSON.toString());

        JSONObject requestBody = new JSONObject();
        requestBody.put("send_cloud_flag", "true");
        requestBody.put("app_name", "NO71");
        requestBody.put("limit_opt", "1");
        requestBody.put("interval", "3");
        requestBody.put("token_key", "token_key");
        requestBody.put("batch_size", "100");
        requestBody.put("app_key", "NO71");
        requestBody.put("os_type", "1");
        requestBody.put("sdp_app_id", "NO71");
        HttpEntity<String> requestEntity = new HttpEntity(requestBody.toJSONString(), requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(pp+common_data_collect+commonUrl, HttpMethod.POST, requestEntity, String.class);
        return responseEntity;
    }

    /**
     * 携带header的Delete请求
     * @param url
     * @param stringClass
     * @return
     */
    private static ResponseEntity<String> deleteForEntityWithBodyAndHeader(String url, Class<String> stringClass) {
        String pp = "http://ucproxy.dev.web.nd/proxy/preproduct?url=";
        String common_data_collect = "http://common-data-collect.debug.web.nd";
        String commonUrl = "/v0.1/m/application_server/2";
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("x-loginname", "15980084814@org_esp_app_preprod");
        requestHeaders.add("x-password", "123456");
        requestHeaders.setContentType(MediaType.parseMediaType("application/json"));
        requestHeaders.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> requestEntity = new HttpEntity<String>(null, requestHeaders);
        return restTemplate.exchange(pp+common_data_collect+commonUrl, HttpMethod.DELETE, requestEntity, String.class);
    }
}
