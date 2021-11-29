import org.apache.ibatis.annotations.Select;


public interface aaamapper {


    @Select("SELECT ID_ FROM act_ru_identitylink where TASK_ID_ = #{id}")
    String aaa1(String id);
}
