package api_reqres.in.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUpdateUserResponseModel {
    String name;
    String job;

}
