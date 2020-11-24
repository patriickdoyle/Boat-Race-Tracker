/*boatRaceTracker.kt
This program tracks the names of different boats and their
respective course times
Last edited by Pat Doyle 10/23/20
 */
fun main() {
    //Prompt the user for the names of boats and their
    //times. Will call stats() to output the winner and their time,
    //output the slowest boat and their time and output the average time
    userPrompt()
} // end main()

//fun userPrompt() uses a map to store boat names and
//times. A while loop is used that the user can end
fun userPrompt()
{
    //initialize variables
    val boatNames = mutableSetOf<String>()
    val boatsAndTimes = mutableMapOf<String, Double>()
    var endLoop = false

    //get user input and add it to boatNames
    println("Enter the name of a boat.")
    var userInput = readLine()
    boatNames.add(userInput.toString())

    //while loop will ask for boat names until endLoop == true
    while(!endLoop)
    {
        println("Enter the name of another boat.")
        println("Input a blank space (\" \") to stop adding boats.")
        println("*Boat names MUST be unique*")
        userInput = readLine()

        if(userInput == " ") {
            endLoop = true
        } else boatNames.add(userInput.toString())
    } //end while

    //for each loop will put boat names into a map as keys and ask for
    //a corresponding time.
    boatNames.forEach {
        println("Enter a time for $it")
        boatsAndTimes[it] = readLine()!!.toDouble()
    }//end foreach

    stats(boatsAndTimes)
} //end userPrompt()

//stats() outputs the winner and slowest boat along with their times and the average time.
fun stats(boatsAndTimes: Map<String, Double>) {
    //best and worst times found using min and max functions
    val winnerTime = boatsAndTimes.minOf{ it.value }
    val loserTime = boatsAndTimes.maxOf { it.value }

    //winner and loser are found by matching the best and worst times to their keys
    var winner = String()
    boatsAndTimes.forEach{
        if (it.value == winnerTime){
            winner = it.key
        }//end if
    }//end foreach
    var loser = String()
    boatsAndTimes.forEach{
        if (it.value == loserTime) loser = it.key
    }//end foreach

    //sum is the total of all times. avgTime is found by dividing sum
    //by the number of entries in the map
    var sum = 0.0
    boatsAndTimes.forEach{
        sum += it.value
    }//end foreach
    val avgTime = sum / boatsAndTimes.count()

    //print data
    println("Our winner is $winner with a time of $winnerTime!")
    println("Our last place loser is $loser with a time of $loserTime")
    println("The average time of all boats was $avgTime")
}//end stats()