package requests;

import enums.Gender;
import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private Integer age;
    private String address;
    private Gender gender;
    private String mobileNo;
    private String emailId;
    private String roles;
}
