package org.bdframe.core.service;

import java.util.List;

import org.bdframe.core.entity.UserInfo;
import org.springframework.stereotype.Service;

/**
 * @author cwenao
 * @version $Id HbaseAccountInfoService.java, v 0.1 2017-02-17 11:52 cwenao Exp $$
 */
@Service
public interface AccountInfoService {
	UserInfo findUserInfoByEntity(String table, String family, String rowKey, UserInfo userInfo);

    List<UserInfo> findAll(String tablename,String family);
}
