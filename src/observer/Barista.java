package observer;

import subject.CoffeeCorporate;

public class Barista implements Observer, Display {
    
    private String name;
    private String id;
    private CoffeeCorporate coffeecorporate;

    private String varietal;
    private String tasting_notes;
    private String origin;
    private String height;   
    private int pounds;

    public Barista(String name, String id, CoffeeCorporate coffeecorporate){
        this.name = name;
        this.id = id;
        this.coffeecorporate = coffeecorporate;
        coffeecorporate.registerObserver(this);
    }

    @Override
    public void display(){
        System.out.println("User: " + name + " Id: " + id + 
        "\nVarietal: " + varietal +
        "\nTasting Notes: " + tasting_notes +
        "\nOrigin: " + origin +
        "\nHeight: " + height +
        "\nPounds (lb): " + pounds + "\n"
        );
    }
    
    @Override
    public void update(){
        // Tomamos los valores del subject
        this.varietal = coffeecorporate.getVarietal();
        this.tasting_notes = coffeecorporate.getTastingNotes();
        this.origin = coffeecorporate.getOrigin();
        this.height = coffeecorporate.getHeight();
        this.pounds = coffeecorporate.getPounds();
        display(); 
    }
}