package uz.gita.masterclassmb2024.data.model

import com.google.gson.annotations.SerializedName

data class SignUpRequest(
    val phone: String,
    val password: String,
    @SerializedName("first-name")
    val firstName: String,
    @SerializedName("last-name")
    val lastName: String,
    @SerializedName("born-date")
    val bornDate: Long,
    val gender: Int//0 - Male, 1- Female
)
/*{
    "phone": "+998936949666",
    "password": "1234567",
    "first-name": "Azamjon",
    "last-name": "Alijonov",
    "born-date": "969822000000",
    "gender": "0"
}*/