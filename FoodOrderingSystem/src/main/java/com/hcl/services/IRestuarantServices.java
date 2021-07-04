package com.hcl.services;

import java.util.List;

import com.hcl.entity.Menu;

public interface IRestuarantServices {
	List<Menu> getResturant(String name);
}
