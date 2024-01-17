import com.fasterxml.jackson.databind.JsonNode;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {





        while(true) {

            公共.保管公共=new 公共();




            一级请求.run();
            for (String item : 公共.保管公共.地区名) {
                公共.保管二级请求 =new 二级请求();

                for (JsonNode item1 : 公共.保管公共.一级的返回地区列表) {
                    if (String.valueOf(item1.get("region_name")).equals(item)) {
                        公共.保管二级请求.地区列表.add(item1.get("region_sign").textValue());
                    }
                }


//            Integer 第几页=1;
                公共.保管二级请求.page_index = 1;
                公共.保管二级请求.max_page = 99999;
                while (公共.保管二级请求.page_index <= 公共.保管二级请求.max_page) {
                    公共.保管公共.机器列表.addAll(二级请求.run());
                    公共.保管二级请求.page_index++;
                }


            }



            List<JsonNode> result = 公共.保管公共.机器列表.stream()
                    .filter(s -> {
                        return s.get("gpu_order_num").intValue() > 0;
                    })
                    .collect(Collectors.toList());



            Collections.sort(result, Comparator.comparingInt(s -> {
                return s.get("payg_price").intValue();
            }));


//            int size=result.size();
//            int tempNum = 1;
//            for (JsonNode item : result) {
            for (int i=3;i>=0;i--) {
                System.out.println(result.get(i).get("region_name"));
                System.out.println(result.get(i).get("machine_alias"));
//                System.out.println(item.get("gpu_order_num"));
                System.out.println(result.get(i).get("payg_price"));
                System.out.println("-----");
            }
            System.out.println("==========");

//        公共.logger.info(result.toString());

            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }

    }
}
