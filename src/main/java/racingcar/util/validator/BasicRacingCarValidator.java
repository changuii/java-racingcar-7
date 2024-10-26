package racingcar.util.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BasicRacingCarValidator implements RacingCarValidator {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int MOVE_COUNT_MIN = 1;
    private static final int CAR_NAME_NUMBER_MIN = 1;

    @Override
    public void validateCarNames(List<String> carNames) {
        validateCarNameNumberMoreThanMin(carNames);

        Set<String> carNameSet = new HashSet<>();
        carNames.stream().forEach((carName) -> {
            validateCarNameLengthLessThanMax(carName);
            validateCarNameLengthMoreThanMin(carName);
            validateDuplicateCarName(carNameSet, carName);
        });
    }

    @Override
    public void validateMoveCount(int moveCount) {
        validateMoveCountMoreThanMin(moveCount);
    }

    private void validateCarNameLengthLessThanMax(String carName) {
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCarNameLengthMoreThanMin(String carName) {
        if (carName.length() < CAR_NAME_MIN_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateMoveCountMoreThanMin(int moveCount) {
        if (moveCount < MOVE_COUNT_MIN) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCarNameNumberMoreThanMin(List<String> carNames) {
        if (carNames.size() < CAR_NAME_NUMBER_MIN) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateCarName(Set<String> carNameSet, String carName){
        if(!carNameSet.add(carName)){
            throw new IllegalArgumentException();
        }
    }
}
