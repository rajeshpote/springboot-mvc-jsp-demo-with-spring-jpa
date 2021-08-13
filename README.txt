# springboot-mvc-jsp-demo-with-spring-jpa
**Spring Boot MVC demo application with JPA For Registration**


Usage:
To RUN ---> mvn spring-boot:run

Registration URL-->    http://localhost:8080/customer
 


**Brief**
Required Platform: Java 8
For this task you will create a registration form for customers, featuring in-line validation, field manipulation and basic database functions. The form needs to be able to take in an argument from the URL that defines which ‘site’ the form is for (Avalon City or AceParks), this means the same form can be used for multiple sites thus increasing its versatility.

**Part 1 – Database**
H2,create three tables to the following specifications.
Customers
COLUMN NAME DATA TYPE MANDATORY ID Auto incremented INT PK Y
REGISTERED
DateTime/Timestamp
Y E-MAIL ADDRESS Variable Character – 255 Length - Unique Y
TITLE
Variable Character – 5 Length
Y FIRST NAME Variable Character – 50 Length Y
LAST NAME
Variable Character – 50 Length
Y ADDRESS LINE 1 Variable Character – 255 Length Y
ADDRESS LINE 2
Variable Character – 255 Length
N CITY Variable Character – 255 Length N
POSTCODE
Variable Character – 10 Length
Y TELEPHONE NUMBER Variable Character – 20 Length N


**Sites Table**
COLUMN NAME  DATA TYPE
MANDATORY ID Auto incremented INT PK Y
NAME
Variable Character – 255 Length Y


**Customer Sites Table**

COLUMN NAME      DATA TYPE
MANDATORY CUSTOMER_ID INT – FK Customer ID Y
SITE_ID INT – FK Site ID
Once these are created, populate the Sites table using the CSV provided.


**Part 2 – Form Creation**

 The form should present the fields present in the Customers table (except ID and Registered date), using relevant (eg. Is a valid e-mail address, maximum length etc…) validation based on the field, including whether the field can be blank.
Additionally on initialization of the form, the current ‘site’ should be determined from the URL – perhaps using a query string parameter or part of the URL pattern – by default the site should be set to Avalon City.
When submitted the fields should be validated server-side before insertion into the DB.
Optional ideas for extra kudos:
- Remove case sensitivity on e-mails when inserting to ensure uniqueness
- Don’t allow duplicate e-mails to be submitted in the form – but do allow customers to sign up for both sites using the same customer record.
- Use in-line validation using client-side (such as JS)

**Part 3 – Database Insertion**
Valid entries should be inserted into the Customers table, and a record in the Customer Sites table to indicate which site the customer signed up for on this instance. Assuming your validation has worked, there should be no issue inserting the record into the DB.

** Part 4 – Success Page **
Upon successful insertion into the database, the user should be presented with a success page. The copy on this is entirely at your discretion. Be aware that you will most likely want to forward the user to this page rather than displaying it, to prevent resubmission on a refresh.


**Success Page:**
Registration Success
Customer Registration List:
ID	Title	FirstName	Last Name	Email	Telephone Number
3	mr	Rajesh	Pote	poterajesh566@gmail.com	09175329397
