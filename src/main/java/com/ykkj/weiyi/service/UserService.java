package com.ykkj.weiyi.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.ykkj.weiyi.pojo.OutPatient;
import com.ykkj.weiyi.pojo.OutUser;





public abstract interface UserService {
	
	public OutUser findUserByMobile(String mobile);
	
	public int saveUser(OutUser user);
	
	public int savePatient(OutPatient op);
	
	public boolean login(OutUser user,HttpServletRequest request);
	
	public int selPatientCount(String id);

	public int updateUser(OutUser user);
	
	public boolean findPassword(OutUser user);
	
	public OutPatient loadMyselfPatient(String userid);
	
	public int updatePatient(OutPatient op);
	
	public List<OutPatient> findPatientList(String userId);
	
	public List<OutPatient> findOtherPatientList(String userId);
	
	public OutPatient loadPatientByPID(String patientId);
	
	public int deletePatient(String patientId);
	
	public int updatePatientBind(OutPatient op);
	
	public OutUser selectByUserId(String id);
	
}
