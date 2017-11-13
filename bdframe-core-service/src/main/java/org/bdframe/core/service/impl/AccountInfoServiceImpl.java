package org.bdframe.core.service.impl;

import org.bdframe.core.entity.UserInfo;
import org.bdframe.core.service.AccountInfoService;
import org.bdframe.core.service.mapper.AccountInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author cwenao
 * @version $Id HbaseAccountInfoServiceImpl.java, v 0.1 2017-02-21 21:09 cwenao Exp $$
 */
@Service("accountInfoService")
public class AccountInfoServiceImpl  implements AccountInfoService{
	@Autowired
    AccountInfoMapper accountInfoMapper;
    @Override
    public UserInfo findUserInfoByEntity(String table, String family, String rowKey, UserInfo userInfo) {
        return accountInfoMapper.findUserInfoByEntity(table,family,rowKey,userInfo);
    }

    @Override
    public List<UserInfo> findAll(String tablename,String family) {
        return accountInfoMapper.findAll(tablename,family);
    }
}
