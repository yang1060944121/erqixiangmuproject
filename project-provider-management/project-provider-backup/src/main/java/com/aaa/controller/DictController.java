package com.aaa.controller;

import com.aaa.model.Dict;
import com.aaa.service.DictService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DictController {
    @Autowired
    private DictService dictService;


    //查询字典信息
    @RequestMapping("/queryDict")
    public List<Dict> selectDIct(){
        try {
            List<Dict> dicts = dictService.selectDict();
            return dicts;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    //新增字典信息
    @RequestMapping("/addDict")
    public Integer addDict(@RequestBody Dict dict){
        return dictService.addDict(dict);
    }

    //通过主键批量删除字典信息
    @RequestMapping("/deleteDict")
    public Integer deleteDict(@RequestParam("dictIds") List<Object> dictIds) {
        return dictService.deleteDict(dictIds);
    }

    //修改字典信息
    @RequestMapping("/updateDict")
    public Integer updateDict(@RequestBody Dict dict) {
        return dictService.updateDict(dict);
    }

    //字典分页查询
    @RequestMapping("/queryDictAllpage")
    public PageInfo<Dict> selectAllDictByPage(@RequestBody Dict dict, @RequestParam("pageNo") Integer pageNo
            ,@RequestParam("pageSize") Integer pageSize){
        try {
            PageInfo pageInfo = dictService.selectAllDictBypage(dict,pageNo,pageSize);
            return pageInfo;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //根据条件查询
    @RequestMapping("/queryDictList")
    public List<Dict> selectDictList(@RequestBody Dict dict){
        try {
            List<Dict> dicts =dictService.queryList(dict);
            return dicts;
        }catch (Exception e){
            e.printStackTrace();
        }return null;
    }

}
