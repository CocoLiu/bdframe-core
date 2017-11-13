package org.bdframe.core.api;

import java.util.List;

import org.bdframe.core.entity.UserInfo;

/**
 * @author CocoLiu
 * @version $Id AccountInfoApi.java$
 */
public interface AccountInfoApi {
	List<UserInfo> listAccountInfo(String tablename,String family);
}
