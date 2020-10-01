import com.rtl.dao.DeptDao;
import com.rtl.po.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 *
 * @author rentianlun
 * @create 2020-10-01-9:18
 */
public class TestMyBatis {
    private InputStream is;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private DeptDao dd;

    @Before
    public void before() throws IOException {
        is= Resources.getResourceAsStream("mybtis-config.xml");
        sqlSessionFactory= new SqlSessionFactoryBuilder().build(is);
        sqlSession = sqlSessionFactory.openSession(true);
        dd = sqlSession.getMapper(DeptDao.class);
    }

    @org.junit.Test
    public void testSelectAll() throws IOException {
       dd.selectAll().forEach(System.out::println);

    }


    @Test
    public void testSelectOne(){
        Dept dept = dd.selectOne(7);
        System.out.println("dept = " + dept);
    }

    @Test
    public void testInsert(){
        Dept dept=new Dept();
        dept.setDept_name("添祥");
        int insert = dd.insert(dept);
        System.out.println("insert = " + insert);
    }

    @Test
    public void testDelete(){
        int delete = dd.delete(10);
        System.out.println("delete = " + delete);
    }
    @After
    public void after(){
        sqlSession.commit();
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
