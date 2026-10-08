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
}
