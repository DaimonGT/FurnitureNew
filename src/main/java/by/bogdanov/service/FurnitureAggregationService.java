package by.bogdanov.service;

import javax.inject.Inject;

public class FurnitureAggregationService {
    private final FurniturePostgresService furniturePostgresService;
    private final FurnitureMongoService furnitureMongoService;

    @Inject
    public FurnitureAggregationService(FurniturePostgresService furniturePostgresService, FurnitureMongoService furnitureMongoService) {
        this.furniturePostgresService = furniturePostgresService;
        this.furnitureMongoService = furnitureMongoService;
    }


}
