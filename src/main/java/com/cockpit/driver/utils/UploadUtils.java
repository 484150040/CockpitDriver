package com.cockpit.driver.utils;

import com.alibaba.fastjson.JSONObject;
import com.dahuatech.icc.oauth.http.DefaultClient;
import com.dahuatech.icc.oauth.http.IClient;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.cockpit.driver.utils.HttpClientUtil.*;


public class UploadUtils {

    @SneakyThrows
    public static void main(String[] args) {
        Map<String,String> stringObjectMap = new HashMap<>();
        stringObjectMap.put("key","4b99ec1244f5475ab781356aec822463");
        stringObjectMap.put("username","Ebanswers");
        stringObjectMap.put("count","30");
        Map<String, Object> map = json2map(sendGet("http://10.98.53.2/Webedit/api/player/players/list?key=4b99ec1244f5475ab781356aec822463&username=Ebanswers&count=30",new HashMap<>()));
        List<Map<String,Object>> mapList = (List<Map<String, Object>>) map.get("data");
// 创建工作簿对象

        Workbook workbook = new XSSFWorkbook();

// 创建工作表对象

        Sheet sheet = workbook.createSheet("信息发布数据");
        for (int i = 0; i <=mapList.size() ; i++) {
            // 创建行和单元格对象
            Row row = sheet.createRow(i);
            if (i==0){

                continue;
            }
            int cent = 0;
            for (String s : mapList.get(i-1).keySet()) {
                // 创建行和单元格对象
                Cell cell = row.createCell(cent);
                cell.setCellValue(String.valueOf(mapList.get(i-1).get(s)));
                cent++;
            }

        }

// 向单元格中写入数据

// 导出Excel文件

        FileOutputStream outputStream = new FileOutputStream("信息发布数据.xlsx");

        workbook.write(outputStream);

        workbook.close();

    }

    /*public static void main(String[] args) throws IOException {
        String input = "appId=unismart2&secret=V20230228&account=admin&time=1693558358179";
        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            byte[] hash = sha256.digest(input.getBytes("UTF-8"));
            StringBuffer hexHash = new StringBuffer();

            // 将字节数组转换成16进制字符串
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexHash.append('0');
                hexHash.append(hex);
            }
            System.out.println("SHA256 哈希值: " + hexHash.toString());

            String pas = "{\n" +
                    "    \"appId\": \"unismart2\",\n" +
                    "    \"account\": \"admin\",\n" +
                    "    \"password\": \"Kechuang123\",\n" +
                    "    \"sign\": \"4422c304c6f3be6d2d44c0327deca9e7e9c649c0bd39e555e8dfb770d9a9453c\",\n" +
                    "    \"time\": 1693558358179\n" +
                    "}";
            String a = sendPost("https://172.17.1.156/open/v1/login",pas,new HashMap<>());
            System.out.println(a);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }*/





  /*  @SneakyThrows
    public static void main(String[] args) {
        DHhttpCleentUtil dHhttpCleentUtil = new DHhttpCleentUtil();
        List<Map<String,Object>> mapListAll = new ArrayList<>();
        List<Integer> mapListId = new ArrayList<>();
        mapListId.add(1002760);
        Integer con = 1003760;
        for (int i = 0; i <24 ; i++) {
            con += 1;
            mapListId.add(con);
        }
        for (Integer integer : mapListId) {
            IClient iClient = new DefaultClient("172.17.1.2","kechuang","bf8093df-8c98-4a35-a349-cb527874d73a");
            String datas = dHhttpCleentUtil.get("/evo-apigw/evo-brm/1.0.0/device/"+integer,new HashMap<>(),iClient);
            //服务出参
            JSONObject roots = JSONObject.parseObject(datas);
            Map<String, Object> map = json2map(roots.getString("data"));
            List<Map<String,Object>> mapList = (List<Map<String, Object>>) map.get("units");
            List<Map<String,Object>> mapLists = (List<Map<String, Object>>) mapList.get(0).get("channels");
            for (Map<String, Object> list : mapLists) {
                Map<String, Object> map1 = new HashMap<>();
                map1.put("设备编号",map.get("deviceCode"));
                map1.put("设备名称",map.get("deviceName"));
                map1.put("设备ip地址",map.get("deviceIp"));
                map1.put("设备通道编号",list.get("channelCode"));
                map1.put("设备通道名称",list.get("channelName"));
                mapListAll.add(map1);
            }
        }

// 创建工作簿对象

        Workbook workbook = new XSSFWorkbook();

// 创建工作表对象

        Sheet sheet = workbook.createSheet("门禁数据");
        for (int i = 0; i <=mapListAll.size() ; i++) {
            // 创建行和单元格对象
            Row row = sheet.createRow(i);
            if (i==0){
                Cell cell0 = row.createCell(0);
                Cell cell1 = row.createCell(1);
                Cell cell2 = row.createCell(2);
                Cell cell3 = row.createCell(3);
                Cell cell4 = row.createCell(4);
                cell0.setCellValue("设备ip地址");
                cell1.setCellValue("设备通道名称");
                cell2.setCellValue("设备通道号");
                cell3.setCellValue("设备编号");
                cell4.setCellValue("设备名称");
                continue;
            }
            int cent = 0;
            for (String s : mapListAll.get(i-1).keySet()) {
                // 创建行和单元格对象
                Cell cell = row.createCell(cent);
                cell.setCellValue(String.valueOf(mapListAll.get(i-1).get(s)));
                cent++;
            }

        }

// 向单元格中写入数据

// 导出Excel文件

        FileOutputStream outputStream = new FileOutputStream("门禁数据.xlsx");

        workbook.write(outputStream);

        workbook.close();

    }*/


/*
    @SneakyThrows
    public static void main(String[] args) {
        Map<String,Object> body = new HashMap<>();
        body.put("username","admin");
        body.put("password","admin123");
        Map<String, Object> maps = json2map(httpPost2Json("http://172.17.102.244/dev-api/login",body));
        Map<String,String> map = new HashMap<>();
        map.put("Authorization",maps.get("token").toString());
        map.put("Content-Type","application/json");

        String bodyy="{\n" +
                "    \"page\": {\n" +
                "        \"current\": 1,\n" +
                "        \"size\": 100\n" +
                "    },\n" +
                "    \"parentId\": 250\n" +
                "}";
        String bodys = sendPost("http://172.17.102.244/dev-api/device/list",bodyy,map);
        Map<String, Object>  m = json2map(bodys);
        Map<String, Object>  m1 = (Map<String, Object>) m.get("dataOne");
        List<Map<String,Object>> mapList = (List<Map<String, Object>>) m1.get("recordes");
        System.out.println();*/
/*// 创建工作簿对象

        Workbook workbook = new XSSFWorkbook();

// 创建工作表对象

        Sheet sheet = workbook.createSheet("象和");
        for (int i = 0; i <=mapList.size() ; i++) {
            // 创建行和单元格对象
            Row row = sheet.createRow(i);
            if (i==0){

                continue;
            }
            int cent = 0;
            for (String s : mapList.get(i-1).keySet()) {
                // 创建行和单元格对象
                Cell cell = row.createCell(cent);
                cell.setCellValue(String.valueOf(mapList.get(i-1).get(s)));
                cent++;
            }

        }

// 向单元格中写入数据

// 导出Excel文件

        FileOutputStream outputStream = new FileOutputStream("象和.xlsx");

        workbook.write(outputStream);

        workbook.close();*/

//    }
}
