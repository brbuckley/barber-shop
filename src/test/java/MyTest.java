import exception.NotExistException;
import model.Appointment;
import model.Barber;
import model.Customer;
import model.Haircut;
import model.Shop;
import org.junit.jupiter.api.Test;
import repository.AppointmentRepo;
import repository.BarberRepo;
import repository.CustomerRepo;
import repository.HaircutRepo;
import repository.QueueRepo;
import repository.ShopRepo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTest {

    CustomerRepo customerRepo = new CustomerRepo("TestPersistence");

    @Test
    public void test1() throws NotExistException {

        // Adds a new customer to the DB
        Customer customer = new Customer();
        customer.setName("Brendan");
        customer.setAge(23);
        customer.setAddress("Avenida Roberto Silveira");
        customerRepo.add(customer);

        Customer newCustomer = customerRepo.get(1);
        assertEquals("Brendan",newCustomer.getName());
    }

    @Test
    public void test2() throws NotExistException {

        ShopRepo shopRepo = new ShopRepo("TestPersistence");
        BarberRepo barberRepo = new BarberRepo("TestPersistence");
        AppointmentRepo appointmentRepo = new AppointmentRepo("TestPersistence");

        SetupDataBase.setup();

        Customer newCustomer = customerRepo.get(1);
        assertEquals("Brendan",newCustomer.getName());

        Barber newBarber = barberRepo.get(1);
        assertEquals("Zé",newBarber.getName());

        Shop newShop = shopRepo.get(1);
        assertEquals("Barbearia do Zé",newShop.getName());
        // Here we assert that the Barber is linked to the shop
        assertEquals("Zé",newShop.getBarbers().get(0).getName());

        Appointment newAppointment = appointmentRepo.get(1);
        // Here we assert that the appointment links Barber Customer and Haircut together
        assertEquals("Brendan",newAppointment.getCustomer().getName());
        assertEquals("Zé",newAppointment.getBarber().getName());
        assertEquals("Barba, cabelo e bigode",newAppointment.getHaircut().getDescription());
    }

    @Test
    public void test3() throws NotExistException {

        QueueRepo queueRepo = new QueueRepo("TestPersistence");

        SetupDataBase.setup();

        assertEquals("Carol",queueRepo.get(2).getAppointments().get(0).getCustomer().getName());
        assertEquals("Jão",queueRepo.get(2).getAppointments().get(1).getCustomer().getName());
    }

}
