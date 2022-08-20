package cl.pinolabs.kevinstore.model.persistence.mapper;

import cl.pinolabs.kevinstore.model.domain.dto.VentaDTO;
import cl.pinolabs.kevinstore.model.persistence.entity.Venta;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ClienteMapper.class, ProductosMapper.class})
public interface VentaMapper {
    @Mappings({
            @Mapping(source = "idVenta", target = "idVenta"),
            @Mapping(source = "montoVenta", target = "montoVenta"),
            @Mapping(source = "idCliente", target = "idCliente"),
            @Mapping(source = "cliente", target = "clienteDTO"),
            @Mapping(source = "productos", target = "productoDTOs"),
    })
    VentaDTO toVentaDTO(Venta venta);
    List<VentaDTO> toVentaDTOs(List<Venta> ventas);
    @InheritInverseConfiguration
    Venta toVenta(VentaDTO ventaDTO);
}
