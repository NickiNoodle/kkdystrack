package com.dystify.kkdystrack3.server.dao.entity;

import javax.persistence.*;

@Entity
public class ShopItem {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String itemName;
  private String category;
  private int cost;
  private int discountedCost;
  private int stock = 0;
  private String itemCooldown;
  private String info;
  private String description;

  protected ShopItem() {}

  public ShopItem(String itemName) {
    this.itemName = itemName;
    this.category = "test";
    this.cost = 100;
    this.stock = 10;
    this.itemCooldown = "";
    this.info = "/";
    this.description = "Test Item";
  }

  public ShopItem(String itemName, String category, int cost, int discountedCost, int stock, String itemCooldown,
                  String info, String description) {
    this.itemName = itemName;
    this.category = category;
    this.discountedCost = discountedCost;
    this.cost = cost;
    this.stock = stock;
    this.itemCooldown = itemCooldown;
    this.info = info;
    this.description = description;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public int getCost() {
    return cost;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }

  public int getDiscountedCost() {
    return discountedCost;
  }

  public void setDiscountedCost(int discountedCost) {
    this.discountedCost = discountedCost;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public String getItemCooldown() {
    return itemCooldown;
  }

  public void setItemCooldown(String itemCooldown) {
    this.itemCooldown = itemCooldown;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
