package sam.samyups.retrofit

import sam.samyups.model.Dog
import sam.samyups.util.EntityMapper
import javax.inject.Inject

class NetworkMapper
@Inject
constructor() : EntityMapper<DogNetworkEntity, Dog> {

    override fun mapFromEntity(entity: DogNetworkEntity): Dog {
        return Dog(
            id = entity.id,
            name = entity.name,
            temperament = entity.temperament,
            life_span = entity.life_span,
            alt_names = entity.alt_names,
            wikipedia_url = entity.wikipedia_url,
            origin = entity.origin,
            weight = entity.weight,
            country_code = entity.country_code,
            height = entity.height,
            bred_for = entity.bred_for,
            breed_group = entity.breed_group,
            reference_image_id = entity.reference_image_id,
            image = entity.image
        )
    }

    override fun mapToEntity(domainModel: Dog): DogNetworkEntity {
        return DogNetworkEntity(
            id = domainModel.id,
            name = domainModel.name,
            temperament = domainModel.temperament,
            life_span = domainModel.life_span,
            alt_names = domainModel.alt_names,
            wikipedia_url = domainModel.wikipedia_url,
            origin = domainModel.origin,
            weight = domainModel.weight,
            country_code = domainModel.country_code,
            height = domainModel.height,
            bred_for = domainModel.bred_for,
            breed_group = domainModel.breed_group,
            reference_image_id = domainModel.reference_image_id,
            image = domainModel.image
        )
    }

    fun mapFromEntityList(entities: List<DogNetworkEntity>): List<Dog> {
        return entities.map { mapFromEntity(it) }
    }
}