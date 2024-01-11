package Day4.Lambdas;

import java.util.ArrayList;

public class State {
    private String name;
    private String capital;
    private ArrayList<City> cities;

    public State() { }

    public State(String name) {
        this.name = name;
    }

    public State(String name, String capital, ArrayList<City> cities) {
        this.name = name;
        this.capital = capital;
        this.cities = cities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return this.name + ":" + cities;
    }

    
    

    
}
