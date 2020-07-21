package com.aaa.controller;

import cam.aaa.service.IProjectService;
import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.Dict;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DictController extends BaseController {

    @Autowired
    private IProjectService iProjectService;

    //查询字典信息

    @RequestMapping("/queryDict")
    public ResultData selectDict(){
        try {
            List<Dict> dicts = iProjectService.selectDict();
            return getSuccess(dicts);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return getFalse();

    }

    @RequestMapping("/addDict")
    public ResultData addDict(@RequestBody Dict dict){
        Integer integer = iProjectService.addDict(dict);
        if (integer > 0){
            return addSuccess();
        }else {
            return addFalse();
        }
    }


    //通过主键批量删除字典信息
    @RequestMapping("/deleteDict")
    public ResultData deleteDict(@RequestParam("dictIds") List<Object> dictIds){
        Integer integer = iProjectService.deleteDict(dictIds);
        //判断受影响的行数是否大于0
        if (integer > 0){
            //大于0删除成功返回自定义信息
            return deleteSuccess();
        }else {
            return deleteFalse();
        }
    }


    //修改字典信息
    @RequestMapping("/updateDict")
    public ResultData updateDict(@RequestBody Dict dict){
        Integer integer = iProjectService.updateDict(dict);
        //判断受影响的行数
        if (integer > 0){
            return updateSuccess();
        }else {
            return updateFalse();
        }
    }


    //字典信息分页查询
    @RequestMapping("/queryDictAllPage")
    public ResultData selectAllDictByPage(Dict dict,Integer pageNo,Integer pageSize){
        try {
            PageInfo<Dict> dictPageInfo = iProjectService.selectAllDictByPage(dict,pageNo,pageSize);
            return getSuccess(dictPageInfo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return getFalse();
    }






}
