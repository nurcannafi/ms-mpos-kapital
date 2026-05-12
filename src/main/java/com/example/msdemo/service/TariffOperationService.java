package com.example.msdemo.service;

import com.example.msdemo.domain.entity.TariffOperationByMcgEntity;
import com.example.msdemo.domain.entity.TccsEntity;
import com.example.msdemo.domain.repository.TariffOperationByMcgRepository;
import com.example.msdemo.domain.repository.TccsRepository;
import com.example.msdemo.model.response.MccMcgResponse;
import com.example.msdemo.model.response.TariffOperationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TariffOperationService {

    private final TccsRepository tccsRepository;
    private final TariffOperationByMcgRepository tariffOperationByMcgRepository;
    private final MerchantCategoryService merchantCategoryService;

    private static final String PRODUCT_TYPE = "POS";
    private static final List<Integer> PROPERTY_IDS = List.of(3, 4, 5);

    public List<TariffOperationResponse> getTariffsByTin(String tin) {

        MccMcgResponse mccMcg = merchantCategoryService.getMccMcgByTin(tin);
        Long mcgId = mccMcg.getMcg();

        List<TccsEntity> tccsList = tccsRepository
                .findByProductTypeAndPropertyIdIn(PRODUCT_TYPE, PROPERTY_IDS);

        if (tccsList.isEmpty()) {
            return getDefaultResponse(mcgId);
        }

        List<Long> tccsIds = tccsList.stream()
                .map(TccsEntity::getId)
                .toList();

        List<TariffOperationByMcgEntity> operations = tariffOperationByMcgRepository
                .findByTccsIdInAndMcgId(tccsIds, mcgId);

        if (operations.isEmpty()) {
            return getDefaultResponse(mcgId);
        }

        return operations.stream()
                .map(op -> TariffOperationResponse.builder()
                        .id(op.getId())
                        .tccsId(op.getTccsId())
                        .mcgId(op.getMcgId())
                        .operationCode(op.getOperationCode())
                        .build())
                .toList();
    }

    private List<TariffOperationResponse> getDefaultResponse(Long mcgId) {
        List<TariffOperationByMcgEntity> defaults = tariffOperationByMcgRepository
                .findByTccsIdInAndMcgId(List.of(5999L), mcgId);

        return defaults.stream()
                .map(op -> TariffOperationResponse.builder()
                        .id(op.getId())
                        .tccsId(op.getTccsId())
                        .mcgId(op.getMcgId())
                        .operationCode(op.getOperationCode())
                        .build())
                .toList();
    }
}
