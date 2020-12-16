package in.ravikalla.simple_springboot.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
	Logger L = LoggerFactory.getLogger(DemoService.class);

	public String create(String strFirstName) throws IOException {
		return strFirstName + " - Demo create - response";
	}

	public String get(String strParam1) {
		return strParam1 + " - Demo get - Response";
	}
}
