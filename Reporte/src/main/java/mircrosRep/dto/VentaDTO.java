package mircrosRep.dto;
import lombok.Data;

@Data
public class VentaDTO {
    private int idVenta;
    private int idSucursal;
    private double totalVenta;
    private String fechaVenta;
}

