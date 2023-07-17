package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	List<Item> findByCategoryIdOrderByIdAsc(Integer categoryId);

	List<Item> findByNameLikeOrderByIdAsc(String string);

	List<Item> findByPriceLessThanEqualOrderByIdAsc(Integer maxPrice);

	List<Item> findByPriceLessThanEqualAndNameLikeOrderByIdAsc(Integer maxPrice, String string);

	List<Item> findByNameLikeAndCategoryIdOrderByIdAsc(String string, Integer categoryId);

	List<Item> findByPriceLessThanEqualAndNameLikeAndCategoryIdOrderByIdAsc(Integer maxPrice, String string,
			Integer categoryId);

	List<Item> findByPriceLessThanEqualAndCategoryIdOrderByIdAsc(Integer maxPrice, Integer categoryId);

	List<Item> findAllByOrderByIdAsc();

	List<Item> findByCategoryId(Integer categoryId);

}
