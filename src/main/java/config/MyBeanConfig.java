package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import repository.IRepository;
import repository.impl.TxtRepository;
import repository.impl.XMLRepository;
import service.MessageService;
import service.impl.MessageServiceImpl;

@ComponentScan(basePackages = {
		"repository",
		"service",
		"main"
})
public class MyBeanConfig {
	
	@Bean (name = "messageServiceTxtRepository")
	public MessageService getMessageServiceTxtRepository(@Qualifier("txtRepository") IRepository repository) {
		return new MessageServiceImpl(repository);
	}
	
	@Bean (name = "messageServiceXmlRepository")
	public MessageService getMessageServiceXmlRepository(@Qualifier("xmlRepository") IRepository repository) {
		return new MessageServiceImpl(repository);
	}
	
	
//	@Bean (name = "txtRepository")
//	public IRepository getTxtRepository() {
//		return new TxtRepository();
//	}
//	
//	@Bean (name = "xmlRepository")
//	public IRepository getXMLRepository() {
//		return new XMLRepository();
//	}
//	
////	@Bean (name = "messageService")
////	public MessageService getMessageService() {
////		return new MessageServiceImpl(getXMLRepository());
////	}
	
	
	
}
