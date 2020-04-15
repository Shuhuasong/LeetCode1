

public class Passenger extends Thread{
    int passengerId;
    int seatNumber;
    int zoneNumber;
    String threadName;

    public Passenger(){
        passengerId = -1;
        seatNumber = 0;
        zoneNumber = 0;
        threadName = " ";
    }


    //Methods
    void arriveAiport() { //checking in kiosk to print boarding pass

    }
    void waitInLine() { //block on a different object(same zone =same object)

    }
    void getBoardingPass(){ //get seat number and zone number

    }


    void waitSameZone() { //passengers belonging to the same zone will all block on the same object(3)

    }

    void enterAirplane() { //flight attendant calls all passengers of zone 1 (use notifyAll) and asks the passengers to scan their boarding pass and get to the airplane’s door.
    //be done in a mutual exclusion way
    //the passengers enter the plane in groups (determine by groupNum)
    }

    void enjoyOnFlight() { } //All other passengers get entertained on the flight in transit to their destination (use wait).

    void rebookFlightAndGoHome(){ //All passengers that arrive at the gate after this announcement

    }

    void disembarkPlane(){ //passengers are asked (notified) to leave the plane in ascending order of their seat number

    }
}
