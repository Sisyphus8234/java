package xxxpackage;

import javax.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.*;

//spring会自动把首字母大写转小写变成beanid
//一个类大于等于2个连续大写字母开头，spring不会把首字母转小写变成id，什么都不会变就是beanid
//@Component("xxxid")也可以主动定beanid

@Component
//@Scope("prototype") //多例
//@Lazy //在单例模式下，懒加载，取的时候再加载
//注解上下不影响加载顺序
public class User {

	@Autowired // 自动装配。
	           //?优先byType,如果找到多个，用byName进一步筛选
	//@Resource(name="userDao")也可以，参数可以不要，优先byName
	private UserDao u;

	public void doPost() {
		u.login();
	}

	@PostConstruct
	public void init() {
		System.out.println("初始化");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("销毁");
	}
}

//@Component  通用注解，不满足以下3种一般用这种
//@Controller  控制器组件
//@Service  业务组件
//@Repository  持久化组件 Dao
//以上注解在spring作用域等效，只是语义不同