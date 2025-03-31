package com.example.models;

public class Gift {
   private String name;
   private int value;

   public Gift(String name, int value) {
      this.name = name;
      this.value = value;
   }

   public int getValue() {
      return value;
   }

   public String getName() {
      return name;
   }  
}
