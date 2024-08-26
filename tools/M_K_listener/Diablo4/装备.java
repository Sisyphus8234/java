package custom;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class 装备 {

    public static int 左线 = 1269;
    public static int 右线 = 1875;
    public static int 上线 = 720;
    public static int 下线 = 966;
    public static int 横向数量 = 11;
    public static int 纵向数量 = 3;
    public static class 每一格 {
        public Point point;

        public int x1;
        public int x2;
        public int y1;
        public int y2;

        public boolean 是这一个(Point point){
            return x1<= point.x&&point.x<=x2
                    &&y1<= point.y&&point.y<=y2;
        }

        public boolean 包含(List<Point> pointList){
            boolean result=false;
            for (Point s : pointList) {
                if (是这一个(s)) {
                    result = true;
                    break;
                }
            }
            return result;

        }
    }

    public static List<每一格> 背包 =new ArrayList<>();



    public static void 分格(){
        double 一格宽度=(右线-左线)/横向数量;
        double 一格高度=(下线-上线)/纵向数量;
        int 第几个x=1;
        int 第几个y=1;
        while (true){
            每一格 每一格=new 每一格();
            每一格.x2=(int) (左线+第几个x*一格宽度);
            每一格.x1= (int) (每一格.x2-一格宽度);
            每一格.y2=(int) (上线+第几个y*一格高度);
            每一格.y1= (int) (每一格.y2-一格高度);

            Point point=new Point((int) (左线+第几个x*一格宽度-一格宽度/2), (int) (上线+第几个y*一格高度-一格高度/2));

            每一格.point=point;
            背包.add(每一格);

            if(第几个x>=横向数量&&第几个y>=纵向数量){
                break;
            }
            if(第几个x>=横向数量){
                第几个x=1;
                第几个y++;
            }else {
                第几个x++;
            }




        }

    }

    static {
        分格();
    }











}
