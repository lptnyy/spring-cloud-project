package com.wzy.service;
import com.wzy.common.method.ProParameter;
import com.wzy.common.oauth.VaRole;
import com.wzy.common.oauth.VaUser;
import com.wzy.common.util.MessageType;
import com.wzy.common.util.ServiceResponse;
import com.wzy.system.IProMenuService;
import com.wzy.system.IProRoleMenuService;
import com.wzy.system.IProUserRoleService;
import com.wzy.system.UserService;
import com.wzy.system.dto.ProMenu;
import com.wzy.system.dto.ProRoleMenu;
import com.wzy.system.dto.ProUser;
import com.wzy.system.dto.ProUserRole;
import com.wzy.system.request.ProMenuRequest;
import com.wzy.system.request.ProRoleMenuRequest;
import com.wzy.system.request.ProUserRoleRequest;
import com.wzy.system.request.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OAuth2UserService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Autowired
    IProMenuService proMenuService;

    @Autowired
    IProUserRoleService proUserRoleService;

    @Autowired
    IProRoleMenuService proRoleMenuService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User userPar = new User();
        userPar.setUserName(s);
        ServiceResponse<ProUser> response = userService.userNameGetUser(new ProParameter<User>().setObj(userPar));
        if (response.getCode() == MessageType.SUCCESS.getValue()){
            ProUser user = response.getObj();
            VaUser vaUser = null;
            if (user != null) {
                try {

                    // 获取用户角色信息
                    ProUserRoleRequest userRoleRequest = new ProUserRoleRequest();
                    userRoleRequest.setUserId(user.getUserId());
                    ServiceResponse<List<ProUserRole>> userRoleResponse = proUserRoleService.getList(new ProParameter<>(userRoleRequest));
                    // 查看服务是否正常执行
                    userRoleResponse.checkState();

                    // 获取返回结果 获取所有的角色id
                    List<ProUserRole> userRoles = userRoleResponse.getObj();
                    List<Integer> roleIds = userRoles.stream().map(op -> op.getRoleId()).collect(Collectors.toList());

                    // 角色id 获取所有角色菜单id
                    ProRoleMenuRequest proRoleMenuRequest = new ProRoleMenuRequest();
                    proRoleMenuRequest.setRoleId(1); // 使用ids 随意输入 起到标记作用 查询哪个字段
                    proRoleMenuRequest.setIds(roleIds); // 通过id数组进行in查询
                    ServiceResponse<List<ProRoleMenu>> proRoleMenuResponse = proRoleMenuService.findIdsList(new ProParameter<>(proRoleMenuRequest));
                    // 查看服务是否正常执行
                    proRoleMenuResponse.checkState();

                    // 获取所有menuid
                    List<ProRoleMenu> proRoleMenus = proRoleMenuResponse.getObj();
                    List<Integer> menuIds = proRoleMenus.stream().map(op -> op.getMenuId()).distinct().collect(Collectors.toList());
                    ProMenuRequest proMenuRequest = new ProMenuRequest();
                    proMenuRequest.setMenuId(1);
                    proMenuRequest.setIds(menuIds);
                    ServiceResponse<List<ProMenu>> proMenusResponse = proMenuService.findIdsList(new ProParameter<>(proMenuRequest));
                    // 查看服务是否正常执行
                    proMenusResponse.checkState();

                    // 封装权限信息
                    List<VaRole> vaRoleList = new ArrayList<>();
                    List<ProMenu> proMenus = proMenusResponse.getObj();
                    proMenus.forEach(proMenu -> {
                        VaRole vaRole = new VaRole();
                        vaRole.setId(proMenu.getMenuId());
                        if (!StringUtils.isEmpty(proMenu.getJurisdiction())) {
                            vaRole.setName(proMenu.getJurisdiction());
                            vaRoleList.add(vaRole);
                        }
                    });

                    vaUser = new VaUser(user.getUserName(),user.getUserPass(),vaRoleList);
                    vaUser.setUserface(user.getHeadImg());
                    vaUser.setId(user.getUserId().longValue());
                    if(user.getStats().equals(1)) {
                        vaUser.setEnabled(false);
                    } else {
                        vaUser.setEnabled(true);
                    }
                } catch (Exception e) {
                    throw new UsernameNotFoundException(e.getMessage());
                }
            }
            return vaUser;
        }
        return null;
    }
}
