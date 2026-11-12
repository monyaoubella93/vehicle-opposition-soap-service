package local.verifopposition.client;

import local.verifopposition.wsdl.VerifOppositionRequest;
import local.verifopposition.wsdl.VerifOppositionResponse;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

public class VerifOppositionClient {

    public static void main(String[] args) {
        // 1. Configurer le convertisseur XML <-> Java (Marshaller)
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("local.verifopposition.wsdl");

        // 2. Créer le client SOAP Spring WS
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(marshaller);
        webServiceTemplate.setUnmarshaller(marshaller);

        // 3. Préparer la requête avec un numéro d'immatriculation
        VerifOppositionRequest request = new VerifOppositionRequest();
        request.setNumeroImmatriculation("1234-AB-5");

        // 4. Appeler le service web SOAP (le serveur doit être démarré sur le port 8084)
        String uri = "http://localhost:8084/ws";
        VerifOppositionResponse response = (VerifOppositionResponse) webServiceTemplate
                .marshalSendAndReceive(uri, request);

        // 5. Afficher le résultat dans la console
        System.out.println("=== RÉSULTAT DU CLIENT SOAP ===");
        System.out.println("Véhicule : " + request.getNumeroImmatriculation());
        System.out.println("En opposition : " + response.isOpposition());
        System.out.println("Message : " + response.getMessage());
    }
}