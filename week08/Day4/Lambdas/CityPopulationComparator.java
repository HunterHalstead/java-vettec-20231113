package Day4.Lambdas;

import java.util.Comparator;

public class CityPopulationComparator implements Comparator<City> {

    @Override
    public int compare(City city1, City city2) {
        if(city1 == null) {
            if(city2 == null) {
                return 0;
            }
            return 1;
        }

        if(city1.getPopulation() < city2.getPopulation()) {
            return -1;
        } else if(city1.getPopulation() == city2.getPopulation()) {
            return 0;
        } else {
            return 1;
        }
    }
    
}
