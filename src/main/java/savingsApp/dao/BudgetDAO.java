package savingsApp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import savingsApp.entity.Budget;

@Repository
public interface BudgetDAO extends CrudRepository<Budget, Long>{

}
