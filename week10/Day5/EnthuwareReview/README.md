Test 4

Prob 50 
- prefix postfix 
    Note: 
    - in for-loop as the iterator it doesn't matter
    - in while loop condition it will matter
    - postfix count++ gives the old value (will iterate through one more time than might expect)
    - prefix ++count gives the new value (will stop sooner)
- do while 
    Note: do while is special because it loops at least once
- shortcut formula
     summing up numbers 1 + 2 + 3 + 4 + ... + n = n * (n + 1) / 2 
     ex: 100 * 101 / 2 = 10100 / 2 = 5050
     ex: 3 * 4 = 12 / 2 = 6
     ex: 11 * 12 = 11 * 10 + 11 * 2 
                 = 110 + 22 = 132 / 2 
                 = 66 - 3  - 6 - 9
                 = 48
Answer: b

Problem 15 
   prefix postfix
   ternary: condition ? (true-case return value) : (false-case return value)
   1-- = 1 > 0 = true
   0-- = 0 > 0 = false
   variable scope - looks in variable first and then wider scope

Problem 49
- - implicit super calls

Y A) class B { } has a constructor. What is it?
   class B { 
      B() {
        // Anything happening?
        super(); <--- calls Object()
      }
   }

x B) class B extends A { } has a constructor. What is it?
   class B { 
      B() {
        // Anything happening?
        super(); <--- calls A() which doesn't exist 
      }
   }

x C) class B extends A {
         B() {
            super(); <-- calls A() which doesn't exist
            System.out.println("i = " + i); // is i accessible? yes
         }
  }

Y D) class B { 
     B() {
        // Anything happening?
        super(); <--- calls Object()
     }
   } 




Problem 4
- ternary operator
   Note: condition ? value1 : value2
         condition ? method1() : method2()     valid - method calls that return a value
         condition ? null : null               invalid
         condition ? int : double              valid
         condition ? Integer : Short           invalid
         condition ? { method1(); method2() } : { method3(); method4() } - invalid

Can you use a lambda in a ternary?

Predicate<Integer> mytest = isTuesday(Date.now()) ? x -> x > 10 : (x, y) -> x < y; 

