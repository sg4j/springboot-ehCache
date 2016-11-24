package com.petclinic.config;



import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jmx.support.MBeanServerFactoryBean;

import net.sf.ehcache.CacheManager;

@Configuration
@EnableCaching
@ComponentScan({ "com.petclinic.entity.*" })
public class CachingConfiguration {

	@Bean
	@Primary
	public net.sf.ehcache.CacheManager cacheManager() {
		CacheManager cacheManager = ehCache().getObject();
		//cacheManager.setName("petCache");
		return (cacheManager);
	}

	@Bean
	public EhCacheManagerFactoryBean ehCache() {
		EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
		cmfb.setConfigLocation(new ClassPathResource("ehCache.xml"));
		cmfb.setShared(true);
		return cmfb;
	}
	
	@Bean
	public MBeanServerFactoryBean mbeanServer(){
		
		MBeanServerFactoryBean mBeanServerFactory = new MBeanServerFactoryBean();
		mBeanServerFactory.setLocateExistingServerIfPossible(true);
		return(mBeanServerFactory);
	}
}