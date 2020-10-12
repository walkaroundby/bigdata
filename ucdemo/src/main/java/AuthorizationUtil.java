import com.alibaba.druid.util.Base64;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Random;

/**
 * <p>Title: 获取uc客户端校验信息  </p>
 * <p>Description: Function Description </p>
 * <p>Copyright: Copyright (c) 2015     </p>
 * <p>Company: ND Co., Ltd.       </p>
 * <p>Create Time:  2015/4/23          </p>
 *         <p>Update Time:                      </p>
 *         <p>Updater:                          </p>
 *         <p>Update Comments:                  </p>
 * @author linchanghui
 */
public class AuthorizationUtil {
	private static Logger logger = LoggerFactory.getLogger(AuthorizationUtil.class);
	public static final String KEY_MD5 = "MD5";
	/**
	 *
	 * @param name
	 * @param pwd
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getAuth(String name, String pwd, String method, URI uri) throws UnsupportedEncodingException {
		pwd = encryptMD5_Salt(pwd);
		String path = uri.getPath();
		String domain = uri.getHost();
		String host = domain;
		String url = "http://aqapi.101.com/v1.0/tokens";
		HttpPost httpPost = new HttpPost( url);
		final String ACCEPT = "Accept";
		final String HOST = "Host";
		httpPost.setHeader(ACCEPT, "application/json");
		httpPost.setHeader(HOST, host);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("login_name", name);
		map.put("password", pwd);
		JSONObject json = new JSONObject(map);
		// 添加请求体
		StringEntity reqEntity = new StringEntity(json.toString(), "UTF-8");
		reqEntity.setContentType("application/json");
		httpPost.setEntity(reqEntity);
		CloseableHttpResponse response;
		String content = "";
		try {
			response = HttpClients.createDefault().execute(httpPost);
			HttpEntity httpEntity = response.getEntity();
			content = EntityUtils.toString(httpEntity);
		} catch (IOException e) {

		}
		JSONObject obj = JSONObject.parseObject(content);
		String mac_key = obj.getString("mac_key");
		String access_token = obj.getString("access_token");
		StringBuilder sbRawMac = new StringBuilder();
		String nonce = System.currentTimeMillis() + ":" + generateMixRandomCode(8);
		sbRawMac.append(nonce);
		sbRawMac.append("\n");
		sbRawMac.append(method.toUpperCase());
		sbRawMac.append("\n");
		sbRawMac.append(path);
		sbRawMac.append("\n");
		sbRawMac.append(domain);
		sbRawMac.append("\n");
		String newMac = encryptHMac256(sbRawMac.toString(), mac_key);
		StringBuilder auth = new StringBuilder();
		auth.append("MAC id=\"");
		auth.append(access_token);
		auth.append("\",nonce=\"");
		auth.append(nonce);
		auth.append("\",mac=\"");
		auth.append(newMac);
		auth.append("\"");
		obj.put("MAC id",access_token);
		obj.put("nonce",nonce);
		obj.put("mac",newMac);
		return auth.toString();
	}
	/**
	 * HMac256加密
	 * @param content
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encryptHMac256(String content, String key) {
		String resultString = "";
		try {
			// 还原密钥
			SecretKey secretKey = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
			// 实例化Mac
			Mac mac = Mac.getInstance(secretKey.getAlgorithm());
			// 初始化mac
			mac.init(secretKey);
			// 执行消息摘要
			byte[] digest = mac.doFinal(content.getBytes("UTF-8"));
			resultString = new String(Base64.byteArrayToBase64(digest));
		} catch (Exception e) {
			logger.error("encryptHMac256 fail", e);
		}
		return  resultString;
	}
	/**
	 * MD5+Salt加密
	 * @param content
	 * @return
	 */
	public static String encryptMD5_Salt(String content) throws UnsupportedEncodingException {
		String resultString = "";
		String appkey = "fdjf,jkgfkl";
		byte[] a = appkey.getBytes("UTF-8");
		byte[] datSource = content.getBytes("UTF-8");
		byte[] b = new byte[a.length + 4 + datSource.length];

		int i;
		for (i = 0; i < datSource.length; i++){
			b[i] = datSource[i];
		}
		b[i++] = (byte)163;
		b[i++] = (byte)172;
		b[i++] = (byte)161;
		b[i++] = (byte)163;
		for (int k = 0; k < a.length; k++){
			b[i] = a[k];
			i++;
		}
		try {
			MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
			md5.update(b);
			resultString =new HexBinaryAdapter().marshal(md5.digest());
		} catch (Exception e) {
			logger.error("encryptMD5 fail", e);
		}
		return resultString.toLowerCase();
	}

	/**
	 * 生成sum位数字字母随机码
	 * @param sum 随机数长度
	 * @return 随机码
	 * @author lanyl
	 */
	public static String generateMixRandomCode(int sum) {
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < sum; ++i) {
			int number = random.nextInt(62);
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}
}
