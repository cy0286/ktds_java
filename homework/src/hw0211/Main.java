package hw0211;

public class Main {

	public static void main(String[] args) {
        Product p1 = new Product(1, "스탠리", 15000, 1, 3);
        Product p2 = new Product(2, "텀블러", 12000, 10, 5);
        Product p3 = new Product(3, "보온병", 5000, 4, -1); 

        Product[] products = { p1, p2, p3 };
        
        VendingMachine vm = new VendingMachine(products);
        vm.printStock();
        Customer customer = new Customer(40000, products); 
        
        try {
            vm.sell(1, 15000, customer);
            customer.printCustomerStatus();
        } 
        catch (ExpiredProductException | SoldOutException | NeedMoreMoneyException e) {
            System.out.println(e.getMessage());
        }
        vm.printStock();
        
        try {
            vm.sell(3, 2500, customer); 
            customer.printCustomerStatus();
        } 
        catch (ExpiredProductException | SoldOutException | NeedMoreMoneyException e) {
            System.out.println(e.getMessage());
        }
        vm.printStock();
        
        try {
        	vm.sell(2, 1000, customer);
        }
        catch (ExpiredProductException | SoldOutException | NeedMoreMoneyException e) {
            System.out.println(e.getMessage());
        }
        vm.printStock();
        
        try {
            vm.sell(1, 15000, customer);
            customer.printCustomerStatus();
        } 
        catch (ExpiredProductException | SoldOutException | NeedMoreMoneyException e) {
            System.out.println(e.getMessage());
        }
        vm.printStock();
	}
}
