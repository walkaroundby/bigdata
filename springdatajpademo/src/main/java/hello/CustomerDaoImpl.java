package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author luowei
 * @date 2018-12-03 15:44
 */
@Repository
public class CustomerDaoImpl {
    @Autowired
    private CustomerRepositorySpe customerRepository;
    public Page<Customer> findList(int page, int size, String firstName) {
        Specification<Customer> spec = (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (firstName != null) {
                predicates.add(builder.equal(root.<String>get("firstName"), firstName));
            }
            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        };
        return customerRepository.findAll(spec, new PageRequest(page - 1, size, Sort.Direction.DESC, "id"));
    }
}
