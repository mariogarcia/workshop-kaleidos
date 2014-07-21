import groovy.transform.TupleConstructor

@TupleConstructor
class Person {
    String city
    String name
    Integer age
}

def cities = ['Madrid', 'Dublin', 'London', 'Barcelona', 'Nice', 'Paris', 'Chicago', 'New York', 'Brussels', 'Rome', 'Geneve']
def names = ['Ronnie', 'Ozzy', 'Rob', 'David', 'Michael', 'Sebastian', 'Steve', 'John', 'Mathias', 'Yngwie', 'Joe']
def ages = [22, 45, 64, 68, 47, 87, 45, 44, 45, 24, 37]

def people = [cities, names, ages].combinations() as Person[]

 // _____      _                        _ _          _   _                              _          _ _ 
 //| ____|_  _| |_ ___ _ __ _ __   __ _| (_)______ _| |_(_) ___  _ __    ___ _   _  ___| | _____  | | |
 //|  _| \ \/ / __/ _ \ '__| '_ \ / _` | | |_  / _` | __| |/ _ \| '_ \  / __| | | |/ __| |/ / __| | | |
 //| |___ >  <| ||  __/ |  | | | | (_| | | |/ / (_| | |_| | (_) | | | | \__ \ |_| | (__|   <\__ \ |_|_|
 //|_____/_/\_\\__\___|_|  |_| |_|\__,_|_|_/___\__,_|\__|_|\___/|_| |_| |___/\__,_|\___|_|\_\___/ (_|_)
 //                                                                                                    

class Messy {
    
    List<Person> findAllPeopleOlderThan30(Person[] all) {
        List<Person> filteredPeople = []
        all.each { person ->
            if (person.age > 30) {
                filteredPeople << person
            }
        }
        return filteredPeople
    }
    
}

assert new Messy()
    .findAllPeopleOlderThan30(people)
    .size() == 1089
    
    
//  _____    _ _____ ____   ____ ___ ____ ___ ___  ____   
// | ____|  | | ____|  _ \ / ___|_ _/ ___|_ _/ _ \/ ___|  
// |  _| _  | |  _| | |_) | |    | | |    | | | | \___ \  
// | |__| |_| | |___|  _ <| |___ | | |___ | | |_| |___) | 
// |_____\___/|_____|_| \_\\____|___\____|___\___/|____/  
//            

// [1] ELIMINAR ITERACION EXTERNA
// [2] REFACTORIZAR CONDICION A UN METODO
// [3] UTILIZAR METODO COMO CLOSURE
// [4] UTILIZAR GPARS 

/*
    import static groovyx.gpars.GParsPool.withPool
    
    return withPool {
        people.findAllParallel(condition)
    }

*/