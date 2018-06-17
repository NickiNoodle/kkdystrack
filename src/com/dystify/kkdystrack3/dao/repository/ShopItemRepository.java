package com.dystify.kkdystrack3.dao.repository;

import com.dystify.kkdystrack3.dao.entity.ShopItem;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopItemRepository extends JpaRepository<ShopItem, Long> {
  List<ShopItem> findByCategory(String category);
}
