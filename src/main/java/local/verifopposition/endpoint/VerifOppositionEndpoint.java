package local.verifopposition.endpoint;

import local.verifopposition.repository.OppositionRepository;
import local.verifopposition.wsdl.VerifOppositionRequest;
import local.verifopposition.wsdl.VerifOppositionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class VerifOppositionEndpoint {

    private static final String NAMESPACE_URI = "http://local.verifopposition";

    @Autowired
    private OppositionRepository oppositionRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "VerifOppositionRequest")
    @ResponsePayload
    public VerifOppositionResponse handleRequest(@RequestPayload VerifOppositionRequest request) {
        VerifOppositionResponse response = new VerifOppositionResponse();
        String numImmat = request.getNumeroImmatriculation();

        var oppositionOpt = oppositionRepository.findByNumeroImmatriculation(numImmat);

        if (oppositionOpt.isPresent()) {
            var opposition = oppositionOpt.get();
            response.setOpposition(opposition.isEnOpposition());
            response.setMessage(opposition.getMessage());
        } else {
            response.setOpposition(false);
            response.setMessage("Véhicule non trouvé. Aucune opposition détectée.");
        }
        return response;
    }
}