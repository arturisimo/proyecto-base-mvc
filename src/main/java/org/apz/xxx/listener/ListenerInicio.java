//package org.apz.xxx.listener;
//
//import java.io.ByteArrayInputStream;
//import java.io.FileInputStream;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.nio.charset.Charset;
//import java.util.Properties;
//
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
//import org.apz.xxx.util.Utilidades;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
// 
// 
//public class ListenerInicio implements ApplicationListener<ContextRefreshedEvent> {
//
//	protected static Logger logger = Logger.getLogger(ListenerInicio.class);
//	
//	public ListenerInicio() {
//    } 
//	
//    
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//    	
//    	System.out.println("--> [LISTENER INICIO]");
//		tracear_charset();
//    	
//    	try 
//    	{
//			logger.debug("---------- _START ListenerInicio ");
//			
//			String defaultCharacterEncoding = System.getProperty("file.encoding");
//			
//			ApplicationContext applicationContext = event.getApplicationContext();
//			String sRutaBase =  applicationContext.getEnvironment().getProperty("ruta.xxxxx");
//			
//			String separador = System.getProperty("file.separator");
//			sRutaBase = sRutaBase +  separador + "wrk" +   separador + "data" + separador;
//			
//			//Configuracion log4j
//			try {
//				//String sRutaLog4j =  applicationContext.getEnvironment().getProperty("ruta.xxxxx") + separador + "wrk" + separador + "log4j.properties";
//				
//				String sRutaLog4j = "properties" + separador + "log4j.properties";
//				
//				Utilidades.PATH_LOG4J = sRutaLog4j;
//				
//				System.out.println("--> [Log4j] : Inicializando log4j con fichero : " + sRutaLog4j);
//				
//				Properties p = new Properties();
//				InputStream is = new FileInputStream(sRutaLog4j);
//				p.load(is);
//				is.close();
//				
//				ClassLoader contextLoader = Thread.currentThread().getContextClassLoader();
//				PropertyConfigurator.configure(p);
//				 
//			} catch (Exception e) {
//				logger.debug("[log4j.properties]: Fichero no encontado.");
//				//logger.error(Utilidades.getStackTrace(e));
//			}
//			System.getProperties().setProperty("net.fortuna.ical4j.timezone.update.enabled", "false");
//			
//			//Acceso a los datos de la aplicacion
//			sRutaBase = sRutaBase +  separador + "wrk" +   separador + "data" + separador + "manuales" + separador;
//			//Utilidades.RUTA_MANUALES = sRutaACV;
//		 	
//			logger.debug("---------- _END ListenerInicio ");
//    	} catch (Exception e) 
//    	{
//    		//logger.error(Utilidades.getStackTrace(e));
//    	}
//    }   
//
//	public void tracear_charset(){
//        String defaultCharacterEncoding = System.getProperty("file.encoding");
//        System.out.println("defaultCharacterEncoding by property: " + defaultCharacterEncoding);
//        System.out.println("defaultCharacterEncoding by code: " + getDefaultCharEncoding());
//        System.out.println("defaultCharacterEncoding by charSet: " + Charset.defaultCharset());
//    }
//	
//	public String getDefaultCharEncoding(){
//        byte [] bArray = {'w'};
//        InputStream is = new ByteArrayInputStream(bArray);
//        InputStreamReader reader = new InputStreamReader(is);
//        String defaultCharacterEncoding = reader.getEncoding();
//        return defaultCharacterEncoding;
//    }
//    
//}