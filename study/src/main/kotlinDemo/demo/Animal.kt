class Animal(name : String) {

    var animalName = name

    var age = 1

    init {
        println("Animal init ---")
    }

    fun  run(){
        println("animal run ---")
    }
}

fun main(args: Array<String>) {
    var e = Animal("dog")
    e.run()

}
