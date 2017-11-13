package org.bdframe.core.service.biz;

import java.util.List;

import org.bdframe.core.api.AccountInfoApi;
import org.bdframe.core.entity.UserInfo;
import org.bdframe.core.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountInfoApi")
public class AccountInfoBiz  implements AccountInfoApi{
	@Autowired
	private AccountInfoService accountInfoService;
	
	@Override
	public List<UserInfo> listAccountInfo(String tablename,String family) {
		// TODO Auto-generated method stub
		List<UserInfo> listAccountInfos = accountInfoService.findAll(tablename, family);
		return listAccountInfos;
	}

}
