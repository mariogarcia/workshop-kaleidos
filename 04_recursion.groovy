
//  ____                          _              __                            _              __            ____  
// |  _ \ ___  ___ _   _ _ __ ___(_) ___  _ __  / / __ ___  ___ _   _ _ __ ___(_) ___  _ __  / / __ ___     \ \ \ 
// | |_) / _ \/ __| | | | '__/ __| |/ _ \| '_ \| | '__/ _ \/ __| | | | '__/ __| |/ _ \| '_ \| | '__/ _ \     | | |
// |  _ <  __/ (__| |_| | |  \__ \ | (_) | | | | | | |  __/ (__| |_| | |  \__ \ | (_) | | | | | | |  __/_ _ _| | |
// |_| \_\___|\___|\__,_|_|  |___/_|\___/|_| |_| |_|  \___|\___|\__,_|_|  |___/_|\___/|_| |_| |_|  \___(_|_|_) | |
//                                              \_\                                          \_\            /_/_/ 

// PARA PODER UTILIZAR trampoline() o @TailRecursive ES IMPRESCINDIBLE

// (1) ESTRUCTURAR LA FUNCION PARA QUE LA LLAMADA RECURSIVA SEA LA ULTIMA EXPRESION DE LA FUNCION
// (2) UTILIZAR trampoline() PARA GENERAR UNA VERSION DE LA FUNCION COMPATIBLE CON LA RECURSION

def contador = 0

contador = { items, counter = 0 ->
    if (!items) {
        return counter
    } else {
        contador.trampoline(items.tail(), counter + 1) // TAIL
    }
}

contador = contador.trampoline()
assert contador(1..1000) == 1000


//                                          __                     __      _    __              ______  
//  ___ _   _ _ __ ___   __ _   _ __ ___   / /   ___ _   _ _ __   / /  ___(_)  / / __   ____ _  \ \ \ \ 
// / __| | | | '_ ` _ \ / _` | | '__/ _ \ | |   / __| | | | '__| | |  / __| | | |  \ \ / / _` |  | | | |
// \__ \ |_| | | | | | | (_| | | | |  __/ | |  | (__| |_| | |    | |  \__ \ | | |   \ V / (_| |  | | | |
// |___/\__,_|_| |_| |_|\__,_| |_|  \___| | |   \___|\__,_|_|    | |  |___/_| | |    \_/ \__,_|  | | | |
//                                         \_\                    \_\          \_\              /_/_/_/ 

def tramp
tramp = { List<Integer> numbers, Integer sofar = 0 ->
     !numbers ? 
        sofar : 
        tramp(
            numbers.tail(),
            numbers.head() + sofar)
}

tramp(1..4)

// USAR TRAMPOLINE()
// CREAR UN METODO QUE TENGA ESTA SIGNATURA Y QUE SUME DE MANERA RECURSIVA

/*
    @groovy.transform.TailRecursive
    def recursiveSumMethod(List<Integer> numbers, Integer aggregator = 0) {
        //
    }

*/
