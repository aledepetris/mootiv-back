package com.mootiv.service;

import com.mootiv.shared.AffectionRequest;
import com.mootiv.shared.AffectionResponse;

import java.util.List;

public interface AffectionCrudService {

    List<AffectionResponse> getAffections();
    AffectionResponse createAffection(AffectionRequest request);
    AffectionResponse updateAffection(Integer id, AffectionRequest request);
    AffectionResponse getAffection(Integer id);
    void deleteAffection(Integer id);

}
