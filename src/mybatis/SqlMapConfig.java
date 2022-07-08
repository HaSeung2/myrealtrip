package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {
	private static SqlSessionFactory factory;
	
	//static블럭, 클래스 초기화 블럭	: 클래스가 처음 로딩될 대 처음만 실행	
	static {
		//static블럭은 처음 로딩할 때 시작임으로 현재폴더는 최상위 폴더임
		String resource = "./mybatis/config.xml";
		try {
			//Reader타입의 객체를 생성하여 resource경로를 담고
			Reader reader = Resources.getResourceAsReader(resource);
			//factory 변수에 객체 생성 코드를 작성하여 reader를 가져와 실행하도록 한다..
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException ioe) {
			System.out.println("초기화 문제 발생 : " + ioe);
		}
	}
	
	public static SqlSessionFactory getFactory() {
		//getFactory 메소드를 실행하면 이 factory변수를 불러와 객체를 만들도록 함.
		return factory;
	}
}
