package cl.pinolabs.kevinstore.model.domain.dto;

import java.util.List;

import lombok.Data;

@Data
public class VentaDTO {
    private Integer idVenta;
    private Float montoVenta;
    private Integer idCliente;
    private ClienteDTO clienteDTO;
    private List<ProductoDTO> listaCompra;
}
