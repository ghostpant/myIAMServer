package my.iam.httpRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import my.iam.info.params.WxQRcodeParams;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class WxApiHttp {

    public static String doGetWxAppletAccessToken(String accessTokenUrl) {


        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet httpGet = new HttpGet(accessTokenUrl);

        String rs = null;
        String access_token = null;
        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            rs = EntityUtils.toString(responseEntity);
            JSONObject jsonObject = JSONObject.parseObject(rs);
            access_token = jsonObject.getString("access_token");
            String expires_in = jsonObject.getString("expires_in");
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        } finally {
            releaseResource(httpClient, response);
        }
        return access_token;
    }


    public static String doPostWxAppletQRcode(String QRcodeUrl, WxQRcodeParams params) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost(QRcodeUrl);

        String jsonString = JSON.toJSONString(params);


        StringEntity entity = new StringEntity(jsonString, "UTF-8");
        entity.setContentType("image/png");
        String rs = null;
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            InputStream content = response.getEntity().getContent();

            //将流转换为base64编码
            byte[] data = null;
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[100];
            int rc = 0;
            while ((rc = content.read(buff, 0, 100)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            data = swapStream.toByteArray();
            rs = new String(Base64.getEncoder().encode(data));


        } catch (ParseException | IOException e) {
            e.printStackTrace();
        } finally {
            releaseResource(httpClient, response);
        }
        return rs;
    }



    static void releaseResource(CloseableHttpClient httpClient, CloseableHttpResponse response) {
        try {
            // 释放资源
            if (httpClient != null) {
                httpClient.close();
            }
            if (response != null) {
                response.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
