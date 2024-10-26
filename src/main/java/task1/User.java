package task1;

public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    Address address;
    private String  phone;
    private String website;
    Company company;


    static class Address{
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        Geo geo;


        public Address(String street, String suite, String city, String zipcode, String lat, String lng) {
            this.street = street;
            this.suite = suite;
            this.city = city;
            this.zipcode = zipcode;
            geo = new Geo(lat, lng);
        }
        static class Geo{
            private String lat;
            private String lng;

            public Geo(String lat, String lng) {
                this.lat = lat;
                this.lng = lng;
            }

            @Override
            public String toString() {
                return "{" +
                        "lat='" + lat + '\'' +
                        ", lng='" + lng + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "{" +
                    "street='" + street + '\'' +
                    ", suite='" + suite + '\'' +
                    ", city='" + city + '\'' +
                    ", zipcode=" + zipcode +
                    ", geo: " + geo +
                    '}';
        }
    }

    static class Company{
        private String companyName;
        private String catchphrase;
        private String bs;

        public Company(String companyName, String catchphrase, String bs) {
            this.companyName = companyName;
            this.catchphrase = catchphrase;
            this.bs = bs;
        }

        @Override
        public String toString() {
            return "{" +
                    "companyName='" + companyName + '\'' +
                    ", catchphrase='" + catchphrase + '\'' +
                    ", bs='" + bs + '\'' +
                    '}';
        }
    }

    public User(int id, String name, String username, String email, String street, String suite, String city, String zipcode, String lat, String lng, String phone, String website, String companyName, String catchphrase, String bs) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        address = new Address(street, suite, city, zipcode, lat, lng);
        this.phone = phone;
        this.website = website;
        company = new Company(companyName, catchphrase, bs);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", address: " + address +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", company: " + company +
                '}';
    }
}
