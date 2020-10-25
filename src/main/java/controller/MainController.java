package controller;

import model.Kalkulator;

import java.io.IOException;
import java.net.Socket;
import java.io.PrintWriter;

public class MainController {

    MainView mainView;
    private String serverPort;
    private String serverIP;

    public MainController(MainView mainView) {
        this.mainView = mainView;
    }

    public void hitungTambah(String nilai1, String nilai2) throws IOException {
        sendRequest(nilai1 + " + " + nilai2);
    }

    public void hitungKurang(String nilai1, String nilai2) {

        if (nilai1.isEmpty() || nilai2.isEmpty()) {

        } else {
            long nilaia = Long.parseLong(nilai1);
            long nilaib = Long.parseLong(nilai2);

            long total = nilaia - nilaib;

            Kalkulator kalkulator = new Kalkulator();
            kalkulator.setTotal(total);

            mainView.bindView(kalkulator);
            mainView.emptyTextField();

        }

    }

    public void hitungKali(String nilai1, String nilai2) {

        if (nilai1.isEmpty() || nilai2.isEmpty()) {

        } else {
            long nilaia = Long.parseLong(nilai1);
            long nilaib = Long.parseLong(nilai2);

            long total = nilaia * nilaib;

            Kalkulator kalkulator = new Kalkulator();
            kalkulator.setTotal(total);

            mainView.bindView(kalkulator);
            mainView.emptyTextField();

        }

    }

    public void hitungBagi(String nilai1, String nilai2) {

        if (nilai1.isEmpty() || nilai2.isEmpty()) {

        } else {
            long nilaia = Long.parseLong(nilai1);
            long nilaib = Long.parseLong(nilai2);

            long total = nilaia / nilaib;

            Kalkulator kalkulator = new Kalkulator();
            kalkulator.setTotal(total);

            mainView.bindView(kalkulator);
            mainView.emptyTextField();

        }

    }

    public void sendRequest(String request) throws IOException {
        Socket s = new Socket(this.serverIP, Integer.parseInt(this.serverPort));

        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println(request);
        pr.flush();

        s.close();
    }

}
