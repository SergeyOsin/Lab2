package app

fun main(){
    apartments {
        add(Apartament(25000.0, Adress("Main Street", 101, 1), 55.0, 2, true))
        add(Apartament(30000.0, Adress("Second Street", 102, 1), 65.0, 3, false))
        add(Apartament(20000.0, Adress("Third Street", 103, 2), 45.0, 1, true))
        add(Apartament(40000.0, Adress("Fourth Street", 104, 2), 75.0, 4, false))
        add(Apartament(35000.0, Adress("Fifth Street", 105, 3), 70.0, 3, true))
    }
    val apartmentList = ApartamentList()
    println(apartmentList.add(Apartament(25000.0, Adress("Main Street", 101, 1), 55.0, 2, true))) // true
    println(apartmentList.add(Apartament(30000.0, Adress("Second Street", 102, 1), 65.0, 3, false))) // true
    println(apartmentList.add(Apartament(20000.0, Adress("Third Street", 103, 2), 45.0, 1, true))) // true
    println(apartmentList.add(Apartament(40000.0, Adress("Fourth Street", 104, 2), 75.0, 4, false))) // true
    println(apartmentList.add(Apartament(35000.0, Adress("Fifth Street", 105, 3), 70.0, 3, true))) // true
    println(apartmentList.add(Apartament(36000.0, Adress("Sixth Street", 101, 4), 80.0, 3, true))) // false, т.к. ApartmentNumb=101 уже есть
    println("\nСортировка по Rent по убыванию:")
    apartmentList.sort (SortCriteria.REVERSE to PropertyCriteria.RENT)
    println("\nФильтрация по IsRented = true:")


    val searchResult = apartmentList.search(102);
    println(searchResult)
    val deleteResult = apartmentList.delete(103);

    println(apartmentList);
    val selectedApartment = apartmentList select 104
    println(selectedApartment)
}