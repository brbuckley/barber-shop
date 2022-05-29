public class SetupDataBase {

  //  public static void setup() throws NotExistException {
  //
  //    CustomerRepo customerRepo = new CustomerRepo();
  //    ShopRepo shopRepo = new ShopRepo();
  //    BarberRepo barberRepo = new BarberRepo();
  //    HaircutRepo haircutRepo = new HaircutRepo();
  //    AppointmentRepo appointmentRepo = new AppointmentRepo();
  //    QueueRepo queueRepo = new QueueRepo();
  //
  //    Customer customer = new Customer();
  //    customer.setName("Brendan");
  //    customer.setAge(23);
  //    customer.setAddress("Avenida Roberto Silveira");
  //    customerRepo.add(customer);
  //
  //    Customer customer2 = new Customer();
  //    customer2.setName("Carol");
  //    customerRepo.add(customer2);
  //
  //    Customer customer3 = new Customer();
  //    customer3.setName("Jão");
  //    customerRepo.add(customer3);
  //
  //    Shop shop = new Shop();
  //    shop.setName("Barbearia do Zé");
  //    shopRepo.add(shop);
  //
  //    Barber barber = new Barber();
  //    barber.setName("Zé");
  //    barber.setShop(shop);
  //    // this next line might crash
  //    shop.getBarbers().add(barber);
  //    barberRepo.add(barber);
  //
  //    Barber barber2 = new Barber();
  //    barber2.setName("Ramalho");
  //    barber2.setShop(shop);
  //    // this next line might crash
  //    shop.getBarbers().add(barber2);
  //    barberRepo.add(barber2);
  //
  //    Haircut haircut = new Haircut();
  //    haircut.setDescription("Barba, cabelo e bigode");
  //    haircutRepo.add(haircut);
  //
  //    Haircut haircut2 = new Haircut();
  //    haircut2.setDescription("Só Barba");
  //    haircutRepo.add(haircut2);
  //
  //    Haircut haircut3 = new Haircut();
  //    haircut3.setDescription("Só Cabelo");
  //    haircutRepo.add(haircut3);
  //
  //    Haircut haircut4 = new Haircut();
  //    haircut4.setDescription("Só Bigode");
  //    haircutRepo.add(haircut4);
  //
  //    Appointment appointment = new Appointment();
  //    appointment.setBarber(barber);
  //    barber.getAppointments().add(appointment);
  //    appointment.setCustomer(customer);
  //    customer.getAppointments().add(appointment);
  //    appointment.setHaircut(haircut);
  //    haircut.getAppointments().add(appointment);
  //    appointmentRepo.save(appointment);
  //
  //    Appointment appointment2 = new Appointment();
  //    appointment2.setBarber(barber2);
  //    barber2.getAppointments().add(appointment2);
  //    appointment2.setCustomer(customer2);
  //    customer2.getAppointments().add(appointment2);
  //    appointment2.setHaircut(haircut2);
  //    haircut2.getAppointments().add(appointment2);
  //    appointmentRepo.save(appointment2);
  //
  //    Appointment appointment3 = new Appointment();
  //    appointment3.setBarber(barber2);
  //    barber2.getAppointments().add(appointment3);
  //    appointment3.setCustomer(customer3);
  //    customer3.getAppointments().add(appointment3);
  //    appointment3.setHaircut(haircut3);
  //    haircut3.getAppointments().add(appointment3);
  //    appointmentRepo.save(appointment3);
  //
  //    Queue queue = new Queue();
  //    queue.setBarber(barber);
  //    queue.getAppointments().add(appointment);
  //    appointment.setQueue(queue);
  //    queueRepo.add(queue);
  //
  //    Queue queue2 = new Queue();
  //    queue2.setBarber(barber2);
  //    queue2.getAppointments().add(appointment2);
  //    appointment2.setQueue(queue2);
  //    queue2.getAppointments().add(appointment3);
  //    appointment3.setQueue(queue2);
  //    queueRepo.add(queue2);
  //  }
}
