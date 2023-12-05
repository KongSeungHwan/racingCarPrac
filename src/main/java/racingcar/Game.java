package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//입력 받은 값을 Car 객체로 변환
public class Game {
    private List<Car> carList;
    private int endNumber;

    Game(String cars,int number){
        carList = new ArrayList<>();
        endNumber = number;
        inputCars(cars);
    }
    void inputCars(String cars){
        carList = Arrays.stream(cars.split(","))
                .map(car-> new Car(car))
                .toList();
    }//분할 후 자동차 데이터 추가
    void progressGame(){
        boolean flag = checkEndPoint().size()>0;
        while(flag){
            carList.forEach(car->car.move());
            flag = flag = checkEndPoint().size()>0;
        }
    }
    List<Car> checkEndPoint(){
        return carList.stream()
                .filter(car->car.getDistance()==endNumber)
                .toList();
    }
}
