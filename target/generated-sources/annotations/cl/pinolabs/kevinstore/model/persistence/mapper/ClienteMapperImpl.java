package cl.pinolabs.kevinstore.model.persistence.mapper;

import cl.pinolabs.kevinstore.model.domain.dto.ClienteDTO;
import cl.pinolabs.kevinstore.model.persistence.entity.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-18T23:45:31-0400",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteDTO toClienteDTO(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setIdCliente( cliente.getIdCliente() );
        clienteDTO.setRut( cliente.getRut() );
        clienteDTO.setNombre( cliente.getNombre() );
        clienteDTO.setNumero( cliente.getNumero() );
        clienteDTO.setDireccion( cliente.getDireccion() );

        return clienteDTO;
    }

    @Override
    public List<ClienteDTO> toClienteDTOs(List<Cliente> clientes) {
        if ( clientes == null ) {
            return null;
        }

        List<ClienteDTO> list = new ArrayList<ClienteDTO>( clientes.size() );
        for ( Cliente cliente : clientes ) {
            list.add( toClienteDTO( cliente ) );
        }

        return list;
    }

    @Override
    public Cliente toCliente(ClienteDTO clienteDTO) {
        if ( clienteDTO == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setIdCliente( clienteDTO.getIdCliente() );
        cliente.setRut( clienteDTO.getRut() );
        cliente.setNombre( clienteDTO.getNombre() );
        cliente.setNumero( clienteDTO.getNumero() );
        cliente.setDireccion( clienteDTO.getDireccion() );

        return cliente;
    }
}
