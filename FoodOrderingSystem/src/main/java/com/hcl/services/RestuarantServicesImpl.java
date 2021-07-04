package com.hcl.services;

import com.hcl.entity.Menu;
import com.hcl.entity.Restuarant;
import com.hcl.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestuarantServicesImpl implements IRestuarantServices {
	@Autowired
	private IMenuServices md;
	@Autowired
	private IRestuarantDAO rd;

	// Method to get menu items based on restuarent
	@Override
	public List<Menu> getResturant(String name) {
		Restuarant r = rd.findByRestuarantName(name);
		System.out.println("restuarant record" + r);
		List<Menu> menuList = md.getdetailsByRestuarant(r.getRestuarantId());
		return menuList;
	}

}
