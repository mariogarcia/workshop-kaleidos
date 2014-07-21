import groovy.transform.Immutable

@Immutable class Person {
    String city
    String name
    Integer age
}

def cities = ['Madrid', 'Dublin', 'London', 'Barcelona', 'Nice', 'Paris', 'Chicago', 'New York', 'Brussels', 'Rome', 'Geneve']
def names = ['Ronnie', 'Ozzy', 'Rob', 'David', 'Michael', 'Sebastian', 'Steve', 'John', 'Mathias', 'Yngwie', 'Joe']
def ages = [22, 45, 64, 68, 47, 87, 45, 44, 45, 24, 37]

def sample = [cities, names, ages].combinations() as Person[]

//   ____                                _                __ _ _ _                
//  / ___|___  _ __ ___  _ __   ___  ___(_)_ __   __ _   / _(_) | |_ ___ _ __ ___ 
// | |   / _ \| '_ ` _ \| '_ \ / _ \/ __| | '_ \ / _` | | |_| | | __/ _ \ '__/ __|
// | |__| (_) | | | | | | |_) | (_) \__ \ | | | | (_| | |  _| | | ||  __/ |  \__ \
//  \____\___/|_| |_| |_| .__/ \___/|___/_|_| |_|\__, | |_| |_|_|\__\___|_|  |___/
//                      |_|                      |___/                            
                                                                                  
class MyService {

    final Person[] people
    MyService(Person[] people) {
        this.people = people
    }
    
    List<Person> findAllPeopleOlderThanThirty() {
        return people.findAll { it.age > 30 }
    }
    
    List<Person> findAllPeopleOlderThanFourty() {
        return people.findAll { it.age > 40 }
    }
    
    List<Person> findAllPeopleWithNameStartingWithR() {
        return people.findAll { it.name.startsWith('R') }
    }
 
    List<Person> findAllPeopleOlderThanThirtyWithNameStartingWithR() {
        // No se puede recorrer la lista mas de una vez
        // Las expressiones deben reutilizarse
        // No se permiten bucles anidados
    }       
}

def myService = new MyService(sample)

myService.findAllPeopleOlderThanThirty().size() == 1089
myService.findAllPeopleOlderThanFourty().size() == 968
myService.findAllPeopleWithNameStartingWithR().size() == 242
