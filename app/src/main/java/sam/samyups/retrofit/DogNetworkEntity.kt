package sam.samyups.retrofit

import com.google.gson.annotations.SerializedName

data class DogNetworkEntity(

    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("temperament")
    val temperament: String,

    @SerializedName("life_span")
    val life_span: String,

    @SerializedName("alt_names")
    val alt_names: String,

    @SerializedName("wikipedia_url")
    val wikipedia_url: String,

    @SerializedName("origin")
    val origin: String,

    @SerializedName("weight")
    val weight: Any,

    @SerializedName("country_code")
    val country_code: String,

    @SerializedName("height")
    val height: Any,

    @SerializedName("bred_for")
    val bred_for: String,

    @SerializedName("breed_group")
    val breed_group: String,

    @SerializedName("reference_image_id")
    val reference_image_id: String,

    @SerializedName("image")
    val image: Any
)
