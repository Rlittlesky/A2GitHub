import com.rtl.dao.DeptDao;
import com.rtl.po.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author rentianlun
 * @create 2020-10-01-9:02
 */
public class MyTest {

    @org.junit.Test
    public void before(){
        System.out.println("MyTest.before");
    }

    @org.junit.Test
    public void test(){
        System.out.println("MyTest.test");
    }

    @Test
    public void after(){
        System.out.println("MyTest.after");
    }

}
