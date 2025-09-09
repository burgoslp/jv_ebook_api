package com.leopoldo.ebook.ebook.repositories;
import org.springframework.data.repository.CrudRepository;
import com.leopoldo.ebook.ebook.models.Loan;

public interface ILoanRepository extends CrudRepository<Loan, Long>{
    
    
}
