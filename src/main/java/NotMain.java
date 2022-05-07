import exception.NotExistException;
import model.Customer;
import repository.CustomerRepo;

public class NotMain {

    // I'm using this main for tests atm.
    public static void main(String[] args) throws NotExistException {

        CustomerRepo customerRepo = new CustomerRepo();

        // Adds a new customer to the DB
        Customer customer = new Customer();
        customer.setName("Brendan");
        customer.setAge(23);
        customer.setAddress("Avenida Roberto Silveira");
        customerRepo.add(customer);

        Customer newCustomer = customerRepo.get(1);
        System.out.println(newCustomer.getName());
    }

}
