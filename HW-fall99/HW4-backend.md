# Internet Engineering - Golang (HW4)

In this homework, we want to create Rest APIs for a supermarket application, actually Javad's supermarket. People usually come and buy a lot of daily products namely milk, biscuits, chocolates, ice cream and more. Managing customers are becoming severe to handle for him, so you are here to help Javad handle his supermarket's need rapidly.

## Part 1

Javad needs a panel to manage customers. Below is a schema of customers data in backend.

| Key             | Type     | Description                           | Example             |
| --------------- | -------- | ------------------------------------- | ------------------- |
| `cName`         | `String` | Customer name                         | Darush              |
| `cTel`          | `Number` | Customer telephone                    | 9123012345          |
| `cAddress`      | `String` | Customer address                      | Valiasr St. ,Tehran |
| `cID`           | `Number` | Customer unique ID                    | 1                   |
| `cRegisterDate` | `Time`   | Customer register date in supermarket | 2020-10-25          |

What you should do is to implement a **CRUD** Rest api that have the following endpoints:

| Api                       | Description                |
| ------------------------- | -------------------------- |
| `POST /customers`         | Create new customer        |
| `PUT /customers/{cID}`    | Edit a customer by `cID`   |
| `GET /customers`          | Get all customers          |
| `DELETE /customers/{cID}` | Delete a customer by `cID` |

### **More details:**

#### 1) Create new customer:

-   When creating a new customer, user sends body request as follows:

```json
/*
	POST /customers
*/

{
    "cName": "Darush",
    "cTel": 9123012345,
    "cAddress": "Valiasr St. ,Tehran"
}
```

-   Http response:

```json
{
 	"cID"      : 1,
    "cName"    : "Darush",
 	"cTel"     : 9123012345,
 	"cAddress" : "Valiasr St. ,Tehran",
   	"cRegisterDate" : "2020-10-25"
    "msg"      : "success"
}
```

#### 2) Edit a customer by `cID`:

-   When editing a customer, user sends body request as follows:

```json
/*
	PUT /customers/{cID}
*/

{
    "cName": "Kourosh",
    "cTel": 9123012345,
    "cAddress": "Vanak St. ,Tehran"
}
```

-   Http response:

```json
{
	"cID"      : 1,
    "cName"    : "Kourosh",
	"cTel"     : 9123012345,
	"cAddress" : "Vanak St. ,Tehran",
   	"cRegisterDate" : "2020-10-25"
	"msg"      : "success"
    // OR
    "msg"	   : "error (when cID is not available)"
}
```

#### 3) Get customers:

-   When getting customers list, user just calls

```json
/*
	GET /customers
*/
```

-   Http response:

```json
{
     "size"	   :  3, // Length of customers array
    "customers":[
       	{
		 	"cID"      : 1,
            "cName"    : "Kourosh",
            "cTel"     : 9123012345,
            "cAddress" : "Vanak St. ,Tehran",
        	"cRegisterDate" : "2020-10-25"
		},
     	{...},
	 	{...},
	],
     	"msg"      : "success",
    // OR
    "msg"	   : "error (when no customers are not available)",
}
```

#### 4) Delete a customer by `cID`:

-   When Deleting a customer, user sends body request as follows:

```json
/*
	DELETE /customers/{cID}
*/
```

-   Http response:

```json
{
 	"msg" : "success"
    // OR
    "msg" : "error (when cID is not available)"
}
```

---

## Part 2

Another feature that can help Javad is report list. In report list he can see how many customers he had in every month, or can choose specific month to see the results. Imagine he chose February, then you should accumulate number of customers during that period. (Months are zero based and are like this: _January: 0, February: 1, ..., December: 11_)

-   Http request:

    `GET /report/{month}`

    example : `GET /report/1`

-   Http response:

    ```json
    {
        "totalCustomers": 2,
        "period": 1,
        "msg": "success" //OR "error"
    }
    ```

---

The last but not least is when Javad needs to look for customers phone & address by his name or just some part of beginning of their name.

-   Http query param:

    `GET /customers?cName={cName}`

    example: `GET /customers?cName=Kour`

-   Http response:

```json
{
    "cID": 1,
    "cName": "Kourosh",
    "cTel": 9123012345,
    "cAddress": "Vanak St. ,Tehran",
    "cRegisterDate": "2020-10-25"
}
```

---

### Extra Points

-   Data in your application is not persistent meaning that you can handle requests without database! but if you want extra score, you can use **PostgreSQL** or **MongoDB** or other databases.

---

### How to send homework

-   Zip all your files and name it `[STUDENT_ID]-[STUDENT_NAME]-[HW4].zip`
-   Upload your zip file.

### Good Luck!
