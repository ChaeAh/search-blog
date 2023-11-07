package kakao.persistence.common;

import java.util.List;

/**
 * @author chaeah.kim
 */
public interface BaseMapper<DTO, Entity> {

    DTO convertEntitytoDTO(Entity e);

    Entity convertDTOtoEntity(DTO dto);

    List<DTO> convertEntitytoDTO(List<Entity> e);

    List<Entity> convertDTOtoEntity(List<DTO> dto);
}


