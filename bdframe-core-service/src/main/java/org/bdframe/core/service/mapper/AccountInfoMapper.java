package org.bdframe.core.service.mapper;
import java.util.List;

import org.bdframe.core.entity.UserInfo;

/**
 * @author cwenao
 * @version $Id AccountInfoMapper.java, v 0.1 2017-02-16 17:37 cwenao Exp $$
 */
public interface  AccountInfoMapper {
	 UserInfo findUserInfoByEntity(String table, String family, String rowKey, UserInfo userInfo);

	 List<UserInfo> findAll(String tablename, String family);
}
