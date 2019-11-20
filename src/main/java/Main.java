//import com.company.model.Invoice;
//import com.company.model.InvoiceDAO;

import org.bonitasoft.engine.api.APIClient;
import org.bonitasoft.engine.api.ApiAccessType;
import org.bonitasoft.engine.bdm.BusinessObjectDaoCreationException;
import org.bonitasoft.engine.bpm.process.ProcessInstanceNotFoundException;
import org.bonitasoft.engine.business.data.BusinessDataRepositoryException;
import org.bonitasoft.engine.exception.ServerAPIException;
import org.bonitasoft.engine.exception.UnknownAPITypeException;
import org.bonitasoft.engine.expression.ExpressionEvaluationException;
import org.bonitasoft.engine.platform.LoginException;
import org.bonitasoft.engine.platform.LogoutException;
import org.bonitasoft.engine.util.APITypeManager;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String... args) throws ServerAPIException, UnknownAPITypeException, LoginException, ExpressionEvaluationException, ProcessInstanceNotFoundException, BusinessObjectDaoCreationException, IOException, BusinessDataRepositoryException, LogoutException {

        // Configure the client
        Map<String, String> settings = new HashMap<>();
        settings.put("server.url", "http://localhost:8080/");
        settings.put("application.name", "bonita");
        APITypeManager.setAPITypeAndParams(ApiAccessType.HTTP, settings);

        // Instantiate the API client and login
        APIClient apiClient = new APIClient();
        apiClient.login("walter.bates", "bpm");

        System.out.println(apiClient.getSession().getUserId());

        // FIXME: work in progress on usage of BDM DAO in a Java standalone application
        /*
        // Get a reference to processAPI and used it to get the process instance execution context for a running instance with id equals to 2
        final ProcessAPI processAPI = apiClient.getProcessAPI();
        Map<String, Serializable> processInstanceExecutionContext = processAPI.getProcessInstanceExecutionContext(2L);

        // Display the content of the context
        for (String key : processInstanceExecutionContext.keySet()) {
            System.out.println(key);
        }

        // From the context get the BusinessDataReference using the name of the business variable + "ref_"
        // Cast the BusinessDataReference to the appropriate subtype: SimpleBusinessDataReference or MultipleBusinessDataReference
        MultipleBusinessDataReference refCars = (MultipleBusinessDataReference) processInstanceExecutionContext.get("cars_ref");

        // Create a list of objects to store our multiple business variable values
        List<Car> cars = new ArrayList();

        // Get a reference to the business object DAO
        CarDAO carDAO = apiClient.getDAO(CarDAO.class);

        // Iterate over the list of storage ids provided by the MultipleBusinessDataReference
        for (Long storageId : refCars.getStorageIds()) {
            System.out.println("Storage id: " + storageId);
            // Use the DAO to get the business object value and add it to the list
            cars.add(carDAO.findByPersistenceId(storageId));
        }

        for (Car car : cars) {
            System.out.println(car.getBrand() + " " + car.getColor());
        }
        */

        apiClient.logout();
    }
}
