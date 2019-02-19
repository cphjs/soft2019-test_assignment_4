



# Account#getInterest equivalence partitions

| Lower boundary(inclusive) | Upper boundary (exclusive) |
|:-------------------------:|:--------------------------:|
|-∞                         | 0                          | 
| 0                         | 100                        |
| 100                       | 1000                       |
| 1000                      | ∞ + 1                      |


Boundary values are `-1,0`, `99,100`, `999,1000`.


# CreditCard#getDiscount decision table

| New customer                      | T | T | T | T  | F  | F  | F  | F |
| Is existing and has loyalty card  | T | T | F | F  | T  | T  | F  | F |
| Is existing and has coupon        | T | F | T | F  | T  | F  | T  | F |
| Discount size                     | - | - | - | 15 | 30 | 10 | 20 | 0 |

# ATM state diagram

![atm state diagram](ATM\ state\ diagram.png)