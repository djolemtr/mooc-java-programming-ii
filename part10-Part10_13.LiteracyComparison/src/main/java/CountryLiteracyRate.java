public class CountryLiteracyRate implements Comparable<CountryLiteracyRate> {
    private String theme;
    private String ageGroup;
    private String gender;
    private String country;
    private int year;
    private double literacyPercent;

    public CountryLiteracyRate(String theme, String ageGroup, String gender, String country, int year,
            double literacyPercent) {
        this.theme = theme;
        this.ageGroup = ageGroup;
        this.gender = gender;
        this.country = country;
        this.year = year;
        this.literacyPercent = literacyPercent;
    }

    public String getTheme() {
        return theme;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    public int getYear() {
        return year;
    }

    public double getLiteracyPercent() {
        return literacyPercent;
    }

    @Override
    public int compareTo(CountryLiteracyRate o) {

        if (this.literacyPercent == o.getLiteracyPercent()) {
            return 0;
        } else if (this.literacyPercent > o.getLiteracyPercent()) {
            return 1;
        } else {
            return -1;
        }

    }

    @Override
    public String toString() {
        return this.country + " (" + this.year + "), " + this.gender + ", " + this.literacyPercent;
    }
}
