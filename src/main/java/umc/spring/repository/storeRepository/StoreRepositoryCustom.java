package umc.spring.repository.storeRepository;

import umc.spring.domain.Restaurant;

import java.util.List;

public interface StoreRepositoryCustom {

    List<Restaurant> dynamicQueryWithBooleanBuilder(String name, Float score);
}
