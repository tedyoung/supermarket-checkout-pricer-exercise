# The Supermarket Checkout Pricer

The aim of the exercise is to build the pricing portion of a self-service checkout machine. 

The supermarket has a catalog with different types of products (rice, apples, milk, toothbrushes,...). Each product has a price, and the total price of the shopping cart is the total of all the prices.

But the supermarket also runs special deals, e.g.
 - Buy two toothbrushes, get one free
 - 10% discount on rice
 - 20% discount on apples if you buy more than 10
 - Bags of 1 kg of oranges $4 instead of $5.

These are just examples: the actual special deals changes each week, so needs to be easily configurable.

## Scenarios

The goal of the exercise is to implement a pricer that can handle the scenarios, such as the following:

 - The pricer should be able to handle a shopping cart with no special deals
 - The client should get a receipt with the list of purchases and the total price.
 - The pricer should be able to handle the following scenarios:
    - Buy 2 of the same item, get one 50% off
    - Buy 3 of the same item, get one free
    - 10% discount on certain products (e.g. 10% discount on 1kg packets of rice)
    - Fixed $ discounts (e.g., bag of 1kg of oranges costs $4 instead of $5)
    - Discounts based on day of the week (e.g., Friday Special: sourdough bread 30% off)
 
 - The pricer should be able to handle combinations of the above scenarios, when there is more than one special deal in the shopping cart items.
