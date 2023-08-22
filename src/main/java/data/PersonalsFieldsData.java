package data;

public enum PersonalsFieldsData {
    NAME ("Валера"),
    SName ("Филимонов"),
    LATINNAME ("Филимонов"),
    LATINSURNAME ("Philimonov"),

    BLOGNAME ("Phil_Valera"),

    DATEOFBIRTH("11.11.2003"),

    SKYPELOGIN("Haliavkino"),

    COMPANY("ООО Барракуда"),

    PROFESSION("Инженер"),

    COUNTRY("Россия"),
    CITY("Александров"),
    GENDER("Мужской");

    private String title;

    PersonalsFieldsData(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


}
