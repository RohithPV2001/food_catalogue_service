package com.example.foodCatalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodCatalogue.dto.FoodCataloguePage;
import com.example.foodCatalogue.dto.FoodItemDTO;
import com.example.foodCatalogue.service.FoodCatalogueService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/foodItem")
public class FoodCatalogueController {
    

    @Autowired
    FoodCatalogueService foodCatalogueService;


    @PostMapping
    public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO  foodItemDTO){
        FoodItemDTO foodItem = foodCatalogueService.createFoodItem(foodItemDTO);
        return new ResponseEntity<>(foodItem,HttpStatus.CREATED);
    }

    @GetMapping("/fetchWithRestuarantId/{restuarantId}")
    public ResponseEntity<FoodCataloguePage> fetchFoodItemsWithRestuaId(@PathVariable Integer restuarantId){
        FoodCataloguePage foodCataloguePage = foodCatalogueService.fetchFoodItemsWithRestuaId(restuarantId);
        return new ResponseEntity<>(foodCataloguePage,HttpStatus.OK);
    }
}
