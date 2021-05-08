package com.example.soaptest;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pl.pollub.web_service.*;
import pl.pollub.web_service.Laptop;

import java.math.BigInteger;
import java.util.List;

@Endpoint
public class LaptopEndpoint {

    private static final String NAMESPACE_URI = "http://pollub.pl/web-service";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLaptopsByProducerRequest")
    @ResponsePayload
    public GetLaptopsByProducerResponse getLaptopsByProducer(@RequestPayload GetLaptopsByProducerRequest request) {
        GetLaptopsByProducerResponse response = new GetLaptopsByProducerResponse();

        response.setNumberOfLaptops(BigInteger.valueOf(69));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLaptopsByScreenTypeRequest")
    @ResponsePayload
    public GetLaptopsByScreenTypeResponse getLaptopsByProducer(@RequestPayload GetLaptopsByScreenTypeRequest request) {
        GetLaptopsByScreenTypeResponse response = new GetLaptopsByScreenTypeResponse();

        response.getLaptop().addAll(createSampleLaptop());

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLaptopsByScreenResolutionRequest")
    @ResponsePayload
    public GetLaptopsByScreenResolutionResponse getLaptopsByScreenResolution(@RequestPayload GetLaptopsByScreenResolutionRequest request) {
        GetLaptopsByScreenResolutionResponse response = new GetLaptopsByScreenResolutionResponse();

        response.setNumberOfLaptops(BigInteger.valueOf(420));

        return response;
    }

    private static List<Laptop> createSampleLaptop() {
        Laptop laptop1 = new Laptop();
        laptop1.setCpuCores(BigInteger.valueOf(1939));
        laptop1.setDiscDrive("dupa");
        laptop1.setGraphicCard("dupa");
        laptop1.setRam("dupa");
        laptop1.setVRam("dupa");

        Laptop laptop2 = new Laptop();
        laptop2.setCpuCores(BigInteger.valueOf(1999));
        laptop2.setRam("dupa2");
        laptop2.setVRam("dupa2");

        return List.of(laptop1, laptop2);
    }
}
