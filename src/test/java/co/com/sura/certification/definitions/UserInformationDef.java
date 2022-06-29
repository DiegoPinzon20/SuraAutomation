package co.com.sura.certification.definitions;

import io.cucumber.java.DataTableType;
import saucedemo.model.UserInformationModel;

import java.util.Map;

public class UserInformationDef {

    @DataTableType
    public UserInformationModel defineProfileInformation(Map<String, String> entry) {
        return new UserInformationModel(
                entry.get("firstName"),
                entry.get("lastName"),
                entry.get("postalCode")
        );
    }
}
