# Service Web SOAP – Vérification d'Opposition Véhicule

Application backend exposant un service web SOAP (Contract-First) permettant de vérifier le statut d'opposition judiciaire ou administrative d'un véhicule à partir de son numéro d'immatriculation.

## Technologies utilisées
- **Java 17** & **Spring Boot 3**
- **Spring Web Services (Spring-WS)** & **JAXB** (génération de classes depuis XSD/WSDL)
- **Spring Data JPA** & **MySQL**
- **Client SOAP Java** (WebServiceTemplate) & **Maven**

## Fonctionnalités
- Exposition dynamique du contrat **WSDL** (/ws/verifOpposition.wsdl)
- Interrogation de la base MySQL par numéro d'immatriculation
- Consommation du service via un client Java autonome (VerifOppositionClient)
