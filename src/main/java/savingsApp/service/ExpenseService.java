package savingsApp.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import savingsApp.dao.BudgetDAO;
import savingsApp.dao.ExpenseDAO;
import savingsApp.entity.Budget;
import savingsApp.entity.Expense;

@Service
@Transactional
public class ExpenseService {

	@Autowired
	private ExpenseDAO expenseRepo;
	
	public List<Expense> retrieveAll(){
		List<Expense> result = new ArrayList<>();
		expenseRepo.findAll().forEach(result::add);
		return result;
	}
	
	public Double totalExpense(){
		List<Double> result = new ArrayList<>();
		expenseRepo.findAll().forEach(expense -> result.add(expense.getAmount()));
		return result.stream().mapToDouble(Double::doubleValue).sum();
	}
	
	//TODO: create implementation
	public Double remainingExpense(){
		return new Double(100);
	}
	
	public void saveExpense(Expense expense){
		expenseRepo.save(expense);
	}
	
	public void deleteExpense(Long id){
		expenseRepo.delete(id);
	}
	
	
}
