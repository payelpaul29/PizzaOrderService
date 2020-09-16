package com.test.sw.PizzaOrder.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.sw.PizzaOrder.Entity.Pizza;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

	@Query("select pizza_id from Pizza p where p.style = ?1 and p.size=?2")
	Integer findByStyleNSize(String style, String size);

}
