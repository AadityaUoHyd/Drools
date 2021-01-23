package org.abc.drools.controller;

import org.abc.drools.model.Order;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class MyOfferController {
	
	@Autowired
	private KieSession session;

	@PostMapping("/offer")
	public Order orderNow(@RequestBody Order order) {
		session.insert(order);
		session.fireAllRules();
		return order;
	}

}