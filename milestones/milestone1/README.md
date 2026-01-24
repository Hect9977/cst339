# CST-339 Milestone 1 — Project Proposal

## Overview
In this course, we will design and build a complete **enterprise-class N-Layer application** using the **Spring Boot** framework.  
For **Milestone 1**, we must submit a project proposal, an initial sitemap, a draft division of work, a plan for managing the project, and a list of risks.

---

## 1) Domain and Products (This is what the app manages)

### Domain
A small **pet store** inventory and catalog management system.

### Products Managed
The application will manage items the pet store sells, such as:
- Pet food
- Toys
- Treats
- Grooming supplies
- Accessories

### Product Data (The Initial Fields)
Each product will include:
- **Name**
- **Category** (Food, Toy, Treat, Grooming, etc.)
- **Price**
- **Quantity in stock**
- **Description**

---

## 2) High-Level Features (This is what will the app do while it's running)

### User Features
- Register an account
- Login / Logout

### Product Features (CRUD)
- View all products (table/list)
- Add a new product
- View product details
- Edit a product
- Delete a product

### Other Requirements
- **Check user input:** make sure forms are filled out correctly (example: price can’t be negative).
- **Friendly Use Pages:** the site should look good on phones and computers.
- **Organized code (N-Layer):** keep the code separated into parts:
  - **UI:** pages and buttons the user clicks
  - **Logic:** rules and actions (what the app should do)
  - **Data:** saving and loading information (database later)


### Planned for Later Milestones
- Database storage (MySQL or PostgreSQL)
- Spring Security to protect pages (login required)
- Secured REST APIs

---

## 3) Sitemap (Pages and Navigation)

### Public Pages
- `/` — Home
- `/register` — Register
- `/login` — Login

### After Login
- `/dashboard` — Dashboard
- `/products` — Product List

### From Product List
- `/products/new` — Add Product
- `/products/{id}` — Product Details
- `/products/{id}/edit` — Edit Product
- `/products/{id}/delete` — Delete Product (confirm + submit)

---

## 4) Work Plan + Division of Work

### Project Management Approach
We will manage the project using a simple **Agile** approach:
- Maintain a task board (Trello or GitHub Projects)
- Each week, select tasks for the milestone
- Meet 1–2 times per week to review progress
- Demo working features at the end of each milestone

### Division of Work (2-Person Example)
- **Person A (Backend):**
  - Controllers, services, product logic
  - Later: database and security integration
- **Person B (Frontend):**
  - Thymeleaf pages, Bootstrap layout, navigation
  - Validation messages and UI consistency

> If we have 3 people, one member will focus on database + security later milestones.

---

## 5) Risks and Mitigation

### Risk 1 — Spring Security complexity
**Mitigation:** Implement security step-by-step starting with basic protected routes.

### Risk 2 — Database refactor later may break features
**Mitigation:** Keep database logic in a separate layer so it can be swapped in cleanly.

### Risk 3 — Scope creep (too many extra features)
**Mitigation:** Build only required milestone features first; track extra ideas as “future enhancements.”

---

## Instructor Approval
This project concept will be submitted to the instructor for approval before moving forward.
