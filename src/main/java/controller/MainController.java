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
            int nilaia = Integer.parseInt(nilai1);
            int nilaib = Integer.parseInt(nilai2);

            int total = nilaia + nilaib;

            Kalkulator kalkulator = new Kalkulator();
            kalkulator.setTotal(total);

            mainView.bindView(kalkulator);
        }

    }

}
