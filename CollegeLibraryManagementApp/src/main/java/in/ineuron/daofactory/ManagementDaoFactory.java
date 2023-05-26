package in.ineuron.daofactory;

import in.ineuron.dao.IManagementDao;
import in.ineuron.dao.ManagementDaoImpl;

public class ManagementDaoFactory {
	
	private ManagementDaoFactory() {} 
	
	private static IManagementDao managementDao = null; 
	
	public static IManagementDao getManagementDao() {
		
		if(managementDao == null) {
			managementDao = new ManagementDaoImpl();
		}
		return managementDao; 	
	}	
}
