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
@ComponentScan("edu.curso")
@EnableWebMvc   
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"edu.curso"})
public class Config implements WebMvcConfigurer {
	@Autowired
	ApplicationContext ctx;

	@Bean
	public SpringResourceTemplateResolver templateResolver(){
		SpringResourceTemplateResolver tr = new SpringResourceTemplateResolver();
		tr.setApplicationContext(this.ctx);
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
		// viewResolver.setViewNames(new String[] {".html", ".xhtml"});
		return viewResolver;
	}

	@Bean
	public DataSource dataSource() { 
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl("jdbc:mariadb://localhost:3306/jogosdb");
		ds.setUsername("root");
		ds.setPassword("");
		ds.setDriverClassName("org.mariadb.jdbc.Driver");
		return ds;
	}

	@Bean
	public Properties hibernateProperties() { 
		Properties p = new Properties();
		p.put("hibernate.dialect", 
				"org.hibernate.dialect.MariaDB53Dialect");
		p.put("hibernate.hbm2ddl.auto", "update");
		p.put("hibernate.format_sql", false);
		p.put("hibernate.use_sql_comments", true);
		p.put("hibernate.show_sql", true);
		p.put("hibernate.max_fetch_depth", 3);
		p.put("hibernate.jdbc.batch_size", 10);
		p.put("hibernate.jdbc.fetch_size", 50);
		return p;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		return new HibernateJpaVendorAdapter();
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean =
			new LocalContainerEntityManagerFactoryBean();
		factoryBean.setPackagesToScan("edu.curso");
		factoryBean.setDataSource(dataSource());
		factoryBean.setJpaProperties(hibernateProperties());
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		factoryBean.afterPropertiesSet();
		return factoryBean.getNativeEntityManagerFactory();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory());
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.viewResolver(viewResolver());
	}
} 