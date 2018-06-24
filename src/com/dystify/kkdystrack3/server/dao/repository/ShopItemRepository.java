package com.dystify.kkdystrack3.server.dao.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dystify.kkdystrack3.server.dao.entity.ShopItem;

import java.util.List;

@Repository
public interface ShopItemRepository extends JpaRepository<ShopItem, Long> {
  List<ShopItem> findByCategory(String category);
}
