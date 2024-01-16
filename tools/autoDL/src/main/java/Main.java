import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {


        第一.run();
        for(String item:公共.地区名) {
            最终.地区列表.clear();
            for(JsonNode item1:公共.一级的返回地区列表){
                if(String.valueOf(item1.get("region_name")).equals(item)){
                    最终.地区列表.add(item1.get("region_sign").textValue());
                }
            }


//            Integer 第几页=1;
            最终.page_index=1;
            最终.max_page=99999;
            while (最终.page_index<=最终.max_page){
                公共.机器列表.addAll(最终.run());
                最终.page_index++;
            }


        }


        公共.logger.info(String.valueOf(公共.机器列表.size()));
        List<JsonNode> result = 公共.机器列表.stream()
                .filter(s -> {return s.get("gpu_order_num").intValue() > 0;})
                .collect(Collectors.toList());

        公共.logger.info(String.valueOf(result.size()));

        Collections.sort(result, Comparator.comparingInt(s->{
            return s.get("payg_price").intValue();
        }));


        int tempNum=1;
        for(JsonNode item:result){
            if(tempNum>4){
                break;
            }

            System.out.println(item.get("region_name"));
            System.out.println(item.get("machine_alias"));
            System.out.println(item.get("gpu_order_num"));
            tempNum++;
        }

//        公共.logger.info(result.toString());



    }
}
