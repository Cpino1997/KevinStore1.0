package cl.pinolabs.kevinstore.model.persistence.mapper;

import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import cl.pinolabs.kevinstore.model.domain.dto.ClienteDTO;
import cl.pinolabs.kevinstore.model.persistence.entity.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

        @Mappings({
                @Mapping(source = "idCliente", target = "idCliente"),
                @Mapping(source = "rut", target = "rut"),
                @Mapping(source = "nombre", target = "nombre"),
                @Mapping(source = "numero", target = "numero"),
                @Mapping(source = "direccion", target = "direccion"),
        })
        ClienteDTO toClienteDTO(Cliente cliente);
        List<ClienteDTO> toClienteDTOs(List<Cliente> clientes);

        @InheritInverseConfiguration
        Cliente toCliente(ClienteDTO clienteDTO);
}
