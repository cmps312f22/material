package com.msms.scaffoldsession1.models
import kotlinx.serialization.Serializable

@Serializable
data class Breed(
    var weight: Weight= Weight("",""),
    var id:String="Missing",
    var name: String="Missing",
    var cfa_url:String="Missing",
    var vetstreet_url:String="Missing",
    var vcahospitals_url:String="Missing",
    var temperament:String="Missing",
    var origin:String="Missing",
    var country_codes:String="Missing",
    var country_code:String="Missing",
    var description: String="Missing",
    var life_span:String="Missing",
    var indoor:Int=-1,
    var lap:Int=-1,
    var alt_names:String="Missing",
    var adaptability:Int=-1,
    var affection_level:Int=-1,
    var child_friendly:Int=-1,
    var cat_friendly:Int=-1,
    var dog_friendly:Int=-1,
    var energy_level:Int=-1,
    var grooming: Int=-1,
    var health_issues: Int=-1,
    var intelligence:Int=-1,
    var shedding_level:Int=-1,
    var social_needs:Int=-1,
    var stranger_friendly:Int=-1,
    var vocalisation:Int=-1,
    var bidability:Int=-1,
    var experimental:Int=-1,
    var hairless:Int=-1,
    var natural:Int=-1,
    var rare:Int=-1,
    var rex:Int=-1,
    var suppressed_tail:Int=-1,
    var short_legs:Int=-1,
    var wikipedia_url:String="Missing",
    var hypoallergenic:Int=-1,
    var reference_image_id:String="Missing",
    var image:Image=Image("",-1,-1,""),
    )

@Serializable
data class Weight(
    var imperial:String,
    var metric:String,
)

@Serializable
data class Image(
    var id:String,
    var width:Int,
    var height:Int,
    var url:String,
)