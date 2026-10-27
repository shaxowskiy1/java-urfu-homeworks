package ru.shaxowskiy.MySecondTestAppSpringBoot.service;

import org.junit.jupiter.api.Test;
import ru.shaxowskiy.MySecondTestAppSpringBoot.model.Positions;

import java.time.Year;

import static org.assertj.core.api.Assertions.assertThat;

class AnnualBonusServiceImplTest {

    private final AnnualBonusService annualBonusService = new AnnualBonusServiceImpl();

    @Test
    void calculate() {
        Positions position = Positions.HR;
        double bonus = 2.0;
        int workDays = 243;
        double salary = 100000.00;

        double result = annualBonusService.calculate(position, salary, bonus, workDays);

        double expected = salary * bonus * Year.now().length() * position.getPositionCoefficient() / workDays;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void calculateQuarterlyForManager() {
        Positions position = Positions.TL;
        double bonus = 2.0;
        int workDays = 243;
        double salary = 100000.00;

        double result = annualBonusService.calculateQuarterly(position, salary, bonus, workDays);

        double expected = annualBonusService.calculate(position, salary, bonus, workDays) / 4;
        assertThat(result).isEqualTo(expected);
        assertThat(result).isPositive();
    }

    @Test
    void calculateQuarterlyForNotManager() {
        double result = annualBonusService.calculateQuarterly(Positions.DEV, 100000.00, 2.0, 243);

        assertThat(result).isZero();
    }
}
