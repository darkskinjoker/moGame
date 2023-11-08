package ee.mainor.moGame.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
public class MoGameResponse {

    private String text;

    public void setTextResponse(String textResponse) {
        this.text = textResponse;
    }

}