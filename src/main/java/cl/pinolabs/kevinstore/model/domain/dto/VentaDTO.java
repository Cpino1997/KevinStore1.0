package cl.pinolabs.kevinstore.model.domain.dto;

import java.util.List;

public class VentaDTO {
    private Integer idVenta;
    private Float montoVenta;
    private Integer idCliente;
    private ClienteDTO clienteDTO;
    private List<ProductoDTO> productoDTOs;

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Float getMontoVenta() {
        return montoVenta;
    }

    public void setMontoVenta(Float montoVenta) {
        this.montoVenta = montoVenta;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public ClienteDTO getClienteDTO() {
        return clienteDTO;
    }

    public void setClienteDTO(ClienteDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
    }

    public List<ProductoDTO> getProductoDTOs() {
        return productoDTOs;
    }

    public void setProductoDTOs(List<ProductoDTO> productoDTOs) {
        this.productoDTOs = productoDTOs;
    }
}
