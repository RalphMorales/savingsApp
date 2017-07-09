package savingsApp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import savingsApp.entity.Budget;
import savingsApp.entity.Expense;

@Repository
public interface ExpenseDAO extends CrudRepository<Expense, Long>{

}
