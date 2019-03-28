/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package designer.createFactory.builderpattern;

/**
 * ceshi
 * Date: 2019-03-29
 *
 * @author zhaqianming
 */
public class TestBuilder {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal vegMeal = mealBuilder.prepareVetMeal();
        System.out.println("VegMeal: ");
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());


        Meal nonVegMeal = mealBuilder.prepareNonVetMeal();
        System.out.println("nonVegMeal: ");
        vegMeal.showItems();
        System.out.println("Total Cost: " + nonVegMeal.getCost());
    }


}
