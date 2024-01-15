package pl.pingwit.age.util;

import java.time.LocalDate;
import java.time.Period;

public class AgeCalculatorUtils {

    private AgeCalculatorUtils(){
        // private constructor for the util class
    }

    /**
     * Calculates the age based on the provided date of birth.
     *
     * @param birthDate The date of birth.
     * @return The age in full years.
     * @throws IllegalArgumentException If the provided birthDate is after the current date or null,
     *                                  indicating an invalid scenario.
     */
    public static Integer calculateAge(LocalDate birthDate) {
        LocalDate today = LocalDate.now();
        if (birthDate.isAfter(today)) {
            throw new IllegalArgumentException("Entered date is after today: " + birthDate + ", " + today);
        }
        return Period.between(birthDate, today).getYears();
    }

    /**
     * Counts the number of leap years during a person's lifetime based on their birth date.
     *
     * @param birthDate The date of birth.
     * @return The number of leap years during the person's lifetime.
     * @throws IllegalArgumentException If the provided birthDate is after the current date or null,
     *                                  indicating an invalid scenario.
     */
    public static Integer countPersonLeapYears(LocalDate birthDate) {
        if (birthDate == null) {
            throw new IllegalArgumentException("Birth date must not be null");
        }
        LocalDate today = LocalDate.now();
        if (birthDate.isAfter(today)) {
            throw new IllegalArgumentException("Entered date is after today: " + birthDate + ", " + today);
        }
        int leapYearCount = 0;

        for (int year = birthDate.getYear(); year <= today.getYear(); year++) {
            if (LocalDate.ofYearDay(year, 1).isLeapYear()) {
                leapYearCount++;
            }
        }
        return leapYearCount;
    }
}
