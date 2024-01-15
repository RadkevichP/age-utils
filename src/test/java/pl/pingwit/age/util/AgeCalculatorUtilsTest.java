package pl.pingwit.age.util;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AgeCalculatorUtilsTest {

    @Test
    void calculateAge_ValidBirthDate_ReturnsCorrectAge() {
        LocalDate birthDate = LocalDate.of(1990, 1, 1);
        int expectedAge = Period.between(birthDate, LocalDate.now()).getYears();

        int actualAge = AgeCalculatorUtils.calculateAge(birthDate);

        assertThat(actualAge).isEqualTo(expectedAge);
    }

    @Test
    void calculateAge_BirthDateIsToday_ReturnsZero() {
        LocalDate birthDate = LocalDate.now();
        int expectedAge = 0;

        int actualAge = AgeCalculatorUtils.calculateAge(birthDate);

        assertThat(actualAge).isEqualTo(expectedAge);
    }

    @Test
    void calculateAge_BirthDateIsAfterToday_ThrowsIllegalArgumentException() {
        LocalDate birthDate = LocalDate.now().plusDays(1);

        assertThrows(IllegalArgumentException.class, () -> {
            AgeCalculatorUtils.calculateAge(birthDate);
        });
    }
}
