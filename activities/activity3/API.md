# REST API Design — Topic 3-2 Orders REST Service

**Version:** 1.0  
**Date:** 2026-02-04  
**Author:** Hector Gonzalez  
**Application:** Spring Boot Orders REST Service  
**Description:** A REST service that returns a list of orders in JSON and XML formats.

---

## Base URL

`http://localhost:8080`

## Base Path

`/service`

---

## Index

1. **GET** `/service/getjson` — Get Orders as JSON
2. **GET** `/service/getxml` — Get Orders as XML

---

## Conventions

- All endpoints use standard HTTP methods and return data using standard HTTP status codes.
- Responses are returned as either **JSON** or **XML** depending on the endpoint.
- These endpoints do not require authentication (assignment testing endpoints).
- No request parameters are used for these endpoints.

---

## Status Codes

- **200 OK** — Request succeeded
- **400 Bad Request** — Invalid request (not expected here since there are no inputs)
- **404 Not Found** — The resource/endpoint path does not exist
- **500 Internal Server Error** — Unhandled server error occurred

---

## Data Models

### OrderModel (JSON Object)

Represents an order returned by the service.

**Fields**

- `id` (number)
- `orderNo` (string)
- `productName` (string)
- `price` (number)
- `quantity` (number)

### OrderList (XML Wrapper)

Represents the XML root element that wraps the list of orders.

- Root element: `<orders>`
- Contains: a list of `OrderModel` entries

---

# Endpoint 1: Get Orders as JSON

## Description

Returns the current list of orders in **JSON** format.

## Request

- **Method:** GET
- **URL:** `/service/getjson`
- **Headers (recommended):**
  - `Accept: application/json`
- **Parameters:** None
- **Request Body:** None

## Response

### Success Response

- **Status:** 200 OK
- **Content-Type:** `application/json`
- **Body:** JSON array of `OrderModel`

**JSON Response**

```json
[
  {
    "id": 1,
    "orderNo": "0000001",
    "productName": "Product 1",
    "price": 9.99,
    "quantity": 1
  },
  {
    "id": 2,
    "orderNo": "0000002",
    "productName": "Product 2",
    "price": 19.99,
    "quantity": 2
  },
  {
    "id": 3,
    "orderNo": "0000003",
    "productName": "Product 3",
    "price": 29.99,
    "quantity": 3
  }
]
```
# Endpoint 2: Get Orders as XML

## Description
Returns the current list of orders in **XML** format using an `OrderList` wrapper.

## Request
- **Method:** GET
- **URL:** `/service/getxml`
- **Headers (recommended):**
  - `Accept: application/xml`
- **Parameters:** None
- **Request Body:** None

## Response

### Success Response
- **Status:** 200 OK
- **Content-Type:** `application/xml`
- **Body:** `OrderList` XML document (root `<orders>`)

**XML Response**
```xml
<orders>
  <orders>
    <id>1</id>
    <orderNo>0000001</orderNo>
    <productName>Product 1</productName>
    <price>9.99</price>
    <quantity>1</quantity>
  </orders>
  <orders>
    <id>2</id>
    <orderNo>0000002</orderNo>
    <productName>Product 2</productName>
    <price>19.99</price>
    <quantity>2</quantity>
  </orders>
  <orders>
    <id>3</id>
    <orderNo>0000003</orderNo>
    <productName>Product 3</productName>
    <price>29.99</price>
    <quantity>3</quantity>
  </orders>
</orders>
```
### Error Responses
- **404 Not Found:** Incorrect URL Path
- **500 Internal Server Error:** Server-side exception