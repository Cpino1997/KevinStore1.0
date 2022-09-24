package cl.pinolabs.kevinstore.model.persistence.mapper;

import cl.pinolabs.kevinstore.model.domain.dto.MensajeDTO;
import cl.pinolabs.kevinstore.model.persistence.entity.Mensaje;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-21T22:55:00-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class MensajeMapperImpl implements MensajeMapper {

    @Override
    public MensajeDTO toMensajeDTO(Mensaje mensaje) {
        if ( mensaje == null ) {
            return null;
        }

        MensajeDTO mensajeDTO = new MensajeDTO();

        mensajeDTO.setIdMensaje( mensaje.getId() );
        mensajeDTO.setCorreo( mensaje.getCorreo() );
        mensajeDTO.setMensaje( mensaje.getMensaje() );

        return mensajeDTO;
    }

    @Override
    public List<MensajeDTO> toMensajesDTO(List<Mensaje> mensajes) {
        if ( mensajes == null ) {
            return null;
        }

        List<MensajeDTO> list = new ArrayList<MensajeDTO>( mensajes.size() );
        for ( Mensaje mensaje : mensajes ) {
            list.add( toMensajeDTO( mensaje ) );
        }

        return list;
    }

    @Override
    public Mensaje toMensaje(MensajeDTO mensajeDTO) {
        if ( mensajeDTO == null ) {
            return null;
        }

        Mensaje mensaje = new Mensaje();

        if ( mensajeDTO.getIdMensaje() != null ) {
            mensaje.setId( mensajeDTO.getIdMensaje() );
        }
        mensaje.setCorreo( mensajeDTO.getCorreo() );
        mensaje.setMensaje( mensajeDTO.getMensaje() );

        return mensaje;
    }
}
