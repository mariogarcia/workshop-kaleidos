import groovy.transform.Immutable

@Immutable(copyWith=true)
class Product {
    String name
    String type
    Double base
    Double vat
    Double dto
}

def names = ['Madrid', 'Dublin', 'London', 'Barcelona', 'Nice', 'Paris', 'Chicago', 'New York', 'Brussels', 'Rome', 'Geneve']
def types = ['luxury', 'standard']
def bases = [220.2, 45.3, 64.45, 680, 470, 871, 450, 442, 451, 240.2, 37.2]
def vats = [0.16]
def dtos = [0.2, 0.3, 0.4, 0.5]

def sample = [names, types, bases, vats, dtos].combinations() as Product[]

//   ____                                _               _                        __                            _   _                 
//  / ___|___  _ __ ___  _ __   ___  ___(_)_ __   __ _  | |_ _ __ __ _ _ __  ___ / _| ___  _ __ _ __ ___   __ _| |_(_) ___  _ __  ___ 
// | |   / _ \| '_ ` _ \| '_ \ / _ \/ __| | '_ \ / _` | | __| '__/ _` | '_ \/ __| |_ / _ \| '__| '_ ` _ \ / _` | __| |/ _ \| '_ \/ __|
// | |__| (_) | | | | | | |_) | (_) \__ \ | | | | (_| | | |_| | | (_| | | | \__ \  _| (_) | |  | | | | | | (_| | |_| | (_) | | | \__ \
//  \____\___/|_| |_| |_| .__/ \___/|___/_|_| |_|\__, |  \__|_|  \__,_|_| |_|___/_|  \___/|_|  |_| |_| |_|\__,_|\__|_|\___/|_| |_|___/
//                      |_|                      |___/                                                                                

class MyService {

    Product[] products
    
    MyService(Product[] products) {
        this.products = products
    }

    List<Product> transformToStandard() {
        return products.collect { it.copyWith(type: 'standard') }
    }
    
    List<Product> transformDtoTo30() {
        return products.collect { it.copyWith(dto: 0.3) }
    }
    
    // (1)
    List<Product> transformToStandardAndDtoTo30() {
        // No se puede recorrer la lista mas de una vez
        // las expresiones deben reutilizarse
        // No se pueden utilizar bucles anidados
    }
    
    // (2)
    List<Product> transformToLuxuryAndDtoToZero() {
        // No se puede recorrer la lista mas de una vez
        // las expresiones deben reutilizarse
        // No se pueden utilizar bucles anidados
    }
    
}

def myService = new MyService(sample)
myService.transformToStandard()
