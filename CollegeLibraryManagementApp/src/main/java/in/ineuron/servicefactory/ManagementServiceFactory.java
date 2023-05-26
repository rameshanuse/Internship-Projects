package in.ineuron.servicefactory;

import in.ineuron.service.IManagementService;
import in.ineuron.service.IStudentService;
import in.ineuron.service.ManagementServiceImpl;
import in.ineuron.service.StudentServiceImpl;

public class ManagementServiceFactory {
	
	private ManagementServiceFactory() {} 
	
	private static IManagementService managementService = null; 
	
	public static IManagementService getManagementService() {
		
		if(managementService == null) {
			managementService = new ManagementServiceImpl();
		}
		return managementService; 	
	}	
}
