import com.fasterxml.jackson.databind.JsonNode;

import java.util.*;
import java.util.logging.Logger;


public class 公共 {

    public static 公共 保管公共;
    public static 二级请求 保管二级请求;

    public static final Logger logger = Logger.getLogger(公共.class.getName());

    public List<JsonNode> 一级的返回地区列表 =new ArrayList<>();
    public Set<String> 地区名 =new HashSet<>();
    public List<JsonNode> 机器列表 =new ArrayList<>();


    public static Map<String, String> headers() {
        String authorization="eyJhbGciOiJFUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1aWQiOjI5NTkzOSwidXVpZCI6IjU3ZTU2MGVlLTNiOGEtNDk4OC1iYjU1LWYzZGEyZTJkZTI5MyIsImlzX2FkbWluIjpmYWxzZSwiYmFja3N0YWdlX3JvbGUiOiIiLCJpc19zdXBlcl9hZG1pbiI6ZmFsc2UsInN1Yl9uYW1lIjoiIiwidGVuYW50IjoiYXV0b2RsIiwidXBrIjoiIn0.rbxt38eTkpOFwd301ccqau-Aved1BHK6_-EiMSRMRUBDNIAzyJR-fsfv5zWOCmbpa2KkTITpJqAvnkXNUEjQXA";
        String cookie="_ga=GA1.1.137710885.1704788542; Hm_lvt_e24036f31c6b8d171ce550a059a6f6fd=1704788541,1705304645,1705378077; Hm_lpvt_e24036f31c6b8d171ce550a059a6f6fd=1705378077; _ga_NDC1CJB7XZ=GS1.1.1705378077.3.0.1705378077.0.0.0";

        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "*/*");
        headers.put("Accept-Encoding", "gzip, deflate, br");
        headers.put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6,zh-TW;q=0.5");
        headers.put("Appversion", "v5.25.0");
        headers.put("Authorization", authorization);
        headers.put("Cache-Control", "no-cache");
        headers.put("Content-Length", "314"); // Set your content length
        headers.put("Content-Type", "application/json;charset=UTF-8");
        headers.put("Cookie", cookie);
        headers.put("Origin", "https://www.autodl.com");
        headers.put("Pragma", "no-cache");
        headers.put("Referer", "https://www.autodl.com/market/list?voucher=register");
        headers.put("Sec-Ch-Ua", "\"Not_A Brand\";v=\"8\", \"Chromium\";v=\"120\", \"Microsoft Edge\";v=\"120\"");
        headers.put("Sec-Ch-Ua-Mobile", "?0");
        headers.put("Sec-Ch-Ua-Platform", "\"Windows\"");
        headers.put("Sec-Fetch-Dest", "empty");
        headers.put("Sec-Fetch-Mode", "cors");
        headers.put("Sec-Fetch-Site", "same-origin");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36 Edg/120.0.0.0");
        return headers;
    }



}
