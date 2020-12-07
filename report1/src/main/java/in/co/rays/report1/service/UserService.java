package in.co.rays.report1.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;



import in.co.rays.report1.dto.User;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service

public class UserService {

	
	public List<User>  getUser() {
		return getUserList();
		
	}
	
	private List <User> getUserList() {
		
		List <User> users= new ArrayList <User>();
		
		User user = new User();
		user.setId(1);
		user.setFname("shivam");
		user.setLname("verma");
		user.setCity("indore");
		
		User user1 = new User();
		user1.setId(2);
		user1.setFname("shubham");
		user1.setLname("sharma");
		user1.setCity("bhopal");
		
		List list = new ArrayList();
		list.add(user);
		list.add(user1);
		return list;
		
	}
	public String exportReport(String format) throws FileNotFoundException, JRException {
		List<User> list = getUser();
		
		String path ="E://jasper Report//";
		File file = ResourceUtils.getFile("classpath:jasp.jrxml");
		JasperReport jasper = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(list);
		
		Map parameters = new HashMap();
		parameters.put("gain java", "knowldege");
		JasperPrint jasperPrint= JasperFillManager.fillReport(jasper, parameters,ds);
		JasperExportManager.exportReportToPdfFile(jasperPrint,path +"//re1.html");
		return "path :" + path;
	}
	
}
