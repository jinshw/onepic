package com.ykkj.weiyi.dao;

import java.util.List;

import com.ykkj.weiyi.pojo.OutPatient;
import com.ykkj.weiyi.pojo.OutUser;


public abstract interface UserMapper
{
	OutUser findUserByMobile(String paramString);
	
	OutUser selectByUserId(String id);
 
  int saveUser(OutUser user);
  
  int savePatient(OutPatient op);
  
  int updateUser(OutUser user);
  
  int selPatientCount(String id);
  
  OutPatient loadMyselfPatient(String userid);
  
  int updatePatient(OutPatient op);
  
  List<OutPatient> findPatientList(String userId);
  
  List<OutPatient> findOtherPatientList(String userId);
  
  OutPatient loadPatientByPID(String patientId);
  
  int deletePatient(String patientId);
  
  int updatePatientBind(OutPatient op);
}

