package response;

import enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private String name;
    private Integer age;
    private String address;
    private Gender gender;
    private String mobileNo;
    private String emailId;
    private String roles;
}
