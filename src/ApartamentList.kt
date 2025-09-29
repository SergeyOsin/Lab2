package app

enum class PropertyCriteria {
    RENT, NUMB, AREA, CNTROOMS, ISRENTED
}

enum class SortCriteria {
    STRAIGHT, REVERSE
}

fun apartments(block: ApartamentList.() -> Unit): Unit {
    return ApartamentList().block()
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

    object by {
        operator fun invoke(typeAndProperty: Pair<String, PropertyCriteria>) = typeAndProperty
        operator fun invoke(sortAndPropCriterias: Pair<SortCriteria, PropertyCriteria>) =
            sortAndPropCriterias
    }

    infix fun <T>filter(typeAndProperty: Pair <String, PropertyCriteria>): List<Apartament>?{
        var(crit, typeCrit) = typeAndProperty

        when(typeCrit){
            PropertyCriteria.RENT ->
                return innerDataBase.filter{
                    it.Rent.toString().startsWith(crit)
                }
            PropertyCriteria.NUMB->
                 return innerDataBase.filter{
                    it.adress.ApartmentNumb.toString().startsWith(crit)
                }
            PropertyCriteria.AREA ->
                return innerDataBase.filter {
                    it.Area.toString().startsWith(crit)
                }
            PropertyCriteria.CNTROOMS->
                return  innerDataBase.filter {
                    it.CntRooms.toString().startsWith(crit)
                }
            PropertyCriteria.ISRENTED ->
                return innerDataBase.filter {
                    it.IsRented.toString().startsWith(crit)
                }
            else -> return null
        }
    }

    //sortCrit: SortCriteria, propCrit: PropertyCriteria
    infix fun sort(sortAndPropCriterias: Pair<SortCriteria, PropertyCriteria>): Unit {
        var(sortCrit, propCrit) = sortAndPropCriterias
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

    infix fun search(numb: Int): Apartament? {
        return innerDataBase.find{it.adress.ApartmentNumb == numb}
    }



}

