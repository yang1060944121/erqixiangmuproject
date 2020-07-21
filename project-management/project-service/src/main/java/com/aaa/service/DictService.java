package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.DictMapper;
import com.aaa.model.Dict;
import com.github.pagehelper.PageInfo;
import net.sf.jsqlparser.statement.execute.Execute;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

@Service
public class DictService extends BaseService<Dict> {
    @Autowired
    private DictMapper dictMapper;

    //查询字典信息
    public List<Dict> selectDict() {
        try {
            //查询所有字典信息
            List<Dict> dicts = dictMapper.selectAll();
            //判断查询结果是否为空
            if (dicts != null && !"".equals(dicts)) {
                //不为空返回查询结果
                return dicts;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //新增字典信息
    public Integer addDict(Dict dict) {
        //判断新增字典信息是否为空
        if (dict == null) {
            //不为空
            int insert = dictMapper.insert(dict);
            if (insert > 0) {
                return insert;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    //通过主键批量删除
    public Integer deleteDict(List<Object> dictIds) {
        //判断参数是否大于0
        if (dictIds.size() > 0) {
            try {
                //大于0，删除字典信息
                Integer integer = batchDelete(dictIds);
                //判断受影响几行
                if (integer > 0) {
                    return integer;
                } else {
                    return 0;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return 0;
        }
        return 0;
    }


    //修改字典信息
    public Integer updateDict(Dict dict) {
        //判断要修改的数据是否为空
        if (dict != null && !"".equals(dict)) {
            try {
                //不为空，调用父类方法执行修改操作
                Integer update = dictMapper.updateDict(dict);
                //判断受影响的行数
                if (update > 0) {
                    //如果大于0就返回
                    return update;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }


    //字典信息分页查询
    public PageInfo<Dict> selectAllDictBypage(Dict dict, Integer pageNo, Integer pageSize) {
        try {
            //调用父类分页方法把参数传进去查询
            PageInfo<Dict> dictPageInfo = queryListByPage(dict, pageNo, pageSize);
            //判断查询结果是否为空
            if (dictPageInfo != null && !"".equals(dictPageInfo)) {
                //不为空返回查询结果
                return dictPageInfo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }return null;
    }


    @Override
    public List<Dict> queryList(Dict dict) throws Exception{
        return super.queryList(dict);
    }

}
