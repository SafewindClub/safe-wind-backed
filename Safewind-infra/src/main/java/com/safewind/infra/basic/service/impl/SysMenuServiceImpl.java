package com.safewind.infra.basic.service.impl;

import com.safewind.infra.basic.entity.SysMenu;
import com.safewind.infra.basic.dao.SysMenuDao;
import com.safewind.infra.basic.service.SysMenuService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


/**
 * 菜单权限表(SysMenu)表服务实现类
 *
 * @author Darven
 * @since 2025-05-21 21:46:55
 */
@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {
    @Resource
    private SysMenuDao sysMenuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param menuId 主键
     * @return 实例对象
     */
    @Override
    public SysMenu queryById(Long menuId) {
        return this.sysMenuDao.queryById(menuId);
    }


    /**
     * 新增数据
     *
     * @param sysMenu 实例对象
     * @return 实例对象
     */
    @Override
    public SysMenu insert(SysMenu sysMenu) {
        this.sysMenuDao.insert(sysMenu);
        return sysMenu;
    }

    /**
     * 修改数据
     *
     * @param sysMenu 实例对象
     * @return 实例对象
     */
    @Override
    public SysMenu update(SysMenu sysMenu) {
        this.sysMenuDao.update(sysMenu);
        return this.queryById(sysMenu.getMenuId());
    }

    /**
     * 通过主键删除数据
     *
     * @param menuId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long menuId) {
        return this.sysMenuDao.deleteById(menuId) > 0;
    }
}
