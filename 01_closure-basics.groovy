
//  ____  _                                     _                       _                   _             
// / ___|(_) ___ _ __ ___  _ __  _ __ ___    __| | _____   ___   _  ___| |_   _____    __ _| | __ _  ___  
// \___ \| |/ _ \ '_ ` _ \| '_ \| '__/ _ \  / _` |/ _ \ \ / / | | |/ _ \ \ \ / / _ \  / _` | |/ _` |/ _ \ 
//  ___) | |  __/ | | | | | |_) | | |  __/ | (_| |  __/\ V /| |_| |  __/ |\ V /  __/ | (_| | | (_| | (_) |
// |____/|_|\___|_| |_| |_| .__/|_|  \___|  \__,_|\___| \_/  \__,_|\___|_| \_/ \___|  \__,_|_|\__, |\___/ 
//                        |_|                                                                 |___/       

Closure<?> algo = { -> }

algo() == null
assert null.getClass() == org.codehaus.groovy.runtime.NullObject

// PUEDEN NO TENER NINGUN PARAMETRO { -> }
// PUEDEN TENER UN PARAMETRO POR DEFECTO { it }
// PUEDEN TENER N PARAMETROS { a, b, c, d -> }










//  _____                 _   _                   _   ___       _        __                
// |  ___|   _ _ __   ___| |_(_) ___  _ __   __ _| | |_ _|_ __ | |_ ___ / _| __ _  ___ ___ 
// | |_ | | | | '_ \ / __| __| |/ _ \| '_ \ / _` | |  | || '_ \| __/ _ \ |_ / _` |/ __/ _ \
// |  _|| |_| | | | | (__| |_| | (_) | | | | (_| | |  | || | | | ||  __/  _| (_| | (_|  __/
// |_|   \__,_|_| |_|\___|\__|_|\___/|_| |_|\__,_|_| |___|_| |_|\__\___|_|  \__,_|\___\___|
//   ___ ___   ___ _ __| |_(_) ___  _ __                                                   
//  / __/ _ \ / _ \ '__| __| |/ _ \| '_ \                                                  
// | (_| (_) |  __/ |  | |_| | (_) | | | |                                                 
//  \___\___/ \___|_|   \__|_|\___/|_| |_|                                                 
                                                                                         
// UN 'FUNCTIONAL INTERFACE' (Un interfaz con un solo metodo) 
// SE PUEDE CONVERTIR A UNA CLOSURE AUTOMATICAMENTE

interface Fn {
    Integer transform(Integer number)
}

class OldFashionedClass {
    Integer applyToNumber(Integer number, Fn function) {
        return function.transform(number)
    }
}

assert new OldFashionedClass().applyToNumber(2) { it * 2 } == 4





//  _   _                        _            _         _                      _      _ 
// | | | |_ __    _ __ ___   ___| |_ ___   __| | ___   ( )_ __  _   _  ___  __| | ___( )
// | | | | '_ \  | '_ ` _ \ / _ \ __/ _ \ / _` |/ _ \  |/| '_ \| | | |/ _ \/ _` |/ _ \/ 
// | |_| | | | | | | | | | |  __/ || (_) | (_| | (_) |   | |_) | |_| |  __/ (_| |  __/  
//  \___/|_| |_| |_| |_| |_|\___|\__\___/ \__,_|\___/    | .__/ \__,_|\___|\__,_|\___|  
//                                           _           |_|                            
//  ___  ___ _ __   _   _ _ __   __ _    ___| | ___  ___ _   _ _ __ ___                 
// / __|/ _ \ '__| | | | | '_ \ / _` |  / __| |/ _ \/ __| | | | '__/ _ \                
// \__ \  __/ |    | |_| | | | | (_| | | (__| | (_) \__ \ |_| | | |  __/                
// |___/\___|_|     \__,_|_| |_|\__,_|  \___|_|\___/|___/\__,_|_|  \___|                

class MyClass {
    Boolean isGreaterThanThirty(Integer number) {
        return number > 30
    }   
}    

assert [24, 45, 39, 22, 89]
    .findAll(new MyClass().&isGreaterThanThirty) == [45, 39, 89]         






    
//                                              _              _          _            
// __   _____ _ __     __ _   ___ _   _    __ _| |_ __ ___  __| | ___  __| | ___  _ __ 
// \ \ / / _ \ '_ \   / _` | / __| | | |  / _` | | '__/ _ \/ _` |/ _ \/ _` |/ _ \| '__|
//  \ V /  __/ | | | | (_| | \__ \ |_| | | (_| | | | |  __/ (_| |  __/ (_| | (_) | |   
//   \_/ \___|_| |_|  \__,_| |___/\__,_|  \__,_|_|_|  \___|\__,_|\___|\__,_|\___/|_|   
  
// OJO!!! SOLO EN EL MOMENTO EN EL QUE SE DECLARAN 

class ClosureScope {
    def a = 1

    def methodA() {
        a = 1
        def fn = { b -> b - a }
        return fn
    }
    
}                

Closure fn = new ClosureScope().methodA()
int a = 33 // no importa
assert fn(2) == 1




//  _____    _ _____ ____   ____ ___ ____ ___ ___  ____   
// | ____|  | | ____|  _ \ / ___|_ _/ ___|_ _/ _ \/ ___|  
// |  _| _  | |  _| | |_) | |    | | |    | | | | \___ \  
// | |__| |_| | |___|  _ <| |___ | | |___ | | |_| |___) | 
// |_____\___/|_____|_| \_\\____|___\____|___\___/|____/  
//                                                        



                                                                                                                                     
// [1] CREAR UNA CLOSURE QUE SOLO PUEDA DEVOLVER LA SUMA DE DOS ENTEROS
// QUE SE PASEN POR PARAMETRO



// [2] DECLARAR UNA CLOSURE QUE SE PUEDA USAR PARA FILTRAR LOS NUMEROS
// PARES DE LOS NUMEROS DEL 1 AL 100



// [3] CREAR UN METODO QUE PUEDA SERVIR PARA FILTRAR LOS NUMEROS IMPARES DEL
// 1 AL 100



// [4] DECLARAR UNA CLOSURE PARA MULTIPLICAR (COLLECT) TODOS LOS NUMEROS DEL
// 1 AL 100 CONTENIDOS EN UNA LISTA, POR EL NUMERO 2



// [5] CREAR UN METODO QUE PUEDA SER UTILIZADO PARA MULTIPLICAR TODOS LOS NUMEROS
// DEL 1 AL 100 CONTENIDOS EN UNA LISTA, POR EL NUMERO 3
