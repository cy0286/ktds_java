package com.ktdsuniversity.edu.fp.stream.data;

public class Dish { 
    private final String NAME; 
    private final boolean VEGETARIAN; 
    private final int CALORIES; 
    private final Type TYPE; 

    public Dish(String name, boolean vegetarian, int calories, Type type ) { 
        this.NAME = name; 
        this.VEGETARIAN = vegetarian; 
        this.CALORIES = calories; 
        this.TYPE = type;
    } 
    public String getName () { 
        return NAME;
    } 
    
    public boolean getisVegetarian() { 
        return VEGETARIAN;
    } 
    
    public int getCalories() { 
        return CALORIES; 
    }
    
    public Type getType() { 
        return TYPE;
    } 
    
    @Override 
    public String toString() { 
        return NAME;
    } 
}