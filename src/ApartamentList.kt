package app

enum class PropertyCriteria {
    RENT, NUMB, AREA, CNTROOMS
}

enum class SortCriteria {
    STRAIGHT, REVERSE
}

class ApartamentList() {

    private val innerDataBase: MutableList<Apartament> = mutableListOf()

    fun add(appart: Apartament): Boolean{
        if (innerDataBase.find {it.Numb == appart.Numb} == null){
            innerDataBase.add(appart)
            return true
        }
        return false
    }

    fun delete(numb: Int): Boolean{
        var apart: Apartament? = innerDataBase.find {it.Numb == numb}
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
            PropertyCriteria.NUMB ->
                 return innerDataBase.filter{
                    it.Numb.toString().startsWith(crit.toString())
                }
            PropertyCriteria.AREA ->
                return innerDataBase.filter {
                    it.Area.toString().startsWith(crit.toString())
                }
            PropertyCriteria.CNTROOMS->
                return  innerDataBase.filter {
                    it.cntRooms.toString().startsWith(crit.toString())
                }
            else -> return null
        }
    }

    /*
    использовать when для критериев
    использовать sortBy для сортировки по возрастанию
    использовать sortByDescending для сортировки по убыванию
     */
    fun sort(sortCrit: SortCriteria, propCrit: PropertyCriteria): Unit {
        when (sortCrit) {
            SortCriteria.STRAIGHT ->
                when (propCrit) {
                    PropertyCriteria.AREA -> innerDataBase.sortBy { it.Area }
                    PropertyCriteria.NUMB -> innerDataBase.sortBy { it.Numb }
                    PropertyCriteria.RENT -> innerDataBase.sortBy { it.Rent }
                    PropertyCriteria.CNTROOMS -> innerDataBase.sortBy { it.cntRooms }
                    else-> return
                }

            SortCriteria.REVERSE ->
                when (propCrit) {
                    PropertyCriteria.AREA -> innerDataBase.sortByDescending { it.Area }
                    PropertyCriteria.NUMB -> innerDataBase.sortByDescending { it.Numb }
                    PropertyCriteria.RENT -> innerDataBase.sortByDescending { it.Rent }
                    PropertyCriteria.CNTROOMS -> innerDataBase.sortByDescending { it.cntRooms }
                    else -> return
                }
        }
        return
    }

    fun search(numb: Int): Apartament? {
        return innerDataBase.find{it.Numb == numb}
    }

}