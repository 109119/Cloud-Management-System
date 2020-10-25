package controller;

import model.Kalkulator;

public class MainController {

    MainView mainView;

    public MainController(MainView mainView) {
        this.mainView = mainView;
    }

    public void hitungTambah(String nilai1, String nilai2) {

        if (nilai1.isEmpty() || nilai2.isEmpty()) {

        } else {
            long nilaia = Long.parseLong(nilai1);
            long nilaib = Long.parseLong(nilai2);

            long total = nilaia + nilaib;

            Kalkulator kalkulator = new Kalkulator();
            kalkulator.setTotal(total);

            mainView.bindView(kalkulator);
            mainView.emptyTextField();
        }

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

}
