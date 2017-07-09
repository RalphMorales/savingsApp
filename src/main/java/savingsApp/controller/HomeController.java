package savingsApp.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import savingsApp.entity.Budget;
import savingsApp.service.BudgetService;
import savingsApp.utils.Constants.ATTRIBUTE;
import savingsApp.utils.Constants.BUDGET_MODE;
import savingsApp.utils.Constants.GLOBAL_MODE;

@Controller
public class HomeController {

	@GetMapping("/index")
	public String mainView(HttpServletRequest request) {
		request.setAttribute(ATTRIBUTE.MODE.toString(), GLOBAL_MODE.HOME.toString());
		return "index";
	}

}
