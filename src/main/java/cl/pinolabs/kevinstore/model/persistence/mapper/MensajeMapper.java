package cl.pinolabs.kevinstore.model.persistence.mapper;

import cl.pinolabs.kevinstore.model.domain.dto.MensajeDTO;
import cl.pinolabs.kevinstore.model.persistence.entity.Mensaje;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MensajeMapper {
    @Mappings({
            @Mapping(source = "id", target = "idMensaje"),
            @Mapping(source = "correo", target = "correo"),
            @Mapping(source = "mensaje", target = "mensaje"),
    })
    MensajeDTO toMensajeDTO(Mensaje mensaje);
    List<MensajeDTO> toMensajesDTO(List<Mensaje> mensajes);

    @InheritInverseConfiguration
    Mensaje toMensaje(MensajeDTO mensajeDTO);
}