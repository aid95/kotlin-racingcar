package step2.data

import step2.util.Const.Companion.NOTICE_NOT_DIVIDE_ZERO

data class Operand(private val value: Double) {

    fun add(input: Operand) = Operand(this.value + input.value)

    fun minus(input: Operand) = Operand(this.value - input.value)

    fun multiply(input: Operand) = Operand(this.value * input.value)

    fun divide(input: Operand): Operand {
        validateToDivide(input)
        return Operand(this.value / input.value)
    }

    private fun validateToDivide(input: Operand) {
        if (input.value == 0.0) {
            throw IllegalArgumentException(NOTICE_NOT_DIVIDE_ZERO)
        }
    }

    override fun toString(): String {
        return "$value"
    }
}
