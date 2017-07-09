package savingsApp.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import savingsApp.dao.BudgetDAO;
import savingsApp.entity.Budget;

@Service
@Transactional
public class BudgetService {

	@Autowired
	private BudgetDAO budgetRepo;
	
	public List<Budget> retrieveAll(){
		List<Budget> result = new ArrayList<>();
		budgetRepo.findAll().forEach(result::add);
		return result;
	}
	
	public Double totalBudget(){
		List<Double> result = new ArrayList<>();
		budgetRepo.findAll().forEach(budget -> result.add(budget.getAmount()));
		return result.stream().mapToDouble(Double::doubleValue).sum();
	}
	
	//TODO: create implementation
	public Double remainingBudget(){
		return new Double(100);
	}
	
	public void saveBudget(Budget budget){
		budgetRepo.save(budget);
	}
	
	public void deleteBudget(Long id){
		budgetRepo.delete(id);
	}
	
	
}
