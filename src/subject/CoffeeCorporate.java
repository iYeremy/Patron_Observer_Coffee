package subject;

import observer.Observer;
import java.util.ArrayList;
import java.util.List;

public class CoffeeCorporate implements Subject {
    private List<Observer> observers; 
    private String varietal;
    private String tasting_notes;
    private String origin;
    private String height;
    private int pounds;

    public CoffeeCorporate(){
        observers = new ArrayList<>();
        pounds = 0;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    private void measurementsChanged() {
        notifyObservers();
    }

    // Getters
    public String getVarietal() { return varietal; }
    public String getTastingNotes() { return tasting_notes; }
    public String getOrigin() { return origin; }
    public String getHeight() { return height; }
    public int getPounds() { return pounds; }

    // Método para registrar un microlote
    public void addLot(String varietal, String tasting_notes, String origin, String height, int newPounds){
        if (newPounds <= 50){
            this.varietal = varietal;
            this.tasting_notes = tasting_notes;
            this.origin = origin;
            this.height = height;
            this.pounds = newPounds;
            measurementsChanged();
        } else {
            System.out.println("Error: microlote supera las 50 libras.");
        }
    }
}