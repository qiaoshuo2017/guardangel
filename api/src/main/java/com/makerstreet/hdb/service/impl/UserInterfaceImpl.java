package com.makerstreet.hdb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makerstreet.hdb.dao.UserDao;
import com.makerstreet.hdb.model.UserModel;

@Service
public class UserInterfaceImpl implements UserInterface {
	
	
	@Autowired
	private UserDao userDao;
	/*
	 *如果userDao接口的isPhoneExist返回值为空，说明手机号不存在，反之说明手机号存在。 
	 *
	 */
	public boolean isPhoneExist(String MobilePhone) {
	UserModel userModel=new UserModel();
	userModel.setMobilePhone(MobilePhone);
	userModel=userDao.isPhoneExist(MobilePhone);
	if (userModel==null){
		return false;
	}else{
		return true;
	}
		
		
	}

}
