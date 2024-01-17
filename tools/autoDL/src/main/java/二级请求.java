import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class 二级请求 {


    public int page_index;
    public int page_size=100;
    public int max_page;

    public List<String> 地区列表 =new ArrayList<>();
    public static List<JsonNode> run() {

        List<JsonNode> result= new ArrayList<>();
        try {
            // 定义目标URL
            String url = "https://www.autodl.com/api/v1/user/machine/list";

            // 构建POST请求参数
            Connection connection = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .headers(公共.headers())
                    .requestBody(payload())
                    .method(Connection.Method.POST);

            // 发送POST请求并获取响应字符串
            String responseBody = connection.execute().body();

            // 使用Jackson解析JSON数据
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(responseBody);

            JsonNode temp=jsonNode.get("data").get("list");
            公共.保管二级请求.max_page=jsonNode.get("data").get("max_page").asInt();


            for(JsonNode item:temp){
                result.add(item);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }



    private static String payload() throws JsonProcessingException {
        // 创建一个包含请求参数的Map
        Map<String, Object> requestBodyMap = new HashMap<>();
        requestBodyMap.put("charge_type", "payg");
        requestBodyMap.put("region_sign", "");
        requestBodyMap.put("gpu_type_name", new String[]{});
        requestBodyMap.put("machine_tag_name", new String[]{});
        requestBodyMap.put("gpu_idle_num", 1);
        requestBodyMap.put("mount_net_disk", false);
        requestBodyMap.put("instance_disk_size_order", "");
        requestBodyMap.put("date_range", "");
        requestBodyMap.put("date_from", "");
        requestBodyMap.put("date_to", "");
        requestBodyMap.put("page_index", 公共.保管二级请求.page_index);
        requestBodyMap.put("page_size", 公共.保管二级请求.page_size);
        requestBodyMap.put("pay_price_order", "");
        requestBodyMap.put("gpu_idle_type", "");
        requestBodyMap.put("default_order", true);

//        String[] regionSignList = {"bj-B1"};
        requestBodyMap.put("region_sign_list", 公共.保管二级请求.地区列表);

        公共.logger.info(公共.保管二级请求.地区列表.toString());

        // 使用Jackson库将Map转换为JSON字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonPayload = objectMapper.writeValueAsString(requestBodyMap);
        return jsonPayload;
    }
}