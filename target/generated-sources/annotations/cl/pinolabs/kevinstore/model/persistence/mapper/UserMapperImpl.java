package cl.pinolabs.kevinstore.model.persistence.mapper;

import cl.pinolabs.kevinstore.model.domain.dto.Rol;
import cl.pinolabs.kevinstore.model.domain.dto.User;
import cl.pinolabs.kevinstore.model.persistence.entity.RolEntity;
import cl.pinolabs.kevinstore.model.persistence.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-18T23:45:31-0400",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private RolMapper rolMapper;

    @Override
    public User toUser(UserEntity user) {
        if ( user == null ) {
            return null;
        }

        User user1 = new User();

        user1.setUsername( user.getUsername() );
        user1.setPassword( user.getPassword() );
        if ( user.getEnabled() != null ) {
            user1.setEnabled( user.getEnabled() );
        }
        user1.setRoles( rolMapper.toRoles( user.getRoles() ) );

        return user1;
    }

    @Override
    public List<User> toUsers(List<UserEntity> users) {
        if ( users == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( users.size() );
        for ( UserEntity userEntity : users ) {
            list.add( toUser( userEntity ) );
        }

        return list;
    }

    @Override
    public UserEntity toUserEntity(User user) {
        if ( user == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setUsername( user.getUsername() );
        userEntity.setPassword( user.getPassword() );
        userEntity.setEnabled( user.isEnabled() );
        userEntity.setRoles( rolListToRolEntityList( user.getRoles() ) );

        return userEntity;
    }

    protected List<RolEntity> rolListToRolEntityList(List<Rol> list) {
        if ( list == null ) {
            return null;
        }

        List<RolEntity> list1 = new ArrayList<RolEntity>( list.size() );
        for ( Rol rol : list ) {
            list1.add( rolMapper.toRolEntity( rol ) );
        }

        return list1;
    }
}
