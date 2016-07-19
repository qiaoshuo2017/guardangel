package com.makerstreet.hdb.dao;

import com.makerstreet.hdb.model.UserModel;

public interface UserDao {
	public UserModel isPhoneExist(String MobilePhone);//检测手机号是否存在,如果手机号存在，此方法会返回一个UserModel对象，反则返回空；
}
