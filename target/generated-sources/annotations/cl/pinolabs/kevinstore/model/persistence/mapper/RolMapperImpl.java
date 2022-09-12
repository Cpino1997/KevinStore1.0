package cl.pinolabs.kevinstore.model.persistence.mapper;

import cl.pinolabs.kevinstore.model.domain.dto.Rol;
import cl.pinolabs.kevinstore.model.persistence.entity.RolEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-11T22:16:46-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class RolMapperImpl implements RolMapper {

    @Override
    public Rol toRol(RolEntity rol) {
        if ( rol == null ) {
            return null;
        }

        Rol rol1 = new Rol();

        rol1.setRolId( rol.getRolId() );
        rol1.setRolName( rol.getRolName() );

        return rol1;
    }

    @Override
    public List<Rol> toRoles(Iterable<RolEntity> roles) {
        if ( roles == null ) {
            return null;
        }

        List<Rol> list = new ArrayList<Rol>();
        for ( RolEntity rolEntity : roles ) {
            list.add( toRol( rolEntity ) );
        }

        return list;
    }

    @Override
    public RolEntity toRolEntity(Rol rol) {
        if ( rol == null ) {
            return null;
        }

        RolEntity rolEntity = new RolEntity();

        rolEntity.setRolId( rol.getRolId() );
        rolEntity.setRolName( rol.getRolName() );

        return rolEntity;
    }
}
