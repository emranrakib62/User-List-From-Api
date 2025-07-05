package com.example.addressbookapi.datamodel

data class Address(
    var street:String="",
    var suite:String="",
    var city:String="",
    var zipcode:String="",
    var geo:Geo




)

/*



"address": {
      "street": "Douglas Extension",
      "suite": "Suite 847",
      "city": "McKenziehaven",
      "zipcode": "59590-4157",
      "geo": {
        "lat": "-68.6102",
        "lng": "-47.0653"
      }
 */
