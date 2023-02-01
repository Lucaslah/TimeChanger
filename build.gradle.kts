plugins {
    base
    idea
    id("io.freefair.lombok") version "6.5.1" apply false
}

allprojects {
    group = "me.lucaslah"
    version = property("me.lucaslah.timechanger.version") as String + "-" + property("me.lucaslah.timechanger.release")
    description = "Client size time changer for minecraft"

    apply(plugin = "io.freefair.lombok")
}