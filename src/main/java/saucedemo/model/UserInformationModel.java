package saucedemo.model;

import lombok.Data;

@Data
public class UserInformationModel {
    private final String firstName;
    private final String lastName;
    private final String postalCode;
}