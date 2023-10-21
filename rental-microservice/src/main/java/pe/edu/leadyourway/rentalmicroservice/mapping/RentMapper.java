package pe.edu.leadyourway.rentalmicroservice.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pe.edu.leadyourway.rentalmicroservice.domain.model.entity.Rent;
import pe.edu.leadyourway.rentalmicroservice.resource.CreateRentResource;
import pe.edu.leadyourway.rentalmicroservice.resource.RentResource;
import pe.edu.leadyourway.rentalmicroservice.resource.UpdateRentResource;
import pe.edu.leadyourway.rentalmicroservice.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class RentMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public RentResource toResource(Rent model) {
        return mapper.map(model, RentResource.class);
    }

    public Rent toModel(CreateRentResource resource) {
        return mapper.map(resource, Rent.class);
    }

    public Rent toModel(UpdateRentResource resource) {
        return mapper.map(resource, Rent.class);
    }

    public Page<RentResource> modelListPage(List<Rent> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, RentResource.class), pageable, modelList.size());
    }
}
