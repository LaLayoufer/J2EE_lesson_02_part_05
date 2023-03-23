package baiyunu.edu.smbms.dao;

import java.util.List;
import java.util.Map;

import baiyunu.edu.smbms.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * 查询用户表记录数
     * @return
     */
    public int count();

    /**
     * 查询用户列表
     * @return
     */
    public List<User> getUserList();

    /**
     * 查询用户列表，返回包含角色名称
     * @return
     */
    public List<User> getAllUserWithRoleName();

    /**
     * 根据用户名称查询用户列表(模糊查询)
     * @param userName
     * @return
     */
    public List<User> getUserListByUserName(String userName);

    public List<User> getUserListByUserBean(User user);

    public List<User> getUserListByMap(Map<String, String> uMap);

    public List<User> getUserListWithRoleName(User user);

    public int add(User user);

    public int modify(User user);

    public int updatePwd(@Param("userId")Integer id, @Param("newPassword")String pwd);

    public int deleteByUserId(@Param("userId")Integer id);

    public List<User> getUserListByRoleId(@Param("userRole")Integer roleId);

    public List<User> getAddressListByUserId(@Param("userId")Integer userId);
}
