package cl.pinolabs.kevinstore.model.persistence.mapper;

import cl.pinolabs.kevinstore.model.domain.dto.ProductoDTO;
import cl.pinolabs.kevinstore.model.domain.dto.VentaDTO;
import cl.pinolabs.kevinstore.model.persistence.entity.Producto;
import cl.pinolabs.kevinstore.model.persistence.entity.Venta;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-11T22:16:46-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class VentaMapperImpl implements VentaMapper {

    @Autowired
    private ClienteMapper clienteMapper;
    @Autowired
    private ProductosMapper productosMapper;

    @Override
    public VentaDTO toVentaDTO(Venta venta) {
        if ( venta == null ) {
            return null;
        }

        VentaDTO ventaDTO = new VentaDTO();

        ventaDTO.setIdVenta( venta.getIdVenta() );
        ventaDTO.setMontoVenta( venta.getMontoVenta() );
        ventaDTO.setIdCliente( venta.getIdCliente() );
        ventaDTO.setClienteDTO( clienteMapper.toClienteDTO( venta.getCliente() ) );
        ventaDTO.setProductoDTOs( productosMapper.toProductoDTOs( venta.getProductos() ) );

        return ventaDTO;
    }

    @Override
    public List<VentaDTO> toVentaDTOs(List<Venta> ventas) {
        if ( ventas == null ) {
            return null;
        }

        List<VentaDTO> list = new ArrayList<VentaDTO>( ventas.size() );
        for ( Venta venta : ventas ) {
            list.add( toVentaDTO( venta ) );
        }

        return list;
    }

    @Override
    public Venta toVenta(VentaDTO ventaDTO) {
        if ( ventaDTO == null ) {
            return null;
        }

        Venta venta = new Venta();

        venta.setIdVenta( ventaDTO.getIdVenta() );
        venta.setMontoVenta( ventaDTO.getMontoVenta() );
        venta.setIdCliente( ventaDTO.getIdCliente() );
        venta.setCliente( clienteMapper.toCliente( ventaDTO.getClienteDTO() ) );
        venta.setProductos( productoDTOListToProductoList( ventaDTO.getProductoDTOs() ) );

        return venta;
    }

    protected List<Producto> productoDTOListToProductoList(List<ProductoDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Producto> list1 = new ArrayList<Producto>( list.size() );
        for ( ProductoDTO productoDTO : list ) {
            list1.add( productosMapper.toProducto( productoDTO ) );
        }

        return list1;
    }
}
