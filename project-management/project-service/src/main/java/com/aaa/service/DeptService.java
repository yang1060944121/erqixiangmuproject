package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.DeptMapper;
import com.aaa.model.Dept;
import com.aaa.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Service
public class DeptService extends BaseService<Dept> {
    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private RedisService<Dept> redisService;

    //根据parentId查询部门以及子部门
    public List<Dept> selectAllDeptByParentId(Integer parentId){
        //调用selectDeptByparentId方法，查询父部门信息
        List<Dept> allDept = deptMapper.selectDeptByParentId(parentId);

        //判断查询结果是否为空
        if (allDept.size() > 0 && allDept != null) {
            //结果不为空
            for (Dept dept : allDept){
                //获取父部门的id，作为子部门的父id进行查询
                Integer id1 = dept.getDeptId();
                List<Dept> children = deptMapper.selectDeptByParentId(id1);
                //将结果放到children中
                dept.setChildren(children);
            }
            return allDept;
        }else {
            return null;
        }
    }

    //根据部门名称，创建时间，查询部门信息
    public List<Dept> selectDeptInfoByField(Map map) {
        List<Dept> deptList = null;
        try {
            //调用selectDeptInfoByField方法查询部门信息
            deptList=deptMapper.selectDeptInfoByField(map);
        }catch (Exception e){
            e.printStackTrace();
        }
        //判断查询结果是否为空
        if (deptList == null && deptList.size() > 0) {
            //查询成功
            return deptList;
        }else {
            //查询失败，返回null
            return null;
        }


    }

    //新增部门信息
    public Boolean insertDept(Dept dept){
        //查看前端传值是否为空
        if (dept == null && !"".equals(dept)) {
            int i = 0;
            try {
                //获取当前时间
                Date date = new Date();
                //日期格式
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
                String format = simpleDateFormat.format(date);

                //获取前端参数，传入dept1中
                Dept dept1 = dept.setDeptName(dept.getDeptName())
                        .setOrderNum(dept.getOrderNum())
                        .setParentId(dept.getParentId())
                        .setCreateTime(format);
                i = super.add(dept1);
            }catch (Exception e){
                e.printStackTrace();
            }
            if (i > 0) {
                return  true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    //通过主键，执行删除操作
    public Boolean deletDeptByprimaryKey(Dept deptId){
        //判断值是否为空
        if (deptId != null && !"".equals(deptId)) {
            Integer delete = null;

            try {
                // 说明前端传值成功，调用父类BaseService的delete方法，执行删除操作
                delete = delete(deptId);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 判断 受影响行数是否大于0，删除是否成功
            if (delete > 0) {
                // 删除成功，返回true
                return true;
            }else {
                // 删除失败，返回false
                return false;
            }
        }else {
            // 前端传参失败，返回false 删除失败
            return false;
        }
        }

        //批量删除 调用父类的批量删除方法（根据主键），执行删除操作
        public Boolean batchDeleteByPrimaryKey(List<Object> ids) {
            // 判断 前端传值是否为空
            if (null != ids && !"".equals(ids)) {
                Integer batchDelete = null;

                try {
                    // 调用父类的批量删除方法
                    batchDelete = super.batchDelete(ids);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // 判断 受影响行数是否大于0，删除是否成功
                if (batchDelete > 0) {
                    // 删除成功，返回true
                    return true;
                }else {
                    // 删除失败，返回false
                    return false;
                }
            }else {
                // 前端传参失败，返回false 删除失败
                return false;
            }
        }

        //通过主键-修改部门信息
        public Boolean updateDeptByPrimaryKey(Dept dept) {
            // 判断 前端传值是否为空
            if (null != dept && !"".equals(dept)) {
                Integer update = null;
                try {
                    // 获取当前时间
                    Date date = new Date();
                    // 设置日期格式
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String format = simpleDateFormat.format(date);

                    // 获取前端传递的参数，放入 dept1 中
                    Dept dept1 = dept.setDeptId(dept.getDeptId())
                            .setDeptName(dept.getDeptName())
                            .setOrderNum(dept.getOrderNum())
                            .setParentId(dept.getParentId())
                            .setModifyTime(format);

                    // 调用父类的update方法，更新部门信息
                    update = super.update(dept1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // 判断 受影响行数是否大于0，修改是否成功
                if (update > 0) {
                    // 说明修改成功，返回true
                    return true;
                }else {
                    // 删除失败，返回false
                    return false;
                }
            }else {
                // 前端传参失败，返回false 删除失败
                return false;
            }
        }

}
