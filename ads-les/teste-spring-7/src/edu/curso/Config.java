package edu.curso;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("edu.curso")
@EnableJpaRepositories(basePackages = {"edu.curso"}) 
public class Config implements WebMvcConfigurer {
	@Autowired
	private ApplicationContext applicationContext;
	@Bean
	public SpringResourceTemplateResolver templateResolver(){
		SpringResourceTemplateResolver tr = new SpringResourceTemplateResolver();
		tr.setApplicationContext(this.applicationContext);
		tr.setPrefix("/WEB-INF/views/");
		tr.setSuffix(".html");
		tr.setTemplateMode(TemplateMode.HTML);
		tr.setCacheable(true);
		return tr;
	}

	@Bean
	public SpringTemplateEngine templateEngine(){
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		templateEngine.setEnableSpringELCompiler(true);
		return templateEngine;
	}

	@Bean
	public ThymeleafViewResolver viewResolver(){
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setOrder(1);
		viewResolver.setViewNames(new String[] {".html", ".xhtml"});
		return viewResolver;
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine());
		registry.viewResolver(resolver);
	}

	@Bean
	public DataSource dataSource() {
		try {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
		    dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		    dataSource.setUsername("root");
		    dataSource.setPassword("");
		    dataSource.setUrl(
		    	"jdbc:mariadb://localhost/agendadb?createDatabaseIfNotExist=true"); 
		    return dataSource;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory());
	}
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		return new HibernateJpaVendorAdapter();
	}
	@Bean
	public Properties hibernateProperties() {
		Properties hibernateProp = new Properties();
		hibernateProp.put("hibernate.dialect", 
				"org.hibernate.dialect.MariaDB53Dialect");
		hibernateProp.put("hibernate.hbm2ddl.auto", "update");
		hibernateProp.put("hibernate.format_sql", false);
		hibernateProp.put("hibernate.use_sql_comments", true);
		hibernateProp.put("hibernate.show_sql", true);
		hibernateProp.put("hibernate.max_fetch_depth", 3);
		hibernateProp.put("hibernate.jdbc.batch_size", 10);
		hibernateProp.put("hibernate.jdbc.fetch_size", 50);
		return hibernateProp;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean =
				new LocalContainerEntityManagerFactoryBean();
		factoryBean.setPackagesToScan("edu.curso");
		factoryBean.setDataSource(dataSource());
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factoryBean.setJpaProperties(hibernateProperties());
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		factoryBean.afterPropertiesSet();
		return factoryBean.getNativeEntityManagerFactory();
	}
}
