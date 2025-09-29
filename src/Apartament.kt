package app
data class Apartament(var Rent: Double, var adress: Adress, var Area: Double, var CntRooms: Int,
    var IsRented: Boolean) {

    operator fun plus(other: Int): Apartament {
        return Apartament(this.Rent + other, this.adress, this.Area, this.CntRooms, this.IsRented)
    }

    operator fun inc(): Apartament {
        this.Rent + 1
        return this
    }

    override fun toString(): String {
        return "Квартира №${adress.ApartmentNumb} | " +
                "Площадь: $Area м² | " +
                "Комнат: $CntRooms | " +
                "Аренда: $Rent руб/мес | " +
                "Статус: ${if (IsRented) "Сдана" else "Свободна"}"
    }

}

data class Adress(var Street: String, var ApartmentNumb: Int, var HouseNumb: Int){}
