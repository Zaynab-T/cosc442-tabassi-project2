import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class VendingMachineTest {
    
    @Test
    public void testConstructor_balanceIsZero() {
        
        VendingMachine vm = new VendingMachine();

        assertEquals(0.0, vm.getBalance(), 0.001);
    }

    @Test
    public void testConstructor_allSlotsEmpty() {
        
        VendingMachine vm = new VendingMachine();

        assertNull(vm.getItem("A"));
        assertNull(vm.getItem("B"));
        assertNull(vm.getItem("C"));
        assertNull(vm.getItem("D"));
    }

    @Test 
    public void testAddItem_emptySlot() {
        
        VendingMachine vm = new VendingMachine();
        VendingMachineItem item = new VendingMachineItem("Chips", 1.50);

        vm.addItem(item, "A");

        assertSame(item, vm.getItem("A"));
    }

    @Test
    public void testAddItem_lastSlot() {

        VendingMachine vm = new VendingMachine();
        VendingMachineItem item = new VendingMachineItem("Gum", 0.75);

        vm.addItem(item, "D");

        assertSame(item, vm.getItem("D"));
    }

    @Test 
    public void testAddItem_occupiedSlot() {
        
        VendingMachine vm = new VendingMachine();
        vm.addItem(new VendingMachineItem("Chips", 1.50), "B");
        VendingMachineItem newItem = new VendingMachineItem("Soda", 1.25);

        assertThrows(VendingMachineException.class, () -> vm.addItem(newItem, "B"));
    }

    @Test 
    public void testAddItem_invalidCode() {
        
        VendingMachine vm = new VendingMachine();
        VendingMachineItem item = new VendingMachineItem("Candy", 1.00);

        assertThrows(VendingMachineException.class, () -> vm.addItem(item, "E"));
    }

    @Test 
    public void testAddItem_emptyStringCode() {
        
        VendingMachine vm = new VendingMachine();
        VendingMachineItem item = new VendingMachineItem("Candy", 1.00);

        assertThrows(VendingMachineException.class, () -> vm.addItem(item, ""));
    }

    @Test 
    public void testAddItem_lowercaseCode() {

        VendingMachine vm = new VendingMachine();
        VendingMachineItem item = new VendingMachineItem("Candy", 1.00);

        assertThrows(VendingMachineException.class, () -> vm.addItem(item, "a"));
    }

    @Test 
    public void testGetItem_occupiedSlot() {
        
        VendingMachine vm = new VendingMachine();
        VendingMachineItem item = new VendingMachineItem("Chips", 1.50);
        vm.addItem(item, "C");

        VendingMachineItem result = vm.getItem("C");

        assertSame(item, result);
    }

    @Test 
    public void testGetItem_invalidCode() {

        VendingMachine vm = new VendingMachine();

        assertThrows(VendingMachineException.class, () -> vm.getItem("E"));
    }

    @Test 
    public void testRemoveItem_occupiedSlot() {
        
        VendingMachine vm = new VendingMachine();
        VendingMachineItem item = new VendingMachineItem("Chips", 1.50);
        vm.addItem(item, "A");

        VendingMachineItem removedItem = vm.removeItem("A");

        assertSame(item, removedItem);
        assertNull(vm.getItem("A"));
    }

    @Test 
    public void testRemoveItem_emptySlot() {

        VendingMachine vm = new VendingMachine();

        assertThrows(VendingMachineException.class, () -> vm.removeItem("A"));
    }

    @Test 
    public void testRemoveItem_invalidCode() {

        VendingMachine vm = new VendingMachine();

        assertThrows(VendingMachineException.class, () -> vm.removeItem("E"));
    }

    @Test 
    public void testRemoveItem_sameSlotTwice() {

        VendingMachine vm = new VendingMachine();
        vm.addItem(new VendingMachineItem("Chips", 1.50), "B");
        vm.removeItem("B");

        assertThrows(VendingMachineException.class, () -> vm.removeItem("B"));
    }
}
