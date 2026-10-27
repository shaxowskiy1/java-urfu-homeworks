package ru.shaxowskiy.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.shaxowskiy.MySecondTestAppSpringBoot.model.Positions;

import java.time.Year;

@Service
public class AnnualBonusServiceImpl implements AnnualBonusService {

    private static final int QUARTERS_IN_YEAR = 4;

    @Override
    public double calculate(Positions positions, double salary, double bonus, int workDays) {
        return salary * bonus * getDaysInYear() * positions.getPositionCoefficient() / workDays;
    }

    @Override
    public double calculateQuarterly(Positions positions, double salary, double bonus, int workDays) {
        if (!positions.isManager()) {
            return 0;
        }
        return calculate(positions, salary, bonus, workDays) / QUARTERS_IN_YEAR;
    }

    private int getDaysInYear() {
        return Year.now().length();
    }
}
