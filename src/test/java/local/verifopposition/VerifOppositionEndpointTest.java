package local.verifopposition;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.xml.transform.StringSource;

import static org.springframework.ws.test.server.RequestCreators.withPayload;

@SpringBootTest
public class VerifOppositionEndpointTest {

    @Autowired
    private ApplicationContext applicationContext;

    private MockWebServiceClient mockClient;

    @BeforeEach
    public void init() {
        mockClient = MockWebServiceClient.createClient(applicationContext);
    }

    @Test
    public void testVerifOpposition() {
        StringSource requestPayload = new StringSource(
            "<ver:VerifOppositionRequest xmlns:ver=\"http://local.verifopposition\">" +
            "   <ver:numeroImmatriculation>1234-AB-5</ver:numeroImmatriculation>" +
            "</ver:VerifOppositionRequest>"
        );

        mockClient.sendRequest(withPayload(requestPayload));
    }
}