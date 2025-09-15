package app

enum class PropertyCriteria {
    RENT, NUMB, ELECTRICITY, UTILITIES
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
            PropertyCriteria.ELECTRICITY ->
                return innerDataBase.filter {
                    it.Electricity.toString().startsWith(crit.toString())
                }
            PropertyCriteria.UTILITIES ->
                return  innerDataBase.filter {
                    it.Utilities.toString().startsWith(crit.toString())
                }
            else -> return null
        }
    }
    /*
    использовать when для критериев
    использовать sortBy для сортировки по возрастанию
    использовать sortByDescending для сортировки по убыванию
     */
    fun sort(sortCrit: SortCriteria, propCrit: PropertyCriteria){
        innerDataBase.sortBy {  }
    }

}