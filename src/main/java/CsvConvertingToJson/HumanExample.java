package CsvConvertingToJson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HumanExample {
    @JsonProperty("CIK")
    private String cik;

    @JsonProperty("MET")
    private String metadata;

    @JsonProperty("ENTITY_NAME")
    private String entityName;

    @JsonProperty("STREET1")
    private String street1;

    @JsonProperty("STREET2")
    private String street2;

    @JsonProperty("CITY")
    private String city;

    @JsonProperty("STATE_CODE")
    private String stateCode;

    @JsonProperty("ZIP")
    private String zip;

    @JsonProperty("FILLING_DATE")
    private String fillingDate;

    @JsonProperty("DOCTYPE_CODE")
    private String docTypeCode;

}
