package edu.pe.leadyourway.bikemicroservice.application.mapper;

import edu.pe.leadyourway.bikemicroservice.domain.model.Bicycle;
import edu.pe.leadyourway.bikemicroservice.infrastructure.entity.BicycleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BicycleMapper {
    BicycleMapper INSTANCE = Mappers.getMapper(BicycleMapper.class);
    BicycleEntity bicycleModelToEntity(Bicycle bicycle);

    Bicycle bicycleEntityToModel(BicycleEntity bicycleEntity);

    List<Bicycle> bicycleEntityListToModelList(List<BicycleEntity> bicycleEntities);
}
