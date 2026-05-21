import com.stschool.ecommerce.controller.CustomerController;
import com.stschool.ecommerce.exception.CustomerExistsException;
import com.stschool.ecommerce.exception.CustomerNotFoundException;
import com.stschool.ecommerce.exception.InvalidCredentialsException;
import com.stschool.ecommerce.factory.AppFactory;
import com.stschool.ecommerce.model.Customer;
import com.stschool.ecommerce.repository.CustomerRepository;
import com.stschool.ecommerce.service.CustomerService;
import com.stschool.ecommerce.service.CustomerServiceImpl;
import com.stschool.ecommerce.ui.CustomerUI;
import com.stschool.ecommerce.util.CsvReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("E-Commerce Application");
       /* CsvReader csvReader = new CsvReader();
        CustomerRepository customerRepository = new CustomerRepository(csvReader);
        System.out.println(customerRepository.getCustomers());*/
        CustomerController customerController = AppFactory.getCustomerControllerInstance();
         CustomerUI customerUI = new CustomerUI(customerController);
       /* try {
            Customer registeredCustomer = customerUI.registerCustomer();
            if(registeredCustomer != null)
                System.out.println("Customer registered successfully");

        } catch (CustomerExistsException e) {
            System.out.println("Registration Failed:");
            System.out.println(e.getMessage());

        }*/
        try{
           Customer existingCustomer =  customerUI.loginCustomer();
           if(existingCustomer != null)
               System.out.println("Login Successful, Welcome: " + existingCustomer.getName() );
        } catch(CustomerNotFoundException | InvalidCredentialsException e){
            System.out.println(e.getMessage());
        }


    }
}