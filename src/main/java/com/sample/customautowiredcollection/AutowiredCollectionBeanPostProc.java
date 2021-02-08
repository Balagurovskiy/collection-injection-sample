package com.sample.customautowiredcollection;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

/**
 *  - find bean fields with custom annotation
 * 	- extract values (classes) from annotation
 *  - convert class name to bean name
 *  - get beans with such name from context
 *  - inject that beans to the annotated field (hopefully it will be a collection)
 *  
 * @author OlexiySergiyovich
 *
 */

@Component
public class AutowiredCollectionBeanPostProc implements BeanPostProcessor{

	@Autowired
	private ApplicationContext _appContext;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		Set<Field> fields = Arrays.stream( bean.getClass().getDeclaredFields() )
									.filter(field -> field.isAnnotationPresent(AutowiredCollection.class))
									.collect(Collectors.toSet() );
		
		for (Field field : fields) {
			if (Collection.class.isAssignableFrom(field.getType())) {
				AutowiredCollection ann = field.getAnnotation(AutowiredCollection.class);
				List<Object> bList = Arrays.stream( ann.value() )
											.map(clazz -> lowerFirstLetter( clazz.getSimpleName() ))
											.map(name -> _appContext.getBean(name))
											.collect(Collectors.toList() );
				field.setAccessible(true);
				ReflectionUtils.setField(field, bean, bList);
//				try {
//					field.set(bean, bList);
//				} catch (IllegalArgumentException | IllegalAccessException e) {
//					e.printStackTrace();
//				}
			}
		} 
		return bean;
	}

	private String lowerFirstLetter(String str) {
		if (str == null || str.length() == 0) {
			throw new IllegalArgumentException();
		}
		String first = str.substring(0, 1).toLowerCase();
		String last = str.substring(1);
		return first + last;
	}
}
