package cam.aaa.service;


import com.aaa.model.LoginLog;
import com.aaa.model.Mappingproject;
import com.aaa.model.MenuInfo;
import com.aaa.model.User;
import com.aaa.vo.TokenVo;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

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

    //测绘管理 查询所有项目
    @RequestMapping("/selectALl")
    List<Mappingproject> selectAllProject();

    //将所有查询到的项目，进行分页
    @RequestMapping("/selectAllByPAge")
    PageInfo selectAllByPAge(@RequestBody Mappingproject mappingproject,
                             @RequestParam("pageNo") Integer pageNo,
                             @RequestParam("pageSize") Integer pageSize);

    //根据项目汇交类型查询
    @RequestMapping("/selectAllBYResultsstatus")
    List<Mappingproject> selectAllBYResultsstatus(@RequestParam(value = "Resultsstatus",required = false) String Resultsstatus);


    //模糊查询测绘项目名称
    @RequestMapping("/fuzzyProjectName")
    public List<Mappingproject> fuzzyProjectName(@RequestParam("projectName") String projectName);



}
