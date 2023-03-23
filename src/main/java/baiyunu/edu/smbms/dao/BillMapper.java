package baiyunu.edu.smbms.dao;

import baiyunu.edu.smbms.pojo.Bill;
import baiyunu.edu.smbms.pojo.Provider;

import java.util.List;


public interface BillMapper {
    /**
     * 查询订单表记录数
     * @return
     */
    public int count();
    /**
     * 查询订单列表
     * @return
     */
    public List<Bill> getBillList();
    /**
     * 根据供应商名称查询订单列表(id查询)
     * @param billId
     * @return
     */
    public List<Bill> getBillById(int billId);
}
