package com.wzy.role.service;
import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.TxcTransaction;
import com.wzy.common.util.ServiceResponse;
import com.wzy.common.util.Srfactory;
import com.wzy.mapper.RoleMapper;
import com.wzy.pojo.Role;
import com.wzy.role.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@Api(value = "权限接口")
public class RoleServiceImpl implements RoleService {
    @Resource
    RoleMapper roleMapper;

    @Override
    @ApiOperation(value = "添加权限", notes = "权限接口")
    @TxcTransaction(propagation = DTXPropagation.SUPPORTS)
    @Transactional
    public ServiceResponse addRole(Role role) {
        return Srfactory.sr()
                .run(()->{
                    return roleMapper.insertSelective(role);
                })
                .build();
    }

    @Override
    @ApiOperation(value = "删除权限", notes = "权限接口")
    @TxcTransaction(propagation = DTXPropagation.SUPPORTS)
    @Transactional
    public ServiceResponse delRole(Role role) {
        return Srfactory.sr()
                .run(()->{
                    return roleMapper.deleteByPrimaryKey(role.getId());
                })
                .build();
    }

    @Override
    @ApiOperation(value = "修改权限", notes = "权限接口")
    @TxcTransaction(propagation = DTXPropagation.SUPPORTS)
    @Transactional
    public ServiceResponse updateRole(Role role) {
        return Srfactory.sr()
                .run(()->{
                    return roleMapper.updateByPrimaryKeySelective(role);
                })
                .build();
    }

    @Override
    @ApiOperation(value = "获取单个权限", notes = "权限接口")
    public ServiceResponse getRole(Role role) {
        return Srfactory.sr()
                .run(()->{
                    return roleMapper.selectByPrimaryKey(role.getId());
                })
                .build();
    }

    @Override
    @ApiOperation(value = "获取权限列表", notes = "权限接口")
    public ServiceResponse getRoles(Role role) {
        return Srfactory.sr()
                .run(()->{
                    return roleMapper.selectByPrimaryKey(role.getId());
                })
                .build();
    }

    @Override
    @ApiOperation(value = "分页获取权限列表", notes = "权限接口")
    public ServiceResponse getRoles(Role role, int pageNo, int pageSize) {
        return Srfactory.sr()
                .run(()->{
                    return roleMapper.selectByPrimaryKey(role.getId());
                })
                .build();
    }
}
