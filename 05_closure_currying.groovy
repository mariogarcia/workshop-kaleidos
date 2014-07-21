
//   ____                _  __ _                                                          _ _
//  / ___|   _ _ __ _ __(_)/ _(_) ___ __ _  __ _  __ _ _ __ ___  _ __ ___   ___  ___  ___| | |
// | |  | | | | '__| '__| | |_| |/ __/ _` |/ _` |/ _` | '_ ` _ \| '_ ` _ \ / _ \/ _ \/ _ \ | |
// | |__| |_| | |  | |  | |  _| | (_| (_| | (_| | (_| | | | | | | | | | | |  __/  __/  __/_|_|
//  \____\__,_|_|  |_|  |_|_| |_|\___\__,_|\__,_|\__,_|_| |_| |_|_| |_| |_|\___|\___|\___(_|_)
//

def increment = { Integer increment = 1, Integer valueToIncrement ->
    return valueToIncrement + (increment * 2)
}

// CURRY
def curriedIncrement1 = increment.curry(2)
assert curriedIncrement1(2) == 6









// ADELANTANDO POR LA DERECHA
def curriedIncrement2 = increment.rcurry(5)
assert curriedIncrement2(2) == 9









// LO QUIERO TODO
def curriedIncrement3 = increment.ncurry(0,2,3)
assert curriedIncrement3() == 7







//  _____  _               _      _
// | ____|(_) ___ _ __ ___(_) ___(_) ___  ___ _
// |  _|  | |/ _ \ '__/ __| |/ __| |/ _ \/ __(_)
// | |___ | |  __/ | | (__| | (__| | (_) \__ \_
// |_____|/ |\___|_|  \___|_|\___|_|\___/|___(_)
//


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

def olderThan = { } //
def olderThanThirty = {} // Use rcurry

def byCity = {}
def livingInMadrid = {} // Use curry

def findAllOlderThanThirtyAndLivingInMadrid = {
    return sample
        .findAll(olderThanThirty)
        .findAll(livingInMadrid)
}

assert findAllOlderThanThirtyAndLivingInMadrid().size() == 99


//  ___       _             _                         _
// |_ _|   __| | ___  _ __ | |_   _ __   ___  ___  __| |   __ _    ___ _   _ _ __ _ __ _   _
//  | |   / _` |/ _ \| '_ \| __| | '_ \ / _ \/ _ \/ _` |  / _` |  / __| | | | '__| '__| | | |
//  | |  | (_| | (_) | | | | |_  | | | |  __/  __/ (_| | | (_| | | (__| |_| | |  | |  | |_| |
// |___|  \__,_|\___/|_| |_|\__| |_| |_|\___|\___|\__,_|  \__,_|  \___|\__,_|_|  |_|   \__, |    ___
// | |_ ___     ___ _   _ _ __ _ __ _   _         _   _  ___  _   _  | | ___ __   _____|___/ __ |__ \
// | __/ _ \   / __| | | | '__| '__| | | |       | | | |/ _ \| | | | | |/ / '_ \ / _ \ \ /\ / /   / /
// | || (_) | | (__| |_| | |  | |  | |_| |_ _ _  | |_| | (_) | |_| | |   <| | | | (_) \ V  V /   |_|
//  \__\___/   \___|\__,_|_|  |_|   \__, (_|_|_)  \__, |\___/ \__,_| |_|\_\_| |_|\___/ \_/\_/    (_)
//                                  |___/         |___/


def sum = { a, b -> a + b }

def partialSum = { a ->
    return { b ->
        a + b
    }
}

assert sum.curry(2).call(2) == partialSum(2).call(2)

//  _____  _               _      _
// | ____|(_) ___ _ __ ___(_) ___(_) ___  ___ _
// |  _|  | |/ _ \ '__/ __| |/ __| |/ _ \/ __(_)
// | |___ | |  __/ | | (__| | (__| | (_) \__ \_
// |_____|/ |\___|_|  \___|_|\___|_|\___/|___(_)
//

// HACER EL EJERCICIO ANTERIOR APLICANDO ESTA TECNICA
