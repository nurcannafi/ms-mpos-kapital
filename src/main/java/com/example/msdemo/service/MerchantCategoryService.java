package com.example.msdemo.service;

import com.example.msdemo.domain.entity.ActivityCodeMccMappingEntity;
import com.example.msdemo.domain.entity.MerchantCategoryCodeEntity;
import com.example.msdemo.domain.repository.ActivityCodeMccMappingRepository;
import com.example.msdemo.domain.repository.MerchantCategoryCodeRepository;
import com.example.msdemo.model.response.MccMcgResponse;
import com.example.msdemo.model.response.TaxActivityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MerchantCategoryService {

    private final TaxesService taxesService;
    private final ActivityCodeMccMappingRepository activityCodeMccMappingRepository;
    private final MerchantCategoryCodeRepository merchantCategoryCodeRepository;

    public MccMcgResponse getMccMcgByTin(String tin) {
        TaxActivityResponse taxActivity = taxesService.getActivity(tin);

        if (taxActivity == null) {
            throw new RuntimeException("Tax activity not found for tin " + tin);
        }

        String activityCode = taxActivity.getActivityCode();
        ActivityCodeMccMappingEntity mapping = activityCodeMccMappingRepository
                .findByActivityCode(activityCode)
                .orElseThrow(() -> new RuntimeException("MCC not found for activity code " + activityCode));

        MerchantCategoryCodeEntity categoryCode = merchantCategoryCodeRepository
                .findByCode(mapping.getMcc())
                .orElseThrow(() -> new RuntimeException("MCG not found for mcc " + mapping.getMcc()));

        return MccMcgResponse.builder()
                .mcc(mapping.getMcc())
                .mcg(categoryCode.getMcgId())
                .build();
    }
}
