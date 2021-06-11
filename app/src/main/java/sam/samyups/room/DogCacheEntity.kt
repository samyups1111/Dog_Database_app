package sam.samyups.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Dogs")
data class DogCacheEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "temperament")
    var temperament: String,

    @ColumnInfo(name = "life_span")
    var life_span: String,

    @ColumnInfo(name = "alt_names")
    var alt_names: String,

    @ColumnInfo(name = "wikipedia_url")
    var wikipedia_url: String,

    @ColumnInfo(name = "origin")
    var origin: String,

    @ColumnInfo(name = "weight")
    var weight: Any,

    @ColumnInfo(name = "country_code")
    var country_code: String,

    @ColumnInfo(name = "height")
    var height: Any,

    @ColumnInfo(name = "bred_for")
    var bred_for: String,

    @ColumnInfo(name = "breed_group")
    var breed_group: String,

    @ColumnInfo(name = "reference_image_id")
    var reference_image_id: String,

    @ColumnInfo(name = "image")
    var image: Any
)