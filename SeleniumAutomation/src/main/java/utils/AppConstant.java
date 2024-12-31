package utils;

import esignly.constant.ApplicationMessages;

public class AppConstant {
	
	private AppConstant() {
		
	}
	
	private static String MASTER_CONFIG_FILE_PATH = ApplicationMessages.MASTER_CONFIG_FILE_PATH;

	
	public static String GET_MASTER_CONFIG_FILE_PATH() {
		System.out.println(MASTER_CONFIG_FILE_PATH);
		return MASTER_CONFIG_FILE_PATH;
	}

}
