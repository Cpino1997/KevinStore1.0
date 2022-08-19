package cl.pinolabs.kevinstore.model.persistence.mapper;

import cl.pinolabs.kevinstore.model.domain.dto.Rol;
import cl.pinolabs.kevinstore.model.persistence.entity.RolEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-18T23:04:29-0400",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 1.4.100.v20220318-0906, environment: Java 17.0.3 (Eclipse Adoptium)"
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
