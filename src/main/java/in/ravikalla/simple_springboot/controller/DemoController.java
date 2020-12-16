package in.ravikalla.simple_springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.ravikalla.simple_springboot.service.DemoService;

@RestController
@RequestMapping(value = "/demowebservice")
public class DemoController {
	Logger L = LoggerFactory.getLogger(DemoController.class);

	private DemoService demoService;
	@Autowired
	public void setProjectService(DemoService demoService) {
		this.demoService = demoService;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String createData(@RequestParam(value="testParameter", required=true) String strTestParameter) throws Exception {
		L.info("Start : DemoController.create(...) : strTestParameter = {}", strTestParameter);
		String strResponse = null;
		try {
			strResponse = demoService.create(strTestParameter);
		} catch (Exception e) {
			L.error("39 : DemoController.create(...) : Exception e = {}", e);
		}
		L.info("End : DemoController.create(...) : strTestParameter = {}", strTestParameter);
		return strResponse;
	}

	@RequestMapping(value = "/param1/{param1}", method = RequestMethod.GET)
	public String getData(@PathVariable(value="param1", required=true) String strParam1) throws Exception {
		L.info("Start : DemoController.getData(...) : strParam1 = {}", strParam1);
		String strResponse = null;
		try {
			strResponse = demoService.get(strParam1);
		} catch (Exception e) {
			L.error("46 : DemoController.getData(...) : Exception e = {}", e);
		}
		L.info("End : DemoController.getData(...) : strParam1 = {}", strParam1);
		return strResponse;
	}
}