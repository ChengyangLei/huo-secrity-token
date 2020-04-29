package com.huotn.huosecritytoken.service.impl;

import com.huotn.huosecritytoken.entity.TSysUser;
import com.huotn.huosecritytoken.mapper.TSysUserMapper;
import com.huotn.huosecritytoken.service.TSysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author leichengyang
 * @since 2020-04-29
 */
@Service(value = "TSysUserServiceImpl")
public class TSysUserServiceImpl extends ServiceImpl<TSysUserMapper, TSysUser> implements TSysUserService {

}
