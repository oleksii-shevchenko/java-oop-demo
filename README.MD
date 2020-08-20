# Homework

## Domain model

You are creating demo for your new customer who is provides different
services for local travelers. They want you to build an CLI application for
their administrators.

This is mock application, so we are going to use in memory data store.

 ![User Flow Diagram](./hw-diagram.png)
 
 If something goes wrong during the interaction flow application should
 handle this and retry a step or whole flow.
 
 Domain model MUST include next entities:
 
 1. User:
    - User Id
    - First Name
    - Second Name
    - Age
    - Location
    - Birthday
    - Email
 2. Hotel:
    - Hotel Id
    - Hotel Name
    - Location
 3. Checkout
    - Hotel
    - Checkin Date
    - Checkout Date
    - Price
    - Duration
    - User
 4. Trip
    - Trip Id
    - Checkout
    - User
    - Total price

## Services

### Show Trip

Must display trip description by trip id and/or user id or user name.

### Cancel Trip

Must delete and cancel a trip by trip id and or user id or user name.

### Create Trip

This should be an iterative process. One checkout/hotel should be added to
trip at one time.

Optionally after each iteration you should display list of the hotels.

## Infrastructure

Everything should be back by YOUR implementation of Linked List 
(ua.kpi.ipt.hw.infra.impl.LinkedList).

