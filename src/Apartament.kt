package app
data class Apartament(var Rent: Double, var adress: Adress, var Area: Double, var CntRooms: Int,
    var IsRented: Boolean) {

    operator fun plus(other: Int): Apartament {
        return Apartament(this.Rent + other, this.adress, this.Area, this.CntRooms, this.IsRented)
    }

    
    //    override fun toString(): String {
//        //return super.toString()
//    }
}

data class Adress(var Street: String, var ApartmentNumb: Int, var HouseNumb: Int){}
