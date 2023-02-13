package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Name {
    @JsonProperty("$id")
    public String id;
    @JsonProperty("FirstName")
    public String firstName;
    @JsonProperty("MiddleName")
    public String middleName;
    @JsonProperty("LastName")
    public String lastName;
}
