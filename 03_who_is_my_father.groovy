
// __        ___             _                          __       _   _                 ___ 
// \ \      / / |__   ___   (_)___   _ __ ___  _   _   / _| __ _| |_| |__   ___ _ __  |__ \
//  \ \ /\ / /| '_ \ / _ \  | / __| | '_ ` _ \| | | | | |_ / _` | __| '_ \ / _ \ '__|   / /
//   \ V  V / | | | | (_) | | \__ \ | | | | | | |_| | |  _| (_| | |_| | | |  __/ |     |_| 
//    \_/\_/  |_| |_|\___/  |_|___/ |_| |_| |_|\__, | |_|  \__,_|\__|_| |_|\___|_|     (_) 
//                                             |___/                                       

class A {
    int b = 2
}

Map map = [a:4, b: 1]

Closure<Integer> addTwoNumbers = { a + b }

//  _____  _               _      _             
// | ____|(_) ___ _ __ ___(_) ___(_) ___  ___ _ 
// |  _|  | |/ _ \ '__/ __| |/ __| |/ _ \/ __(_)
// | |___ | |  __/ | | (__| | (__| | (_) \__ \_ 
// |_____|/ |\___|_|  \___|_|\___|_|\___/|___(_)
//      |__/                                    

// [1] TENIENDO EN CUENTA QUE LAS CLOSURES RESUELVEN SUS VARIABLES
// BUSCANDO EN SU OWNER, DELEGATE Y/O LOCAL VARIABLES, RESUELVE
// EL PROBLEMA DE ARRIBA 

// A) Resuelve ambas variables con map

assert addTwoNumbers() == 5

// C) Resuelve ambas variables resolviendo primero en A y despues
// en map

assert addTwoNumbers() == 6

// PUEDES COMBINAR LA RESOLUCION DE VARIABLES UTILIZANDO LAS 
//SIGUIENTES EXPRESIONES

//closure = closure.rehydrate(delegate, owner, thisObject)
//closure.setResolveStrategy(strategy) Mirar Closure api









// [2] Crear una clase que parsee este DSL
// SOLO NECESITAS setDelegate o instance.with(closure)

/*
String description =
    Builder.build {
        mission('rexj1') {
            step('one')
            step('two')
        }
    }
    
assert description == 'Mission rexj1 will have steps: one and two'

*/
