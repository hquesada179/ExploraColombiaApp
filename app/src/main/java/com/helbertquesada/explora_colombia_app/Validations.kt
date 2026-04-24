package com.helbertquesada.explora_colombia_app

import android.util.Patterns

fun validateEmail(email: String): Pair<Boolean, String> {
    if (email.isEmpty()) return Pair(false, "El correo es requerido.")
    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) return Pair(false, "El correo es invalido")
    if (!email.endsWith("@test.com")) return Pair(false, "Ese email no es corporativo.")
    return Pair(true, "")
}

fun validatePassword(password: String): Pair<Boolean, String> {
    if (password.isEmpty()) return Pair(false, "La contraseña es requerida.")
    if (password.length < 8) return Pair(false, "La contraseña debe tener al menos 8 caracteres.")
    if (!password.any { it.isDigit() }) return Pair(false, "La contraseña debe tener al menos un número.")
    return Pair(true, "")
}

fun validateName(name: String): Pair<Boolean, String> {
    if (name.isEmpty()) return Pair(false, "El nombre es requerido.")
    if (name.length < 3) return Pair(false, "El nombre debe tener al menos 3 caracteres.")
    return Pair(true, "")
}

fun validateConfirmPassword(password: String, confirmPassword: String): Pair<Boolean, String> {
    if (confirmPassword.isEmpty()) return Pair(false, "La contraseña es requerida.")
    if (confirmPassword != password) return Pair(false, "Las contraseñas no coinciden.")
    return Pair(true, "")
}
