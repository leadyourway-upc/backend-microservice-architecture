package upc.edu.leadyourway.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userPhone;
    private String userBirthDate;
    private String imageData;
}
