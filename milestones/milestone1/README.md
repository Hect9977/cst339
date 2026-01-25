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

## 4) Work Plan + Division of Work (Simple)

### How we will manage the project
- Use a simple task board (GitHub Projects).
- For each milestone, we will:
  - List the tasks we need to finish
  - Split the tasks between teammates
  - Meet 1–2 times during the week to check progress
  - Show what works at the end (a quick demo)

### Who will do what (3-person team)
- **Person A (Backend / Logic):**
  - Write the main Spring Boot code (controllers + services)
  - Make sure the app follows the rules (business logic)

- **Person B (Frontend / Pages):**
  - Build the web pages using Thymeleaf
  - Make pages look good with Bootstrap
  - Show validation messages on forms

- **Person C (Database + Security):**
  - Plan and later connect the database (MySQL/PostgreSQL)
  - Help add Spring Security login protection
  - Help with REST API setup in later milestones

> This section is only for a 3 person team.

### If only one person is doing the project (solo plan)
- **Week/Milestone workflow**
  - Make a short task list for the milestone
  - Build the backend first (controllers/services)
  - Build the pages next such as using **Bootstrap**
  - Test the forms and validation
  - Push updates to Git and write a short progress note/demo

- **How the work is split (all done by one person)**
  - **Backend + Logic:** build the Spring Boot controllers and services
  - **Frontend + Pages:** create Bootstrap layout
  - **Database + Security (for later on the course):** connect the database and add Spring Security step-by-step

> Tip: focus on one feature at a time (example: “Product List” first), then move to the next feature.


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
