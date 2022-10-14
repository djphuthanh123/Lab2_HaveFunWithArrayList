import java.util.Objects;

class Address {

    private final Country country;

    private final String street;
    private final City city;

    public Address(Country country, String street, City city) {
        this.country = country;
        this.street = street;
        this.city = city;
    }


    public Country getCountry() {
        return country;
    }

    public String getStreet() {
        return street;
    }

    public City getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(getCountry(), address.getCountry()) && Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getCity(), address.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountry(), getStreet(), getCity());
    }

    @Override
    public String toString() {
        return   "[ Country: " + getCountry()+
                 "  City :  " +   getCity()   +
                 " Stress:  "+ getStreet()+ " ]";
    }
}