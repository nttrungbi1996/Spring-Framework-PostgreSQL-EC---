package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	List<Item> findByCategoryId(Integer categoryId);

	List<Item> findByNameLike(String string);

	List<Item> findByPriceLessThanEqual(Integer maxPrice);

	List<Item> findByPriceLessThanEqualAndNameLike(Integer maxPrice, String string);
}
