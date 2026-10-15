open class BankAccount(
    val accName: String,
    val accNumber: Int
) {
    var balance: Int = 0

    open fun displayInfo() {
        println("Account Holder: $accName")
        println("Account Number: $accNumber")
        println("Balance: $balance")
    }
}

class SavingAccount(
    accName: String,
    accNumber: Int,
    val interestRate: Float
) : BankAccount(accName, accNumber) {

    fun credit(amount: Int) {
        balance += amount
    }

    fun debit(amount: Int) {
        balance -= amount
    }

    override fun displayInfo() {
        super.displayInfo()
        println("Interest Rate: $interestRate")
    }
}

fun main() {

    val account = SavingAccount(
        "John",
        12345,
        5.5f
    )

    account.credit(10000)
    account.debit(2000)

    account.displayInfo()
}