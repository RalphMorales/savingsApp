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
import savingsApp.entity.Expense;
import savingsApp.service.BudgetService;
import savingsApp.service.ExpenseService;
import savingsApp.utils.Constants.ATTRIBUTE;
import savingsApp.utils.Constants.BUDGET_MODE;
import savingsApp.utils.Constants.EXPENSE_MODE;
import savingsApp.utils.Constants.GLOBAL_MODE;

@Controller
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	@GetMapping("/expense")
	public String allExpense(HttpServletRequest request) {
		request.setAttribute("expenses", expenseService.retrieveAll());
		request.setAttribute("totalExpense", expenseService.totalExpense());
		request.setAttribute("remainingExpense", expenseService.remainingExpense());
		request.setAttribute(ATTRIBUTE.MODE.toString(), EXPENSE_MODE.ALL_EXPENSE.toString());
		return "expense";
	}

	@PostMapping(value = "/save-expense")
	public String saveBudget(@ModelAttribute Expense expense, BindingResult bindingresult, HttpServletRequest request) {
		expenseService.saveExpense(new Expense(new Date(), expense.getDescription(), expense.getAmount()));
		return allExpense(request);
	}

	@GetMapping("/delete-expense")
	public String hello(@RequestParam Long id, HttpServletRequest request) {
		expenseService.deleteExpense(id);
		return allExpense(request);
	}

}
