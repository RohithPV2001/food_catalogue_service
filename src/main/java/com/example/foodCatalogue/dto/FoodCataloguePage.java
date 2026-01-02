package com.example.foodCatalogue.dto;

import java.util.*;

import com.example.foodCatalogue.models.FoodItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodCataloguePage {
    
    private List<FoodItem> foodItemList;
    private Restuarant restuarant;
}
