package springA;


import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

import javax.lang.model.SourceVersion;
import javax.tools.Tool;

import mainpackage.AppConfig;

import java.util.Enumeration;
import java.util.Set;




public class ApplicationContextA{

private Class configclass;

private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<String, Object>();

private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();


public ApplicationContextA(Class configclass)  throws Exception{
	
	
	this.configclass=configclass;
	
	
	ComponentScan componentScan=(ComponentScan)configclass.getDeclaredAnnotation(ComponentScan.class);
	
	
	
    String path=componentScan.value();
    
    
    ClassLoader classLoader=ApplicationContextA.class.getClassLoader();
    URL url=classLoader.getResource(path);
    
    File file=new File(url.getFile());
        
    
    File[] files=file.listFiles();
    for(File f:files) {
    	
    	String filename=f.getAbsolutePath();
    	
    	if(filename.endsWith(".class")) {
    		
    	filename=filename.substring(filename.indexOf(path),filename.indexOf(".class"));
    	
    	filename=filename.replace("\\", ".");
    	
    	
    	try {
    	Class<?> class1=classLoader.loadClass(filename);
    	if(class1.isAnnotationPresent(Component.class)){
    		String beanName=class1.getDeclaredAnnotation(Component.class).value();
    		
    		BeanDefinition beanDefinition=new BeanDefinition();
    		beanDefinition.class1=class1;
    		
    		if(class1.isAnnotationPresent(Scope.class)) {
    			beanDefinition.scope=class1.getDeclaredAnnotation(Scope.class).value();

    			
    			
    		}else {
    			beanDefinition.scope="single";
    			
    		}
    		
    		beanDefinitionMap.put(beanName,beanDefinition);
    	
    	}
    	
    	
    	}catch(ClassNotFoundException e){
    	}
    	}
    	}
    
    
    Enumeration<String> e1=beanDefinitionMap.keys();
    
while(e1.hasMoreElements()){
	
	String beanName=e1.nextElement();
	
	BeanDefinition beanDefinition=beanDefinitionMap.get(beanName);
	

	if(beanDefinition.scope.equals("singleton")) {
		Object bean=createBean(beanDefinition);
		
		singletonObjects.put(beanName,bean);
		
		
	}
	
	
}


}


public Object createBean(BeanDefinition beanDefinition) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
	Class class1=beanDefinition.class1;
	Object o=class1.getDeclaredConstructor().newInstance();
	return o;
}


public Object getBean(String beanName) throws Exception{
	
	if(beanDefinitionMap.containsKey(beanName)){
		
		BeanDefinition beanDefinition=beanDefinitionMap.get(beanName);
		
		if(beanDefinition.scope.equals("singleton")){
			
			Object o=singletonObjects.get(beanName);
			
			
			return o;
			
		}else {
			
			Object bean=createBean(beanDefinition);
			return bean;
		}
	}
	

	
	return null;
}





}
