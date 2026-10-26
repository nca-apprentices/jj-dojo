package dojo

fun main(args: Array<String>) {
    println(greet(args.firstOrNull() ?: "dojo"))
}
