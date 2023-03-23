package baiyunu.edu.smbms.dao;

import java.util.List;

import baiyunu.edu.smbms.pojo.Provider;


public interface ProviderMapper {
    /**
     * 查询供应商表记录数
     * @return
     */
    public int count();
    /**
     * 查询供应商列表
     * @return
     */
    public List<Provider> getProviderList();
    /**
     * 根据供应商名称查询供应商列表(模糊查询)
     * @param proName
     * @return
     */
    public List<Provider> getProviderListByProName(String proName);

    public List<Provider> getBillListByProId(int proId);
}
