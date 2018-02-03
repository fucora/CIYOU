package com.ciyou.edu.service.impl

import com.ciyou.edu.entity.Admin
import com.ciyou.edu.entity.Permission

import com.ciyou.edu.mapper.AdminMapper
import com.ciyou.edu.mapper.PermissionMapper
import com.ciyou.edu.service.AdminService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * @Author C.
 * @Date 2018-02-02 20:42
 */
@Service
class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminMapper adminMapper
    @Autowired
    private PermissionMapper permissionMapper

    @Transactional
    @Override
    int addAdmin(Admin admin) {
        return adminMapper?.addAdmin(admin)
    }

    @Override
    Admin findAdminById(Integer adminId) {
        Admin admin = adminMapper?.findAdminById(adminId)
        //获取权限
        List<Permission> permissionList =  permissionMapper?.findPermissionByAdmin(adminId)
        //获取父权限

        admin?.setPermissionList(permissionList)
        return admin
    }

    @Override
    Admin findByAdminName(String adminName) {
        Admin admin = adminMapper?.findAdminByName(adminName)
        //获取权限
        List<Permission> permissionList =  permissionMapper?.findPermissionByAdmin(admin?.getAdminId())
        //获取父权限


        admin?.setPermissionList(permissionList)
        return admin
    }
}
