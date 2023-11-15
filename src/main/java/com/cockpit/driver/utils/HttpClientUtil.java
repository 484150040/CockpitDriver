package com.cockpit.driver.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author vconinfo
 * @createdOn 2019/8/19
 * @description: http工具类
 */
@Slf4j
public class HttpClientUtil {
    private static PoolingHttpClientConnectionManager pcm;
    private static String EMPTY_STR = "";
    private static String UTF_8 = "UTF-8";
    /**
     * 连接池最大连接数
     */
    private static int MAX_TOTAL = 300;
    /**
     * 每路由最大连接数，默认是2
     */
    private static int MAX_PER_ROUTE = 5;
    /**
     * 连接超时时间 单位毫秒
     */
    private static int CONN_TIME_OUT = 60000;
    /**
     * 从connect Manager获取connection超时时间 单位毫秒
     */
    private static int reqTimeout = 5000;

    private static void init() {
        if (pcm == null) {
            pcm = new PoolingHttpClientConnectionManager();
            // 整个连接池最大连接数
            pcm.setMaxTotal(MAX_TOTAL);
            // 每路由最大连接数，默认值是2
            pcm.setDefaultMaxPerRoute(MAX_PER_ROUTE);
        }
    }
    /**
     * 通过连接池获取HttpClient
     *
     * @return
     */
    private static CloseableHttpClient getHttpClient() {
        init();
        return HttpClients.custom().setConnectionManager(pcm).build();
    }


  public static String replaceBlank(String str) {
    String dest = "";
    if (str != null) {
      Pattern p = Pattern.compile("\\s*|\t|\r|\n");
      Matcher m = p.matcher(str);
      dest = m.replaceAll("");
    }
    return dest;
  }

  public static Map<String, Object> objectToMap(Object object){
    Map<String,Object> dataMap = new HashMap<>();
    Class<?> clazz = object.getClass();
    for (Field field : clazz.getDeclaredFields()) {
      try {
        field.setAccessible(true);
        dataMap.put(field.getName(),field.get(object));
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    }
    return dataMap;
  }
  public static Map<String, Object> json2map(String str_json) {
    Map<String, Object> res = null;
    try {
      Gson gson = new Gson();
      res = gson.fromJson(str_json, new TypeToken<Map<String, Object>>() {
      }.getType());
    } catch (JsonSyntaxException e) {
    }
    return res;
  }
    public static String httpPost2Json(String url, Map<String, Object> parameters) throws UnsupportedEncodingException {
        OkHttpClient client = new OkHttpClient.Builder().readTimeout(20, TimeUnit.SECONDS).build();
        ObjectMapper objectMapper = new ObjectMapper();
        MediaType mediaType = MediaType.parse("application/json");
        String param;
        try {
            param = objectMapper.writeValueAsString(parameters);
        } catch (JsonProcessingException e1) {
            return "";
        }
        RequestBody body = RequestBody.create(mediaType, param);
        Request request =
                new Request.Builder().url(url).post(body).addHeader("Content-Type", "application/json")
                        .addHeader("cache-control", "no-cache").build();

        Response response;
        try {
            response = client.newCall(request).execute();
            int code = response.code();
            String str = response.body().string();
            str = replaceBlank(str);
            return str;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    /**
     * 发送GET请求并获取响应结果
     * @param url 请求的URL地址
     * @return 响应结果字符串
     */
    public static String sendGet(String url, Map<String, String> header) {
        StringBuilder result = new StringBuilder();
        try {
            URL urlObj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
            if (header!=null) {
                for (Map.Entry<String, String> entry : header.entrySet()) {
                    connection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }


    /**
     * url: 请求地址
     * param： 请求参数 [{'key1':'value1','key2':'value2'},{'key1':'value3','key2':'value4'}]
     * header 设置header
     *
     */
    public static String sendPost(String url, String param, Map<String, String> header) throws UnsupportedEncodingException, IOException {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        URL realUrl = new URL(url);
        // 打开和URL之间的连接
        URLConnection conn = realUrl.openConnection();
        //设置超时时间
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(15000);
        // 设置通用的请求属性
        if (header!=null) {
            for (Map.Entry<String, String> entry : header.entrySet()) {
                conn.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        conn.setRequestProperty("accept", "*/*");
        conn.setRequestProperty("connection", "Keep-Alive");
        conn.setRequestProperty("user-agent",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        // 发送POST请求必须设置如下两行
        conn.setDoOutput(true);
        conn.setDoInput(true);
        // 获取URLConnection对象对应的输出流
        out = new PrintWriter(conn.getOutputStream());
        // 发送请求参数
        out.print(param);
        // flush输出流的缓冲
        out.flush();
        // 定义BufferedReader输入流来读取URL的响应
        in = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), "utf8"));
        String line;
        while ((line = in.readLine()) != null) {
            result += line;
        }
        if(out!=null){
            out.close();
        }
        if(in!=null){
            in.close();
        }
        return result;
    }


    @SneakyThrows
    public static void main(String[] args) {
/*
        Map<String,Object> body = new HashMap<>();
        body.put("username","admin");
        body.put("password","admin123");
        try {
            Map<String, Object> maps = json2map(httpPost2Json("http://172.17.102.244/dev-api/login",body));
            Map<String,String> map = new HashMap<>();
            map.put("Authorization",maps.get("token").toString());
            map.put("Content-Type","application/json");

            System.out.println(maps.get("token"));
            Map<String,Object> body1 = new HashMap<>();
            Map<String,Object> body2 = new HashMap<>();
            body2.put("current",1);
            body2.put("size",10);
            body1.put("page",body2);
            body1.put("parentId",100);
            String bodyy="{\n" +
                    "    \"page\": {\n" +
                    "        \"current\": 1,\n" +
                    "        \"size\": 100\n" +
                    "    },\n" +
                    "    \"parentId\": 250\n" +
                    "}";
            System.out.println(body1);
            System.out.println("数据"+sendPost("http://172.17.102.244/dev-api/device/list",bodyy,map));

            String aa= "{\n" +
                    "\"pointType\": \"usefuleletric\",\n" +
                    "\"deviceId\": null,\n" +
                    "\"page\": {\n" +
                    "\"current\": 1,\n" +
                    "\"size\": 10\n" +
                    "}\n" +
                    "} }\n" +
                    "}";
            System.out.println(sendPost("http://172.17.102.244/dev-api/system/dept/nengYuan",aa,map));
            String bb = "{\n" +
                    "\"treenodeType\": \"tree\"\n" +
                    "}";
            System.out.println(sendPost("http://172.17.102.244/dev-api/system/dept/postTree",bb,map));

            System.out.println(doGet("http://172.17.102.244/dev-api/pointValue/32",map,new HashMap<>()));

            Map<String,Object> info = json2map(doGet("http://172.17.102.244/dev-api/device/38",map,new HashMap<>()));
            Map<String,Object> vulue = json2map(doGet("http://172.17.102.244/dev-api/pointValue/38",map,new HashMap<>()));

            String s = "{\"dataOne\":{\"recordes\":[{\"pointData\":[{\"createBy\":\"admin\",\"updateBy\":\"admin\",\"id\":69,\"name\":\"总有功电能\",\"type\":\"float\",\"rw\":0,\"base\":0.0,\"minimum\":null,\"maximum\":null,\"multiple\":1.0,\"accrue\":0,\"format\":\"%.2f\",\"unit\":\"Kwh\",\"profileId\":7,\"description\":\"\",\"createTime\":\"2023-07-14T13:30:28.000+08:00\",\"updateTime\":\"2023-08-03T08:33:35.000+08:00\",\"deleted\":0,\"deviceId\":32,\"pointModelId\":14,\"pointType\":\"usefuleletric\",\"value\":\"397.92Kwh\",\"deviceName\":null,\"parentId\":null,\"address\":\"\"}]}]},\"numberValue\":null}\n";
            System.out.println(vulue.get("dataOne"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
       /* String s = "{\"dataOne\":{\"recordes\":[{\"pointData\":[{\"createBy\":\"admin\",\"updateBy\":\"admin\",\"id\":69,\"name\":\"总有功电能\",\"type\":\"float\",\"rw\":0,\"base\":0.0,\"minimum\":null,\"maximum\":null,\"multiple\":1.0,\"accrue\":0,\"format\":\"%.2f\",\"unit\":\"Kwh\",\"profileId\":7,\"description\":\"\",\"createTime\":\"2023-07-14T13:30:28.000+08:00\",\"updateTime\":\"2023-08-03T08:33:35.000+08:00\",\"deleted\":0,\"deviceId\":32,\"pointModelId\":14,\"pointType\":\"usefuleletric\",\"value\":\"397.92Kwh\",\"deviceName\":null,\"parentId\":null,\"address\":\"\"}]}]},\"numberValue\":null}\n";
        Map<String, Object>  m = json2map(s);
        Map<String, Object>  m1 = (Map<String, Object>) m.get("dataOne");
        List<LinkedTreeMap> linkedHashMaps = (List<LinkedTreeMap>) m1.get("recordes");
        List<LinkedTreeMap> maps = (List<LinkedTreeMap>) linkedHashMaps.get(0).get("pointData");
        System.out.println(maps.get(0));*/
    }
}
