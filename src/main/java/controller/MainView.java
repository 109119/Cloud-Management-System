package controller;

import model.Kalkulator;
import model.Worker;

public interface MainView {

    public void bindView(Kalkulator kalkulator);
    public void emptyTextField();

}
