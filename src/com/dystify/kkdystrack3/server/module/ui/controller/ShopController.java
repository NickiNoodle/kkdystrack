package com.dystify.kkdystrack3.server.module.ui.controller;

import com.dystify.kkdystrack3.server.dao.entity.ShopItem;
import com.dystify.kkdystrack3.server.dao.repository.ShopItemRepository;
import com.dystify.kkdystrack3.server.module.ui.json.ShopItemJsonView;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/shop")
public class ShopController {

  @Autowired
  private ShopItemRepository shopItemRepository;

  @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Map> addItem(@RequestBody ShopItemJsonView shopItem, Errors errors) {
    JSONObject result = new JSONObject();

    if (errors.hasErrors()) {
      result.put("message", errors.getAllErrors()
          .stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
          .collect(Collectors.joining(",")));

      return ResponseEntity.badRequest().body(result.toMap());
    }

    ShopItem newItem = new ShopItem(shopItem.getName());
    this.shopItemRepository.save(newItem);

    result.put("success", true);
    return ResponseEntity.ok(result.toMap());
  }

  @GetMapping("")
  public String shop(Model model) {
    List<ShopItem> list = this.shopItemRepository.findAll();
    model.addAttribute("list", list);
    return "shop";
  }
}
