import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class Passengers_Reservations_Data {

    public static ArrayList<Passenger> passengersList = new ArrayList<Passenger>();
    public static ArrayList<Booking> reservationsList = new ArrayList<Booking>();
    public static boolean Old = false;

    public static void fetchPassengerData() {
        try {
            BufferedReader passengersFile = new BufferedReader(new FileReader("Passengers.txt"));
            String[] line = new String[5];
            int i = 0;
            while ((line[i] = passengersFile.readLine()) != null) {
                i++;
                if (i == 5) {
                    Passenger p = new Passenger();
                    p.setOldPassengerName(line[0], line[1]);
                    p.setOldPassengerID(line[2]);
                    p.setOldPassengerEmail(line[3]);
                    p.setOldPassengerPhone(line[4]);
                    i = 0;
                    passengersList.add(p);
                }
            }
            passengersFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fetchReservationsData() {
        try {
            BufferedReader reservationsFile = new BufferedReader(new FileReader("Reservations_Data.txt"));
            String[] line = new String[9];
            int i = 0;
            while ((line[i] = reservationsFile.readLine()) != null) {
                i++;
                if (i == 9) {
                    String Id = line[0].substring(0, 9);
                    for (Passenger p : passengersList) {
                        if (p.getPassengerID().equals(Id)) {
                            Booking booking = new Booking(Id);
                            Seat s = new Seat(Integer.parseInt(line[2]), line[3]);
                            booking.setBookingStatus(line[1]);
                            booking.setSeatForBooking(s);
                            booking.setServ(line[4]);
                            List<FlightDetails> flights = ArrayListData.flightDetails();
                            for (FlightDetails f : flights) {
                                if (f.getFlightNum().equals(line[5])) {
                                    f.setPrice(line[6]);
                                    booking.setFlightInfo(f);
                                    break;
                                }
                            }
                            booking.ticket.setTicketNumber(Integer.parseInt(line[7]));
                            booking.ticket.setExpireDate(line[8]);
                            p.addFlight(booking);
                        }
                    }
                    i = 0;
                }
            }
            reservationsFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void savePassengersData() throws IOException {
        BufferedWriter passengersFile = new BufferedWriter(new FileWriter("Passengers.txt"));
        for (Passenger p : passengersList) {
            passengersFile.write(p.getPassengerFirstName() + "\n");
            passengersFile.write(p.getPassengerLastName() + "\n");
            passengersFile.write(p.getPassengerID() + "\n");
            passengersFile.write(p.getPassengerEmail() + "\n");
            passengersFile.write(p.getPassengerPhone() + "\n");
        }

        passengersFile.close();
    }

    public static void saveReservationsData() throws IOException {

        BufferedWriter reservationsFile = new BufferedWriter(new FileWriter("Reservations_Data.txt"));
        for (Booking B : reservationsList) {
            reservationsFile.write(B.getBookingID() + "\n");
            reservationsFile.write(B.getBookingStatus() + "\n");
            reservationsFile.write(B.seatForBooking.getSeat_Num() + "\n");
            reservationsFile.write(B.seatForBooking.getSeatClass() + "\n");
            reservationsFile.write(B.getServ() + "\n");
            reservationsFile.write(B.flightInfo.getFlightNum() + "\n");
            reservationsFile.write(B.flightInfo.getPrice() + "\n");
            reservationsFile.write(B.ticket.getTicketNumber() + "\n");
            reservationsFile.write(B.ticket.getExpireDate() + "\n");
        }
        reservationsFile.close();
    }

}

