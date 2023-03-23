package baiyunu.edu.smbms;

// import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import baiyunu.edu.smbms.dao.BillMapper;
import baiyunu.edu.smbms.pojo.Bill;
import baiyunu.edu.smbms.utils.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
// import org.apache.log4j.Logger;

import baiyunu.edu.smbms.dao.UserMapper;
import baiyunu.edu.smbms.dao.ProviderMapper;
import baiyunu.edu.smbms.pojo.User;
import baiyunu.edu.smbms.pojo.Address;
import baiyunu.edu.smbms.pojo.Provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;
import java.text.SimpleDateFormat;

public class UserMapperTest {

    // private Logger logger = Logger.getLogger(UserMapperTest.class);


    public static void testBillCount() {
        System.out.println("------------> test Billcount function START");

        SqlSession sqlSession = null;
        try {
            //3 创建sqlSession
            sqlSession = MyBatisUtil.createSqlSession();
            //4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
            int countFromSQL = sqlSession.selectOne("baiyunu.edu.smbms.dao.BillMapper.count");
            int countFromDAOInterface = sqlSession.getMapper(BillMapper.class).count();

            System.out.println("Billcount from SQL result ---> " + countFromSQL);
            System.out.println("Billcount from DAO Interface result ---> " + countFromDAOInterface);
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            MyBatisUtil.createSqlSession();
        }

        System.out.println("------------> test Billcount function END");
    }

    public static void testCount() {
        System.out.println("------------> test count function START");

        SqlSession sqlSession = null;
        try {
            //3 创建sqlSession
            sqlSession = MyBatisUtil.createSqlSession();
            //4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
            int countFromSQL = sqlSession.selectOne("baiyunu.edu.smbms.dao.UserMapper.count");
            int countFromDAOInterface = sqlSession.getMapper(UserMapper.class).count();

            System.out.println("count from SQL result ---> " + countFromSQL);
            System.out.println("count from DAO Interface result ---> " + countFromDAOInterface);
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            MyBatisUtil.createSqlSession();
        }

        System.out.println("------------> test count function END");
    }
    public static void testGetAllBill() {
        System.out.println("------------> test get all bill function START");

        SqlSession sqlSession = null;
        try {
            //3 创建sqlSession
            sqlSession = MyBatisUtil.createSqlSession();

            List<Bill> userListFromSQL = new ArrayList<>();
            List<Bill> userListFromDAOInterface = new ArrayList<>();

            //第一种方式:调用selectList方法执行查询操作
            userListFromSQL = sqlSession.selectList("baiyunu.edu.smbms.dao.BillMapper.getBillList");
            //第二种方式:调用getMapper(Mapper.class)执行dao接口方法来实现对数据库的查询操作
            userListFromDAOInterface = sqlSession.getMapper(BillMapper.class).getBillList();
            for (Bill user: userListFromSQL) {
                System.out.println("bill list from SQL, result: " + user.toString());
            }

            for (Bill user: userListFromDAOInterface) {
                System.out.println("bill list from DAO Interface, result: " + user.toString());
            }

        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            MyBatisUtil.createSqlSession();
        }

        System.out.println("------------> test get all bill function END");
    }

    public static void testGetAllUser() {
        System.out.println("------------> test get all user function START");

        SqlSession sqlSession = null;
        try {
            //3 创建sqlSession
            sqlSession = MyBatisUtil.createSqlSession();

            List<User> userListFromSQL = new ArrayList<User>();
            List<User> userListFromDAOInterface = new ArrayList<User>();

            //第一种方式:调用selectList方法执行查询操作
            userListFromSQL = sqlSession.selectList("baiyunu.edu.smbms.dao.UserMapper.getUserList");
            //第二种方式:调用getMapper(Mapper.class)执行dao接口方法来实现对数据库的查询操作
            userListFromDAOInterface = sqlSession.getMapper(UserMapper.class).getUserList();
            for (User user: userListFromSQL) {
                System.out.println("user list from SQL, result: " + user.toString());
            }

            for (User user: userListFromDAOInterface) {
                System.out.println("user list from DAO Interface, result: " + user.toString());
            }

        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            MyBatisUtil.createSqlSession();
        }

        System.out.println("------------> test get all user function END");
    }

    public static void testGetAllUserWithRoleName() {
        System.out.println("------------> test get all user with role name function START");

        SqlSession sqlSession = null;
        try {
            //3 创建sqlSession
            sqlSession = MyBatisUtil.createSqlSession();

            List<User> userListFromDAOInterface = new ArrayList<User>();

            userListFromDAOInterface = sqlSession.getMapper(UserMapper.class).getAllUserWithRoleName();

            for (User user: userListFromDAOInterface) {
                System.out.println("user list from DAO Interface with role name, result: " + user.toString());
            }

        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            MyBatisUtil.createSqlSession();
        }

        System.out.println("------------> test get all user with role name function END");
    }

    public static void testGetUserByName() {
        System.out.println("------------> test get user by name function START");

        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            List<User> userList = new ArrayList<User>();
            userList = sqlSession.getMapper(UserMapper.class).getUserListByUserName("孙");
            for (User user: userList) {
                System.out.println("user list by name, result: " + user.toString());
            }
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            MyBatisUtil.createSqlSession();
        }

        System.out.println("------------> test get user by name function END");
    }

    public static void testGetUserByBean() {
        System.out.println("------------> test get user by bean function START");

        SqlSession sqlSession = null;
        try {
            //3 创建sqlSession
            sqlSession = MyBatisUtil.createSqlSession();

            List<User> userList = new ArrayList<User>();
            User userBean = new User();
            userBean.setUserName("孙");
            userBean.setUserRole(3);
            userList = sqlSession.getMapper(UserMapper.class).getUserListByUserBean(userBean);
            for (User user: userList) {
                System.out.println("user list from bean query, result: " + user.toString());
            }
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            MyBatisUtil.createSqlSession();
        }

        System.out.println("------------> test get user by bean function END");
    }

    public static void testGetUserByMap() {
        System.out.println("------------> test get user by map function START");

        SqlSession sqlSession = null;
        try {
            //3 创建sqlSession
            sqlSession = MyBatisUtil.createSqlSession();

            List<User> userList = new ArrayList<User>();
            Map<String, String> userMap = new HashMap<String, String>();
            userMap.put("uName", "孙");
            userMap.put("uRole", "2");
            userList = sqlSession.getMapper(UserMapper.class).getUserListByMap(userMap);
            for (User user: userList) {
                System.out.println("user list from map query, result: " + user.toString());
            }
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            MyBatisUtil.createSqlSession();
        }

        System.out.println("------------> test get user by map function END");
    }

    public static void testGetUserByBeanWithRoleName() {
        System.out.println("------------> test get user by bean with role name function START");

        SqlSession sqlSession = null;
        try {
            //3 创建sqlSession
            sqlSession = MyBatisUtil.createSqlSession();

            List<User> userList = new ArrayList<User>();
            User userBean = new User();
            userBean.setUserName("孙");
            userBean.setUserRole(3);
            userList = sqlSession.getMapper(UserMapper.class).getUserListWithRoleName(userBean);
            for (User user: userList) {
                System.out.println("user list from bean query, result: " + user.toString());
            }
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            MyBatisUtil.createSqlSession();
        }

        System.out.println("------------> test get user by bean with role name function END");
    }

    public static void testAddUser() {
        System.out.println("------------> test add user function START");

        SqlSession sqlSession = null;
        int count = 0;
        try {
            //3 创建sqlSession
            sqlSession = MyBatisUtil.createSqlSession();

            User user = new User();
            user.setUserCode("test001");
            user.setUserName("测试用户001");
            user.setUserPassword("1234567");
            Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse("1984-12-12");
            user.setBirthday(birthday);
            user.setCreationDate(new Date());
            user.setAddress("地址测试");
            user.setGender(1);
            user.setPhone("13688783697");
            user.setUserRole(1);
            user.setCreatedBy(1);
            user.setCreationDate(new Date());

            count = sqlSession.getMapper(UserMapper.class).add(user);

            //模拟异常，进行回滚
            //int i = 2/0;
            sqlSession.commit();
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            sqlSession.rollback();
            count = 0;
        }
        finally {
            MyBatisUtil.createSqlSession();
        }

        System.out.println("add new user, added count: " + count);
        System.out.println("------------> test add user function END");
    }

    public static void testModifyUser() {
        System.out.println("------------> test modify user function START");

        SqlSession sqlSession = null;
        int count = 0;
        try {
            //3 创建sqlSession
            sqlSession = MyBatisUtil.createSqlSession();

            User user = new User();
            user.setId(18);
            user.setUserCode("test888");
            user.setUserName("测试用户888");
            user.setUserPassword("7654321");
            Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse("1994-12-12");
            user.setBirthday(birthday);
            user.setCreationDate(new Date());
            user.setAddress("广州");
            user.setGender(1);
            user.setPhone("18702013837");
            user.setUserRole(1);
            user.setCreatedBy(1);
            user.setCreationDate(new Date());

            count = sqlSession.getMapper(UserMapper.class).modify(user);

            //模拟异常，进行回滚
            //int i = 2/0;
            sqlSession.commit();
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            sqlSession.rollback();
            count = 0;
        }
        finally {
            MyBatisUtil.createSqlSession();
        }

        System.out.println("modify user, modified count: " + count);
        System.out.println("------------> test modify user function END");
    }

    public static void testUpdateUserPassword() {
        System.out.println("------------> test update user password function START");

        SqlSession sqlSession = null;
        int count = 0;
        try {
            //3 创建sqlSession
            sqlSession = MyBatisUtil.createSqlSession();

            Integer id = 18;
            String password = "&UJMNHY^";
            count = sqlSession.getMapper(UserMapper.class).updatePwd(id, password);

            //模拟异常，进行回滚
            //int i = 2/0;
            sqlSession.commit();
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            sqlSession.rollback();
            count = 0;
        }
        finally {
            MyBatisUtil.createSqlSession();
        }

        System.out.println("modify user, modified count: " + count);
        System.out.println("------------> test update user password function END");
    }

    public static void testDeleteUser() {
        System.out.println("------------> test delete user function START");

        SqlSession sqlSession = null;
        int count = 0;
        try {
            //3 创建sqlSession
            sqlSession = MyBatisUtil.createSqlSession();

            Integer id = 22;
            count = sqlSession.getMapper(UserMapper.class).deleteByUserId(id);

            //模拟异常，进行回滚
            //int i = 2/0;
            sqlSession.commit();
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            sqlSession.rollback();
            count = 0;
        }
        finally {
            MyBatisUtil.createSqlSession();
        }

        System.out.println("delete user, deleted count: " + count);
        System.out.println("------------> test delete user function END");
    }

    public static void testGetUserListByRoleId() {
        System.out.println("------------> test get user by role id function START");

        SqlSession sqlSession = null;
        try {
            //3 创建sqlSession
            sqlSession = MyBatisUtil.createSqlSession();

            List<User> userList = new ArrayList<User>();
            Integer roleId = 3;
            userList = sqlSession.getMapper(UserMapper.class).getUserListByRoleId(roleId);
            for (User user: userList) {
                System.out.println("user list from bean query, result: " + user.toString());
                System.out.println("roleId: " + user.getRole().getId() + "--" + user.getRole().getRoleCode() + "--" + user.getRole().getRoleName());
            }
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            MyBatisUtil.createSqlSession();
        }

        System.out.println("------------> test get user by role id function END");
    }

    public static void testGetAddressListByUserId() {
        System.out.println("------------> test get user address by user id function START");

        SqlSession sqlSession = null;
        try {
            //3 创建sqlSession
            sqlSession = MyBatisUtil.createSqlSession();

            List<User> userList = new ArrayList<User>();
            Integer userId = 1;
            userList = sqlSession.getMapper(UserMapper.class).getAddressListByUserId(userId);
            for (User user: userList) {
                System.out.println("user list from bean query, result: " + user.getUserName());

                for(Address address : user.getAddressList()){
                    System.out.println("address ----> id: " + address.getId() + ", contact: " + address.getContact()
                            + ", addressDesc: " + address.getAddressDesc() + ", tel: " + address.getTel()
                            + ", postCode: " + address.getPostCode()+ ", userId: " + address.getUserId());
                }
            }

        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            MyBatisUtil.createSqlSession();
        }

        System.out.println("------------> test get user address by user id function END");
    }

    public static void testGetProviderList(){
        System.out.println("------------> test get provider list function BEGIN");

        SqlSession sqlSession = null;
        List<Provider> providerList = new ArrayList<Provider>();
        try {
            sqlSession = MyBatisUtil.createSqlSession();

            //第一种方式:调用selectList方法执行查询操作
            //providerList = sqlSession.selectList("cn.smbms.dao.provider.ProviderMapper.getProviderList");

            //第二种方式:调用getMapper(Mapper.class)执行dao接口方法来实现对数据库的查询操作
            providerList = sqlSession.getMapper(ProviderMapper.class).getProviderList();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            MyBatisUtil.closeSqlSession(sqlSession);
        }
        for(Provider provider: providerList){
            System.out.println("testGetProviderList proCode: " + provider.getProCode() + " and proName: " + provider.getProName());
        }

        System.out.println("------------> test get provider list function END");
    }

    public static void testGetgetBillListByProId() {
        System.out.println("------------> test get provider bill by provider id function START");

        SqlSession sqlSession = null;
        try {
            //3 创建sqlSession
            sqlSession = MyBatisUtil.createSqlSession();

            List<Provider> userList = new ArrayList<>();
            int userId = 1;
            userList = sqlSession.getMapper(ProviderMapper.class).getBillListByProId(userId);
            for (Provider user: userList) {
                System.out.println("provider list from bean query, result: " + user.getProName());

                for(Bill address : user.getBillList()){
                    System.out.println("公司:"+user.getProName()+"    订单:  "+address.toString());
                }
            }

        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            MyBatisUtil.createSqlSession();
        }

        System.out.println("------------> test get user address by user id function END");
    }

    public static void main(String[] args)  {

        System.out.println("--------------BillMapper test start");
        testBillCount();
        System.out.println("\n==========================================================================");
        testGetAllBill();
        System.out.println("\n==========================================================================");

        testGetgetBillListByProId();

    }
}


