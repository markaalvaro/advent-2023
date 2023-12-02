import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Week1Tests {

    @Test
    fun `test Trebuchet Part One`() {
        assertEquals(55816, trebuchet1())
    }

    @Test
    fun `test Trebuchet Part Two`() {
        assertEquals(54980, trebuchet2())
    }
}