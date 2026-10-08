# BUGS

## Bug 1: VendingMachine constructor loop goes past the end of the array

**Observed failure:** new VendingMachine() threw an ArrayIndexOutOfBoundsException so every test that created a machine failed on that line.

**Test that exposed it:** testConstructor_newMachine_balanceIsZero and testConstructor_newMachine_allSlotsEmpty in VendingMachineTest.

**Source-code fault:** In the VendingMachine() constructor the loop condition was i <= NUM_SLOTS. With NUM_SLOTS = 4, i reached 4, but the array only has indexes 0 to 3.

**How I diagnosed it:** I read the failure message, which pointed at the constructor line, then compared the loop's range of i values (0 to 4) to the array's valid indexes (0 to 3).

**Correction:** Changed the condition to i < NUM_SLOTS.