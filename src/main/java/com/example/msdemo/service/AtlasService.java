package com.example.msdemo.service;

import com.example.msdemo.client.atlas.AtlasClient;
import com.example.msdemo.client.atlas.configuration.AtlasProperties;
import com.example.msdemo.model.request.AtlasCustomerSearchRequest;
import com.example.msdemo.model.response.AtlasCustomerResponse;
import com.example.msdemo.model.response.ComplexAgreement;
import com.example.msdemo.model.response.EligibilityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AtlasService {

    private final AtlasClient atlasClient;
    private final AtlasProperties atlasProperties;

    public List<AtlasCustomerResponse> getCustomerByCif(String cif) {
        AtlasCustomerSearchRequest request = new AtlasCustomerSearchRequest();
        request.setCif(cif);
        return atlasClient.searchCustomers(request);
    }

    public EligibilityResponse checkEligibility(String cif) {

        AtlasCustomerSearchRequest request = new AtlasCustomerSearchRequest();
        request.setCif(cif);

        List<AtlasCustomerResponse> customers = atlasClient.searchCustomers(request);

        if (customers == null || customers.isEmpty()) {
            return new EligibilityResponse(false, "Customer not found");
        }

        AtlasCustomerResponse customer = customers.get(0);

        return evaluate(customer);
    }

    public String getCustomerType(String cif) {
        AtlasCustomerSearchRequest request = new AtlasCustomerSearchRequest();
        request.setCif(cif);

        List<AtlasCustomerResponse> customers = atlasClient.searchCustomers(request);

        if (customers == null || customers.isEmpty()) {
            throw new RuntimeException("Customer not found");
        }

        return customers.getFirst().getType();
    }

    public ComplexAgreement getAgreement(String cif) {
        AtlasCustomerSearchRequest request = new AtlasCustomerSearchRequest();
        request.setCif(cif);

        List<AtlasCustomerResponse> customers = atlasClient.searchCustomers(request);

        if (customers == null || customers.isEmpty()) {
            throw new RuntimeException("Customer not found");
        }

        return customers.getFirst().getComplexAgreement();
    }

    private EligibilityResponse evaluate(AtlasCustomerResponse customerResponse) {
        if ("INDIVIDUAL".equalsIgnoreCase(customerResponse.getType())) {
            return new EligibilityResponse(true, null);
        }

        Long categoryId = customerResponse.getCategoryId();

        if (categoryId == null) {
            return new EligibilityResponse(false, "CategoryId is missing");
        }

        if (isBlockedCategory(categoryId)) {
            return new EligibilityResponse(false, "Ordering is not allowing for this category");
        }

        if (!hasValidAgreement(customerResponse.getComplexAgreement())) {
            return new EligibilityResponse(false, "Invalid agreement version");
        }
        return new EligibilityResponse(true, null);
    }

    private boolean isBlockedCategory(Long categoryId) {
        return atlasProperties.getBlockedCategories() != null
                && atlasProperties.getBlockedCategories().contains(categoryId);
    }

    private boolean hasValidAgreement(ComplexAgreement agreement) {
        return agreement != null && agreement.getVersion() == 3;
    }
}
