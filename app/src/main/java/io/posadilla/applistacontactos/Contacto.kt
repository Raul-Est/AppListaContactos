package io.posadilla.applistacontactos

import java.math.BigInteger

data class Contacto(
    // primero propiedades
    var nombre : String,
    var apellidos : String,
    var mail: String,
    var telefono: BigInteger,
    var imagenId : Int?
)
