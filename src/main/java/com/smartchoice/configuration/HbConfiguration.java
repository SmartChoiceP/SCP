package com.smartchoice.configuration;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import oracle.jdbc.pool.OracleDataSource;


@Configuration
//@ConfigurationProperties("oracle")
@EnableTransactionManagement
public class HbConfiguration {
	
	@Value("${db.driver}")
	private String DB_DRIVER;
	
	@Value("${db.url}")
	private String DB_URL;
	
	@Value("${db.password}")
	private String DB_PASSWORD;
	
	@Value("${db.username}")
	private String DB_USERNAME;
	
	@Value("${hibernate.dialect}")
	private String HIBERNATE_DIALECT;
	
	@Value("${hibernate.show_sql}")
	private String HIBERNATE_SHOW_SQL;
	
	@Value("${hibernate.hbm2ddl.auto}")
	private String HIBERNATE_HBM2DDL_AUTO;
	
	@Value("${entitymanager.packagesToScan}")
	private String ENTITYMANAGER_PACKAGES_TO_SCAN;
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() throws SQLException
	{
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
		Properties hbproperties=new Properties();
		hbproperties.put("hibernate.dialect", HIBERNATE_DIALECT);
		hbproperties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
		hbproperties.put("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
		sessionFactory.setHibernateProperties(hbproperties);
		return sessionFactory;
	}
	
	@Bean
	public DataSource dataSource() throws SQLException
	{
		/*DriverManagerDataSource dsource=new DriverManagerDataSource();
		dsource.setDriverClassName(DB_DRIVER);
		dsource.setUrl(DB_URL);
		dsource.setUsername(DB_USERNAME);
		dsource.setPassword(DB_PASSWORD);*/
		OracleDataSource dsource = new OracleDataSource();
		dsource.setURL(DB_URL);
		dsource.setUser(DB_USERNAME);
		dsource.setPassword(DB_PASSWORD);
        return dsource;
	}
	
	@Bean
    public HibernateTransactionManager transactionManager() throws SQLException {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(sessionFactory().getObject());
       return txManager;
    }


    private int maxUploadSizeInMb = 5 * 1024 * 1024; // 5 MB


    @Bean
    public CommonsMultipartResolver multipartResolver() {

        CommonsMultipartResolver cmr = new CommonsMultipartResolver();
        cmr.setMaxUploadSize(maxUploadSizeInMb * 2);
        cmr.setMaxUploadSizePerFile(maxUploadSizeInMb); //bytes
        return cmr;

    }

}




