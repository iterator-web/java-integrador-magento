package br.com.iterator.model.helper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogHelper {
	
	public static Logger LOGGER; // Pode utilizar: LOGGER.severe() - LOGGER.warning() - LOGGER.info()

	public void getLogger() {
		LogHelper.LOGGER = Logger.getLogger("IntegradorLog");
		try {
	        SimpleFormatter formatter = new SimpleFormatter();  
			SimpleDateFormat dateFormat = new SimpleDateFormat("Y-M-d");
			FileHandler fileHandler = new FileHandler("c:\\Trabalho\\integrador_"+dateFormat.format(Calendar.getInstance().getTime())+".log", true);
			LogHelper.LOGGER.addHandler(fileHandler);
	        fileHandler.setFormatter(formatter);
		} catch (SecurityException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
		}
	}
}
