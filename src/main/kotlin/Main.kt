fun main() {
    println("A STRING TO CONSIDER")
println(word("Joyeuse"))
    println("PASSWORD")
    println(pass("bebe"))
    println("BINGO MULTIPLES")
    mult()
println("CURRENT ACCOUNT")
    var currentAccount=CurrentAccount(
        234,"Unguka",100.00
    )
    println( "new balance after adding is: ${currentAccount.deposit(2300.0)}")
    println( "new balance after removing is:${currentAccount.withdraw(230.0)}")

    println(currentAccount.details(234,"Unguka",100.00))

println("SAVING ACCOUNT")
    var savingAccount=SavingAccount(
        234,"Unguka",100.00,9
    )
    println( "new balance after adding is: ${savingAccount.deposit(2300.0)}")
    println( "new balance after withdrawing is:${savingAccount.withdraw(230.0)}")
    println(savingAccount.details(234,"Unguka",100.00))
}
//Write and invoke one function that takes in a random string and returns the
//following values: first character, last character, length of the string and
//whether it begins with a vowel or not. (6pts)
data class Str(var a:Char, var b:Char, var c:Int)
fun word(str:String):Str{
    var a= str[0]
    var b= str[str.length-1]
    var c= str.length
    return Str(a,b,c)
}

//Create a function that takes in a password as a parameter. For a password to
//be valid it must meet the following conditions:
//1. Must be at least 8 characters long
//2. Must be at most 16 characters long
//3. Must not be “password”
//4. Must contain a digit
//Your function should determine whether the password provided is valid or not.
//The function returns true/false

fun pass(password:String):Boolean{
    if (password.length in 8..16 && password!="password"){
        return true
    }
    return false
//        for (i in password))
}


//Create a function that prints out multiples of 6 and 8 between 1 and 1000. For
//multiples of both 6 and 8 it should print out “Bingo!”

fun mult() {
    for (i in 1..1000) {
        if (i%6==0 && i%8==0){
            println("${i} Bingo")
        }else{
            println(i)
        }
    }
}

//Create a class CurrentAccount with the following attributes: account number,
//account name, balance. It has the following functions:
//a. deposit(amount: Double) - Increments the balance by the amount
//deposited
//b. withdraw(amount: Double) - Decrements the balance by the amount
//withdrawn
//c. details() - Prints out the account number and balance and name in
//this format: “Account number x with balance y is operated by z”
data class Amount(var accountNumber: Int, var accountName: String, var balance: Double)
class CurrentAccount(accountNumber: Int, accountName: String, balance: Double) {
    var amou=Amount( accountNumber, accountName , balance )

    fun deposit(amount: Double):Double{

        amou.balance+=amount
        return amou.balance
    }
    fun withdraw(amount: Double):Double{

        amou.balance -=amount
       return amou.balance
    }
    fun details(accountNumber: Int,accountName: String,balance: Double):String{

       return ("Account number ${accountNumber} with balance ${balance} is operated by ${accountName}")

    }
}

//Create another class SavingsAccount. It has the same functions and
//attributes as the current account except for one attribute, withdrawals: Int.
//Withdrawals is a counter variable that is used to keep track of how many
//withdrawals have been made from the account in a year. The only other
//difference is that the savings account withdraw() method first checks if the
//number of withdrawals is less than 4 for it to allow one to withdraw money
//from the account. It also increments the withdrawals attribute after a
//successful withdrawal (6pts)

data class Save(var accountNumber: Int, var accountName: String, var balance: Double, var withdrawals:Int)
class SavingAccount(accountNumber: Int, accountName: String, balance: Double, withdrawals: Int) {
    var amou = Save(accountNumber, accountName, balance, withdrawals)

    fun deposit(amount: Double): Double {

        amou.balance += amount
        return amou.balance
    }

    fun withdraw(amount: Double): Double {

        for (withdrawals in 0..3) {
            if (withdrawals < 4) {

                amou.balance -= amount


                return amou.balance
                withdrawals++
            } else {
                return 0.0
            }
        }
        return 0.0
    }

    fun details(accountNumber: Int, accountName: String, balance: Double): String {

        return ("Account number ${accountNumber} with balance ${balance} is operated by ${accountName}")
    }
}

