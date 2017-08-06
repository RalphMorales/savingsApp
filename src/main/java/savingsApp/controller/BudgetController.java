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
public class BudgetController {

	@Autowired
	private BudgetService budgetService;

	@GetMapping("/budget")
	public String allBudget(HttpServletRequest request) {
		request.setAttribute("budgets", budgetService.retrieveAll());
		request.setAttribute("totalBudget", budgetService.totalBudget());
		request.setAttribute("remainingBudget", budgetService.remainingBudget());
		request.setAttribute(ATTRIBUTE.MODE.toString(), BUDGET_MODE.ALL_BUDGET.toString());
		return "budget";
	}

	@PostMapping(value = "/save-budget")
	public String saveBudget(@ModelAttribute Budget budget, BindingResult bindingresult, HttpServletRequest request) {
		budgetService.saveBudget(new Budget(new Date(), budget.getDescription(), budget.getAmount()));
		return allBudget(request);
	}

	@GetMapping("/delete-budget")
	public String deleteBudget(@RequestParam Long id, HttpServletRequest request) {
		budgetService.deleteBudget(id);
		return allBudget(request);
	}

}
