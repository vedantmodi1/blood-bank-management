# blood-bank-management

This is a database system that manages a Blood Bank and Blood donation, which maintains the database containing staff information, donors, blood donations made, hospital details, orders placed by hospitals and order details.

### Objectives of the Project:
- Maintain a database for employees, donors, hospitals.
- Maintain global standards of the project.
- Reduce manual paper work by maintaining the records online.
- Maintain accuracy, integrity and consistency of the data.
- Make the mechanism and functioning of the blood bank faster and smoother.
- Improved control of blood donation related activities.

### Tools Used:
- Front-end development using JAVA
- Back-end development using MySql

### Database Normalization:
1.  First Normal Form
The relation is in 1NF, since all attributes have atomic domains and the values are indivisible. All attributes contain only a single value.

2. Second Normal Form
The relation is in 2NF, since there are no partial dependencies present.
Eg:- Donor_ID -> Name, Age, Sex, Blood_group, Phone_num, history
        Hospital_ID -> Name, address, Phone_num

3. Third Normal Form      
 The relation is in 3NF, since there are no transitive dependencies present. No relation having attributes A, B, C exists such that A -> B and B -> C.
 
 ![plot](C:\Users\vedan\Downloads\Mini proj ER Diagram  (2).jpg)
