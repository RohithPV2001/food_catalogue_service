package com.example.foodCatalogue.mapper;

import org.mapstruct.Mapper;

import com.example.foodCatalogue.dto.FoodItemDTO;
import com.example.foodCatalogue.models.FoodItem;

@Mapper(componentModel = "spring")
public interface FoodCatalogueMapper {

    FoodItemDTO mapFoodItemToFoodItemDTO(FoodItem foodItem);
    FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO);
}