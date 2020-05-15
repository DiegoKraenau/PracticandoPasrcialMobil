package com.piero.misjobs

import com.google.gson.annotations.SerializedName

class Job {

    @SerializedName("title")
    var title: String = ""
    @SerializedName("company")
    var company: String = ""
    @SerializedName("description")
    var description: String = ""
    @SerializedName("company_logo")
    var company_logo: String = ""


}