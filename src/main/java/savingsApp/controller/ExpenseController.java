package savingsApp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import savingsApp.entity.Expense;
import savingsApp.service.ExpenseService;
import savingsApp.utils.ExpenseType;
import savingsApp.utils.ViewConstants.ATTRIBUTE;
import savingsApp.utils.ViewConstants.EXPENSE_MODE;

@Controller
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	@GetMapping("/expense")
	public String allExpense(HttpServletRequest request) {
		allExpenseMode(request, EXPENSE_MODE.ALL_EXPENSE.toString());
		return "expense";
	}

	public String allExpenseMode(HttpServletRequest request, String mode) {
		request.setAttribute("expenses", expenseService.retrieveAll());
		request.setAttribute("totalExpense", expenseService.totalExpense());
		request.setAttribute("expenseTypes", Arrays.asList(ExpenseType.values()));
		request.setAttribute(ATTRIBUTE.MODE.toString(), mode);
		return "expense";
	}

	@PostMapping(value = "/save-expense")
	public String saveExpense(@RequestParam String mode, @RequestParam String expenseType, @ModelAttribute Expense expense, BindingResult bindingresult, HttpServletRequest request) {
		expenseService.saveExpense(new Expense(new Date(), expenseType, expense.getDescription(), expense.getAmount()));
		if(mode.equals(EXPENSE_MODE.GRAPH.toString())) {
			return showGraph(request);
		} 
		
		return allExpense(request);
	}

	@GetMapping("/delete-expense")
	public String deleteExpense(@RequestParam Long id, HttpServletRequest request) {
		expenseService.deleteExpense(id);
		return allExpense(request);
	}

	@GetMapping("/graph-expense")
	public String showGraph(HttpServletRequest request) {
		request.setAttribute("pieData", generatePieData());
		return allExpenseMode(request, EXPENSE_MODE.GRAPH.toString());
	}
	
	private String generatePieData() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("type", "pie");
		
		JSONObject dataset = new JSONObject();
		List<String> types = new ArrayList<>();
		List<String> colors = new ArrayList<>();
		List<Double> results = new ArrayList<>();
		
		for(ExpenseType expType : ExpenseType.values()) {
			types.add(expType.toString());
			colors.add(expType.getColor());
			results.add(expenseService.totalExpense(expType.toString()));
		}
		
		dataset.put("backgroundColor", colors);
		dataset.put("data", results);
		
		JSONObject dataObject = new JSONObject();
		dataObject.put("labels", types);
		
		List<JSONObject>datasets = new ArrayList<>();
		datasets.add(dataset);
		dataObject.put("datasets", datasets);
		
		jsonObject.put("data", dataObject);
		
		return jsonObject.toJSONString();
	}
}
