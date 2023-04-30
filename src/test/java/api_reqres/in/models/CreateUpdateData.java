package api_reqres.in.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUpdateData {
    @JsonProperty()
    private CreateUpdateUserResponseModel createUpdateUserResponseModel;
}
