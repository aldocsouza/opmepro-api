package br.gov.pa.iasep.opmepro_api.services;

import br.gov.pa.iasep.opmepro_api.model.dtos.ApiResponse;
import br.gov.pa.iasep.opmepro_api.model.entities.Material;
import br.gov.pa.iasep.opmepro_api.repositories.MaterialRepository;
import org.springframework.stereotype.Service;

@Service
public class MaterialService {

    private final MaterialRepository materialRepository;

    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    public ApiResponse saveMaterial(Material material){
        this.materialRepository.save(material);
        return new ApiResponse("Material cadastrado com sucesso!", true);
    }

}
