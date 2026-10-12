
# Day 6 — AI-Assisted Debugging Notes

## Stack Trace 1: NumberFormatException

**Root cause:** Java cannot convert the input "abc" into an integer.

**Copilot explanation:** The exception occurs at Integer.parseInt().

**What Copilot got right:** Invalid numeric input causes NumberFormatException.

**Verification:** Tested "abc" at both the menu-choice and quantity prompts. The program displayed the invalid-input message and returned to the menu.

**Conclusion:** The current code handles invalid numeric input correctly. The stale-class explanation was not proven by the stack trace alone.

## Stack Trace 2: InsufficientStockException

**Root cause:** The requested quantity exceeded available stock.

**Copilot explanation:** The exception is caught by Main.java, allowing the menu to continue.

**What Copilot got right:** The stock validation rejects orders exceeding available stock.

**Verification:** Ordered 3 items from stock of 10, then requested 8 items when 7 remained. The program displayed the handled stock error and returned to the menu.

**Conclusion:** Insufficient stock is handled correctly without terminating the program.

## Final Reflection

I used Copilot Chat to analyze two Java stack traces. I verified its explanations against the source code and actual terminal output and identified claims that were not proven by the evidence.
