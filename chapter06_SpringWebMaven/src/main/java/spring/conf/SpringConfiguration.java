package spring.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:spring/db.properties")
@EnableTransactionManagement
public class SpringConfiguration { //이 파일은 일반자바 파일이 아니다 applicationContext.xml과 같은 환경설정 파일이다. 
	
	
	private @Value("${jdbc.driver}")
	 String driver;
	
	private @Value("${jdbc.url}")
	 String url;
	
	private @Value("${jdbc.username}")
	 String username;
	
	private @Value("${jdbc.password}")
	 String password;
	
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(driver);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
		
		
		return basicDataSource; 	
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("spring/mybatis-config.xml"));
		sqlSessionFactoryBean.setMapperLocations(new ClassPathResource("user/dao/userMapper.xml"));
		
		return sqlSessionFactoryBean.getObject(); //sqlsessionfactory를 return해주는 메소드이다. 
	}
	
	@Bean
	public SqlSessionTemplate sqlSession()  throws Exception {
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
		return sqlSessionTemplate;
		
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager() {
		 return new DataSourceTransactionManager(dataSource()); 
	}

}

/*
만약에 mapper.xml이 여러개인 경우 

1.
sqlSessionFactoryBean.setMapperLocations(new ClassPathResource("user/dao/userMapper.xml"),
										(new ClassPathResource("member/dao/memberMapper.xml"),
										(new ClassPathResource("board/dao/boardMapper.xml"),
										...);
이런식으로 지정해주면 됨 


2.
Field에다가 autowired를 걸어주면서
@Autowired
private ApplicationContext context; 
*/
//sqlSessionFactoryBean.setMapperLocations(context.getResources("classpath:*/dao/*Mapper.xml"));
