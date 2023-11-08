package ee.mainor.moGame.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MoGameDto {

    private Long id;
    private String name;

}
