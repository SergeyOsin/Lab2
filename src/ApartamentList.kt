package app

enum class PropertyCriteria {
    RENT, NUMB, AREA, CNTROOMS, ISRENTED
}

enum class SortCriteria {
    STRAIGHT, REVERSE
}

class ApartamentList() {

    private val innerDataBase: MutableList<Apartament> = mutableListOf()

    fun add(appart: Apartament): Boolean{
        if (innerDataBase.find {it.adress.ApartmentNumb == appart.adress.ApartmentNumb} == null){
            innerDataBase.add(appart)
            return true
        }
        return false
    }

    fun delete(numb: Int): Boolean{
        var apart: Apartament? = innerDataBase.find {it.adress.ApartmentNumb == numb}
        if (apart != null){
            innerDataBase.remove(apart)
            return true
        }
        return false
    }

    fun <T>filter(crit: T, typeCrit: PropertyCriteria): List<Apartament>?{
        when(typeCrit){
            PropertyCriteria.RENT ->
                return innerDataBase.filter{
                    it.Rent.toString().startsWith(crit.toString())
                }
            PropertyCriteria.NUMB->
                 return innerDataBase.filter{
                    it.adress.ApartmentNumb.toString().startsWith(crit.toString())
                }
            PropertyCriteria.AREA ->
                return innerDataBase.filter {
                    it.Area.toString().startsWith(crit.toString())
                }
            PropertyCriteria.CNTROOMS->
                return  innerDataBase.filter {
                    it.CntRooms.toString().startsWith(crit.toString())
                }
            PropertyCriteria.ISRENTED ->
                return innerDataBase.filter {
                    it.IsRented.toString().startsWith(crit.toString())
                }
            else -> return null
        }
    }
    
    fun sort(sortCrit: SortCriteria, propCrit: PropertyCriteria): Unit {
        when (sortCrit) {
            SortCriteria.STRAIGHT ->
                when (propCrit) {
                    PropertyCriteria.AREA -> innerDataBase.sortBy { it.Area }
                    PropertyCriteria.NUMB -> innerDataBase.sortBy { it.adress.ApartmentNumb }
                    PropertyCriteria.RENT -> innerDataBase.sortBy { it.Rent }
                    PropertyCriteria.CNTROOMS -> innerDataBase.sortBy { it.CntRooms }
                    else-> return
                }

            SortCriteria.REVERSE ->
                when (propCrit) {
                    PropertyCriteria.AREA -> innerDataBase.sortByDescending { it.Area }
                    PropertyCriteria.NUMB -> innerDataBase.sortByDescending { it.adress.ApartmentNumb }
                    PropertyCriteria.RENT -> innerDataBase.sortByDescending { it.Rent }
                    PropertyCriteria.CNTROOMS -> innerDataBase.sortByDescending { it.CntRooms }
                    else -> return
                }
        }
        return
    }

    fun search(numb: Int): Apartament? {
        return innerDataBase.find{it.adress.ApartmentNumb == numb}
    }

}