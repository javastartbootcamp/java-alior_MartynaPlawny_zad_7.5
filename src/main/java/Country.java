public class Country {
    private final String countryName;
    private final String code;
    private double population;

    public Country(String code, String countryName, double population) {
        this.code = code;
        this.countryName = countryName;
        this.population = population;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCode() {
        return code;
    }

    public double getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        System.out.printf("%s (%s) ma %.0f ludności.", countryName, code, population);
        return null;
    }
}
