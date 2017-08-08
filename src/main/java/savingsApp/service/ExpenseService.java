package savingsApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

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
	
	public Double totalExpense(String type){
		List<Double> result = new ArrayList<>();
		StreamSupport.stream(expenseRepo.findAll().spliterator(), false).filter(expense -> expense.getType().equals(type))
		.forEach(expenseRemaining -> result.add(expenseRemaining.getAmount()));
		return result.stream().mapToDouble(Double::doubleValue).sum();
	}
	
	public void saveExpense(Expense expense){
		expenseRepo.save(expense);
	}
	
	public void deleteExpense(Long id){
		expenseRepo.delete(id);
	}
	
	
}
