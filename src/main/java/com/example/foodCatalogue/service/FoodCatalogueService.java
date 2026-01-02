package com.example.foodCatalogue.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.foodCatalogue.dto.FoodCataloguePage;
import com.example.foodCatalogue.dto.FoodItemDTO;
import com.example.foodCatalogue.dto.Restuarant;
import com.example.foodCatalogue.mapper.FoodCatalogueMapper;
import com.example.foodCatalogue.repo.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.foodCatalogue.models.*;


@Service
public class FoodCatalogueService {
    

    @Autowired
    FoodItemRepo foodItemRepo;

    @Autowired
    FoodCatalogueMapper mapper;

    @Autowired
    RestTemplate restTemplate;


    public FoodItemDTO createFoodItem(FoodItemDTO foodItemDTO){
        FoodItem foodItem = foodItemRepo.save(mapper.mapFoodItemDTOToFoodItem(foodItemDTO));
        return mapper.mapFoodItemToFoodItemDTO(foodItem);
    }

    public FoodCataloguePage fetchFoodItemsWithRestuaId(Integer restuarantId){
        List<FoodItem> foodItemList = fetchFoodItemList(restuarantId);
        Restuarant restuarant = fetchRestuarantDetailsFromRestuarantMS(restuarantId);
        return createFoodCataloguePage(foodItemList, restuarant);
    }

    private List<FoodItem> fetchFoodItemList(Integer restuarantId){
        return foodItemRepo.findByRestuarantId(restuarantId);
    }

    private Restuarant fetchRestuarantDetailsFromRestuarantMS(Integer restuarantId){
        return restTemplate.getForObject("http://restaurant-listing/restuarant/"+restuarantId,Restuarant.class);
    }

    private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItems,Restuarant restuarant){
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setFoodItemList(foodItems);
        foodCataloguePage.setRestuarant(restuarant);
        return foodCataloguePage;
    }
}
