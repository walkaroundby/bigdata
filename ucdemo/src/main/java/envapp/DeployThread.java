package envapp;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author luowei
 * @date 2018-10-29 11:37
 */
public class DeployThread implements Runnable {
    static String dev = "http://jenkins.cc.service.test.sdp.nd/job/branch-";
    static String debug = "http://jenkins.cc.service.debug.sdp.nd/job/";

    public static void main(String[] args) {
        new DeployThread("debug", "jenkins1").run();
    }
    static RestTemplate restTemplate = new RestTemplate();
    String env;
    String appId;
    public DeployThread(String env, String appId){
        this.appId = appId;
        this.env = env;
    }
    public void run() {
        String url;
        if(this.env.equals("dev")){
            url = dev;
        }else{
            url = debug;
        }
        deployApp(appId, url);
    }
    public void deployApp(String appName, String env){
        String url = env + appName+"/buildWithParameters";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("envtarget","test");
        jsonObject.put("branch","develop");
        jsonObject.put("jdkVersion","1.7");
        String auth = "";
        ResponseEntity<String> responseEntity = postWithAuth(url, HttpMethod.POST);
    }
    public static ResponseEntity<String> postWithAuth(String url, HttpMethod httpMethod){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json;charset=UTF-8");
        httpHeaders.add("Authorization", "Basic MTAwMDAwMTAxOmFiY2Q4NzY1NDMyMQ==");
        HttpEntity<String> requestEntity = new HttpEntity<String>(null, httpHeaders);
        ResponseEntity<String> result = restTemplate.exchange(url, httpMethod, requestEntity, String.class);
        return result;
    }
}
