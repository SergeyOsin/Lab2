package app
data class Apartament(var Rent: Double, var adress: Adress, var Area: Double, var CntRooms: Int,
    var IsRented: Boolean) {}

data class Adress(var Street: String, var ApartmentNumb: Int, var HouseNumb: Int){}
