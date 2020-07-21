package cam.aaa.service;


import com.aaa.base.ResultData;
import com.aaa.model.*;
import com.aaa.vo.TokenVo;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(value = "")
public interface IProjectService {
    /**
     * @author
     * @description
     *      执行登录操作
     * @param [user]
     * @date 2020/7/15
     * @return com.aaa.lee.base.ResultData
     * @throws
     **/
    @PostMapping("/doLogin")
    TokenVo doLogin(@RequestBody User user);

    /**
     * @author
     * @description
     *      新增日志
     * @param [loginLog]
     * @date 2020/7/15
     * @return java.lang.Integer
     * @throws
     **/
    @PostMapping("/addLoginLog")
    Integer addLoginLog(@RequestBody LoginLog loginLog);

    //查询子菜单
    @PostMapping("/selectMenu")
    List MenuInfo(@RequestBody MenuInfo menuInfo);

    //查询所有角色信息
    @RequestMapping("/selectAllRole")
    PageInfo selectAllRole(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize);

    //根据条件查询角色信息
    @RequestMapping("/selectRoleByfield")
    PageInfo selectRoleByField(@RequestBody Map map, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize);

    //根据主键查询角色信息
    @RequestMapping("/selectRoleByPrimaryKey")
    Role selectRoleByPrimaryKey(@RequestParam("roleId") Long roleId);

    //测绘管理 查询所有项目
    @RequestMapping("/selectALl")
    List<Mappingproject> selectAllProject();

    //将所有查询到的项目，进行分页
    @RequestMapping("/selectAllByPAge")
    PageInfo selectAllByPAge(@RequestBody Mappingproject mappingproject,
                             @RequestParam("pageNo") Integer pageNo,
                             @RequestParam("pageSize") Integer pageSize);

    //根据项目汇交类型查询
    @RequestMapping("/selectAllByType")
    List<Mappingproject> selectAllByType(@RequestParam(value = "projectType",required = false) String projectType);


    //模糊查询测绘项目名称
    @RequestMapping("/fuzzyProjectName")
    public List<Mappingproject> fuzzyProjectName(@RequestParam("projectName") String projectName);

    //根据parentId查询该部门即子部门
    @RequestMapping("/selectAllDeptByParentId")
    List<Dept> selectAllDeptByParentId(@RequestParam("parentId") Long parentId);

    //根据部门名称，创建时间，查询部门信息
    @RequestMapping("/selectDeptInfoByField")
    List<Dept> selectDeptInfoByField(@RequestBody Map map);

    //新增部门信息
    @RequestMapping("/insertDept")
    Boolean insertDept(@RequestBody Dept dept);

    //通过主键，删除操作
    @RequestMapping("/deleteDeptByPrimaryKey")
    Boolean deleteDeptByPrimaryKey(@RequestBody Dept dept);

    //调用父类批量删除方法，进行删除
    @RequestMapping("/batchDeleteByPrimaryKey")
    Boolean batchDeleteByPrimaryKey(@RequestBody List<Object> ids);

    //通过主键，修改部门信息
    @RequestMapping("/updateDeptByPrimaryKey")
    Boolean updateDeptByPrimaryKey(@RequestBody Dept dept);

    //查询字典信息
    @RequestMapping("/queryDict")
    List<Dict> selectDict();

    //新增字典信息
    @RequestMapping("/addDict")
    Integer addDict(@RequestBody Dict dict);

    //通过主键批量删除字典信息
    @RequestMapping("/deleteDict")
    Integer deleteDict(@RequestParam("dictIds") List<Object> dictIds);

    //修改字典信息
    @RequestMapping("/updateDict")
    Integer updateDict(@RequestBody Dict dict);

    //字典信息分页查询
    @RequestMapping("/queryDictAllPage")
    PageInfo<Dict> selectAllDictByPage(@RequestBody Dict dict, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize);


    //分页获取项目登记通过的项目信息
    @RequestMapping("/selectAuditInfo")
    PageInfo selectAuditInfo(@RequestParam("pageNo") Integer pageNo,
                             @RequestParam("pageSize") Integer pageSize);

    //模糊分页获取项目登记通过的项目信息
    @RequestMapping("/fuzzyQueryAduit")
    PageInfo fuzzyQueryAduit(@RequestParam("pageNo") Integer pageNo,
                             @RequestParam("pageSize") Integer pageSize,
                             @RequestParam("projectName") String projectName);

    //测绘管理--单位基本信息--单位基本信息
    @RequestMapping("/qureyMapping_unit")
    List<Mapping_unit> qureyMapping_unit(@RequestParam("userId") Long userId);

    //测绘管理--单位基本信息--测绘成果详情
    @RequestMapping("/selectResultDetails")
    ResultCommit selectResultDetails(@RequestParam("id") Long id);

    //测绘管理--单位基本信息--查询技术人员信息
    @RequestMapping("/qureyTechnicist")
    List<Technicist> qureyTechnicist(@RequestParam("userId") Long userId);

    //测绘管理--单位基本信息--修改技术人员信息
    @RequestMapping("/updateTechnicist")
    Boolean updateTechnicist(@RequestBody Technicist technicist);

    //测绘管理--单位基本信息--获取特殊岗位人员信息
    @RequestMapping("/qureySpecialPost")
    List<SpecialPost> selectSpecialPost(@RequestParam("userId") Long userId);

    //测绘管理--单位基本信息--获取仪器信息
    @RequestMapping("/qureyEquipment")
    List<Equipment> selectEquipment(@RequestParam("userId") Long userId);

    //获取负责人信息
    @RequestMapping("/queryPrincipal")
    List<Principal> queryOne(@RequestParam("userId") Long userId);

    //修改负责人信息
    @RequestMapping("/updateList")
    Boolean updateList(@RequestBody Principal principal);


    //项目管理 --查询所有项目
    @RequestMapping("/selectProjectInfo")
    PageInfo ProjectManagement(@RequestBody PageInfo pageInfo);

    //测绘管理--项目管理--通过Id查询项目
    @RequestMapping("selectById")
    ProjectInfo selectById(@RequestParam("id") Long id);

    //测绘管理--项目管理--通过id修改项目
    @RequestMapping("/updateById")
    Integer updateById(@RequestBody ProjectInfo manProject);

    //测绘管理--项目管理--根据项目类型查询
    @RequestMapping("/getInfoByType")
    List<ProjectInfo> getInfoByType(@RequestParam("projectType") String projectType);

    //测绘管理--项目管理--新增项目
    @RequestMapping("/insertInfo")
    int insertInfo(@RequestBody ProjectInfo projectInfo);

    //查询公告
    @RequestMapping("/News/selectNews")
    List<News> selectNews();

    //公告模糊查询
    @RequestMapping("/News/selectByTitle")
    ResultData selectByTitle(String title);

    //公告栏添加
    @RequestMapping ("/News/insertNews")
    Integer insertNews(News news);

    //公告栏删除
    @RequestMapping("/News/deleteNews")
    Integer deleteNews(List<Integer> ids);

    //公告栏修改
    @RequestMapping("/News/updateNews")
//    Integer updateNews(@RequestBody News news);
    ResultData updateNews(@RequestBody News news);





}
