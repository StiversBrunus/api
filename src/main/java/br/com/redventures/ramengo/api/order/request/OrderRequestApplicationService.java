package br.com.redventures.ramengo.api.order.request;

import br.com.redventures.ramengo.api.broth.BrothDataStore;
import br.com.redventures.ramengo.api.infra.Security;
import br.com.redventures.ramengo.api.protein.ProteinDataStore;
import br.com.redventures.ramengo.api.validation.ValidationException;
import io.micrometer.common.util.StringUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class OrderRequestApplicationService {

    // Return the order with; orderId, description and image
    public OrderRequest order (OrderRequestForm orderRequestForm) throws IOException, InterruptedException, ValidationException {

        // TO DO: Validation for receive just one order

        // Get order number of the external Url
        String orderNumber = this.getOrderNumber(orderRequestForm.getToken());

        // build order giving the order number
        return this.buildOrder(orderNumber, orderRequestForm);
    }

    // Build order
    public OrderRequest buildOrder (String orderNumber, OrderRequestForm orderRequestForm){

        OrderRequest orderRequest = new OrderRequest();

        orderRequest.setId(orderNumber);
        orderRequest.setDescription(this.buildDescription(orderRequest, orderRequestForm));
        orderRequest.setImage(this.buildImage(Security.RAMEN_EXTERNAL_IMAGE_URL, orderRequest, orderRequestForm));

        return orderRequest;
    }

    // Build description order
    public String buildDescription (OrderRequest orderRequest, OrderRequestForm orderRequestForm) {

        String nameBroth = BrothDataStore.getNameById(orderRequestForm.getBrothId());
        String nameProtein = ProteinDataStore.getNameById(orderRequestForm.getProteinId());

        return orderRequest.buildDescription(nameBroth, nameProtein);
    }

    // Build image description
    public String buildImage (String externalUrl, OrderRequest orderRequest, OrderRequestForm orderRequestForm){

        String nameProtein = ProteinDataStore.getNameById(orderRequestForm.getProteinId());

        return orderRequest.buildImage(externalUrl, nameProtein);
    }

    // Get order number
    private String getOrderNumber(String token) throws IOException, InterruptedException, ValidationException {

        String orderNumber = authenticateExternalUrl(token);

        if (StringUtils.isBlank(orderNumber)){
            throw new ValidationException("Number Order is Empty or Null!");
        }

        return orderNumber;
    }

    // Get order number of the external Url
    private static String authenticateExternalUrl(String token) throws InterruptedException, IOException {

        String orderNumber;

        // created client
        HttpClient client = HttpClient.newHttpClient();

        // Doing request
        HttpRequest request = HttpRequest.newBuilder(
                URI.create(Security.EXTERNAL_URL))
                .header(Security.REQUEST_HEADER_NAME, token).POST(HttpRequest.BodyPublishers.noBody()).build();

        // Take response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Take responseBody
        String responseBody = response.body();

        // Convert from responseBody to JsonObject
        JSONObject jsonObject = new JSONObject(responseBody);

        // Take number from JsonObject
        orderNumber = jsonObject.getString(Security.KEY_JSON_NAME);

        return orderNumber;
    }
}
